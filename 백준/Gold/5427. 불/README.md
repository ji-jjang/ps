# [Gold IV] 불 - 5427 

[문제 링크](https://www.acmicpc.net/problem/5427) 

### 성능 요약

메모리: 136236 KB, 시간: 912 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 11월 11일 15:17:05

### 문제 설명

<p>You are trapped in a building consisting of open spaces and walls. Some places are on ﬁre and you have to run for the exit. Will you make it?</p>

<p>At each second, the ﬁre will spread to all open spaces directly connected to the North, South, East or West side of it. Fortunately, walls will never catch ﬁre and will keep the ﬁre inside the building, so as soon as you are out of the building you will be safe. To run to any of the four open spaces adjacent to you takes you exactly one second. You cannot run through a wall or into an open space that is on ﬁre or is just catching ﬁre, but you can run out of an open space at the same moment it catches ﬁre.</p>

<p>Given a map of the building, decide how fast you can exit the building.</p>

### 입력 

 <p>On the ﬁrst line one positive number: the number of test cases, at most 100. After that per test case:</p>

<ul>
	<li>one line with two space-separated integers w and h (1 ≤ w, h ≤ 1 000): the width and height of the map of the building, respectively.</li>
	<li>h lines with w characters each: the map of the building, consisting of
	<ul>
		<li>‘.’: a room,</li>
		<li>‘#’: a wall,</li>
		<li>‘@’: your starting location,</li>
		<li>‘*’: ﬁre.</li>
	</ul>
	</li>
</ul>

<p>There will be exactly one ‘@’ in the map.</p>

### 출력 

 <p>Per test case:</p>

<ul>
	<li>one line with a single integer which is the minimal number of seconds that you need to exit the building or the string “IMPOSSIBLE” when this is not possible.</li>
</ul>

