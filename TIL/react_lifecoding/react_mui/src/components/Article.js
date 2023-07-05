import Button from '@mui/material/Button';
import ButtonGroup from '@mui/material/ButtonGroup';

export default function Article() {
  return (
    <article>
      <h2>Welcome</h2>
      Hello web!
      <br />
      <ButtonGroup className='margin_right'>
        <Button variant='outlined'>Create</Button>
        <Button variant='outlined'>Update</Button>
      </ButtonGroup>
      <Button variant='outlined'>Delete</Button>
    </article>
  );
}
