# [Silver I] 스타트링크 - 5014 

[문제 링크](https://www.acmicpc.net/problem/5014) 

### 성능 요약

메모리: 62320 KB, 시간: 188 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 11월 11일 16:52:00

### 문제 설명

<p>You are on your way to your first job interview as a program tester, and you are already late. The interview is in a skyscraper and you are currently in floor s, where you see an elevator. Upon entering the elvator, you learn that it has only two buttons, marked "UP u" and "DOWN d". You conclude that the UP-button takes the elevator u floors up (if there aren't enough floors, pressing the UP-botton does nothing, or at least so you assume), whereas the DOWN-button takes you d stories down (or none if there aren't enough). Knowing that the interview is at floor g, and that there are only floors in the building, you quickly decide to write a program that gives you the amount of button pushes you need to perform. If you simply cannot reach the correct floor, your program halts with the message "use the stairs".</p>

<p>Given input f, s, g, u and d (floors, start, goal, up, down), find the shortest sequence of button presses you must press in order to get from s to g, given a building of floors, or output "use the stairs" if you cannot get from s to g by the given elevator.</p>

### 입력 

 <p>The input will consist of one line, namely f s g u d, where 1 ≤ s, g ≤ f ≤ 1000000 and 0 ≤ u, d ≤ 1000000. The floors are one-indexed, i.e. if there are 10 stories, s and g be in [1, 10].</p>

### 출력 

 <p>You must reply with the minimum numbers of pushes you must make in order to get from s to g, or output use the stairs if it is impossible given the configuration of the elvator.</p>

