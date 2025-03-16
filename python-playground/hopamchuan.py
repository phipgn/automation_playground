from flask import Flask, request, jsonify
from flask_cors import CORS
import requests
from bs4 import BeautifulSoup
import sqlite3
import re

app = Flask(__name__)
CORS(app)

def extract_song_data(url):
    print(url)
    response = requests.get(url)
    soup = BeautifulSoup(response.text, 'html.parser')

    title = soup.select_one('h1#song-title').text.strip()
    category = soup.select_one('#song-detail-info a[href*="genre"]').text.strip().lower()
    composers = ','.join([a.text.strip() for a in soup.select('#song-detail-info a[href*="artist"]')])
    singers = ','.join([a.text.strip() for a in soup.select('.perform-singer-list a[href*="artist"]')])
    authors = f"{composers};{singers}"
    lyrics = '\n'.join([div.text.strip() for div in soup.select('.chord_lyric_line')])

    category_mapping = {
        'nhạc vàng': 1,
        'nhạc trữ tình': 2,
        'nhạc trẻ': 3,
        'nhạc quê hương': 4,
        'nhạc ngoại lời việt': 5,
        'nhạc đỏ': 6,
        'nhạc dân ca': 7,
        'nhạc quốc tế': 8,
        'nhạc học trò': 9,
        'nhạc thiếu nhi': 10,
        'nhạc thánh ca': 11,
        'nhạc phật giáo': 12,
        'nhạc chế - vui': 13,
    }
    category_id = category_mapping.get(category, 0)

    print(f"Title: {title}")
    print(f"Authors: {authors}")
    print(f"Category: {category} ({category_id})")
    print(f"Lyrics: {lyrics}")
    return title, authors, category_id, lyrics

def remove_diacritics(s):
    s = re.sub(r"[áàảãạăắằẳẵặâấầẩẫậāǎ]", "a", s)
    s = re.sub(r"[ÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĀ]", "A", s)
    s = re.sub(r"[éèẻẽẹêếềểễệēě]", "e", s)
    s = re.sub(r"[ÉÈẺẼẸÊẾỀỂỄỆ]", "E", s)
    s = re.sub(r"[óòỏõọôốồổỗộơớờởỡợōǒ]", "o", s)
    s = re.sub(r"[ÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢ]", "O", s)
    s = re.sub(r"[íìỉĩịīǐ]", "i", s)
    s = re.sub(r"[ÍÌỈĨỊ]", "I", s)
    s = re.sub(r"[úùủũụưứừửữựūǔ]", "u", s)
    s = re.sub(r"[ÚÙỦŨỤƯỨỪỬỮỰ]", "U", s)
    s = re.sub(r"[ýỳỷỹỵ]", "y", s)
    s = re.sub(r"[ÝỲỶỸỴ]", "Y", s)
    s = re.sub(r"[ñ]", "n", s)
    s = re.sub(r"[đ]", "d", s)
    s = re.sub(r"[Đ]", "D", s)
    return s

def save_to_db(title, authors, category_id, lyrics):
    db_path = 'D:/workspace/sachnhac/app/src/main/assets/databases/sachnhac.db'
    title_no_accents = remove_diacritics(title)

    conn = sqlite3.connect(db_path)
    cursor = conn.cursor()
    cursor.execute('INSERT INTO song (category_id,title,title_no_accents,authors,lyric) VALUES (?, ?, ?, ?, ?)', 
        (category_id, title, title_no_accents, authors, lyrics))
    
    conn.commit()
    conn.close()

@app.route('/save_song', methods=['POST'])
def save_song_api():
    url = request.json.get('url')

    title, authors, category_id, lyrics = extract_song_data(url)
    save_to_db(title, authors, category_id, lyrics)

    return jsonify({'message': f'Saved song: {title}'})

'''
Save a bookmarklet to your browser to save a song from hopamchuan.com:
javascript:(function() { fetch('http://localhost:5001/save_song', { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({ url: window.location.href })}).then(response => response.json()).then(data => alert(data.message)); })();
'''
if __name__ == "__main__":
    app.run(port=5001, debug=True)
    # extract_song_data ('https://hopamchuan.com/song/74919/nhu-nao/?s=1')  