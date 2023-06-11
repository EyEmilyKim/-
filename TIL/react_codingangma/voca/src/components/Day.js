import { useNavigate, useParams } from "react-router-dom";
import Word from "../components/Word";
import useFetch from "../hooks/useFetch";
import { useState } from "react";

export default function Day() {
  const {day} = useParams();
  const words = useFetch(`http://localhost:3001/words?day=${day}`);
  const history = useNavigate();
  const maxDay = useFetch(`http://localhost:3001/days`).length;
  const isMax = day == maxDay ? true : false;
  const isMin = day == 1 ? true : false;

  function goPrevDay(){
    const prevDay = day - 1;
    if(!isMin){
      history(`/day/${prevDay}`);
    }
  }
  function goNextDay(){
    const nextDay = Number(day) + 1;
    if(!isMax){
      history(`/day/${nextDay}`);
    }
  }

  function deleteDay() {
    if (
      window.confirm("해당 일자의 단어가 모두 삭제됩니다. 정말 삭제하시겠습니까?")
    ) {
      //words 에서 day:4 인 각 word에 대해 delete 요청 -> 각각의 결과 배열로 받기
      const wordsDeletePromises = words.map(word => {
        return fetch(`http://localhost:3001/words/${word.id}`, {
          method: "DELETE",
        });
      });
      //words 삭제 모두 완료되면 alert 후 day 삭제
      Promise.all(wordsDeletePromises)
      .then(() => {
        // alert("해당 날짜의 단어가 모두 삭제되었습니다.");

        fetch(`http://localhost:3001/days/${day}`, {
          method: "DELETE",
        })
        .then((res) => {
          if (res.ok) {
            alert("해당 날짜 삭제가 완료되었습니다.");
            history("/");
          }
        });
      });
    }
  }

  return (
    <>
      <div className="flex">
        <h2>Day {day}</h2>
        <button className="btn_del" onClick={deleteDay}>
          Day삭제
        </button>
      </div>
      {words.length === 0 && <span>Loading...</span>}
      <table>
        <tbody>
          {words.map((word) => (
            <Word word={word} key={word.id}/>
          ))}
        </tbody>
      </table>
      <div className="flex">
        <button onClick={goPrevDay} style={{
          opacity : isMin ? 0.3 : 1, 
        }}>◀</button>
        <button onClick={goNextDay} style={{
          opacity : isMax ? 0.3 : 1, 
        }}>▶</button>
      </div>
    </>
  );
}
