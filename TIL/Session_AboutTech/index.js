const express = require("express");
const session = require("express-session");
const cors = require("cors");
const dotenv = require("dotenv");
const userDB = require("./Database");
const FileStore = require("session-file-store")(session);

const app = express();
dotenv.config();

app.use(express.json());

// cors 설정
app.use(
  cors({
    origin: "http://localhost:3000",
    methods: ["GET", "POST"],
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
    store: new FileStore(),
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

// get Session 메뉴
app.get("/session", (req, res) => {
  console.log("/session requested");
  // session을 받아오는 로직

  res.status(200).json("session information");
});

// 로그인
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

// 로그아웃
app.post("/logout", (req, res) => {
  // session destroy;
  req.session.destroy(() => {
    res.status(200).json({ message: "logout success" });
  });
});

// 로그인 상태 유지
app.get("/login/success", (req, res) => {
  try {
    const data = req.session;
    res.status(200).json(data);
  } catch (error) {
    res.status(403).json("User Not Found");
  }
});

app.listen(8122, () => {
  console.log("server is on 8122...");
});
