package faang;

import java.util.ArrayDeque;
import java.util.HashSet;

//https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
//https://www.tutorialcup.com/interview/graph/minimum-steps-to-reach-target-by-a-knight.htm
//https://leetcode.com/problems/minimum-knight-moves/
public class MinimumKnightMoves {
	class Move {
		int x;
		int y;
		int steps;
		public Move(int x, int y, int steps) {
			this.x = x;
			this.y = y;
			this.steps = steps;
		}
	}
	public int getMinMoves(int kx, int ky, int tx, int ty, int n) {
		if(kx <= 0 || kx > n || ky <= 0 || ky > n || tx <= 0 || tx > n || ty <= 0 || ty > n) return -1;		
		if(kx == tx && ky == ty) return 0;
		HashSet<String> visited = new HashSet<String>();
		ArrayDeque<Move> q = new ArrayDeque<Move>();
		Move source = new Move(kx, ky, 0);
		q.offer(source);
		String visit = kx + "|" + ky;
		visited.add(visit);
		int[] h = {-1, -1, 1, 1, 2, 2, -2, -2};
		int[] v = {-2, 2, -2, 2, -1, 1, -1, 1};
		while(!q.isEmpty()) {
			if(q.peek().x == tx && q.peek().y == ty) return q.peek().steps;
			Move next = q.poll();
			for(int i = 0; i < 8; i++) {
				int nx = next.x + h[i];
				int ny = next.y + v[i];
				String coord = nx + "|" + ny;
				if(!visited.contains(coord) && nx > 0 && ny > 0 && nx <= n && ny <= n) {
					Move newMove = new Move(nx, ny, next.steps + 1);
					q.offer(newMove);
					visited.add(coord);
				}
			}
		}
		return q.poll().steps;
	}

}
