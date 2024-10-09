# [Gold V] 암호 만들기 - 1759 

[문제 링크](https://www.acmicpc.net/problem/1759) 

### 성능 요약

메모리: 14088 KB, 시간: 100 ms

### 분류

백트래킹, 브루트포스 알고리즘, 조합론, 수학

### 제출 일자

2024년 10월 10일 02:52:31

### 문제 설명

<p>Farmer John has installed a new security system on the barn and now must issue a valid password to the cows in the herd. A valid password consists of L (3 <= L <= 15) different lower-case characters (from the traditional latin character set 'a'...'z'), has at least one vowel ('a', 'e', 'i', 'o', or 'u'), at least two consonants (non-vowels), and has characters that appear in alphabetical order (i.e., 'abc' is valid; 'bac' is not).</p>

<p>Given a desired length L along with C lower-case characters, write a program to print all the valid passwords of length L that can be formed from those letters. The passwords must be printed in alphabetical order, one per line.</p>

### 입력 

 <ul>
	<li>Line 1: Two space-separated integers, L and C</li>
	<li>Line 2: C space-separated lower-case characters that are the set of characters from which to build the passwords</li>
</ul>

### 출력 

 <ul>
	<li>Lines 1..?: Each output line contains a word of length L characters (and no spaces). The output lines must appear in alphabetical order.</li>
</ul>

