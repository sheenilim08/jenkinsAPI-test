const env = require('dotenv');
env.config();
const http = require('http');
const app = require('./app');
const connectDB = require('./Database');
const server = http.createServer(app);

const startServer = async()=>{
    await connectDB();
    server.listen(process.env.PORT,()=>{
        console.log('Server is listening.....')
    })
}

startServer();