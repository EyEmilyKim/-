const fn = require('./fn');

// 비동기 코드 테스트
// 프로미스 패턴

// test('3초 후에 받아온 나이는 30', () => {
//   return fn.getAge().then((age) => {
//     expect(age).toBe(30);
//   });
// });

// ↑ resolves, rejects 로 간략히 ↓

test('3초 후에 받아온 나이는 30', () => {
  return expect(fn.getAge()).resolves.toBe(30);
});

// test('3초 후에 에러', () => {
//   return expect(fn.getAge()).rejects.toMatch('에러...');
// });

test('0 + 1은 1이야.', () => {
  expect(fn.add(0, 1)).toBe(1);
});
