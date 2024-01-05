const userDatabase = require("../Database");
const jwt = require("jsonwebtoken");

const login = (req, res, next) => {
  console.log("login called");
  const { email, password } = req.body;

  const userInfo = userDatabase.filter((item) => {
    return item.email === email;
  })[0];
  //   console.log(userInfo);

  if (!userInfo) {
    res.status(403).json("Not Authorized");
  } else {
    try {
      // access Token 발급
      const accessToken = jwt.sign(
        {
          id: userInfo.id,
          username: userInfo.username,
          email: userInfo.email,
        },
        process.env.ACCESS_SECRET,
        {
          expiresIn: "1m",
          issuer: "About Tech",
        }
      );
      // refresh Token 발급
      const refreshToken = jwt.sign(
        {
          id: userInfo.id,
          username: userInfo.username,
          email: userInfo.email,
        },
        process.env.REFRESH_SECRET,
        {
          expiresIn: "24h",
          issuer: "About Tech",
        }
      );

      // token 전송
      res.cookie("accessToken", accessToken, {
        secure: false,
        httpOnly: true,
      });
      res.cookie("refreshToken", refreshToken, {
        secure: false,
        httpOnly: true,
      });

      res.status(200).json("login success");
    } catch (error) {
      res.status(500).json(error);
    }
  }
  next();
};

const accessToken = (req, res) => {};
const refreshToken = (req, res) => {};
const loginSuccess = (req, res) => {};
const logout = (req, res) => {};

module.exports = {
  login,
  accessToken,
  refreshToken,
  loginSuccess,
  logout,
};
