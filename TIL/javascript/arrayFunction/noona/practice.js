console.log("=========================================")

let names_ = [
    "Steven Paul Jobs",
    "Bill Gates",
    "Mark Elliot Zuckerberg",
    "Elon Musk",
    "Jeff Bezos",
    "Warren Edward Buffett",
    "Larry Page",
    "Larry Ellison",
    "Tim Cook",
    "Lloyd Blankfein",
];

/** map 문제 */

// 1. 모든 이름을 대문자로 바꾸어서 출력하시오.
let result1 = names_.map((item)=>{
    return item.toUpperCase()
})
console.log("1 : ", result1);
// > (10) ['STEVEN PAUL JOBS', 'BILL GATES', 'MARK ELLIOT ZUCKERBERG', 'ELON MUSK', 'JEFF BEZOS', 'WARREN EDWARD BUFFETT', 'LARRY PAGE', 'LARRY ELLISON', 'TIM COOK', 'LLOYD BLANKFEIN']
let upperCaseName = names_.map((item)=>item.toUpperCase())
console.log(upperCaseName)

// 2. 성을제외한 이름만 출력하시오. (예-[“Steven”,“Bill”,“Mark”,“Elon”…])
let result2 = names_.map((item)=>{
    return item.split(' ')[0];
})
console.log("2 : ", result2);
// > (10) ['Steven', 'Bill', 'Mark', 'Elon', 'Jeff', 'Warren', 'Larry', 'Larry', 'Tim', 'Lloyd']
let firstNames = names_.map((item)=>item.split(' ')[0])
console.log(firstNames)

/*
var text = 'Java Script';
var tokens = text.split(' '); # 공백을 기준으로 문자열을 분리
console.log(tokens[0]); // 'Java'
*/

// 3. 이름의 이니셜만 출력하시오. (예-[“SPU”,“BG”,“MEZ”,“EM”…])
let result3 = names_.map((item)=>{
    let block = item.split(' '); // > ['Steven', 'Paul', 'Jobs'] ...
    let initial = "";
    for(let i=0; i<block.length; i++){
        initial = initial + block[i].charAt(0);
    }
    return initial;
})
console.log("3 : ", result3);
// > (10) ['SPJ', 'BG', 'MEZ', 'EM', 'JB', 'WEB', 'LP', 'LE', 'TC', 'LB']
let initialOnly = names_.map((item) => {
    let splitName = item.split(" ");
    let initial = "";
    splitName.forEach((nameItem) => (initial += nameItem[0]));
    return initial;
  })
console.log(initialOnly)

/*
let String = "test";
console.log("String[2] : ", String[2]); // > s
*/


/** filter 문제 */

// 4. 이름에 a를 포함한 사람들을 출력하시오.
let result4 = names_.filter((item)=>{
    return item.includes('a');
})
console.log("4 : ", result4);
// > (7) ['Steven Paul Jobs', 'Bill Gates', 'Mark Elliot Zuckerberg', 'Warren Edward Buffett', 'Larry Page', 'Larry Ellison', 'Lloyd Blankfein']
let includeA = names_.filter((item)=>item.includes('a'))
console.log(includeA)

// ★ 5. 이름에 같은 글자가 연속해서 들어간 사람을 출력하시오. (예-tt,ff,ll 이런 글자들)
let doubleCha = ['aa','bb','cc','dd','ee','ff','gg','hh','ii','jj','kk','ll','mm','nn','oo','pp','qq','rr','ss','tt','uu','vv','ww','xx','yy','zz'];
let result5 = [];
names_.forEach((item)=>{
    for(let i=0; i<doubleCha.length; i++){
        if(item.includes(doubleCha[i])) result5.push(item);
    }
})
set5 = Array.from(new Set(result5))
// console.log("5. result5 : ", result5); 
// // > (10) ['Bill Gates', 'Mark Elliot Zuckerberg', 'Jeff Bezos', 'Warren Edward Buffett', 'Warren Edward Buffett', 'Warren Edward Buffett', 'Larry Page', 'Larry Ellison', 'Larry Ellison', 'Tim Cook']
console.log("5. set5 : ", set5); 
// > (7) ['Bill Gates', 'Mark Elliot Zuckerberg', 'Jeff Bezos', 'Warren Edward Buffett', 'Larry Page', 'Larry Ellison', 'Tim Cook']

let doubleLetter =  names_.filter((item) => {
    let splitName = item.split("");
    // console.log("splitName : ",splitName); 
    // > ['S', 't', 'e', 'v', 'e', 'n', ' ', 'P', 'a', 'u', 'l', ' ', 'J', 'o', 'b', 's']...
    return splitName.some((letter, index) => letter == splitName[index + 1]);
  })
console.log(doubleLetter)

/** some 문제 */

// 6. 전체 이름의 길이가 20자 이상인 사람이 있는가?
let result6 = names_.some((item)=>{
    return item.length >= 20;
})
console.log("6 : ", result6);
// > true
console.log(names_
.some((item)=>item.length>=20))

// 7. 성을 제외한 이름에 p를 포함한 사람이 있는가?(대소문자 상관 no)
/*
let str = "Hello Java Script";
let lastIndex = str.lastIndexOf(' '); // > 10
let lastNameExcluded = str.substring(0, lastIndex); // > 'Hello Java'
let result_test = lastNameExcluded.toLowerCase(); // > 'hello java'
console.log("7. test : ", result_test);
*/
let result7 = names_.some((item)=>{
    return item.toLowerCase().substring(0,item.lastIndexOf(' ')).includes('p');
})
console.log("7. result7 : ", result7);
// > true
console.log(names_
.some((item)=>{
    let splitName = item.split(' ')
    splitName.pop()
    return splitName.some(eachName=>eachName.toLocaleLowerCase().includes("p"))
}))

/** every 문제 */

// 8. 모두의 전체 이름의 길이가 20자 이상인가?
let result8 = names_.every((item)=>{
    return item.length >= 20;
})
console.log("8 : ", result8);
// > false
console.log(names_
.every(item=>item.length>=20))

// 9. 모두의 이름에 a 가 포함되어 있는가?
let result9 = names_.every((item)=>{
    return item.includes('a')
})
console.log("9 : ", result9);
// > false
console.log(names_
.every(item=>item.includes('a')))

/** find 문제 */

// 10. 전체 이름의 길이가 20자 이상인 사람을 찾으시오.
let result10 = names_.find((item)=>{
    return item.length >= 20;
})
console.log("10 : ", result10)
// > Mark Elliot Zuckerberg
console.log(names_
.find(item=>item.length>=20))

// 11. 미들네임이 포함되어있는 사람을 찾으시오.(예-Steven Paul Jobs)
let result11 = names_.find((item)=>{
    return item.split(' ').length >= 3;
})
console.log("11 : ", result11);
// > Steven Paul Jobs
console.log(names_
.find(item=>item.split(' ').length>=3))

/** findIndex 문제 */

// 12. 전체 이름의 길이가 20자 이상인 사람의 인덱스 번호를 찾으시오.
let result12 = names_.findIndex((item)=>{
    return item.length >= 20;
})
console.log("12 : ", result12);
// > 2
console.log(names_
.findIndex(item=>item.length>=20))

// 13. 미들네임이 포함되어있는 사람의 인덱스 번호를 찾으시오.
let result13 = names_.findIndex((item)=>{
    return item.split(' ').length >= 3;
})
console.log("13 : ", result13);
// > 0
console.log(names_
.findIndex(item=>item.split(' ').length>=3))