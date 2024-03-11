const fn = require('./fn');

// 문자열 관련
// toMatch
// 정규표현식 따로 알아야..

test('Hello World 에 h 라는 글자가 있나? /대소문자 구분없이', () => {
  expect('Hello World').toMatch(/h/i);
});
