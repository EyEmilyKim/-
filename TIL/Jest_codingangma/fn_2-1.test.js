const fn = require('./fn');

// toBe 와 toEqual

test('2 더하기 3은 5야.', () => {
  expect(fn.add(2, 3)).toBe(5);
});

test('2 더하기 3은 5야.', () => {
  expect(fn.add(2, 3)).toEqual(5);
});
