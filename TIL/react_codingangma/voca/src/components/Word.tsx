import { useState } from "react";
import './Word.css';
import { useNavigate, useParams } from "react-router-dom";

interface IProps {
  word: IWord;
}

export interface IWord{
  day: string;
  eng: string;
  kor: string;
  isDone: boolean;
  id: number;
}

export default function Word({ word: w }: IProps) {
  const {day} = useParams();
  const [word, setWord] = useState(w);
  const [isShow, setIsShow] = useState(false);
  const [isDone, setIsDone] = useState(word.isDone);
  const [isDeleting, setIsDeleting] = useState(false);
  const history = useNavigate();

  function toggleShow() {
    setIsShow(!isShow);
  }
  function toggleDone() {
    // setIsDone(!isDone);
    fetch(`http://localhost:3001/words/${word.id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        ...word,
        isDone: !isDone,
      }),
    })
    .then(res => {
      if(res.ok){
        setIsDone(!isDone);
      }
    });
  }

  function upd(){
    history(`/update_word/${word.id}`);
  }

  function del(){
    if(window.confirm('삭제하시겠습니까?')){
      setIsDeleting(true);
      setTimeout(()=>{

        fetch(`http://localhost:3001/words/${word.id}`, {
          method : 'DELETE',
        }).then(res => {
          if(res.ok){
            setWord({
              ...word, id:0
            });
            console.log(`Word() delete done. -> day : ${day}`);
            history(`/day/${day}`);
          }
        });
        
      }, 600);
    }
  }

  if(word.id === 0){
    return null;
  }

  const wordClassName = isDeleting ? "word-fade-out" : "";

  return (
    <tr className={`${isDone ? "off" : ""} ${wordClassName}`}>
      <td>
        <input type="checkbox" checked={isDone} onChange={toggleDone}/>
      </td>
      <td>{word.eng}</td>
      <td>{isShow && word.kor}</td>
      <td>
        <button onClick={toggleShow}>뜻 {isShow ? "숨기기" : "보기"}</button>
        <button className="btn_upd" onClick={upd}>수정</button>
        <button className="btn_del" onClick={del}>삭제</button>
      </td>
    </tr>
  );
}
