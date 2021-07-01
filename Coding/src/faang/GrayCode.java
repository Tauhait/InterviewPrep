package faang;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < Math.pow(2, n); i++){
            int num = i ^ (i >> 1);
            result.add(num);
        }
        return result;
    }
}
/*
 * 
 * My idea is to generate the sequence iteratively. For example, when n=3, we can get the result based on n=2.
00,01,11,10 -> (000,001,011,010 ) (110,111,101,100). The middle two numbers only differ at their highest bit, while the rest numbers of part two are exactly symmetric of part one. It is easy to see its correctness.
Code is simple:
I think this may explain the author's idea much clearly on the statement "The middle two numbers only differ at their highest bit, while the rest numbers of part two are exactly symmetric of part one".
Say the example input is 3.

0 000
1 001
3 011
2 010

6 110
7 111
5 101
4 100

For the pair of (2, 6), (3, 7), (1, 5) and (0, 4), the last 2 bits are the same. The only difference is 6,7,5 and 4 set the first bit on
rs.add(rs.get(k) | 1<<i);
I am not very familiar with bit manipulation, but I can see you come up a very concise solution here.
put a "1" in the "head" of the old number. (e.g. make "101" to be 1101 (101 | 1000 == 1101))

public List<Integer> grayCode(int n) {
    List<Integer> rs=new ArrayList<Integer>();
    rs.add(0);
    for(int i=0;i<n;i++){
        int size=rs.size();
        for(int k=size-1;k>=0;k--)
            rs.add(rs.get(k) | 1<<i);
    }
    return rs;
}
 */
