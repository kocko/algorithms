package codeforces.contests901_1000.problemset988;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DiverseTeam implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] last = new int[101];
        int count = 0; 
        for (int i = 1; i <= n; i++) {
            int rating = in.ni();
            if (last[rating] == 0) {
                count++;
            }
            last[rating] = i;
        }
        if (count >= k) {
            out.println("YES");
            while (k-- > 0) {
                for (int i = 1; i <= 100; i++) {
                    if (last[i] != 0) {
                        out.print(last[i]);
                        out.print(' ');
                        last[i] = 0;
                        break;
                    }
                }
            }
        } else {
            out.println("NO");
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
        try (DiverseTeam instance = new DiverseTeam()) {
            instance.solve();
        }
    }
}
