package faang;

public class Pow {
	/*
    2^10 = (2*2)^5                  even, so double x           and reduce power by half
    = 4^5 = (1.0*4)*(4)^4           odd,  so mutiply x with ans and reduce power by 1
    = 4*(4)^4 = 4*(16)^2            even, so double x           and reduce power by half
    = 4*(16)^2 = 4*(256)^1          even, so double x           and reduce power by half
    = 4*(256)^1 = (4*256)*(256)^0   odd,  so mutiply x with ans and reduce power by 1
    = (4*256)*(256)^0 = 1024        loop break, ans returned                      
    */
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if(nn < 0) nn = -1 * nn;
        while(nn > 0){
            if(nn % 2 == 1){
                //odd,  so mutiply x with ans and reduce power by 1
                ans *= x;
                nn -= 1;
            }else {
                //even, so double x and reduce power by half
                x *= x;
                nn /= 2;
            }
        }
        if(n < 0) ans = (1 / ans);
        return ans;
    }
}
