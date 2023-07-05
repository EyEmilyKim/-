import logo from "./logo.svg";
import "./App.css";
import Header from "./components/Header";
import Nav from "./components/Nav";
import Article from "./components/Article";
import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";

function App() {
  return (
    <Container fixed>
      <Header />
      <Grid container>
        <Grid item xs="3">
          <Nav />
        </Grid>
        <Grid item xs="8">
          <Article />
        </Grid>
      </Grid>
    </Container>
  );
}

export default App;
