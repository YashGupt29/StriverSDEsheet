import java.io.*;
import java.util.*;

public class dp16 {
    static class Project implements Comparable<Project> {
        int start, end, reward;

        public Project(int start, int end, int reward) {
            this.start = start;
            this.end = end;
            this.reward = reward;
        }

        @Override
        public int compareTo(Project o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Project[] projects = new Project[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            projects[i] = new Project(start, end, reward);
        }

        Arrays.sort(projects);

        long[] dp = new long[n];
        dp[0] = projects[0].reward;

        for (int i = 1; i < n; i++) {
            long include = projects[i].reward;
            int index = binarySearch(projects, i);

            if (index != -1) {
                include += dp[index];
            }

            dp[i] = Math.max(dp[i - 1], include);
        }

        pw.println(dp[n - 1]);
        pw.flush();
    }

    public static int binarySearch(Project[] projects, int index) {
        int low = 0;
        int high = index - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (projects[mid].end < projects[index].start) {
                if (mid + 1 < projects.length && projects[mid + 1].end < projects[index].start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
