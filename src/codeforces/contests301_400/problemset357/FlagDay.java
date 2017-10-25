package codeforces.contests301_400.problemset357;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FlagDay implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] result = new int[n + 1];
        while(k-- > 0) {
            int x = in.ni(), y = in.ni(), z = in.ni();
            if (result[x] == 0 && result[y] == 0 && result[z] == 0) {
                result[x] = 1;
                result[y] = 2;
                result[z] = 3;
            } else {
                int color;
                if (result[x] != 0) {
                    color = result[x];
                } else if (result[y] != 0) {
                    color = result[y];
                } else {
                    color = result[z];
                }
                int[] colors = new int[2];
                int c = 0;
                for (int i = 1; i <= 3; i++) if (i != color) colors[c++] = i;
                c = 0;
                for (int i : new int[]{x, y, z}) {
                    if (result[i] == 0) {
                        result[i] = colors[c++];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            out.print(result[i]);
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
        try (FlagDay instance = new FlagDay()) {
            instance.solve();
        }
    }
}
