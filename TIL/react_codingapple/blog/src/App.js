/* eslint-disable */

import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {
  let [post, post변경] = useState(['구름 닮은 빵', '동현 동원 동물원', '당근 거래 후기']);
  let [발행일, c] = useState(['2023-05-31', '2023-05-30']);
  let [따봉, 따봉변경] = useState(0);
  const text = '🥕🐰🥐☁️🐶✨';

  const [isModalOpen, setIsModalOpen] = useState(false);

  return (
    <div className="App">
      <Header />

      <button
        onClick={() => {
          let sort = [...post.sort()];
          post변경(sort);
        }}
      >
        ✨가나다순✨
      </button>

      <div className="list">
        <h4>
          {post[0]}{' '}
          <button
            onClick={() => {
              // let copy = {post};
              let copy = [...post];
              copy[0] = '빵 닮은 구름';
              post변경(copy);
            }}
          >
            ✨글 수정✨
          </button>
        </h4>
        <p>2월 17일 발행</p>
      </div>

      <div className="list">
        <h4>
          {post[1]}{' '}
          <span
            onClick={() => {
              따봉변경(따봉 + 1);
            }}
          >
            👍
          </span>{' '}
          {따봉}{' '}
        </h4>
        <p>{발행일[0]} 발행</p>
      </div>

      <div className="list">
        <h4>
          {post[2]} <button onClick={() => setIsModalOpen(!isModalOpen)}>✨글 열기/닫기🔍</button>
        </h4>
        <p>{발행일[1]} 발행</p>
      </div>

      {isModalOpen ? <Modal post={post[2]} date={발행일[1]} content={text}></Modal> : null}
    </div>
  );
}

function Header() {
  return (
    <div className="black-nav">
      <h4>블로그 - 코딩애플과 함께 하는 React 연습</h4>
    </div>
  );
}

function Modal(props) {
  const post = props.post;
  const date = props.date;
  const content = props.content;
  return (
    <>
      <div className="modal">
        <h4>{post}</h4>
        <p>{date}</p>
        <p>{content}</p>
      </div>
      <div></div>
    </>
  );
}

export default App;
