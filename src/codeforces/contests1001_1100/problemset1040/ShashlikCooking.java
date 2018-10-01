package codeforces.contests1001_1100.problemset1040;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ShashlikCooking implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        List<Integer> best = new ArrayList<>();
        int size = (int) 1e9;
        for (int i = 1; i <= k + 1; i++) {
            List<Integer> temp = new ArrayList<>();
            int start = i;
            while (start <= n) {
                temp.add(start);
                start += 2 * k + 1;
            }
            if (temp.size() > 0 && n - temp.get(temp.size() - 1) <= k) {
                if (temp.size() < size) {
                    best = temp;
                    size = temp.size();
                }
            }
        }
        out.println(best.size());
        for (int value : best) {
            out.print(value);
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
        try (ShashlikCooking instance = new ShashlikCooking()) {
            instance.solve();
        }
    }
}
