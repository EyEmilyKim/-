const fn = require('./fn');

// 예외 관련
// toThrow

test('이거 에러 나나요 ?', () => {
  expect(() => fn.throwErr()).toThrow();
});

test('이거 에러 나나요 _ xx ?', () => {
  expect(() => fn.throwErr()).toThrow('xx');
});
