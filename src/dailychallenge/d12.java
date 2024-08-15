package dailychallenge;

public class d12 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("00011"));

    }
    public  static int numberOfSubstrings(String s) {
        int n = s.length();
        int[] prefixOnes = new int[n + 1];
        int[] prefixZeros = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixOnes[i + 1] = prefixOnes[i] + (s.charAt(i) == '1' ? 1 : 0);
            prefixZeros[i + 1] = prefixZeros[i] + (s.charAt(i) == '0' ? 1 : 0);
        }

        int count = 0;

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int ones = prefixOnes[end + 1] - prefixOnes[start];
                int zeros = prefixZeros[end + 1] - prefixZeros[start];

                if (ones >= zeros * zeros) {
                    count++;
                }
            }
        }

        return count;

    }
}
