// async 4.
// Callback Hell example💩 -> ✨✨✨✨✨

class UserStorage {
  loginUser(id, pw) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (
          (id === 'ellie' && pw === 'dream') ||
          (id === 'coder' && pw === 'academy')
        ) {
          resolve(id);
        } else {
          reject(new Error('not found'));
        }
      });
    });
  }

  getRoles(user) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (user === 'ellie') {
          resolve({ name: 'ellie', role: 'admin' });
        } else {
          reject(new Error('no access'));
        }
      });
    });
  }
}

// const userStorage = new UserStorage();
// const id = prompt('enter your id');
// const pw = prompt('enter your password');
// userStorage
//   .loginUser(id, pw) //
//   .then(userStorage.getRoles)
//   .then((user) => {
//     alert(`Hello ${user.name}, you have a/an ${user.role} role`);
//   })
//   .catch((error) => {
//     console.log(error);
//     alert(error);
//   });

async function operateLogin() {
  const userStorage = new UserStorage();
  const id = prompt('enter your id');
  const pw = prompt('enter your password');
  try {
    const user = await userStorage.loginUser(id, pw);
    const userWithRole = await userStorage.getRoles(user);
    alert(
      `Hello ${userWithRole.name}, you have a/an ${userWithRole.role} role`
    );
  } catch (error) {
    console.log(error);
    alert(error);
  }
}

operateLogin();
