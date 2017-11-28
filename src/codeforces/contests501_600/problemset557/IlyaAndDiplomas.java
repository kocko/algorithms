package codeforces.contests501_600.problemset557;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IlyaAndDiplomas implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] min = new int[3], max = new int[3];
        for (int i = 0; i < 3; i++) {
            min[i] = in.ni();
            max[i] = in.ni();
        }
        int first = 0, second = 0, third = 0;
        for (int i = max[0]; i >= min[0]; i--) {
            int rem = n - i;
            int left = min[1], right = max[1];
            int possibleSecond = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int t = rem - mid;
                if (t < min[2]) {
                    right = mid - 1;
                } else if (t > max[2]) {
                    left = mid + 1;
                } else {
                    possibleSecond = Math.max(possibleSecond, mid);
                    left = mid + 1;
                }
            }
            if (possibleSecond != -1) {
                first = i;
                second = possibleSecond;
                third = n - first - second;
                break;
            }
        }
        out.println(first + " " + second + " " + third);
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
        try (IlyaAndDiplomas instance = new IlyaAndDiplomas()) {
            instance.solve();
        }
    }
}
