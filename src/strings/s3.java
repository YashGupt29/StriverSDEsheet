package strings;

public class s3 {
    public static void main(String[] args) {
    String num="3691669784801845146";
        System.out.println(largestOddNumber(num));
    }
    public  static  String largestOddNumber(String num) {
        if(Integer.parseInt(num.substring(num.length()-1))%2!=0)
        {
            return num;
        }
        for (int i = num.length()-1; i >0 ; i--) {
            char checkNum=num.charAt(i-1);
            if(Integer.parseInt(String.valueOf(checkNum))%2!=0)
            {
                return num.substring(0,i);

            }
        }
        return "";
    }
}
