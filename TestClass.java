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