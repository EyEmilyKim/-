const fn = require('./fn');

// 테스트 전후 작업
// 실행순서 확인

beforeAll(() => console.log('밖 beforeAll')); // 1
beforeEach(() => console.log('밖 beforeEach')); // 2, 6
afterAll(() => console.log('밖 afterAll')); // 4, 10
afterEach(() => console.log('밖 afterEach')); // 마지막 (= 12)

test('0 + 1 = 1', () => {
  expect(fn.add(0, 1)).toBe(1); // 3
});

describe('describe 내부', () => {
  beforeAll(() => console.log('안 beforeAll')); // 5
  beforeEach(() => console.log('안 beforeEach')); // 7
  afterAll(() => console.log('안 afterAll')); // 9
  afterEach(() => console.log('안 afterEach')); // 마지막 -1 (= 11)

  test('0 + 1 = 1', () => {
    expect(fn.add(0, 1)).toBe(1); // 8
  });
});
