package codeforces.contests701_800.problemset727;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TransformationFromAToB implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), b = in.ni();
        int[] result = new int[51];
        start(a, b, result, 50);
        if (!ok) {
            out.println("NO");
        }
    }

    private boolean ok;
    
    private void start(int a, int b, int[] result, int index) {
        if (a == b) {
            ok = true;
            out.println("YES");
            out.println(51 - index);
            result[index] = a;
            for (int i = index; i <= 50; i++) {
                out.print(result[i] + " ");
            }
        } else if (a < b) {
            if (b % 10 == 1) {
                result[index] = b;
                start(a, (b - 1) / 10, result, index - 1);
            } else if (b % 2 == 0) {
                result[index] = b;
                start(a, b / 2, result, index - 1);
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
        try (TransformationFromAToB instance = new TransformationFromAToB()) {
            instance.solve();
        }
    }
}
