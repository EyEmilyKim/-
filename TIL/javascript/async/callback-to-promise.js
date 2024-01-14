// promise 5.
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

// class UserStorage {
//   loginUser(id, pw, onSuccess, onError) {
//     setTimeout(() => {
//       if (
//         (id === 'ellie' && pw === 'dream') ||
//         (id === 'coder' && pw === 'academy')
//       ) {
//         onSuccess(id);
//       } else {
//         onError(new Error('not found'));
//       }
//     }, 2000);
//   }

//   getRoles(user, onSuccess, onError) {
//     setTimeout(() => {
//       if (user === 'ellie') {
//         onSuccess({ name: 'ellie', role: 'admin' });
//       } else {
//         onError(new Error('no access'));
//       }
//     });
//   }
// }

const userStorage = new UserStorage();
const id = prompt('enter your id');
const pw = prompt('enter your password');
userStorage
  .loginUser(id, pw) //
  .then(userStorage.getRoles)
  .then((user) => {
    alert(`Hello ${user.name}, you have a/an ${user.role} role`);
  })
  .catch((error) => {
    console.log(error);
    alert(error);
  });

// const userStorage = new UserStorage();
// const id = prompt('enter your id');
// const pw = prompt('enter your password');
// userStorage.loginUser(
//   id,
//   pw,
//   (user) => {
//     userStorage.getRoles(
//       user,
//       (userWithRole) => {
//         alert(
//           `Hello ${userWithRole.name}, you have a/an ${userWithRole.role} role`
//         );
//       },
//       (error) => {
//         alert(error);
//         console.log(error);
//       }
//     );
//   },
//   (error) => {
//     alert(error);
//     console.log(error);
//   }
// );
