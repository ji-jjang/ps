# [Silver IV] 제로 - 10773 

[문제 링크](https://www.acmicpc.net/problem/10773) 

### 성능 요약

메모리: 23140 KB, 시간: 244 ms

### 분류

자료 구조, 구현, 스택

### 제출 일자

2024년 1월 11일 15:55:41

### 문제 설명

<p>Your boss has asked you to add up a sequence of positive numbers to determine how much money your company made last year.</p>

<p>Unfortunately, your boss reads out numbers incorrectly from time to time.</p>

<p>Fortunately, your boss realizes when an incorrect number is read and says “zero”, meaning “ignore the current last number.”</p>

<p>Unfortunately, your boss can make repeated mistakes, and says “zero” for each mistake.</p>

<p>For example, your boss may say “One, three, five, four, zero, zero, seven, zero, zero, six”, which means the total is 7 as explained in the following chart:</p>

<table class="table table-bordered" style="width:60%">
	<thead>
		<tr>
			<th>Boss statement(s)</th>
			<th>Current numbers</th>
			<th>Explanation</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>“One, three, five, four”</td>
			<td>1, 3, 5, 4</td>
			<td>Record the first four numbers.</td>
		</tr>
		<tr>
			<td>“zero, zero“</td>
			<td>1, 3</td>
			<td>Ignore the last two numbers.</td>
		</tr>
		<tr>
			<td>“seven”</td>
			<td>1, 3, 7</td>
			<td>Record the number 7 at the end of our list.</td>
		</tr>
		<tr>
			<td>“zero, zero”</td>
			<td>1</td>
			<td>Ignore the last two numbers.</td>
		</tr>
		<tr>
			<td>“six”</td>
			<td>1, 6</td>
			<td>We have read all numbers, and the total is 7.</td>
		</tr>
	</tbody>
</table>

<p>At any point, your boss will have said at least as many positive numbers as “zero” statements. If all positive numbers have been ignored, the sum is zero.</p>

<p>Write a program that reads the sequence of boss statements and computes the correct sum.</p>

### 입력 

 <p>The first line of input contains the integer K (1 ≤ K ≤ 100 000) which is the number of integers (including “zero”) your boss will say. On each of the next K lines, there will either be one integer between 1 and 100 (inclusive), or the integer 0.</p>

### 출력 

 <p>The output is one line, containing the integer which is the correct sum of the integers read, taking the “zero” statements into consideration. You can assume that the output will be an integer in the range 0 and 1 000 000 (inclusive).</p>

