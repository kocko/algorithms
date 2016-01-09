package codeforces.contests401_500.problemset500;

import java.util.Scanner;

public class NewYearTransportation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] visited = new boolean[n + 1];
        int t = sc.nextInt();
        visited[1] = true;
        int last = 1;
        for (int i = 1; i < n; i++) {
            int next = sc.nextInt();
            int connectsTo = next + i;
            if (i == last) {
                visited[connectsTo] = true;
                last = connectsTo;
            }
        }
        System.out.println(visited[t] ? "YES" : "NO");
        sc.close();
    }

}
