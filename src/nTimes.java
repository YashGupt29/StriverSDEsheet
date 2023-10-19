public class nTimes {
    public static void main(String[] args) {

     printNtimes(5);
    }
    public static void printNtimes(int n){
        if(n==0)
        {
            return;
        }
        System.out.print("Coding Ninjas ");
        printNtimes(n-1);
    }
}
