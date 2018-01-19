package codeforces.contests901_1000.problemset916;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class JamieAndInterestingGraph implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Edge {
        private int u, v, w;

        private Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return u + " " + v + " " + w;
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni();
        final int MAX = (int) 1e9;
        List<Edge> graph = new ArrayList<>();
        int mst = 2, total = mst;
        graph.add(new Edge(1, n, 2));
        if (n > 2) {
            mst = nextPrime(n) - 2;
            int u = 1, v = 2;
            int each = mst / (n - 2), rem = mst % (n - 2);
            int i;
            for (i = 1; i <= n - 2; i++) {
                int w = each + (rem > 0 ? 1 : 0);
                total += w;
                graph.add(new Edge(u, v++, w));
                if (rem > 0) rem--;
            }
            u = 2; v = 3;
            while (i < m) {
                graph.add(new Edge(u, v, MAX));
                if (v == n) {
                    u++;
                    v = u + 1;
                } else {
                    v++;
                }
                i++;
            }
        }
        out.println(2 + " " + total);
        for (Edge e : graph) {
            out.println(e);
        }
    }

    private int nextPrime(int n) {
        if (n % 2 == 0) n++;
        while (!isPrime(n)) n += 2;
        return n;
    }

    private boolean isPrime(int x) {
        if (x == 2) return true;
        if (x == 1 || x % 2 == 0) return false;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
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
        try (JamieAndInterestingGraph instance = new JamieAndInterestingGraph()) {
            instance.solve();
        }
    }
}
