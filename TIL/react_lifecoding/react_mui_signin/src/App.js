import "./App.css";
import TextField from "@mui/material/TextField";
import {
  Avatar,
  Button,
  Checkbox,
  FormControlLabel,
  Grid,
  Link,
  Typography,
  Box,
  Container
} from "@mui/material";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";

function App() {
  return (
    <Container component="main" maxWidth="xs">
      <Box
        sx={{
          marginTop: 8,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <Avatar sx={{ m: 1, backgroundColor: "secondary.main" }}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="5">
          Sign in
        </Typography>

        <TextField
          label="Email Address"
          name="email"
          required
          margin="dense"
          fullWidth
          autoComplete="email"
          autoFocus
        />
        <TextField
          label="Password"
          type="password"
          name="password"
          required
          margin="dense"
          fullWidth
          autoComplete="current-password"
        />
        <FormControlLabel
          control={<Checkbox value="remember" color="primary" />}
          label="Remember me"
        />
        <Button
          type="submit"
          fullWidth
          variant="contained"
          sx={{ mt: 3, mb: 2 }}
        >
          SIGN IN
        </Button>

        <Grid container justifyContent="flex-start">
          <Grid item xs>
            <Link>Forgot password?</Link>
          </Grid>
          <Grid item>
            <Link>Sign Up</Link>
          </Grid>
        </Grid>
      </Box>
    </Container>
  );
}

export default App;
