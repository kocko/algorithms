package codeforces.contests601_700.problemset660;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CoPrimeArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public void solve() {
        int n = in.ni();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = in.ni();
        }
        List<Integer> result = new ArrayList<>();
        result.add(list[0]);
        int next = 1, last = result.get(0);
        while (next < n) {
            if (gcd(list[next], last) == 1) {
                result.add(list[next]);
            } else {
                for (int j = 2; ; j++) {
                    if (gcd(last, j) == 1 && gcd(list[next], j) == 1) {
                        result.add(j);
                        result.add(list[next]);
                        break;
                    }
                }
            }
            last = list[next];
            next++;
        }
        out.println(result.size() - list.length);
        for (Integer i : result) {
            out.print(i + " ");
        }
        out.println();
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
        new CoPrimeArray().solve();
    }
}
