let names = [
    "Steven Paul Jobs",
    "Bill Gates",
    "Mark Elliot Zuckerberg",
    "Elon Musk",
    "Jeff Bezons",
    "Warren Edward Buffet",
    "Larry Page",
    "Larry Ellison",
    "Tim Cook",
    "Lloid Blankfein"
]

let ceoList = [
    {name:"Larry Page", age:23, ceo:true},
    {name:"Tim Cook", age:40, ceo:true},
    {name:"Elon Musk", age:55, ceo:false}
]

/** 0. for문을 사용한 배열 반복 */
// for (let i=0; i<names.length; i++){
//     console.log(names[i]);
// }


/** 1. forEach() 와 선언된 함수 */
// function printName(item){
//     console.log(item)
// }
// names.forEach(printName)
// forEach()는 함수를 매개변수로 받아서 그 함수에 배열 안 모든 data를 냅다 던져줌.

/** 1. forEach() 와 익명 함수 */
// names.forEach(function (item){
//     console.log(item)
// })

/** 1. forEach() 와 익명 함수 (ES6 문법) */
names.forEach((item)=>{console.log(item)})
names.forEach((item, index)=>{console.log(item, index)})


/** 2. map() */
let data = names.map((item,index)=>{
    return item + "씨"
})
console.log(data)
// ['Steven Paul Jobs씨', 'Bill Gates씨', 'Mark Elliot Zuckerberg씨', 'Elon Musk씨', 'Jeff Bezons씨', 'Warren Edward Buffet씨', 'Larry Page씨', 'Larry Ellison씨', 'Tim Cook씨', 'Lloid Blankfein씨']
// forEach()와 큰 차이 : data를 array로 return해줌. 
// map()은 return 되는 data를 커스텀 가능.
let data_ages = ceoList.map((item)=>{
    return item.age
})
let data_isCeo = ceoList.map((item)=>{
    return item.ceo
})
console.log(data_ages)
// > [23, 40, 55] 
console.log(data_isCeo)
// > [true, true, false]
// 이렇게 원하는 data 만 가져오고 싶을 때 map()을 많이 씀.


/** 3. filter() */
let data2 = ceoList.filter((item)=>{
    return item.age==23
})
console.log(data2)
// > {name: 'Larry Page', age: 23, ceo: true}
let data2_1 = names.filter((item)=>{
    return item.startsWith("L")
})
console.log("filter : ", data2_1)
// > ['Larry Page', 'Larry Ellison', 'Lloid Blankfein']
// true/false 로 딱 떨어지는 조건에 맞는 결과만 보여줌.


/** 4. some() */
let data3 = names.some((item)=>{
    return item.startsWith("L")
})
console.log("some : ", data3)
// > true
let data3_1 = names.some((item)=>{
    return item.startsWith("A")
})
console.log("some : ", data3_1)
// > false
// 조건에 맞는 것이 하나라도 있으면 true, 없으면 false.


/** 5. every() */
let data4 = names.every((item)=>{
    return item.startsWith("L")
})
console.log("every : ", data4)
// > false
let data4_1 = names.every((item)=>{
    return item.length>0
})
console.log("every : ", data4_1)
// > true
// 모든 data 가 조건에 맞으면 true, 아니면 false.


/** 6. find() */
let data5 = names.find((item)=>{
   return item.startsWith("L")
})
console.log("find : ", data5)
// > Larry Page
// filter 와 find 차이점 : 
// 1. filter 는 배열에 담아서 주고, find 는 String type.
// 2. 해당하는 첫번째 data 만 반환. (정확한 값 딱 하나만 찾을 때 좋음)


/** 7. findIndex() */
let data6 = names.findIndex((item)=>{
    return item.startsWith("L")
})
console.log("findIndex : ", data6)
// > 6
// 조건에 맞는 data의 인덱스를 찾아줌.