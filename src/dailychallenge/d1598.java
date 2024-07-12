package dailychallenge;

import java.util.Objects;
import java.util.Stack;

public class d1598 {
    public static void main(String[] args) {
        String [] logs={"./","../","./"};
        System.out.println(minOperations(logs));

    }
    public static int minOperations(String[] logs) {
        Stack<String> stack=new Stack<>();
        for (String log : logs) {
            if (Objects.equals(log, "./")) {
                continue;
            } else if (Objects.equals(log, "../")){
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
                else {
                    continue;
                }

            } else {
                stack.push(log);
            }
        }
        return stack.size();

    }
}
