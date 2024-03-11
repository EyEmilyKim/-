const fn = require('./fn');

// toEqual, toStrictEqual
// 객체 등 깊은 비교를 위해서는 toStrictEqual 을 쓰는 것이 좋다

test('이름과 나이를 전달 받아서 객체를 반환해줘 _ toEqual', () => {
  expect(fn.makeUser('Mike', 30)).toEqual({
    name: 'Mike',
    age: 30,
  });
});

test('이름과 나이를 전달 받아서 객체를 반환해줘 _ toStrictEqual', () => {
  expect(fn.makeUser('Mike', 30)).toStrictEqual({
    name: 'Mike',
    age: 30,
  });
});
