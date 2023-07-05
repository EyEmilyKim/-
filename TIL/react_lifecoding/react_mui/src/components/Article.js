import Button from '@mui/material/Button';
import ButtonGroup from '@mui/material/ButtonGroup';

export default function Article() {
  return (
    <article>
      <h2>Welcome</h2>
      Lorem ipsum dolor sit amet consectetur, adipisicing elit. Illum accusamus perferendis dicta cumque sit vel voluptatem ex inventore doloremque reprehenderit. Modi minima autem explicabo odio ducimus. Earum nemo non alias.
      Nostrum expedita qui odit corrupti beatae autem minus quia, quo repudiandae dolor quae ullam. Dolorem ratione repudiandae incidunt dolorum similique earum asperiores, ad eveniet voluptas laborum amet quis obcaecati exercitationem.
      Nobis accusamus necessitatibus sunt cupiditate voluptate voluptas dolorum vitae itaque soluta? Provident dolore voluptatibus aliquid dignissimos quis, ex error ab nostrum at enim, minima et ipsum tenetur labore. Dolor, odio.
      <br />
      <ButtonGroup className='margin_right'>
        <Button variant='outlined'>Create</Button>
        <Button variant='outlined'>Update</Button>
      </ButtonGroup>
      <Button variant='outlined'>Delete</Button>
    </article>
  );
}
