package codeforces.contests601_700.problemset644;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ParliamentOfBerland implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni(), a = in.ni(), b = in.ni();
        if (n > a * b) {
            out.println(-1);
        } else {
            int k = 1;
            if (b % 2 == 0) {
                for (int i = 0; i < a; i++) {
                    int[] row = new int[b];
                    if (i % 2 == 0) {
                        for (int j = 0; j < b; j++) {
                            if (k <= n) {
                                row[j] = k++;
                            } else {
                                row[j] = 0;
                            }
                        }
                    } else {
                        for (int j = b - 1; j >= 0; j--) {
                            if (k <= n) {
                                row[j] = k++;
                            } else {
                                row[j] = 0;
                            }
                        }
                    }
                    for (int x : row) {
                        out.print(x + " ");
                    }
                    out.println();
                }
            } else {
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < b; j++) {
                        if (k <= n) {
                            out.print(k++);
                        } else {
                            out.print(0);
                        }
                        out.print(" ");
                    }
                    out.println();
                }
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

    public static void main(String[] args) {
        new ParliamentOfBerland().solve();
    }
}
