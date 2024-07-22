# [Silver II] 에디터 - 1406 

[문제 링크](https://www.acmicpc.net/problem/1406) 

### 성능 요약

메모리: 149380 KB, 시간: 584 ms

### 분류

자료 구조, 연결 리스트, 스택

### 제출 일자

2023년 12월 27일 16:29:37

### 문제 설명

<p>You are given a text that is a sequence of characters.</p>

<p>Cursor can be positioned inside of the text (between any two consecutive characters), at the beginning (left of the first character) or at the end (right of the last character) of the text.</p>

<p>You are given sequence of operations you must perform on the text. </p>

<p>Possible operations are: </p>

<table class="table table-bordered" style="width:100%">
	<tbody>
		<tr>
			<th style="width:20%">L</th>
			<td style="width:80%">move cursor one character to the left (if cursor is at the beginning, do nothing)</td>
		</tr>
		<tr>
			<th>D</th>
			<td>move cursor one character to the right (if cursor is at the end, do nothing)</td>
		</tr>
		<tr>
			<th>B</th>
			<td>delete character left of the cursor (if cursor is at the beginning, do nothing)</td>
		</tr>
		<tr>
			<th>P $</th>
			<td>add character <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45F TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D454 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c210E TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D461 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45C TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D453 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D461 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c210E TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D452 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D450 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D462 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45F TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D460 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45C TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45F TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D450 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c210E TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D44E TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45F TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D44E TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D450 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D461 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D452 TEX-I"></mjx-c></mjx-mi><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45F TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>r</mi><mi>i</mi><mi>g</mi><mi>h</mi><mi>t</mi><mi>o</mi><mi>f</mi><mi>t</mi><mi>h</mi><mi>e</mi><mi>c</mi><mi>u</mi><mi>r</mi><mi>s</mi><mi>o</mi><mi>r</mi><mo stretchy="false">(</mo><mi>c</mi><mi>h</mi><mi>a</mi><mi>r</mi><mi>a</mi><mi>c</mi><mi>t</mi><mi>e</mi><mi>r</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$ right of the cursor (character $</span></mjx-container> is any lowercase letter of English alphabet)</td>
		</tr>
	</tbody>
</table>

<p>Before execution of given operations, cursor is at the end of the text. </p>

<p>Write a program that will determine what would the text look like after execution of given operations. </p>

### 입력 

 <p>In the first row there is the text. It consists only of lowercase letters of English alphabet and its maximal length is 100,000 characters.</p>

<p>In the next row there is an integer N, 1 ≤ N ≤ 500,000, number of given operations. </p>

<p>In the next N rows there are operations given in the order of execution. </p>

### 출력 

 <p>In first and only row you should write text after the execution of all the operations. </p>

