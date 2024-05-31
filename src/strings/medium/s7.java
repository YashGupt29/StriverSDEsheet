package strings.medium;

public class s7 {
    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));

    }
    public  static int beautySum(String s) {
        int sum=0;
        for (int i = 0; i <s.length() ; i++) {
            int [] freq=new int[26];
            for (int j = i; j <s.length() ; j++)
            {
                char ch=s.charAt(j);
                freq[ch-'a']++;
                int max=Integer.MIN_VALUE;
                int min=Integer.MAX_VALUE;
                for (int k = 0; k <freq.length ; k++)
                {
                    if(freq[k]>max && freq[k]>0)
                    {
                        max=freq[k];
                    }
                    if(freq[k]<min && freq[k]>0)
                    {
                        min=freq[k];
                    }
                }
                sum+=max-min;

            }

        }
        return sum;
    }
}
