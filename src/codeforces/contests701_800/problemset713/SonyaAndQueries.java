package codeforces.contests701_800.problemset713;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SonyaAndQueries implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char operation = in.next().charAt(0);
            String value = in.next();
            switch (operation) {
                case '+': {
                    String key = convert(value);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    break;
                }
                case '-': {
                    String key = convert(value);
                    map.put(key, map.get(key) - 1);
                    break;
                }
                case '?': {
                    char[] key = new char[18];
                    int from = 18 - value.length();
                    for (int k = 0; k < from; k++) {
                        key[k] = '0';
                    }
                    for (int k = from; k < 18; k++) {
                        key[k] = value.charAt(k - from);
                    }
                    out.println(map.getOrDefault(new String(key), 0));
                    break;
                }
            }
        }
    }
    
    private String convert(String value) {
        char[] result = new char[18];
        int from = 18 - value.length();
        for (int i = 0; i < from; i++) {
            result[i] = '0';
        }
        for (int i = from; i < 18; i++) {
            result[i] = (value.charAt(i - from) - '0') % 2 == 0 ? '0' : '1';
        }
        return new String(result);
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
        try (SonyaAndQueries instance = new SonyaAndQueries()) {
            instance.solve();
        }
    }
}
