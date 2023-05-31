import logo from './logo.svg';
import './App.css';

function App() {

  let post = '강남 우동 맛집';

  return (
    <div className="App">
      <div className="black-nav">
        <h4 style={{color:'red', fontSize:'16px'}}>블로그 - 코딩애플과 함께 하는 React 연습</h4>
      </div>
      <h4 id={post}>{ post }</h4>
    </div>
  );
}

export default App;
