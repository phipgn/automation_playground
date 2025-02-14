function fn() {
    const env = karate.env;
    const config = {
        baseUrl: 'https://reqres.in',
        utilPaths: {
            random: 'classpath:utils/random.feature'
        }
    };

    return config;
}