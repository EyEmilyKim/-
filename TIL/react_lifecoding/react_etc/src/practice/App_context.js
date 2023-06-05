import './App_context.css';
import {createContext, useContext} from 'react';

const themeDefault = { border: '10px solid green' };
const themeContext = createContext(themeDefault);

function App(){
    const theme = useContext(themeContext);
    // console.log('theme', theme);
    return(
        <themeContext.Provider value={{border:'10px solid blue'}}>
        <>
        <h2>Context Practice!</h2>
        <div className="root" style={theme}>
            <h2>Top</h2>
            <Sub1 />
        </div>
        </>
        </themeContext.Provider>
    )
}

function Sub1(){
    const theme = useContext(themeContext);
    return (
        <themeContext.Provider value={{border:'10px solid red'}}>
        <div style={theme}>
            <h2>Sub1</h2>
            <Sub2/>
        </div>
        </themeContext.Provider>
    )
}
function Sub2(){
    const theme = useContext(themeContext);
    return (
        <div style={theme}>
            <h2>Sub2</h2>
            <Sub3/>
        </div>
    )
}
function Sub3(){
    const theme = useContext(themeContext);
    return (
        <div style={theme}>
            <h2>Sub3</h2>
        </div>
    )
}
export default App;
