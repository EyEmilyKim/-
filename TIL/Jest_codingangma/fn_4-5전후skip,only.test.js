const fn = require('./fn');

// 테스트 전후 작업
// .only 단독 실행
// .skip 실행 제외

let num = 0;

test('0 + 1 은 1 ', () => {
  expect(fn.add(num, 1)).toBe(1);
});
test('0 + 2 은 2 ', () => {
  expect(fn.add(num, 2)).toBe(2);
});
test('0 + 3 은 3 ', () => {
  expect(fn.add(num, 3)).toBe(3);
});
test.skip('0 + 4 은 4 ', () => {
  expect(fn.add(num, 4)).toBe(4);
  num = 10;
});
test('0 + 5 은 5 ', () => {
  expect(fn.add(num, 5)).toBe(5);
});
// test.only('0 + 5 은 5 ', () => {
//   expect(fn.add(num, 5)).toBe(5);
// });
