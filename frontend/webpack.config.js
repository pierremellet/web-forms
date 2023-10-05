const dotenv = require('dotenv');


const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const webpack = require('webpack');

const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;

const clientConfig = {
    target: "web",
    mode: 'production',
    entry: './src/ui/index.tsx',
    devtool: 'source-map',
    output: {
        filename: "client.bundle.js",
        publicPath: '/',
        path: path.resolve(__dirname, "build"),
    },
    resolve: {
        extensions: ['.tsx', '.ts', '.js', '.jsx', 'scss'],
    },
    devServer: {
        historyApiFallback: true,
    },
    module: {
        rules: [
            {
                test: /\.(tsx|ts)?$/,
                exclude: [path.resolve(__dirname, "node_modules")],
                loader: 'ts-loader'
            },
            {
                test: /\.(scss|css)$/,
                use: [{
                    loader: 'style-loader'
                }, {
                    loader: 'css-loader'
                }, {
                    loader: 'postcss-loader',
                    options: {
                        postcssOptions: {
                            plugins: function () {
                                return [
                                    require('autoprefixer')
                                ];
                            }
                        }
                    }
                }, {
                    loader: 'sass-loader'
                }]
            }
        ]
    },
    plugins: [
        //new BundleAnalyzerPlugin(),
        new webpack.DefinePlugin({
            'process.env': JSON.stringify(dotenv.config().parsed)
        }), new HtmlWebpackPlugin({
            template: "public/index.html",
        })
    ],

};

module.exports = [clientConfig];