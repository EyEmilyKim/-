import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Nav from './components/Nav';
import Article from './components/Article';
import Container from '@mui/material/Container';

function App() {
  return (
    <Container fixed>
      <Header />
      <Nav />
      <Article />
    </Container>
  );
}

export default App;
