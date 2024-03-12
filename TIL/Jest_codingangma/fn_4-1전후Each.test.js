const fn = require('./fn');

// 테스트 전후 작업
// beforeEach, afterEach

let num = 10;

afterEach(() => {
  num = 0;
});

test('0 + 1 은 1이야', () => {
  num = fn.add(num, 1);
  expect(num).toBe(1);
});

test('0 + 2 은 2이야', () => {
  num = fn.add(num, 2);
  expect(num).toBe(2);
});

test('0 + 3 은 3이야', () => {
  num = fn.add(num, 3);
  expect(num).toBe(3);
});

test('0 + 4 은 4이야', () => {
  num = fn.add(num, 4);
  expect(num).toBe(4);
});
