import "./Login.css";
import axios from "axios";
import { useState, useContext } from "react";
import { LoginContext } from "../context/LoginContext";

export default function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const { isLogin, setIsLogin } = useContext(LoginContext);

  const login = () => {
    console.log("login called");

    axios({
      url: "http://localhost:8122/login",
      method: "POST",
      withCredentials: true,
      data: {
        email: email,
        password: password,
      },
    }).then((result) => {
      if (result.status === 200) {
        setIsLogin(true);
      } else {

      }
    });
  };

  return (
    <div>
      <div className="loginContainer">
        <div className="inputGroup">
          <label className="inputLabel">email</label>
          <input
            type="text"
            onChange={(e) => setEmail(e.target.value)}
            placeholder="email"
            value={email}
            className="inputValue"
          />
        </div>
        <div className="inputGroup">
          <label className="inputLabel">password</label>
          <input
            type="password"
            onChange={(e) => setPassword(e.target.value)}
            placeholder="password"
            value={password}
            className="inputValue"
          />
        </div>
        <button onClick={login} className="loginButton">Login</button>
      </div>
    </div>
  );
}
