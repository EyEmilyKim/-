const fn = require('./fn');

// 비동기 코드 테스트
// async, await

// test('3초 후에 나이 30', async () => {
//   const age = await fn.getAge();
//   expect(age).toBe(31);
// });

// ↑ resolves, rejects 로 간략히 ↓

test('3초 후에 나이 30', async () => {
  await expect(fn.getAge()).resolves.toBe(30);
});

test('0 + 1은 1이야.', () => {
  expect(fn.add(0, 1)).toBe(1);
});
