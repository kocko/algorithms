package codeforces.contests601_700.problemset611;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class NewYearAndOldProperty implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        set = new TreeSet<>();
        generate(0, "1");
        long a = in.nl(), b = in.nl(), cnt = 0;
        for (Long value : set) {
            if (value >= a && value <= b) cnt++;
        }
        out.println(cnt);
    }

    private TreeSet<Long> set;
    
    private void generate(int step, String value) {
        if (step < 63) {
            if (value.indexOf('0') > 0) {
                set.add(Long.parseLong(value, 2));
                generate(step + 1, value + "1");
            } else {
                generate(step + 1, value + "0");
                generate(step + 1, value + "1");
            }
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
        try (NewYearAndOldProperty instance = new NewYearAndOldProperty()) {
            instance.solve();
        }
    }
}
