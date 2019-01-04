package codeforces.contests1001_1100.problemset1097;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class YuhaoAndAParenthesis implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] balance = new int[n], min = new int[n];
        Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
        String[] x = new String[n];
        int result = 0, regular = 0;
        for (int i = 0; i < n; i++) {
            x[i] = in.next();
            int bal = 0, mn = Integer.MAX_VALUE;
            for (char c : x[i].toCharArray()) {
                if (c == '(') {
                    bal++;
                } else {
                    bal--;
                }
                mn = Math.min(mn, bal);
            }
            balance[i] = bal;
            min[i] = mn;
            if (bal == 0 && mn >= 0) {
                regular++;
            } else {
                TreeMap<Integer, Integer> minBalanceCount = map.getOrDefault(bal, new TreeMap<>());
                minBalanceCount.put(mn, minBalanceCount.getOrDefault(mn, 0) + 1);
                map.put(bal, minBalanceCount);
            }
        }
        result += regular / 2;
        for (int i = 0; i < n; i++) {
            if (balance[i] > 0 && min[i] >= 0) {
                TreeMap<Integer, Integer> possible = map.getOrDefault(-balance[i], new TreeMap<>());
                Integer ceilingKey = possible.ceilingKey(-balance[i]);
                if (ceilingKey != null) {
                    Integer count = possible.getOrDefault(ceilingKey, -1);
                    if (count != -1) {
                        result++;
                        if (count > 1) {
                            possible.put(-balance[i], count - 1);
                        } else {
                            possible.remove(-balance[i]);
                        }
                    }
                    if (possible.size() > 0) {
                        map.put(-balance[i], possible);
                    } else {
                        map.remove(-balance[i]);
                    }
                }
            }
        }
        out.println(result);
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
        try (YuhaoAndAParenthesis instance = new YuhaoAndAParenthesis()) {
            instance.solve();
        }
    }
}
