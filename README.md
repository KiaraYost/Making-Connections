# Making Connections

## Context
_Text below is the instructions for an archived COP 3503 (Computer Science II) assignment completed as supplemental work. Link to archived assigment is attached to repository. Uploaded to Github for archival and future reference purposes only. DO NOT USE CODE WITHOUT PERMISSION._

## Objective
Give practice with implementing a disjoint set data structure. 

## Introduction
Consider the process of building a computer network. At the very beginning there will be n 
computers, with no connections between any of them. Then, as time goes on, pairs of computers 
are chosen, one pair at a time, and a direct network connection is added. In the middle of such a 
process, we might get the following graph modeling the connections: 

<img width="303" height="148" alt="image" src="https://github.com/user-attachments/assets/dab4f851-6e3e-46a4-b457-1d829c807a15" />

This network currently has 4 computers in one group that can communicate directly or indirectly, 
1 computer by itself, and another 2 computers that can communicate with each other. 

We can define the average connectivity of a network as the sum of the sizes squared of each of the 
separate components of this graph, divided by the number of components. For the example graph 
shown above, the current connectivity equals (4^2 + 1^2 + 2^2)/3 = 21/3 = 7. 

As a network is being built, the project manager would like to know the average connectivity of 
the network at that given snapshot of time. Write a program to handle the queries as the network 
is being constructed!

## The Problem
Given a network of n initially separate computers, along with a sequence of steps, where either a 
pair of computers is connected or a query about the average connectivity is posted, answer each 
query.

## Input
The first line of input contains two space separated integers, n (1 ≤ n ≤ 10^5) and m (1 ≤ m ≤ 3x10^5), 
where n represents the number of computers and m represents the total number of connections 
built and average connectivity queries. The computers are numbered 1 through n, inclusive. 

The following m lines each contain information about one operation, in the order that they occur. 
Each of these lines will start with a single integer, either 1 or 2. If the first value on one of these 
lines is 1, it means that a pair of computers is being connected with a direct connection. The value 
1 of 1 will be followed by u and v (1 ≤ u, v ≤ n, u ≠ v), representing the pair of computers being 
connected with a direct connection. If the first value on one of these lines is 2, this is a query and 
no other information will be on the line. Note: It’s possible that the same pair of computers may 
have more than one direct connection added during the process of connecting the computers. It’s 
also possible that at the end of the process, that not all n computers are connected in the same 
component. 

## Output

For each query, output the average connectivity of the network at that point in time as a fraction 
in lowest terms on a line by itself. Specifically, output two integers, x and y with the character ‘/’ 
in between, indicating that the average connectivity of the network at the time is x divided by y 
such that x and y share no common factors. 

#### Sample Input 1
```
7 9 
2 
1 1 2 
1 1 3 
2 
1 3 4 
1 2 3 
2 
1 6 7 
2
```
#### Sample Output 1
```
1/1 
13/5 
19/4 
7/1
```

#### Sample Input 2
```
4 9 
1 1 2 
2 
1 3 4 
2 
1 2 3 
2 
1 1 4 
1 2 4 
2
```

#### Sample Output 2
```
2/1 
4/1 
16/1 
16/1
```
