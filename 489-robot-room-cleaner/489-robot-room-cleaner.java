/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    private final int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    //up, left, down, right
    //{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}
    //direction order is constant

    private Set<Pair<Integer, Integer>> visited = new HashSet();
    private Robot robot;
    private final Integer MAX_DIR = 4;
    //chosen direction for robot to rotate is anticlockwise
    private void goBack(){
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
    //
    private void backtrack(int row, int col, int currDir){
        Pair<Integer, Integer> currMove = new Pair(row, col);
        visited.add(currMove);
        robot.clean();
        for(int idx = 0; idx < MAX_DIR; idx++){
            int newDir = (currDir + idx) % MAX_DIR;
            int newRow = row + dirs[newDir][0];
            int newCol = col + dirs[newDir][1];
            Pair<Integer, Integer> newMove = new Pair(newRow, newCol);
            if(!visited.contains(newMove) && robot.move()){
                backtrack(newRow, newCol, newDir);
                goBack();
            }
            robot.turnLeft();
        }
    }
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
}
