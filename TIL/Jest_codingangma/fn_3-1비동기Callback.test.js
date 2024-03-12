const fn = require('./fn');

// 비동기 코드 테스트
// 콜백 패턴

test('3초 후에 받아온 이름은 Mike', (done) => {
  function callback(name) {
    try {
      expect(name).toBe('Mike');
      done();
    } catch (error) {
      done();
    }
  }
  fn.getName(callback);
});

test('0 + 1은 1이야.', () => {
  expect(fn.add(0, 1)).toBe(1);
});
