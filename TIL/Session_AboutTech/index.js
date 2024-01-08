const express = require("express");
const session = require("express-session");
const cors = require("cors");
const dotenv = require("dotenv");

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



app.listen(8122, () => {
  console.log("server is on 8122...");
});
