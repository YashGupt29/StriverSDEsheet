package dp.D1;

public class sample {
    public static void main(String[] args) {
        System.out.println(getLucky("leetcode",2));
    }
    public static int getLucky(String s, int k) {
        int n=0;
        for(int i=0;i<s.length();i++)
        {
            n+= (int)(s.charAt(i)) - 'a';
        }
        int ans=0;
        while(k>0)
        {
            int rem=n %10;
            ans+=rem;
            n=n/10;
            k--;
        }
        return ans;
    }
}
