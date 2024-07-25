# [Platinum V] 히스토그램에서 가장 큰 직사각형 - 6549 

[문제 링크](https://www.acmicpc.net/problem/6549) 

### 성능 요약

메모리: 51748 KB, 시간: 540 ms

### 분류

자료 구조, 분할 정복, 세그먼트 트리, 스택

### 제출 일자

2024년 7월 25일 23:25:04

### 문제 설명

<p>A histogram is a polygon composed of a sequence of rectangles aligned at a common base line. The rectangles have equal widths but may have different heights. For example, the figure on the left shows the histogram that consists of rectangles with the heights 2, 1, 4, 5, 1, 3, 3, measured in units where 1 is the width of the rectangles:</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/histogram.png" style="height:159px; width:506px"></p>

<p>Usually, histograms are used to represent discrete distributions, e.g., the frequencies of characters in texts. Note that the order of the rectangles, i.e., their heights, is important. Calculate the area of the largest rectangle in a histogram that is aligned at the common base line, too. The figure on the right shows the largest aligned rectangle for the depicted histogram.</p>

### 입력 

 <p>The input contains several test cases. Each test case describes a histogram and starts with an integer n, denoting the number of rectangles it is composed of. You may assume that 1<=n<=100000. Then follow n integers h<sub>1</sub>,...,h<sub>n</sub>, where 0<=h<sub>i</sub><=1000000000. These numbers denote the heights of the rectangles of the histogram in left-to-right order. The width of each rectangle is 1. A zero follows the input for the last test case.</p>

### 출력 

 <p>For each test case output on a single line the area of the largest rectangle in the specified histogram. Remember that this rectangle must be aligned at the common base line.</p>

