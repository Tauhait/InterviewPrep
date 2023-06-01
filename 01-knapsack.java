//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    {
        int[][] dp = new int[n][W+1];
         // your code here 
         for(int w = wt[0]; w <= W; w++){
             dp[0][w] = val[0];
         }
         for(int i = 1; i < n; i++){
             for(int w = 0; w <= W; w++){
                 int notTake = dp[i-1][w];
                 int take = Integer.MIN_VALUE;
                 if(wt[i] <= w){
                     take = val[i] + dp[i-1][w-wt[i]];
                 }
                 dp[i][w] = Math.max(take, notTake);
             }
         }
         return dp[n-1][W];
    } 
}
