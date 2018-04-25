package codeforces.contests501_600.problemset579;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingInt;

public class FindingTeamMember implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[][] grid = new int[2 * n + 1][2 * n + 1];
        List<Pair> list = new ArrayList<>();
        for (int i = 2; i <= 2 * n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                grid[i][j] = in.ni();
                list.add(new Pair(i, j, grid[i][j]));
            }
        }
        list.sort(comparingInt(Pair::getStrength));
        boolean[] busy = new boolean[2 * n + 1];
        int[] result = new int[2 * n + 1];
        for (Pair p : list) {
            if (!busy[p.u] && !busy[p.v]) {
                result[p.u] = p.v;
                result[p.v] = p.u;
                busy[p.u] = busy[p.v] = true;
            }
        }
        for (int i = 1; i <= 2 * n; i++) {
            out.print(result[i]);
            out.print(' ');
        }
    }

    private class Pair {
        private int u, v, strength;

        private Pair(int u, int v, int strength) {
            this.u = u;
            this.v = v;
            this.strength = strength;
        }

        private int getStrength() {
            return -strength;
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (FindingTeamMember instance = new FindingTeamMember()) {
            instance.solve();
        }
    }
}
