package dailychallenge;

import java.util.*;

public class d3327 {
    public static void main(String[] args) {
        int [] parent={-1,0,0,0,0};
        String s="aabcb";
        System.out.println(Arrays.toString(findAnswer(parent, s)));
    }
    private static void dfs(int node, Map<Integer, List<Integer>> tree, String s, int bitmask, boolean[] answer) {
        // Flip the bit corresponding to the current node's character (entering the node)
        bitmask ^= (1 << (s.charAt(node) - 'a'));

        // Check if the current bitmask can form a palindrome
        // A valid palindrome occurs if the bitmask has at most one bit set
        answer[node] = (bitmask == 0) || (Integer.bitCount(bitmask) == 1);

        // Traverse all children of the current node
        for (int child : tree.getOrDefault(node, new ArrayList<>())) {
            dfs(child, tree, s, bitmask, answer);
        }

    }


    // Main function to find the answer
    public static boolean[] findAnswer(int[] parent, String s) {
        int n = parent.length;
        boolean[] answer = new boolean[n];

        // Build the tree using an adjacency list representation
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 1; i < n; i++) {
            tree.computeIfAbsent(parent[i], k -> new ArrayList<>()).add(i);
        }

        // Perform DFS starting from the root (node 0)
        int initialBitmask = 0;
        dfs(0, tree, s, initialBitmask, answer);

        return answer;
    }

}
