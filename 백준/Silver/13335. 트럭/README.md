# [Silver I] 트럭 - 13335 

[문제 링크](https://www.acmicpc.net/problem/13335) 

### 성능 요약

메모리: 14472 KB, 시간: 120 ms

### 분류

자료 구조, 구현, 큐, 시뮬레이션

### 제출 일자

2024년 10월 14일 02:24:22

### 문제 설명

<p>There are n cargo trucks in a line to cross a one lane wide bridge over a river. The order of trucks cannot be changed and the weight of each truck may not be the same. Only w trucks can be on the bridge at the same time. We assume that the length of the bridge is w unit distance and each truck moves a unit distance in a unit time. The sum of the weights of the trucks on the bridge should be less than or equal to L due to the maximum safe load of the bridge. Note that the weights of trucks that aren’t fully present on the bridge are not considered in the load calculation of the trucks on the bridge.</p>

<p>For example, let w be 2 and L be 10 and the sequence of the weights of the trucks be [7, 4, 5, 6] and the trucks are crossing from right to left. Then, the earliest time for all the trucks to cross the bridge is 8, as illustrated in Figure 1.</p>

<p style="text-align: center;"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/13335/1.png" style="height:214px; text-align:center; width:664px"></p>

<p style="text-align: center;">Figure 1. Trucks crossing the bridge.</p>

<p>You are given the maximum affordable number of the trucks on the bridge and the maximum safe load of the bridge and the sequence of the weights of the trucks. Write a program for finding the earliest time for the trucks to cross the bridge.</p>

### 입력 

 <p>Your program is to read from standard input. The input consists of two lines. The first line contains three integers n (1 ≤ n ≤ 1,000), w (1 ≤ w ≤ 100) and L (10 ≤ L ≤ 1,000) where n is the number of trucks to cross the bridge, w is the maximum affordable number of trucks on the bridge and L is the maximum safe load of the bridge. The second line contains n integers a<sub>1</sub>, a<sub>2</sub>, ⋯ , a<sub>n</sub> (1 ≤ a<sub>i</sub> ≤ 10), where a<sub>i</sub> represents the weight of i-th truck.</p>

### 출력 

 <p>Your program is to write to standard output. Print the earliest time to cross the bridge. </p>

