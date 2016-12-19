package codeforces.contests701_800.problemset747;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Servers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        long[] busyUntil = new long[n + 1];
        while (q-- > 0) {
            int t = in.ni(), k = in.ni(), d = in.ni();
            List<Integer> servers = new ArrayList<>(); 
            for (int i = 1; i <= n; i++) {
                if (k == 0) break;
                if (busyUntil[i] < t) {
                    servers.add(i);
                    k--;
                }
            }
            if (k == 0) {
                long total = 0L;
                for (int s : servers) {
                    busyUntil[s] = t + d - 1;
                    total += s;
                }
                out.println(total);
            } else {
                out.println(-1);
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
        try (Servers instance = new Servers()) {
            instance.solve();
        }
    }
}
