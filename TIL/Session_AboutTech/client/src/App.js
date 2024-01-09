import logo from "./logo.svg";
import "./App.css";
import axios from "axios";
import Login from "./components/Login";
import { LoginContext } from "./context/LoginContext";
import { useContext, useEffect, useState } from "react";

function App() {
  const { isLogin, setIsLogin } = useContext(LoginContext);
  const [user, setUser] = useState(null);
  console.log("isLogin", isLogin);
  console.log("user", user);

  const session = () => {
    // console.log("session called");
    axios({
      url: "http://localhost:8122/session",
      method: "GET",
      withCredentials: true,
    });
  };

  const logout = () => {
    // console.log("logout called");
    axios({
      url: "http://localhost:8122/logout",
      method: "POST",
      withCredentials: true,
    }).then((result) => {
      if (result.status === 200) {
        setIsLogin(false);
      }
    });
  };

  useEffect(() => {
    try {
      axios({
        url: "http://localhost:8122/login/success",
        method: "GET",
        withCredentials: true,
      })
        .then((result) => {
          if (result.data.user) {
            setUser({
              username: result.data.user.username,
              email: result.data.user.userEmail,
            });
            setIsLogin(true);
          }
        })
        .catch((error) => {
          console.log(error);
        });
    } catch (error) {
      console.log(error);
    }
  }, []);

  return (
    <>
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <a onClick={session} className="App-link">
            get Session
          </a>
          {isLogin ? (
            <>
              {user && <h3>{user.username} 님이 로그인하셨습니다.</h3>}
              <button onClick={logout} className="logoutButton">
                Logout
              </button>
            </>
          ) : (
            <Login />
          )}
        </header>
      </div>
    </>
  );
}

export default App;
