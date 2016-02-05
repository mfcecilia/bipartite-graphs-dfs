# bipartite-graphs-dfs
VT Programming team lecture 2016.02.04

Assigning Teams<br>
Time Limit: 2 seconds

Arranging a board game night sounds like it would be a lot of run, right? If only your friends actually enjoyed each others’ company.

For the games you want to play, you’ll need to divide people in to two teams. The sizes of the teams don’t necessarily matter, just that both teams have at least one person. Normally this would be easy, but your “friends” don’t get along. After you proposed this idea, many of your friends submitted complaints. Bobby told you “I can’t be on a team with Billy! He stole my pringles!”. Similarly, Sally complained, “I can’t be on a team with Harry, we broke up only 3 years ago!”.

Despite the issues, you still want to hold your game night. You make a long list of the complaints and decide that you will attempt to build two teams that satisfy everyone’s demands. Given a complaint made between person aa and person bb, you will try to put person aa on a different team than person bb.

Write a program to assist in this task. Given N people (numbered 0...N−10...N−1), and a list of pairs (i,j)(i,j) such that i,ji,j cannot be on the same team, can you construct two teams?

Input<br>
Input will begin with one line containing two integers N(2≤N≤5000)N(2≤N≤5000) E(1≤E≤20,000)E(1≤E≤20,000), denoting the number of people and the number of issues respectively.

E lines will follow, each of consisting of two integers i,j(0≤i,j<N)i,j(0≤i,j<N) denoting that person ii and person j do not want to be on the same team.

Output<br>
Output a single line containing either the word “yes” or the word “no”. Output “yes” if it is possible to create two teams given the constraints, or “no” otherwise.

Sample Input 1	<br>
7 6<br>
0 1<br>
0 2<br>
3 1<br>
4 5<br>
5 6<br>
6 4<br><br>
Sample Output 1<br>
no<br><br>
Sample Input 2	<br>
4 6 <br>
0 1<br>
2 3<br>
1 2<br>
1 3<br>
0 3<br>
0 2 <br><br>
Sample Output 2<br>
no<br><br>
Sample Input 3	<br>
5 4<br>
0 2<br>
0 3<br>
0 4<br>
1 3<br><br>
Sample Output 3<br>
yes
