package recursion;

public class r1 {
    public static void main(String[] args) {
        String s="   -042";
        System.out.println(myAtoi(s));

    }
    public static int myAtoi(String s) {
        if(s==null && s.isEmpty())
        {
            return 0;
        }
        return myAtoiHelper(s.trim(),0,0,1);
    }
    public static int   myAtoiHelper(String s,int index,int result,int sign)
    {
        if(index>=s.length())
        {
            return sign*result;
        }
        char currentChar=s.charAt(index);
        //Handle sign
        if(index==0 && (currentChar=='-'|| currentChar=='+'))
        {
            sign=currentChar=='-'?-1:1;
            return myAtoiHelper(s,index+1,result,sign);
        }
        //Handle digit
        if(currentChar>='0' && currentChar<='9')
        {
            int digit=currentChar-'0';
            if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && digit>7))
            {
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            result=result*10+digit;
            return myAtoiHelper(s,index+1,result,sign);
        }
        return result*sign;

    }

}
