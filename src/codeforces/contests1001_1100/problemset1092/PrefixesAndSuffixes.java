package codeforces.contests1001_1100.problemset1092;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PrefixesAndSuffixes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Entry {
        private int idx;
        private String value;

        private Entry(int idx, String value) {
            this.value = value;
            this.idx = idx;
        }
    }

    public void solve() {
        int n = in.ni();
        if (n == 2) {
            out.println("PS");
            return;
        }
        List<String> min = new ArrayList<>(), max = new ArrayList<>();
        for (int i = 0; i < 2 * n - 2; i++) {
            String value = in.next();
            list.add(new Entry(i, value));
            if (value.length() == 1) min.add(value);
            if (value.length() == n - 1) max.add(value);
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                String word = min.get(i) + max.get(j);
                char[] t = test(word);
                if (t != null) {
                    for (char c : t) {
                        out.print(c);
                    }
                    return;
                }
            }
        }
    }

    private List<Entry> list = new ArrayList<>();

    private char[] test(String word) {
        int n = word.length();
        char[] result = new char[2 * n - 2];
        int[] can = new int[2 * n - 2];
        boolean[] hasPrefix = new boolean[n], hasSuffix = new boolean[n];
        for (Entry e : list) {
            if (word.startsWith(e.value)) {
                can[e.idx] |= 1;
            }
            if (word.endsWith(e.value)) {
                can[e.idx] |= 2;
            }
        }
        int prefixes = 0, suffixes = 0;

        for (int i = 0; i < can.length; i++) {
            if (can[i] == 0) return null;
            if (can[i] == 1) {
                result[i] = 'P';
                hasPrefix[list.get(i).value.length()] = true;
                prefixes++;
            }
            if (can[i] == 2) {
                suffixes++;
                hasSuffix[list.get(i).value.length()] = true;
                result[i] = 'S';
            }
        }
        if (prefixes >= n || suffixes >= n) return null;
        if (prefixes < n - 1) {
            for (int i = 0; i < can.length; i++) {
                if (prefixes == n - 1) break;
                if (can[i] == 3 && !hasPrefix[list.get(i).value.length()]) {
                    result[i] = 'P';
                    can[i] = 1;
                    hasPrefix[list.get(i).value.length()] = true;
                    prefixes++;
                }
            }
        }
        if (suffixes < n - 1) {
            for (int i = 0; i < can.length; i++) {
                if (suffixes == n - 1) break;
                if (can[i] == 3 && !hasSuffix[list.get(i).value.length()]) {
                    result[i] = 'S';
                    hasSuffix[list.get(i).value.length()] = true;
                    prefixes++;
                }
            }
        }
        return result;
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
        try (PrefixesAndSuffixes instance = new PrefixesAndSuffixes()) {
            instance.solve();
        }
    }
}
