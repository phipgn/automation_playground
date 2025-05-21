function fn() {
    const env = karate.env;
    const config = {
        baseUrl: 'https://reqres.in',
        utilPaths: {
            random: 'classpath:utils/random.feature'
        }
    };
    config.headers = { 'x-api-key': 'reqres-free-v1' };
    return config;
}