const express = require("express");
const { httpAdd, httpGet } = require("../controllers/user");
const router = express.Router();

router.route("/user").post(httpAdd);
router.route("/users").get(httpGet);

module.exports = router;
