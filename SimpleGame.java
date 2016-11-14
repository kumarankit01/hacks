/*
 * Simple Game
Monk and !Monk decided to play a simple number game. Each of them had a set of numbers (may contain a number more than once) to play with. Lets denote by 
A[]A[] the set belonging to Monk, and by 
B
[
]
B[], the set belonging to !Monk.

They defined three functions 
f
(
x
)
f(x) , 
g
(
x
)
g(x) and 
V
(
x
)
V(x) :

f
(
x
)
f(x) : Returns count of numbers strictly smaller than 
x
x in opponent's set

g
(
x
)
g(x) : Returns count of numbers strictly greater than 
x
x in opponent's set

V
(
x
)
V(x) : 
f
(
x
)
×
g
(
x
)
f(x)×g(x)

Score of a player is defined to be the 
∑
V
(
x
)
∑V(x) for each element 
x
x present in the players set.

The player with 
h
i
g
h
e
r
higher score wins the game.

Input: 
The first line contains two positive integers N and M where N and M represent the number of elements present in Monk and !Monk's sets respectively.
The second line contains N space separated integers - elements present in Monk's set
The third line contains M space separated integers - elements present in !Monk's set
Output:

If Monk wins, print "Monk" (without quotes) followed by a space and the score difference between him and !Monk
If !Monk wins, print "!Monk" (without quotes) followed by a space and the score difference between him and Monk
If both players have equal scores, then print "Tie" (without quotes).
Constraints:

1
≤
N
,
M
≤
10
5
1≤N,M≤105
0
≤
A
[
i
]
,
B
[
i
]
≤
10
9
0≤A[i],B[i]≤109

Sample Input(Plaintext Link)
2 2
1 3
0 5
Sample Output(Plaintext Link)
Monk 2
Explanation
Monk's Set : {1,3}
!Monk's Set : {0,5}

Score of Monk :

    f(1) = 1,    There is one element {0}     
    f(3) = 1,    There is one element {0}

    g(1) = 1,    There is one element {5}
    g(3) = 1,    There is one element {5}

    Score = f(1) * g(1) + f(3) * g(3) = 1 + 1 = 2
Score of !Monk :

    f(0) = 0,    There are no elements smaller than 0 with Monk     
    f(5) = 2,    There are two elements {1,3}

    g(0) = 2,    There are two elements {1,3}
    g(5) = 0,    There are no elements greater than 5 with Monk

    Score = f(0) * g(0) + f(5) * g(5) = 0 + 0 = 0
Score of Monk > Score of !Monk
Difference = 2 - 0 = 2
 * 
 */

package core;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleGame {
	private static final String Monk="Monk";
	private static final String Monk2="!Monk";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int monk1[] = new int[N];
		int monk2[] = new int[M];
		for (int i = 0; i < N; i++) {
			monk1[i] = s.nextInt();
		}
		for (int i = 0; i < M; i++) {
			monk2[i] = s.nextInt();
		}
		s.close();
		Arrays.sort(monk1);
		Arrays.sort(monk2);
		int monk1Score = 0;
		int monk2Score = 0;
		for (int i : monk1) {
			monk1Score += calculateScore(i,monk2);
		}
		for (int i : monk2) {
			monk2Score += calculateScore(i,monk1);
		}
		if(monk1Score>monk2Score){
			System.out.println(Monk+" "+(monk1Score-monk2Score));
		}else{
			System.out.println(Monk2+" "+(monk2Score-monk1Score));
		}

	}

	private static int calculateScore(int i, int[] monk2) {
		if(i < monk2[0]){
			return 0;
		}else if(i > monk2[monk2.length-1]){
			return 0;
		}else{
			for (int j = 0; j < monk2.length; j++) {
				if(i > monk2[j]){
					int fx = j+1;
					int gx =  monk2.length-j-1;
					return fx*gx;
				}
			}
		}
		return 0;
	}


}
