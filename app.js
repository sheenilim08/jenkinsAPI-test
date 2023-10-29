const express = require('express');
const app = express();
const userRoute = require('./routes/user');
const morgan = require('morgan');

app.use(express.json())
app.use(morgan('combined'))
app.use('/v1',userRoute);

module.exports = app;