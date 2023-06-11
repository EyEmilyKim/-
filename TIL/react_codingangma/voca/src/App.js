import CreateWord from "./components/CreateWord";
import UpdateWord from "./components/UpdateWord";
import CreateDay from "./components/CreateDay";
import Day from "./components/Day";
import DayList from "./components/DayList";
import EmptyPage from "./components/EmptyPage";
import Header from "./components/Header";
import {BrowserRouter, Routes, Route} from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<DayList />} />
        <Route path="/day/:day" element={<Day />} />
        <Route path="/create_word" element={<CreateWord />} />
        <Route path="/create_day" element={<CreateDay />} />
        <Route path="/update_word/:word" element={<UpdateWord />} />
        <Route path="*" element={<EmptyPage />} />
      </Routes>
    </div>
    </BrowserRouter>
  );
}

export default App;
