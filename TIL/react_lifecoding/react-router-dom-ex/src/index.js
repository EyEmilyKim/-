import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter as Router, Routes, Route, Link, NavLink } from "react-router-dom"; 

function Home() {
  return (
    <div>
      <h2>Home</h2>
      Home...
    </div>
  )
}

function Topics() {
  return (
    <div>
      <h2>Topics</h2>
      <ul>
        <li><NavLink to="/topics/1">HTML</NavLink></li>
        <li><NavLink to="/topics/2">JS</NavLink></li>
        <li><NavLink to="/topics/3">REACT</NavLink></li>
      </ul>
      <Routes>
        <Route path="1" element={"HTML is...."}></Route>
        <Route path="2" element={"JS is...."}></Route>
        <Route path="3" element={"REACT is...."}></Route>
{/*         //출력Test
        <Route path="1" element={<h3>HTML is....</h3>}></Route> //h3으로 출력됨.
        <Route path="2" element={"JS is...."}></Route> //text로 출력됨. //↑←""또는 h3태그 빼면 에러남.
        <Route path="3" >REACT is....</Route> //""있어도 없어도 출력안됨. h3 태그 넣으면 에러남. */}
      </Routes>
    </div>
  )
}

function Contact() {
  return (
    <div>
      <h2>Contact</h2>
      Contact...
    </div>
  )
}

function App(){
  return (
    <Router>
      
    <div>
      <h1>React Router DOM example</h1>
      <ul>
        <li><NavLink to="/">Home</NavLink></li>
        <li><NavLink to="/topics">Topics</NavLink></li>
        <li><NavLink to="/contact">Contact</NavLink></li>
      </ul>
      <Routes>
        <Route path="/" element={<Home/>}></Route>
        <Route path="/topics/*" element={<Topics/>}></Route>
        <Route path="/contact" element={<Contact/>}></Route>
      </Routes>
    </div>

    </Router>
  )
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
