package codeforces.contests001_100.problemset004;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BeforeAnExam implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int d = in.ni(), minTime = in.ni();
        int[][] result = new int[2][d];
        int totalMin = 0, totalMax = 0;
        for (int i = 0; i < d; i++) {
            result[0][i] = in.ni();
            totalMin += result[0][i];
            result[1][i] = in.ni();
            totalMax += result[1][i];
        }
        if (totalMin <= minTime && totalMax >= minTime) {
            while (totalMin < minTime) {
                for (int i = 0; i < d; i++) {
                    if (result[0][i] < result[1][i]) {
                        result[0][i]++;
                        totalMin++;
                    }
                    if (totalMin == minTime) break;
                }
            }
            out.println("YES");
            for (int i : result[0]) {
                out.print(i + " ");
            }
            out.println();
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

    public static void main(String[] args) {
        new BeforeAnExam().solve();
    }
}
