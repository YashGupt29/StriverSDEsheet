public class reverseNumBit {
    public static long reverseBits(long n)
    {
        // Write your code here
        String bit="";
        String fullBit="";
        long revNum=0;
        while(n!=0)
        {
            long rem=n%2;
            bit=rem+bit;
            n=n/2;
        }
        for(int i=0;i<(32-bit.length());i++)
        {
            fullBit=fullBit+0;
        }


        String comBit=fullBit+bit;
        System.out.println(comBit);
        long revBit=reverseNumber(comBit);

        return revBit;
    }
    public static long reverseNumber(String n)
    {
        String revStr="";
        for(int j=0;j<n.length();j++)
        {
        char chr=n.charAt(j);
        revStr=chr+revStr;
        }
       String rev=revStr;
        long num =Long.parseLong(rev,2);


      System.out.println(num);
        return num;
    }
    public static void main(String args[])
    {
        long num=reverseBits(100);
        System.out.println(num);
    }
}