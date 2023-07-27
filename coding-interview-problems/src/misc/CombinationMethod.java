package misc;

public class CombinationMethod {

    static int combination(int n, int r){
        if (n<=0 || r<=0) return 0;
        return facUtil(n)/(facUtil(n-r)*facUtil(r));
    }
    static int facUtil(int x){
        if (x <= 1) return x;
        int res = 1;
        while (x > 1){
            int temp = x-1;
            res*=temp;
            x--;
        }
        return res;
    }

    public static void main(String[] args) {
        //Q1. On a election balot you select x officials from a group of N candidates. How many ways you can do this?
        System.out.println("Number of ways: " + combination(6, 2));
    }
}
