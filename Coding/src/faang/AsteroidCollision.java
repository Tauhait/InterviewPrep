package faang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {        
		if(asteroids == null || asteroids.length == 0) return new int[0];
        ArrayList<Integer> asteroidList = new ArrayList<Integer>();
        for(int elem : asteroids) asteroidList.add(elem);
        boolean hasExploded = false;
        do {
            hasExploded = false;
            for(int i = 0; i < asteroidList.size() - 1; i++) {
                if(asteroidList.get(i) > 0 && asteroidList.get(i + 1) < 0) {
                    if(asteroidList.get(i) > Math.abs(asteroidList.get(i + 1))) asteroidList.remove(i + 1);
                    else if(asteroidList.get(i) <  Math.abs(asteroidList.get(i + 1))) asteroidList.remove(i);
                    else {
                        asteroidList.remove(i + 1);
                        asteroidList.remove(i);
                    }
                    hasExploded = true;
                }
            }
        } while(asteroidList.size() > 1 && hasExploded);
        int[] ans = new int[asteroidList.size()];
        for(int i = 0; i < asteroidList.size(); i++) ans[i] = asteroidList.get(i);
        return ans;
    }
	public int[] asteroidCollision_STCK(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int ast: asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
	public int[] asteroidCollision_OPT(int[] a) {
        LinkedList<Integer> s = new LinkedList<>();
        for (int i : a) {
            if (i > 0)
                s.add(i);
            else {
                while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -i)
                    s.pollLast();
                if (!s.isEmpty() && s.getLast() == -i)
                    s.pollLast();
                else if (s.isEmpty() || s.getLast() < 0)
                    s.add(i);
            }
        }
        return s.stream().mapToInt(i->i).toArray();
    }
}
