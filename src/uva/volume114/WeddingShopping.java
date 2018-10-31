package uva.volume114;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class WeddingShopping implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            money = in.ni();
            int c = in.ni();
            articles = new ArrayList<>();
            for (int i = 0; i < c; i++) {
                int count = in.ni();
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < count; j++) {
                    temp.add(in.ni());
                }
                articles.add(temp);
            }
            n = articles.size();
            dp = new Integer[n][money + 1];
            Integer result = recurse(0, 0);
            out.println(result <= 0 ? "no solution" : result);
        }
    }


    private int n, money;
    private List<List<Integer>> articles;
    private Integer[][] dp;

    private Integer recurse(int idx, int current) {
        if (idx == n) return 0;
        if (dp[idx][current] != null) return dp[idx][current];

        int ans = (int) -1e7;
        List<Integer> article = articles.get(idx);
        for (int value : article) {
            if (current + value <= money) {
                ans = max(ans, value + recurse(idx + 1, current + value));
            }
        }
        return dp[idx][current] = ans;
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
        try (WeddingShopping instance = new WeddingShopping()) {
            instance.solve();
        }
    }
}
