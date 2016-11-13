/*
JP and the Escape Plan
JP is stuck in a grid of buildings of size 
N
×
M
N×M, after he is dropped from a helicopter. He will be able to escape this grid if he can reach to any building that is on the boundary of grid. He can jump from one building to the other if and only if : 

The buildings shares the edges with each other, i.e are adjacent (not diagonally adjacent)
The building to which he is jumping should be of the same height of the building on which he is standing OR the building to which he is jumping should have height at max 
J
J less than the one on which he is standing. 
The top left building will have the co-ordinates 
(
1
,
1
)
(1,1) and the bottom right will have the co-ordinates 
(
N
,
M
)
(N,M)
Input:
The first line contains two space separated integers 
N
N and 
M
M Each of the next 
N
N lines contains 
M
M space separated integers denoting the heights of the buildings.
Next line contains three space separated integers 
D
x
Dx, 
D
y
Dy and 
J
J
D
x
Dx, 
D
y
Dy are the co-ordinates of the building where JP is dropped.

Output:
On the first line, print "YES"(without quotes) if he can reach any building on the boundary of the grid else print "NO"(without quotes).

If the answer is YES, on the next line print a single integer 
K
K, the length of the path JP must travel along to reach his destination. In each of the next 
K
K lines, print 
2
2 space separated integers 
(
x
,
y
)
(x,y). It is necessary that the first co-ordinate along the path must be 
(
D
x
,
D
y
)
(Dx,Dy), and the last co-ordinate along the path must be present on the boundary of the grid.

A path is considered to the valid if and only if it does not contain any repeated co-ordinates, and does not violate any rules of JP's travel conditions mentioned above. In the case of printing a wrong path, you shall get a Wrong Answer. It is not necessary that the printed path should be the shortest one available.

Constraints:

1
≤
N
,
M
≤
500
1≤N,M≤500
1
≤
H
e
i
g
h
t
(
i
,
j
)
≤
10
9
1≤Height(i,j)≤109

1
≤
D
x
≤
N
1≤Dx≤N
1
≤
D
y
≤
M
1≤Dy≤M
1
≤
j
≤
10
9
1≤j≤109

Sample Input(Plaintext Link)
1
4 4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
3 3 5
Sample Output(Plaintext Link)
YES
4
3 3
3 2
2 2
2 1


*/
package core;

import java.util.*;


class TestClass {
	private static final String YES = "YES";
	private static final String NO = "NO";

	public static void main(String args[] ) throws Exception {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int height[][] =  new int[N+2][M+2];
		boolean visited[][] = new boolean[N+2][M+2];
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=M; j++) {
				height[i][j] = s.nextInt();
			}
		}
		int dx =  s.nextInt();
		int dy =  s.nextInt();
		int max_j =  s.nextInt();

		s.close();
		ArrayList<String> path = new ArrayList<>();

		if(findPath(dx,dy,max_j,visited,height,path)){
			System.out.println(YES);
			System.out.println(path.size());
			for (String string : path) {
				System.out.println(string);
			}

		}else{
			System.out.println(NO);

		}
	}

	private static boolean findPath(int dx, int dy, int max_j, boolean[][] visited, int[][] height,
			ArrayList<String> path) {
		//check if we are on the edge
		if(height[dx-1][dy] == 0 || height[dx+1][dy] == 0 ||
				height[dx][dy-1] == 0 || height[dx][dy+1] == 0){
			path.add(dx+" "+dy);
			return true;

		}else{
			// height must be same or diff can be max upto max_j and node should not have been visited before
			//check if we can move up
			if(height[dx][dy] - height[dx-1][dy] >= 0 && 
					height[dx][dy] - height[dx-1][dy] <= max_j && visited[dx-1][dy] == false){
				path.add(dx+" "+dy);
				visited[dx][dy] = true;
				return findPath(dx-1, dy, max_j, visited, height, path);
			}
			//check if we can move down

			if(height[dx][dy] - height[dx+1][dy] >= 0 && 
					height[dx][dy] - height[dx+1][dy] <=max_j && visited[dx+1][dy] == false){
				path.add(dx+" "+dy);
				visited[dx][dy] = true;
				return findPath(dx+1, dy, max_j, visited, height, path);
			}
			//check if we can move left

			if(height[dx][dy] - height[dx][dy-1] >= 0 && 
					height[dx][dy] - height[dx][dy-1] <=max_j && visited[dx][dy-1] == false){
				path.add(dx+" "+dy);
				visited[dx][dy] = true;
				return findPath(dx, dy-1, max_j, visited, height, path);
			}
			//check if we can move right

			if(height[dx][dy] - height[dx][dy+1] >= 0 && 
					height[dx][dy] - height[dx][dy+1] <=max_j && visited[dx][dy+1] == false){
				path.add(dx+" "+dy);
				visited[dx][dy] = true;
				return findPath(dx, dy+1, max_j, visited, height, path);
			}
		}
		return false;
	}
}