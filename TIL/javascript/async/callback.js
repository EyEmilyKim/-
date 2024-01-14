'use strict';
// [드림코딩 - JS] 11. 콜백지옥 (JavaScript ES6)
// https://youtu.be/s1vpVCrT8f4?si=KppFCXvXShBsOhPk

// JavaScript is synchronous.
// Execute the code block in order after hoisting.
// hoisting: var, function declaration
console.log('1');
setTimeout(() => console.log('2'), 1000);
console.log('3');

// Synchronous callback
function printImmediately(print) {
  print();
}
printImmediately(() => console.log('hello'));

// Asynchronous callback
function printWithDelay(print, timeout) {
  setTimeout(print, timeout);
}
printWithDelay(() => console.log('async callback'), 2000);

// Callback Hell example
class UserStorage {
  loginUser(id, pw, onSuccess, onError) {
    setTimeout(() => {
      if (
        (id === 'ellie' && pw === 'dream') ||
        (id === 'coder' && pw === 'academy')
      ) {
        onSuccess(id);
      } else {
        onError(new Error('not found'));
      }
    }, 2000);
  }

  getRoles(user, onSuccess, onError) {
    setTimeout(() => {
      if (user === 'ellie') {
        onSuccess({ name: 'ellie', role: 'admin' });
      } else {
        onError(new Error('no access'));
      }
    });
  }
}

const userStorage = new UserStorage();
const id = prompt('enter your id');
const pw = prompt('enter your password');
userStorage.loginUser(
  id,
  pw,
  (user) => {
    userStorage.getRoles(
      user,
      (userWithRole) => {
        alert(
          `Hello ${userWithRole.name}, you have a/an ${userWithRole.role} role`
        );
      },
      (error) => {
        alert(error);
        console.log(error);
      }
    );
  },
  (error) => {
    alert(error);
    console.log(error);
  }
);

// 콜백체인의 문제점
// 1. 코드 가독성이 좋지 않다.
// 2. 에러 발생시, 문제 분석, 유지 보수가 쉽지 않다.
