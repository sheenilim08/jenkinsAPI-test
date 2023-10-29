const mongoose = require("mongoose");

const connectDB = () => {
  mongoose
    .connect(`${process.env.DB_URL}/${process.env.DB_NAME}`)
    .then(() => {
      console.log("Database connected..");
    })
    .catch((err) => {
      console.log("DB ERR-->", err);
    });
};
module.exports = connectDB;
