import { useEffect, useRef, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import useFetch from '../hooks/useFetch';

export default function UpdateWord() {
  const wordId = useParams().word;
  const word = useFetch(`http://localhost:3001/words/${wordId}`);
  const [selectedOption, setSelectedOption] = useState(-1);
  useEffect(() => {
    if (word) {
      setSelectedOption(word.day);
    }
  }, [word]);
  const days = useFetch(`http://localhost:3001/days`);
  const [isSaving, setIsSaving] = useState(false);
  const navigate = useNavigate();

  const engRef = useRef(null);
  const korRef = useRef(null);
  const dayRef = useRef(null);

  function onSubmit(e) {
    e.preventDefault();

    if (!isSaving) {
      setIsSaving(true);
      fetch(`http://localhost:3001/words/${wordId}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          eng: engRef.current.value,
          kor: korRef.current.value,
          day: dayRef.current.value,
        }),
      }).then((res) => {
        if (res.ok) {
          setIsSaving(false);
          if (window.confirm('수정이 완료되었습니다.\n해당 단어의 수정된 날짜로 이동할까요?')) {
            navigate(`/day/${dayRef.current.value}`);
          } else {
            navigate(-1);
          }
        }
      });
    }
  }

  function onChangeHandle(e) {
    setSelectedOption(e.target.value);
  }

  return (
    <>
      <h2>Update Word...</h2>
      <form onSubmit={onSubmit}>
        <div className="input_area">
          <label>Eng</label>
          <input type="text" defaultValue={word.eng} ref={engRef} />
        </div>
        <div className="input_area">
          <label>Kor</label>
          <input type="text" defaultValue={word.kor} ref={korRef} />
        </div>
        <div className="input_area">
          <label>Day</label>
          <select ref={dayRef} value={selectedOption} onChange={onChangeHandle}>
            {days.map((day) => (
              <option key={day.id} value={day.day}>
                {day.day}
              </option>
            ))}
          </select>
        </div>
        <button
          style={{
            opacity: isSaving ? 0.3 : 1,
          }}
        >
          {isSaving ? 'Saving...' : '저장'}
        </button>
      </form>
    </>
  );
}
