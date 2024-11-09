# [Silver IV] 균형잡힌 세상 - 4949 

[문제 링크](https://www.acmicpc.net/problem/4949) 

### 성능 요약

메모리: 18008 KB, 시간: 164 ms

### 분류

자료 구조, 스택, 문자열

### 제출 일자

2024년 11월 9일 20:20:05

### 문제 설명

<p>The world should be finely balanced. Positive vs. negative, light vs. shadow, and left vs. right brackets. Your mission is to write a program that judges whether a string is balanced with respect to brackets so that we can observe the balance of the world.</p>

<p>A string that will be given to the program may have two kinds of brackets, round (“( )”) and square (“[ ]”). A string is balanced if and only if the following conditions hold.</p>

<ul>
	<li>For every left round bracket (“(”), there is a corresponding right round bracket (“)”) in the following part of the string.</li>
	<li>For every left square bracket (“[”), there is a corresponding right square bracket (“]”) in the following part of the string.</li>
	<li>For every right bracket, there is a left bracket corresponding to it.</li>
	<li>Correspondences of brackets have to be one to one, that is, a single bracket never corresponds to two or more brackets.</li>
	<li>For every pair of corresponding left and right brackets, the substring between them is balanced.</li>
</ul>

### 입력 

 <p>The input consists of one or more lines, each of which being a dataset. A dataset is a string that consists of English alphabets, space characters, and two kinds of brackets, round (“( )”) and square (“[ ]”), terminated by a period. You can assume that every line has 100 characters or less. The line formed by a single period indicates the end of the input, which is not a dataset.</p>

### 출력 

 <p>For each dataset, output “yes” if the string is balanced, or “no” otherwise, in a line. There may not be any extra characters in the output.</p>

