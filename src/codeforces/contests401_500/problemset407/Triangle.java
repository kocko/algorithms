package codeforces.contests401_500.problemset407;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Triangle implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), b = in.ni();
        int[][] result = new int[3][2];
        result[0][0] = result[0][1] = 0;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= a; j++) {
                if (i * i + j * j == a * a) {
                    if (i != result[0][0] && j != result[0][1]) {
                        result[1][0] = i;
                        result[1][1] = j;
                        for (int m = -b; m <= b; m++) {
                            for (int n = -b; n <= b; n++) {
                                if ((m * m + n * n == b * b) && (result[1][0] * m + result[1][1] * n == 0) && (m != result[1][0] && n != result[1][1])) {
                                    result[2][0] = m;
                                    result[2][1] = n;
                                    out.println("YES");
                                    for (int k = 0; k < 3; k++) {
                                        out.print(result[k][0]);
                                        out.print(' ');
                                        out.println(result[k][1]);
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        out.println("NO");
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
        try (Triangle instance = new Triangle()) {
            instance.solve();
        }
    }
}
