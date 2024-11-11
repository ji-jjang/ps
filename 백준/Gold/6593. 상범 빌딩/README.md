# [Gold V] 상범 빌딩 - 6593 

[문제 링크](https://www.acmicpc.net/problem/6593) 

### 성능 요약

메모리: 19904 KB, 시간: 172 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 11월 11일 17:49:39

### 문제 설명

<p>
</p><p>
You are trapped in a 3D dungeon and need to find the quickest way out!
The dungeon is composed of unit cubes which may or may not be filled with rock.
It takes one minute to move one unit north, south, east, west, up or down.
You cannot move diagonally and the maze is surrounded by solid rock on all sides.
</p><p>
Is an escape possible? If yes, how long will it take?

</p>

### 입력 

 The input file consists of a number of dungeons.
Each dungeon description starts with a line containing three integers
<i>L</i>, <i>R</i> and <i>C</i> (all limited to 30 in size).
<p></p><p>
<i>L</i> is the number of levels making up the dungeon.
</p><p>
<i>R</i> and <i>C</i> are the number of rows and columns making up the plan of each
level.
</p><p>
Then there will follow <i>L</i> blocks of <i>R</i> lines each containing <i>C</i>
characters.
Each character describes one cell of the dungeon. A cell full of rock is indicated
by a '#' and empty cells are represented by a '.'.
Your starting position is indicated by 'S' and the exit by the letter 'E'.
There's a single blank line after each level.

Input is terminated by three zeroes for <i>L</i>, <i>R</i> and <i>C</i>.


					</p>

### 출력 

 Each maze generates one line of output. If it is possible to reach the exit,
print a line of the form
<blockquote>
Escaped in <i>x</i> minute(s).
</blockquote>
where <i>x</i> is replaced by the shortest time it takes to escape.
<p></p><p>
If it is not possible to escape, print the line
</p><blockquote>
Trapped!
</blockquote>

