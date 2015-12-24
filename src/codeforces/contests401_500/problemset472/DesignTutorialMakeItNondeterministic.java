package codeforces.contests401_500.problemset472;

import java.util.Scanner;

public class DesignTutorialMakeItNondeterministic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] x = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextLine();
        }
        String[] order = sc.nextLine().split("\\s+");
        sc.close();
        String lastName = min(x[Integer.parseInt(order[0])]);
        for (int i = 1; i < n; i++) {
            int index = Integer.parseInt(order[i]);
            String name = min(x[index]);
            if (name.compareTo(lastName) < 0) {
                String other = max(x[index]);
                if (other.compareTo(lastName) < 0) {
                    System.out.println("NO");
                    return;
                } else {
                    lastName = other;
                }
            } else {
                lastName = name;
            }
        }
        System.out.println("YES");
    }

    static String min(String s) {
        String[] x = s.split("\\s+");
        if (x[0].compareTo(x[1]) <= 0) return x[0];
        return x[1];
    }

    static String max(String s) {
        String[] x = s.split("\\s+");
        if (x[0].compareTo(x[1]) <= 0) return x[1];
        return x[0];
    }

}
