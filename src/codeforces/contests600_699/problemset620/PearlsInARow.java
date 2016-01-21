package codeforces.contests600_699.problemset620;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PearlsInARow implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    void solve() throws IOException {
        int n = Integer.parseInt(in.readLine());
        Set<Integer> used = new HashSet<>();
        String[] line = in.readLine().split("\\s+");
        List<int[]> result = new ArrayList<>();
        int start = 1;
        for (int i = 1; i <= n; i++) {
            int next = Integer.parseInt(line[i - 1]);
            if (!used.contains(next)) {
                 used.add(next);
            } else {
                result.add(new int[]{start, i});
                used = new HashSet<>();
                start = i + 1;
            }
        }
        if (result.size() == 0) {
            out.println(-1);
        } else {
            int k = result.size();
            if (start != k) {
                int[] last = result.get(k - 1);
                result.remove(k - 1);
                result.add(new int[]{last[0], n});
            }
            out.println(result.size());
            for (int[] r : result) {
                out.print(r[0] + " " + r[1]);
                out.print("\n");
            }
            out.println();
        }

    }

    public static void main(String[] args) throws IOException {
        new PearlsInARow().solve();
    }

}
