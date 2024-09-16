package dp.D1;

public class str9 {
    public static void main(String[] args) {
        System.out.println(isMatch("aab","c*a*b"));
    }
    public static boolean isMatch(String s, String p) {
        int lenS=s.length();
        int lenP=p.length();
        int [][] dp=new int[lenS][lenP];
        return helper(lenS-1,lenP-1,s,p,dp);
    }
    static boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
            if (S1.charAt(j) != '*')
                return false;
        }
        return true;
    }
    public static  boolean helper(int i,int j,String s, String t,int [][] dp )
    {
        if(i<0 && j<0)
        {
            return true;
        }
        if(i>=0 && j<0)
        {
            return false;
        }
        if(i<0 && j>=0)
        {
            return isAllStars(t,i);
        }

        if(s.charAt(i)==t.charAt(j) || t.charAt(j)=='?')
        {

            return  helper(i-1,j-1,s,t,dp);
        }
        else {
            if(t.charAt(j)=='*')
            {
                return helper(i-1,j,s,t,dp) || helper(i,j-1,s,t,dp);
            }
            else {
                return false;
            }
        }

    }
}
