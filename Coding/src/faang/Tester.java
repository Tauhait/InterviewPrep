package faang;

public class Tester {

	public static void main(String[] args) {
		MinimumKnightMoves obj = new MinimumKnightMoves();
		int moves = obj.getMinMoves(4, 4, 4, 5, 8);
		if(moves < 0) System.out.println("Invalid starting knight position or target point");
		else System.out.printf("Min moves from (%d, %d) to (%d, %d) is = %d", 4, 4, 4, 5, moves);
	}

}
