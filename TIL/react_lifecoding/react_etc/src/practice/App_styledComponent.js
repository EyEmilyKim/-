import styled from "styled-components";

const SimpleButton = styled.button`
  color: white;
  background-color: green;
`;
const LargeButton = styled(SimpleButton)`
  font-size: 50px;
`;
const ReactButton = (props) => {
  return <button className={props.className}>{props.children}</button>;
};
const ReactLargeButton = styled(ReactButton)`
  font-size: 50px;
`;
const PrimaryButton = styled.button`
  color: ${(props) => (props.primary ? "white" : "default")};
  background-color: ${(props) => (props.primary ? "blue" : "default")};
`;

function App() {
  return (
    <>
      <h2>Styled Component Practice!</h2>
      <div>
        <SimpleButton>Simple</SimpleButton>
        <LargeButton>Large</LargeButton>
      </div>
      <div>
        <ReactButton>React</ReactButton>
        <ReactLargeButton>React Large</ReactLargeButton>
      </div>
      <div>
        <PrimaryButton>Normal</PrimaryButton>
        <PrimaryButton primary>Primary</PrimaryButton>
      </div>
    </>
  );
}

export default App;
