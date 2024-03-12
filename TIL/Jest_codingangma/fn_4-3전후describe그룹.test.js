const fn = require('./fn');

// 테스트 전후 작업
// describe 그룹

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

describe('Car 관련 작업', () => {
  let car;

  beforeAll(async () => {
    car = await fn.connectCarDb();
  });
  afterAll(async () => {
    return fn.disconnectCarDb();
  });

  test('브랜드는 BMW', () => {
    expect(car.brand).toBe('BMW');
  });
  test('모델은 z4', () => {
    expect(car.model).toBe('z4');
  });
  test('색상은 red', () => {
    expect(car.color).toBe('red');
  });
});
