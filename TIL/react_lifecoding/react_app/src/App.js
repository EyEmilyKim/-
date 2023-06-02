import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
// import Header from './components/Header';
import Nav from './components/Nav';
import Article from './components/Article';
// import Create from './components/Create';
import * as Components from './components';


function Create(props){
  return <article>
    <h2>Create</h2>
    <form onSubmit={event=>{
      event.preventDefault();
      const title = event.target.title.value;
      const body = event.target.body.value;
      props.onCreate(title, body);
    }}>
      <p><input type='text' name='title' placeholder='제목을 입력하세요' /></p>
      <p><textarea name='body' placeholder='내용을 입력하세요' /></p>
      <p><input type="submit" value="Create" /></p>
    </form>
  </article>
}

function App() {
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);
  console.log('mode', mode);
  console.log('id', id);
  const [topics, setTopics] = useState([
    {id:1, title:'html', body:'html is ....'},
    {id:2, title:'css', body:'css is ....'},
    {id:3, title:'javascript', body:'javascript is ....'}
  ]);
  const [nextId, setNextId] = useState(4);
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
  } else if(mode === 'CREATE'){
    content = <Create onCreate={(_title, _body)=>{
      const newTopic = { id: nextId, title: _title, body: _body };
      // const newTopics = [...topics];
      // newTopics.push(newTopic);
      // setTopics(newTopics);
      setTopics([...topics, newTopic]);
      setMode('READ');
      setId(nextId);
      setNextId(nextId+1);
    }} />
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

      <a href='/create' onClick={event =>{
        event.preventDefault();
        setMode('CREATE');
      }}>Create</a>

    </div>
  );
}

export default App;
