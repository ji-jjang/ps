# [Platinum V] 백조의 호수 - 3197 

[문제 링크](https://www.acmicpc.net/problem/3197) 

### 성능 요약

메모리: 310788 KB, 시간: 980 ms

### 분류

너비 우선 탐색, 자료 구조, 분리 집합, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 8월 27일 22:55:57

### 문제 설명

<p>Two swans are living on a lake but they are separated with ice that covers parts of the lake. </p>

<p>Lake is rectangular in shape and consists of squares arranged in R rows and C columns. Some squares are covered with ice. </p>

<p>Lake is gradually defrosting – in one day all of the squares covered with ice that are in touch with water melt and turn into water. We consider two squares to be in touch if they are neighbors horizontally or vertically (but not diagonally). </p>

<p>The following figure depicts the lake from the third example: </p>

<pre>...XXXXXX..XX.XXX ....XXXX.......XX .....XX.......... 
....XXXXXXXXX.XXX .....XXXX..X..... ......X.......... 
...XXXXXXXXXXXX.. ....XXX..XXXX.... .....X.....X..... 
..XXXXX..XXXXXX.. ...XXX....XXXX... ....X......XX.... 
.XXXXXX..XXXXXX.. ..XXXX....XXXX... ...XX......XX.... 
XXXXXXX...XXXX... ..XXXX.....XX.... ....X............ 
..XXXXX...XXX.... ....XX.....X..... ................. 
....XXXXX.XXX.... .....XX....X..... ................. 
in the beginning   after first day   after second day 
</pre>

<p>Swans can move only on water squares in horizontal and vertical (but not diagonal) direction. </p>

<p>Write a program that will calculate after how many days the swans will be able to meet each other. </p>

### 입력 

 <p>First line of input contains two integers R and C, 1 ≤ R, C ≤ 1500. </p>

<p>Each of the following R lines contains a sequence of C characters, the description of the lake at the beginning: '.' (dot) denotes a water square, 'X' denotes an ice-covered square, and 'L' denotes a square with a swan.</p>

### 출력 

 <p>First and only line of output should contain the number of days from the problem statement. </p>

