package codeforces.contests201_300.problemset228;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TwoTables implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int na = in.ni(), ma = in.ni();
        int[][] a = new int[na][ma];
        for (int i = 0; i < na; i++) {
            String next = in.next();
            for (int j = 0; j < ma; j++) {
                a[i][j] = next.charAt(j) - '0';
            }
        }
        int nb = in.ni(), mb = in.ni();
        int[][] b = new int[nb][mb];
        for (int i = 0; i < nb; i++) {
            String next = in.next();
            for (int j = 0; j < mb; j++) {
                b[i][j] = next.charAt(j) - '0';
            }
        }
        int max = 0, max_x = 0, max_y = 0; 
        for (int x = -50; x <= 50; x++) {
            for (int y = -50; y <= 50; y++) {
                int temp = 0;
                for (int i = 0; i < na; i++) {
                    for (int j = 0; j < ma; j++) {
                        if (i + x >= 0 && i + x < nb && j + y >= 0 && j + y < mb) {
                            temp += (a[i][j] * b[i + x][j + y]);
                        }
                    }
                }
                if (temp > max) {
                    max = temp;
                    max_x = x;
                    max_y = y;
                }
            }
        }
        out.println(max_x + " " + max_y);
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
        try (TwoTables instance = new TwoTables()) {
            instance.solve();
        }
    }
}
