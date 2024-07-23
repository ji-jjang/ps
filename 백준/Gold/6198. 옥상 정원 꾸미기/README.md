# [Gold V] 옥상 정원 꾸미기 - 6198 

[문제 링크](https://www.acmicpc.net/problem/6198) 

### 성능 요약

메모리: 23528 KB, 시간: 300 ms

### 분류

자료 구조, 스택

### 제출 일자

2024년 7월 23일 23:03:15

### 문제 설명

<p>Some of Farmer John's N cows (1 <= N <= 80,000) are having a bad hair day! Since each cow is self-conscious about her messy hairstyle, FJ wants to count the number of other cows that can see the top of other cows' heads.</p>

<p>Each cow i has a specified height h[i] (1 <= h[i] <= 1,000,000,000) and is standing in a line of cows all facing east (to the right in our diagrams). Therefore, cow i can see the tops of the heads of cows in front of her (namely cows i+1, i+2, and so on), for as long as these cows are strictly shorter than cow i.</p>

<p>Consider this example:</p>

<pre>        =
=       =
=   -   =           Cows facing right -->
=   =   =
= - = = =
= = = = = =
1 2 3 4 5 6</pre>

<ul>
	<li>Cow#1 can see the hairstyle of cows #2, 3, 4</li>
	<li>Cow#2 can see no cow's hairstyle</li>
	<li>Cow#3 can see the hairstyle of cow #4</li>
	<li>Cow#4 can see no cow's hairstyle</li>
	<li>Cow#5 can see the hairstyle of cow 6</li>
	<li>Cow#6 can see no cows at all!</li>
</ul>

<p>Let c[i] denote the number of cows whose hairstyle is visible from cow i; please compute the sum of c[1] through c[N]. For this example, the desired is answer 3 + 0 + 1 + 0 + 1 + 0 = 5.</p>

### 입력 

 <ul>
	<li>Line 1: The number of cows, N.</li>
	<li>Lines 2..N+1: Line i+1 contains a single integer that is the height of cow i.</li>
</ul>

<p> </p>

### 출력 

 <ul>
	<li>Line 1: A single integer that is the sum of c[1] through c[N].</li>
</ul>

