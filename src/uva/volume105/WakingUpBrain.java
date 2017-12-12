package uva.volume105;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class WakingUpBrain implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNextLine()) {
            boolean[] awake = new boolean[26];
            boolean[] exist = new boolean[26];
            int n = parseInt(in.nextLine());
            int m = parseInt(in.nextLine());
            
            char[] x = in.nextLine().toCharArray();
            for (char c : x) awake[c - 'A'] = true;

            boolean[][] graph = new boolean[26][26];
            for (int i = 0; i < m; i++) {
                char[] connection = in.nextLine().toCharArray();
                exist[connection[0] - 'A'] = exist[connection[1] - 'A'] = true;
                graph[connection[0] - 'A'][connection[1] - 'A'] = graph[connection[1] - 'A'][connection[0] - 'A'] = true;
            }
            int year;
            for (year = 0; year < 31; year++) {
                List<Integer> wake = new ArrayList<>();
                for (int i = 0; i < 26; i++) {
                    if (exist[i] && !awake[i]) {
                        int c = 0;
                        for (int j = 0; j < 26; j++) {
                            if (exist[j]) {
                                if (graph[i][j] && awake[j]) c++;
                            }
                        }
                        if (c >= 3) wake.add(i);
                    }
                }
                if (wake.size() == 0) break;
                for (int i : wake) {
                    awake[i] = true;
                }
            }
            int total = 0;
            for (int i = 0; i < 26; i++) {
                if (awake[i]) {
                    total++;
                }
            }
            if (total < n) {
                out.println("THIS BRAIN NEVER WAKES UP");
            } else {
                out.printf("WAKE UP IN, %d, YEARS\n", year);
            }
            if (in.hasNextLine()) in.nextLine();
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (WakingUpBrain instance = new WakingUpBrain()) {
            instance.solve();
        }
    }
}
