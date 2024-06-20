/**
 * JavaScript 로 Heap 구현하기
 * https://cocococo.tistory.com/entry/JavaScript-JavaScript%EB%A1%9C-%ED%9E%99Heap-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0

 * MinHeap 클래스 초기화
(MaxHeap을 사용하고 싶다면 데이터를 음수화해서 MinHeap을 사용하면 된다)
최소 힙의 부모와 자식 간에 다음과 같은 관계가 성립한다.
- 왼쪽 자식의 index = 부모의 index * 2 + 1
- 오른쪽 자식의 index = (부모의 index * 2) + 2
- 부모의 index = Math.floor((자식의 index - 1) / 2)

 * 삽입 연산
Min Heap의 삽입 연산은 다음과 같은 단계로 이루어진다.
1. Heap의 마지막 위치에 요소를 추가한다.
2. 새로운 요소를 추가한 위치에서부터, 부모 노드와 새로 추가된 노드의 값을 비교한다. 만약 새로 추가된 노드의 값이 부모 노드의 값보다 작다면, 부모 노드와 새로 추가된 노드의 위치를 교환한다.
3. 이전 단계에서 교환된 새로 추가된 노드와 부모 노드의 값 비교를 반복한다. 이 단계를 반복하여 Min Heap의 규칙을 지키도록 한다.

 * 삭제 연산
Min Heap의 삭제 연산은 다음과 같은 단계로 이루어진다.
1. Heap에서 가장 작은 값을 가진 노드(루트 노드)를 제거한다. 이때, Min Heap에서 가장 작은 값은 루트 노드이다.
2. Heap의 맨 마지막에 있는 노드를 새로운 루트 노드로 이동시킨다.
3. 새로운 루트 노드와 자식 노드의 값을 비교하여, 자식 노드의 값이 작다면 루트 노드의 위치를 교환한다.
4. 이전 단계에서 교환된 새로운 루트 노드와 자식 노드의 값 비교를 반복한다. 이 단계를 반복하여 Min Heap의 규칙을 지키도록 한다.

*/

/** MinHeap 구현  */
class MinHeap {
  constructor() {
    this.heap = []; // 힙을 저장할 배열
  }

  // 힙의 크기를 반환하는 메서드
  size() {
    return this.heap.length;
  }

  // 최소값 반환하는 메서드
  getMin() {
    return this.heap[0] ? this.heap[0] : null;
  }

  // 새로운 노드를 추가하는 메서드
  push(value) {
    this.heap.push(value); // 힙의 맨끝에 새로운 노드 추가
    this.bubbleUp(); // 상향식 heapify
  }

  // 최소값(루트 노드) 삭제하는 메서드
  pop() {
    if (this.heap.length === 1) {
      return this.heap.pop(); // 힙 크기 1인 경우 힙에서 값 꺼내고 끝
    }
    const value = this.heap[0]; // 힙의 최소값(루트 노드의 값) 저장
    this.heap[0] = this.heap.pop(); // 힙 맨끝 값을 루트 노드로 이동
    this.bubbleDown(); // 하향식 heapify
    return value;
  }

  // 두 노드의 값 바꾸는 메서드
  swap(idx1, idx2) {
    // console.log('swap before', this.heap[idx1], this.heap[idx2]);
    [this.heap[idx1], this.heap[idx2]] = [this.heap[idx2], this.heap[idx1]];
    // console.log('swap after', this.heap[idx1], this.heap[idx2]);
  }

  bubbleUp() {
    let curIdx = this.heap.length - 1; // 새로 추가된 노드의 idx
    let parIdx = Math.floor((curIdx - 1) / 2); // 부모 노드의 idx
    while (
      this.heap[parIdx] && // 부모 노드 존재하고
      this.heap[curIdx] < this.heap[parIdx] // 새 노드 값이 부모보다 작은 경우
    ) {
      this.swap(curIdx, parIdx); // 두 값 자리 교체
      curIdx = parIdx; // 다음 bubble 진행 위한 idx 교체
      parIdx = Math.floor((curIdx - 1) / 2); // 새 부모 idx 계산
    }
  }

  bubbleDown() {
    let curIdx = 0; // 루트 노드의 idx
    let leftIdx = curIdx * 2 + 1; // 왼쪽 자식 노드의 idx
    let rightIdx = curIdx * 2 + 2; // 오른쪽 자식 노드의 idx
    while (
      // 왼쪽 자식 노드가 존재 하면서 값이 루트 노드보다 작거나
      (this.heap[leftIdx] && this.heap[leftIdx] < this.heap[curIdx]) ||
      // 오른쪽 자식 노드가 존재 하면서 값이 루트 노드보다 작으면
      (this.heap[rightIdx] && this.heap[rightIdx] < this.heap[curIdx])
    ) {
      let smallerIdx = leftIdx; // 일단 왼쪽 값이 더 작다고 가정하고 타겟 설정
      // 만약 오른쪽 값이 더 작다면
      if (this.heap[rightIdx] && this.heap[rightIdx] < this.heap[smallerIdx]) {
        smallerIdx = rightIdx; // 오른쪽 자식 노드로 타겟 변경
      }
      this.swap(curIdx, smallerIdx); // 두 값 자리 교체
      curIdx = smallerIdx; // 다음 bubble 진행 위한 idx 교체
      leftIdx = curIdx * 2 + 1; // 새 왼쪽 자식 노드의 idx 계산
      rightIdx = curIdx * 2 + 2; // 새 오른쪽 자식 노드의 idx 계산
    }
  }
}

/** MinHeap 동작 확인 */
const heap = new MinHeap();
console.log(heap); // MinHeap { heap: [] }
heap.push(9);
console.log(heap); // MinHeap { heap: [ 9 ] }
heap.push(5);
console.log(heap); // MinHeap { heap: [ 5, 9 ] }
heap.push(7);
console.log(heap); // MinHeap { heap: [ 5, 9, 7 ] }
heap.push(4);
console.log(heap); // MinHeap { heap: [ 4, 5, 7, 9 ] }
console.log(heap.pop()); //4
console.log(heap); // MinHeap { heap: [ 5, 9, 7 ] }
heap.push(3);
console.log(heap); // MinHeap { heap: [ 3, 5, 7, 9 ] }
console.log(heap.pop()); // 3
console.log(heap); // MinHeap { heap: [ 5, 9, 7 ] }
console.log(heap.size()); // 3
console.log(heap.getMin()); // 5
console.log(heap); // MinHeap { heap: [ 5, 9, 7 ] }

/** MaxHeap으로 사용  */
const heap2 = new MinHeap();
const input = [9, 5, 7, 4, 0, 3, 0, 0, 0, 0]; // 0은 최대값 pop 명령
const output = [];
input.forEach((i) => {
  if (i === 0) output.push(-heap2.pop()); // 다시 (-) 붙여 꺼내기
  else heap2.push(-i); // (-) 붙여 넣었다가
});
console.log(output.join(' ')); // 9 7 5 4 3
