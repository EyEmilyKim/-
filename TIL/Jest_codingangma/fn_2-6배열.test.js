const fn = require('./fn');

// 배열 관련
// toContain

test('유저 리스트에 Mike 가 있나?', () => {
  const user = 'Mike';
  const userList = ['Tom', 'Jane', 'Mike'];

  expect(userList).toContain(user);
});
