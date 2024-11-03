import java.util.Scanner;

 class c1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            int move = 1;
            int position = 0;
            boolean sakurakoTurn = true;

            while (Math.abs(position) <= n) {
                if (sakurakoTurn) {
                    position -= move;
                } else {
                    position += move;
                }
                sakurakoTurn = !sakurakoTurn;
                move += 2;
            }

            if (sakurakoTurn) {
                System.out.println("Kosuke");
            } else {
                System.out.println("Sakurako");
            }
        }
    }
}
