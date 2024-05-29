package strings.medium;

public class s2 {
    public static void main(String[] args) {
        String s="1";
        System.out.println(maxDepth(s));

    }
    public static int maxDepth(String s) {
        int count=0,maxcount=0,index=-1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(')
            {
                count++;
                if(count>maxcount) {
                    index=i;
                    maxcount=count;
                }

            } else if (s.charAt(i)==')') {
                count--;
            }
        }
        return maxcount;
            }
}
