var path = require('path');

module.exports = {
    entry: './src/js/app.js',
    devtool: 'source-map',
    cache: true,
    mode: 'development',
    output: {
        // Caminho onde o arquivo bundle.js será gerado para o Spring Boot servir
        path: path.resolve(__dirname, 'src/main/resources/static/built'),
        filename: 'bundle.js'  // O arquivo será gerado como 'bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ["@babel/preset-env", "@babel/preset-react"]
                    }
                }]
            }
        ]
    }
};
