const fn = require('./fn');

// toBeNull
// toBeUndefined
// toBeDefined

test('null은 null이다.', () => {
  expect(null).toBeNull();
});

// toBeTruthy
// toBeFalsy

test('0은 false이다.', () => {
  expect(fn.add(1, -1)).toBeFalsy();
});

test('안 빈 문자열은 true이다.', () => {
  expect(fn.add('hello', 'world')).toBeTruthy();
});
