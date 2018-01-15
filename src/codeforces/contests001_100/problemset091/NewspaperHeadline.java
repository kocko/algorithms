package codeforces.contests001_100.problemset091;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class NewspaperHeadline implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            char c = x[i];
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }
        int result = 1, idx = 0;
        for (char c : y) {
            if (map.containsKey(c)) {
                List<Integer> list = map.get(c);
                if (idx > list.get(list.size() - 1)) {
                    result++;
                    idx = list.get(0) + 1;
                    continue;
                }
                int left = 0, right = list.size() - 1;
                int next = Integer.MAX_VALUE;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    int p = list.get(mid);
                    if (p >= idx) {
                        next = Math.min(next, p);
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                idx = next + 1;
            } else {
                out.println(-1);
                return;
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
        try (NewspaperHeadline instance = new NewspaperHeadline()) {
            instance.solve();
        }
    }
}
