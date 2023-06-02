import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
// import Header from './components/Header';
import Nav from './components/Nav';
import Article from './components/Article';
// import Create from './components/Create';
// import Update from './components/Update';
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

function Update(props){
  const [title, setTitle] = useState(props.title);
  const [body, setBody] = useState(props.body);
  return <article>
  <h2>Update</h2>
  <form onSubmit={event=>{
    event.preventDefault();
    const title = event.target.title.value;
    const body = event.target.body.value;
    props.onUpdate(title, body);
  }}>
    <p><input type='text' name='title' placeholder='제목을 입력하세요' 
          value={title} onChange={event=>{
            console.log(event.target.value); 
            setTitle(event.target.value);}
          } /></p>
    <p><textarea name='body' placeholder='내용을 입력하세요' 
          value={body} onChange={event=>{setBody(event.target.value);}} /></p>
    <p><input type="submit" value="Update" /></p>
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
  let contextControl = null;
  if(mode === 'WELCOME'){
    content = <Article title="Welcome" body="Hello, WEB"></Article>
  } else if(mode === 'READ'){
    let title, body = null;
    for(let i=0; i<topics.length; i++){
      if(topics[i].id === id){
        title = topics[i].title;
        body = topics[i].body;
        break;
      } 
    }
    content = <Article title={title} body={body}></Article>
    contextControl = <li><a href={'/update/'+id} onClick={event=>{
      event.preventDefault();
      setMode('UPDATE');
      setId(id);
    }}>Update</a></li>;
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
  } else if(mode === 'UPDATE'){
    let __title, __body = null;
    for(let i=0; i<topics.length; i++){
      if(topics[i].id === id){
        __title = topics[i].title;
        __body = topics[i].body;
        break;
      } 
    }
    content = <Update title={__title} body={__body} onUpdate={(_title, _body)=>{
      const updateTopic = { id: id, title: _title, body: _body };
      const newTopics = [...topics];
      for(let i=0; i<newTopics.length; i++){
        if(newTopics[i].id === id){
          newTopics[i] = updateTopic;
          break;
        } 
      }
      setTopics(newTopics);
      setMode('READ');
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

      <ul>
        <li><a href='/create' onClick={event =>{
            event.preventDefault();
            setMode('CREATE');
          }}>Create</a></li>
        {contextControl}
      </ul>
      
    </div>
  );
}

export default App;
