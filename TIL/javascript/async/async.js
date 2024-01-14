'use strict';
// [드림코딩 - JS] 13. async/await. Promise APIs
// https://youtu.be/aoQSOZfz3vQ?si=E2WapbUHF9NurpXy

// async & await
// clear style of using promise :)

// 1. async
async function fetchUser() {
  // do network request in 10 secs...
  return 'ellie';
}

const user = fetchUser();
user.then(console.log);
console.log(user);

// 2.await
function delay(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}
async function getApple() {
  await delay(2000);
  // throw 'error';
  return '🍎';
}
async function getBanana() {
  await delay(4000);
  return '🍌';
}
// function getBanana() {
//   return delay(3000) //
//     .then(() => '🍌');
// }

async function pickFruits1() {
  try {
    const apple = await getApple();
    const banana = await getBanana();
    return `${apple} + ${banana}`;
  } catch (error) {
    return error;
  }
}
// function pickFruits2() {
//   return getApple().then((apple) => {
//     return getBanana().then((banana) => `${apple} + ${banana}`);
//   });
// }
async function pickFruits2() {
  try {
    const applePromise = getApple();
    const bananaPromise = getBanana();
    const apple = await applePromise;
    const banana = await bananaPromise;
    return `${apple} + ${banana}`;
  } catch (error) {
    return error;
  }
}
pickFruits1().then((fruits) => console.log(`${fruits} 1. plane`));
pickFruits2().then((fruits) => console.log(`${fruits} 2. with Promise`));

// 3. useful Promise API
function pickAllFruits() {
  return Promise.all([getApple(), getBanana()]).then((fruits) =>
    fruits.join(' + ')
  );
}
pickAllFruits().then((fruits) => console.log(`${fruits} Promise.all([])`));

function pickOnlyOne() {
  return Promise.race([getApple(), getBanana()]);
}
pickOnlyOne().then((fruits) => console.log(`${fruits} Promise.race([])`));
