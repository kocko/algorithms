package codeforces.contests901_1000.problemset962;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class StudentsInRailwayCarriage implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), a = in.ni(), b = in.ni(), current = 0, result = 0;
        char[] x = in.next().toCharArray();
        for (int i = 0; i < n; i++) {
            if (x[i] == '.') current++;
            else {
                int max = current % 2 == 1 ? (current + 1) / 2 : current / 2;
                int min = current - max;
                if (a >= b) {
                    int score = min(a, max);
                    result += score;
                    a -= score;
                    score = min(b, min);
                    result += score;
                    b -= score;
                } else {
                    int score = min(b, max);
                    result += score;
                    b -= score;
                    score = min(a, min);
                    result += score;
                    a -= score;
                }
                current = 0;
            }
        }
        if (current > 0) {
            int max = current % 2 == 1 ? (current + 1) / 2 : current / 2;
            int min = current - max;
            if (a >= b) {
                int score = min(a, max);
                result += score;
                score = min(b, min);
                result += score;
            } else {
                int score = min(b, max);
                result += score;
                score = min(a, min);
                result += score;
            }
        }
        out.println(result);
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
        try (StudentsInRailwayCarriage instance = new StudentsInRailwayCarriage()) {
            instance.solve();
        }
    }
}
