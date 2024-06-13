import { useNavigate, useParams } from 'react-router-dom';
import Word, { IWord } from './Word';
import useFetch from '../hooks/useFetch';

export default function Day() {
  const { day } = useParams();
  const words: IWord[] = useFetch(`http://localhost:3001/words?day=${day}`);
  // console.log(`Day() day : ${day}`);
  console.log(`Day() words :`, words);
  // console.log('Day() words.length', words.length);
  const navigate = useNavigate();
  const maxDay = useFetch(`http://localhost:3001/days`).length;
  const isMax = Number(day) == maxDay ? true : false;
  const isMin = Number(day) == 1 ? true : false;

  function goPrevDay() {
    const prevDay = Number(day) - 1;
    if (!isMin) {
      navigate(`/day/${prevDay}`);
    }
  }
  function goNextDay() {
    const nextDay = Number(day) + 1;
    if (!isMax) {
      navigate(`/day/${nextDay}`);
    }
  }

  function deleteDayFinally() {
    fetch(`http://localhost:3001/days/${day}`, {
      method: 'DELETE',
    })
      .then((res) => {
        if (res.ok) {
          alert('해당 날짜 삭제가 완료되었습니다.');
          console.log('해당 날짜 삭제가 완료되었습니다.');
          navigate('/');
        }
      })
      .catch((error) => {
        console.log('서버 에러 발생: ', error);
      });
  }

  function deleteDay() {
    if (window.confirm('해당 일자의 단어가 모두 삭제됩니다.\n정말 삭제하시겠습니까?')) {
      if (words.length !== 0) {
        console.log(`deleteDay() day : ${day} -> words !== 0`);
        //해당 날짜 words 순회하며 delete 요청 -> 각각의 결과 배열로 받기
        const wordsDeletePromises = words.map((word) => {
          return fetch(`http://localhost:3001/words/${word.id}`, {
            method: 'DELETE',
          });
        });
        //words 삭제 모두 완료되면 log 후 day 삭제
        Promise.all(wordsDeletePromises).then(() => {
          // console.log('wordsDeletePromises', wordsDeletePromises);
          console.log('해당 날짜의 단어가 모두 삭제되었습니다.');
          deleteDayFinally();
        });
      } else {
        console.log(`deleteDay() day : ${day} -> words === 0`);
        deleteDayFinally();
      }
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
            <Word word={word} key={word.id} />
          ))}
        </tbody>
      </table>
      <div className="flex">
        <button
          onClick={goPrevDay}
          style={{
            opacity: isMin ? 0.3 : 1,
          }}
        >
          ◀
        </button>
        <button
          onClick={goNextDay}
          style={{
            opacity: isMax ? 0.3 : 1,
          }}
        >
          ▶
        </button>
      </div>
    </>
  );
}
