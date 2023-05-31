/* eslint-disable */

import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

  let [post, post변경] = useState(['구름 닮은 빵','으라차차 차은영']);
  let [글제목, 글제목변경] = useState(['당근 거래 후기', '동현 동원 동물원']);
  let [발행일, c] = useState(['2023-05-31', '2023-05-30']);
  let [따봉, 따봉변경] = useState(0);


  return (
    <div className="App">
      <div className="black-nav">
        <h4>블로그 - 코딩애플과 함께 하는 React 연습</h4>
      </div>
      <div className="list">
        <h4>{ post[0] } <span onClick={()=>{ post변경(post[+1]) }}>✨</span></h4>
        <p>2월 17일 발행</p>
      </div>
      <div className="list">
        <h4>{ 글제목[0] } <span onClick={()=>{ 따봉변경(따봉+1) }}>👍</span> {따봉} </h4>
        <p>{ 발행일[0] } 발행</p>
      </div>
      <div className="list">
        <h4>{ 글제목[1] }</h4>
        <p>{ 발행일[1] } 발행</p>
      </div>
    </div>
  );
}

export default App;
