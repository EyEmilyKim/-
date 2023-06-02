import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
// import Header from './components/Header';
import Nav from './components/Nav';
import Article from './components/Article';
import * as Components from './components';


function App() {
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);
  console.log('mode', mode);
  console.log('id', id);
  const topics = [
    {id:1, title:'html', body:'html is ....'},
    {id:2, title:'css', body:'css is ....'},
    {id:3, title:'javascript', body:'javascript is ....'}
  ]
  let content = null;
  if(mode === 'WELCOME'){
    content = <Article title="Welcome" body="Hello, WEB"></Article>
  } else if(mode === 'READ'){
    let title, body = null;
    for(let i=0; i<topics.length; i++){
      console.log(topics[i].id , id);
      if(topics[i].id === id){
        title = topics[i].title;
        body = topics[i].body;
        break;
      } 
    }
    content = <Article title={title} body={body}></Article>
  }

  return (
    <div>
      <Components.Header title="WEB" onChangeMode={()=>{
        setMode('WELCOME');
        setId(null);
      }}></Components.Header>

      <Nav topics={topics} onChangeMode={(_id)=>{
        setMode('READ');
        setId(_id);
      }}></Nav>

      <div className='content'>{content}</div>

    </div>
  );
}

export default App;
