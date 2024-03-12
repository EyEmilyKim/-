const fn = require('./fn');

// 테스트 전후 작업
// beforeAll, afterAll

let user;

beforeAll(async () => {
  user = await fn.connectUserDb();
});
afterAll(async () => {
  return fn.disconnectUserDb();
});

test('이름은 Mike', () => {
  expect(user.name).toBe('Mike');
});
test('나이는 30', () => {
  expect(user.age).toBe(30);
});
test('성별은 남성', () => {
  expect(user.gender).toBe('male');
});
