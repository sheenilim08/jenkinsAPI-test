const User = require("../models/user");

const httpAdd = async (req, res, next) => {
  const resp = await User.create(req.body);
  res.status(201).json({
    status: true,
    msg: "User Added",
  });
};

const httpGet = async (req, res, next) => {
  const resp = await User.find();
  res.status(200).json({
    status: true,
    users: resp,
    msg: "ok1",
  });
};

module.exports = { httpAdd, httpGet };
