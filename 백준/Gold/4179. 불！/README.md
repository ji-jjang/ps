# [Gold III] 불! - 4179 

[문제 링크](https://www.acmicpc.net/problem/4179) 

### 성능 요약

메모리: 83384 KB, 시간: 504 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 11월 11일 11:08:17

### 문제 설명

<p>Joe works in a maze. Unfortunately, portions of the maze have caught on fire, and the owner of the maze neglected to create a fire escape plan. Help Joe escape the maze.</p>

<p>Given Joe's location in the maze and which squares of the maze are on fire, you must determine whether Joe can exit the maze before the fire reaches him, and how fast he can do it.</p>

<p>Joe and the fire each move one square per minute, vertically or horizontally (not diagonally). The fire spreads all four directions from each square that is on fire. Joe may exit the maze from any square that borders the edge of the maze. Neither Joe nor the fire may enter a square that is occupied by a wall.</p>

### 입력 

 <p>The first line of input contains the two integers R and C, separated by spaces, with 1 <= R,C <= 1000. The following R lines of input each contain one row of the maze. Each of these lines contains exactly C characters, and each of these characters is one of:</p>

<ul>
	<li>#, a wall</li>
	<li>., a passable square</li>
	<li>J, Joe's initial position in the maze, which is a passable square</li>
	<li>F, a square that is on fire</li>
</ul>

<p>There will be exactly one J in the input.</p>

### 출력 

 <p>Output a single line containing IMPOSSIBLE if Joe cannot exit the maze before the fire reaches him, or an integer giving the earliest time Joe can safely exit the maze, in minutes.</p>

