package codeforces.contests801_900.problemset864;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Fire implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Item implements Comparable<Item> {
        private int idx, t, d, p;

        private Item(int idx, int t, int d, int p) {
            this.idx = idx;
            this.t = t;
            this.d = d;
            this.p = p;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(this.d, o.d);
        }
    }
    
    public void solve() {
        n = in.ni();
        for (int i = 0; i < n; i++) {
            items.add(new Item(i + 1, in.ni(), in.ni(), in.ni()));
        }
        items.sort(Comparator.naturalOrder());
        final int MAX = 40001;
        dp = new int[n][MAX];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < MAX; j++) {
                dp[i][j] = -1;
            }
        }
        out.println(recurse(0, 0));
        printOrder();
    }
    
    private int n;
    private List<Item> items = new ArrayList<>();
    private int[][] dp;
    
    private int recurse(int idx, int time) {
        if (idx == n) return 0;
        if (dp[idx][time] != -1) return dp[idx][time];

        int ans = recurse(idx + 1, time);
        Item item = items.get(idx);
        if (time + item.t < item.d) {
            int take = item.p + recurse(idx + 1, time + item.t);
            if (take > ans) {
                ans = take;
            }
        }
        return dp[idx][time] = ans;
    }
    
    private void printOrder() {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n - 1) {
            Item item = items.get(i);
            if (dp[i][j] - item.p == dp[i + 1][j + item.t] && dp[i + 1][j + item.t] != -1) {
                result.add(item.idx);
                j += item.t;
            }
            i++;
        }
        if (dp[i][j] != 0) result.add(items.get(n - 1).idx);
        out.println(result.size());
        for (int idx : result) {
            out.print(idx);
            out.print(' ');
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
        try (Fire instance = new Fire()) {
            instance.solve();
        }
    }
}
