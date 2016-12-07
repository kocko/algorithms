package codeforces.contests701_800.problemset742;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArpasLoudOwfAndMehrdadsEvilPlan implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = in.ni();
        }
        int result = 1;
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int current = i;
            int t = 0;
            while (!visited[current]) {
                visited[current] = true;
                t++;
                current = x[current];
            }
            if (current != i) {
                out.println(-1);
                return;
            }
            if (t % 2 == 0) t /= 2;
            if (t >= 1) {
                result = lcm(result, t);
            }
        }
        out.println(result);
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
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
        try (ArpasLoudOwfAndMehrdadsEvilPlan instance = new ArpasLoudOwfAndMehrdadsEvilPlan()) {
            instance.solve();
        }
    }
}
