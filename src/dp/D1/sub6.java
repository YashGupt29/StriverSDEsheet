package dp.D1;

public class sub6 {
    public static void main(String[] args) {
        int [] g={1,2,3};
        int [] s={1,1};
        System.out.println(findContentChildren(g,s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        int count=0;
        int [] dp=new int[s.length];
        for (int i = 0; i < g.length; i++) {
            int cookie=g[i];
            int min=Integer.MAX_VALUE;
            int index=-1;
            for (int j = 0; j < s.length; j++) {
                if(s[j]>=cookie && dp[j]==0)
                {
                   if(s[j]<min)
                   {
                       index=j;
                       min=s[j];
                   }
                }
            }
            if(index!=-1)
            {
                count++;
                dp[index]=1;
            }

        }
        return count;
    }
}
