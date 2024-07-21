# [Bronze II] Strfry - 11328 

[문제 링크](https://www.acmicpc.net/problem/11328) 

### 성능 요약

메모리: 23152 KB, 시간: 296 ms

### 분류

구현, 문자열

### 제출 일자

2024년 7월 22일 01:14:01

### 문제 설명

<p>In the C programming language, strings are not a native data type. In fact, they are just an array of characters, with a sentinel NULL value used to denote the end of the string. Since working with strings is a very important thing to do in programming languages, the C standard library has several very useful functions for string manipulation: among them are <strong>strcpy</strong>, <strong>strcmp</strong>, <strong>strtol</strong>, <strong>strtok</strong>, <strong>strlen</strong>, and <strong>strcat</strong>.</p>

<p>However, there is one function that not many know about, and even fewer use it: the <strong>strfry</strong> function. <strong>strfry</strong> takes an input string and randomly swaps a random number of characters.</p>

<p>Given two strings, determine if it is possible that the second string is the first string, strfried.</p>

### 입력 

 <p>The input begins with a number 0 < <strong>N</strong> < 1001, the number of test cases.</p>

<p>Each test case consists of a single line containing two strings of lowercase English characters, separated by a single space; these are the two strings in question. Each string is at most 1000 characters long.</p>

### 출력 

 <p>Output one line for each test case, containing either "Impossible" or "Possible" (without quotes).</p>

