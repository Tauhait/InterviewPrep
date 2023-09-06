class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String op : operations){
            if(op.equals("C")){
                if(!stack.isEmpty()) stack.pop();
            } else if(op.equals("D")){
                if(!stack.isEmpty()) stack.push(stack.peek() * 2);
            } else if(op.equals("+")){
                if(stack.size() < 2) continue;
                int first = stack.pop();
                int second = stack.peek();
                int add = first + second;
                stack.push(first);
                stack.push(add);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) sum += stack.pop();
        return sum;
    }
}