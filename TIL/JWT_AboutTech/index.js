const express = require("express");
const dotenv = require("dotenv");
const cookieParser = require("cookie-parser");
const cors = require("cors");

const app = express();
dotenv.config();

app.listen(process.env.PORT, ()=>{
    console.log(`server is on ${process.env.PORT}....`);
})
