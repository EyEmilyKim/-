import './App.css';
import { useState } from 'react';
// import Header from './components/Header';
import Nav from './components/Nav';
import Article from './components/Article';
import Create from './components/Create';
import Update from './components/Update';
import * as Components from './components';

function App() {
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);
  console.log('mode', mode);
  console.log('id', id);
  const [topics, setTopics] = useState([
    { id: 1, title: 'HTML', body: 'HTML is ....' },
    { id: 2, title: 'CSS', body: 'CSS is ....' },
    { id: 3, title: 'JavaScript', body: 'JavaScript is ....' },
  ]);
  const [nextId, setNextId] = useState(4);
  let content = null;
  let contextControl = null;
  if (mode === 'WELCOME') {
    content = <Article title="Welcome" body="생활코딩 2022 React 예제 입니다 :)"></Article>;
  } else if (mode === 'READ') {
    let title,
      body = null;
    for (let i = 0; i < topics.length; i++) {
      if (topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
        break;
      }
    }
    content = <Article title={title} body={body}></Article>;
    contextControl = (
      <>
        <li>
          <a
            href={'/update/' + id}
            onClick={(event) => {
              event.preventDefault();
              setMode('UPDATE');
              setId(id);
            }}
          >
            Update
          </a>
        </li>
        <li>
          <input
            type="button"
            value="Delete"
            onClick={() => {
              if (!window.confirm('정말 삭제하시겠습니까?')) return false;
              const newTopics = [];
              for (let i = 0; i < topics.length; i++) {
                if (topics[i].id !== id) {
                  newTopics.push(topics[i]);
                }
              }
              setTopics(newTopics);
              setMode('WELCOME');
            }}
          />
        </li>
      </>
    );
  } else if (mode === 'CREATE') {
    content = (
      <Create
        onCreate={(_title, _body) => {
          const newTopic = { id: nextId, title: _title, body: _body };
          // const newTopics = [...topics];
          // newTopics.push(newTopic);
          // setTopics(newTopics);
          setTopics([...topics, newTopic]);
          setMode('READ');
          setId(nextId);
          setNextId(nextId + 1);
        }}
      />
    );
  } else if (mode === 'UPDATE') {
    let __title,
      __body = null;
    for (let i = 0; i < topics.length; i++) {
      if (topics[i].id === id) {
        __title = topics[i].title;
        __body = topics[i].body;
        break;
      }
    }
    content = (
      <Update
        title={__title}
        body={__body}
        onUpdate={(_title, _body) => {
          const updateTopic = { id: id, title: _title, body: _body };
          const newTopics = [...topics];
          for (let i = 0; i < newTopics.length; i++) {
            if (newTopics[i].id === id) {
              newTopics[i] = updateTopic;
              break;
            }
          }
          setTopics(newTopics);
          setMode('READ');
        }}
      />
    );
  }

  return (
    <div>
      <Components.Header
        title="WEB"
        onChangeMode={() => {
          setMode('WELCOME');
          setId(null);
        }}
      ></Components.Header>

      <Nav
        topics={topics}
        onChangeMode={(_id) => {
          setMode('READ');
          setId(_id);
        }}
      ></Nav>

      <div className="content">{content}</div>

      <ul>
        <li>
          <a
            href="/create"
            onClick={(event) => {
              event.preventDefault();
              setMode('CREATE');
            }}
          >
            Create
          </a>
        </li>
        {contextControl}
      </ul>
    </div>
  );
}

export default App;
