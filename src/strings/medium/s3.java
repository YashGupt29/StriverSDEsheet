package strings.medium;

public class s3 {
    public static void main(String[] args) {
        String s="MCMXCIV";
        System.out.println(romanToInt(s));

    }
    public static int romanToInt(String s) {
        int sum=0;
        int prev=0;
        for (int i = 0; i <s.length() ; i++) {
            int num=s.charAt(i)=='I'?1:s.charAt(i)=='V'?5:s.charAt(i)=='X'?10:s.charAt(i)=='L'?50:s.charAt(i)=='C'?100:s.charAt(i)=='D'?500:1000;
           if(prev<num)
           {
               sum-=2*prev;
           }
           sum+=num;
           prev=num;
        }
        return sum;

    }
}
