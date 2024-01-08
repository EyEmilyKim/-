const express = require("express");
const session = require("express-session");
const cors = require("cors");
const dotenv = require("dotenv");
const userDB = require("./Database");

const app = express();
dotenv.config();

app.use(express.json());

// cors 설정
app.use(
  cors({
    origin: "http://localhost:3000",
    method: ["GET", "POST"],
    credentials: true,
  })
);

// session 설정
app.use(
  session({
    name: "session ID",
    secret: process.env.SESSION_SECRET,
    resave: false,
    saveUninitialized: false,
    cookie: {
      maxAge: 24 * 60 * 60 * 1000,
      httpOnly: false,
      secure: false,
    },
  })
);

// session 확인 미들웨어
app.use("/", (req, res, next) => {
  try {
    if (req.session.views) {
      req.session.views++;
    } else {
      req.session.views = 1;
    }
    console.log("session info", req.session);
    next();
  } catch (error) {
    console.error(error);
    next(error);
  }
});

app.get("/session", (res, req) => {
  console.log("/session requested");
  // session을 받아오는 로직

  res.status(200).json("session information");
});

app.post("/login", (req, res) => {
  const userInfo = userDB.filter((item) => {
    return item.email === req.body.email;
  });

  // session 생성
  req.session.save(() => {
    req.session.user = {
      email: userInfo[0].email,
      username: userInfo[0].username,
    };
    const data = req.session;
    res.status(200).json({ data });
  });
});

app.listen(8122, () => {
  console.log("server is on 8122...");
});
