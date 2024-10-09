# [Silver II] 로또 - 6603 

[문제 링크](https://www.acmicpc.net/problem/6603) 

### 성능 요약

메모리: 15084 KB, 시간: 128 ms

### 분류

백트래킹, 조합론, 수학, 재귀

### 제출 일자

2024년 10월 10일 02:17:23

### 문제 설명

<p>In the German Lotto you have to select 6 numbers from the set {1,2,...,49}. A popular strategy to play Lotto - although it doesn't increase your chance of winning - is to select a subset S containing k (k>6) of these 49 numbers, and then play several games with choosing numbers only from S. For example, for k=8 and S = {1,2,3,5,8,13,21,34} there are 28 possible games: [1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ... [3,5,8,13,21,34].</p>

<p>Your job is to write a program that reads in the number k and the set S and then prints all possible games choosing numbers only from S.</p>

### 입력 

 <p>The input file will contain one or more test cases. Each test case consists of one line containing several integers separated from each other by spaces. The first integer on the line will be the number k (6 < k < 13). Then k integers, specifying the set S, will follow in ascending order. Input will be terminated by a value of zero (0) for k.</p>

<p> </p>

### 출력 

 <p>For each test case, print all possible games, each game on one line. The numbers of each game have to be sorted in ascending order and separated from each other by exactly one space. The games themselves have to be sorted lexicographically, that means sorted by the lowest number first, then by the second lowest and so on, as demonstrated in the sample output below. The test cases have to be separated from each other by exactly one blank line. Do not put a blank line after the last test case.</p>

<p> </p>

