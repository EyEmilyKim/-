import Button from '@mui/material/Button';
import ButtonGroup from '@mui/material/ButtonGroup';
import Dialog from '@mui/material/Dialog';
import DialogTitle from '@mui/material/DialogTitle';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogActions from '@mui/material/DialogActions';
import { useState } from 'react';

export default function Article() {
  const [open, setOpen] = useState(false);

  return (
    <article>
      <h2>Welcome</h2>
      Lorem ipsum dolor sit amet consectetur, adipisicing elit. Ab a sapiente nobis recusandae tempora culpa vel! Non reprehenderit unde rem provident ab in aliquam sit. Sit voluptatem dignissimos assumenda nulla.
      <br />
      <ButtonGroup className='margin_right'>
        <Button variant='outlined' onClick={()=>{setOpen(true);}}>Create</Button>
        <Button variant='outlined'>Update</Button>
      </ButtonGroup>
      <Button variant='outlined'>Delete</Button>

      <Dialog open={open}>
        <DialogTitle>Create</DialogTitle>
        <DialogContent>
          <DialogContentText>Hello Create ~~!</DialogContentText>
        </DialogContent>
        <DialogActions>
        <Button variant='outlined'>Create</Button>
        <Button variant='outlined' onClick={()=>{setOpen(false);}}>Cancel</Button>
        </DialogActions>
      </Dialog>
    </article>
  );
}
