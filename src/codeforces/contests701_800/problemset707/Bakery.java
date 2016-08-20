package codeforces.contests701_800.problemset707;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bakery implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    class Edge implements Comparable<Edge> {
        int start;
        int end;
        int length;

        Edge(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.length, o.length);
        }
    }
    
    public void solve() {
        int n = in.ni(), m = in.ni(), k = in.ni();
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni(), l = in.ni();
            list.add(new Edge(u, v, l));
        }
        boolean[] storage = new boolean[n + 1];
        if (k == 0) {
            out.println(-1);
            return;
        }
        for (int i = 0; i < k; i++) {
            storage[in.ni()] = true;
        }
        Collections.sort(list);
        for (Edge e : list) {
            if ((storage[e.start] && !storage[e.end]) || (storage[e.end] && !storage[e.start])) {
                out.println(e.length);
                return;
            }
        }
        out.println(-1);
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
        try (Bakery instance = new Bakery()) {
            instance.solve();
        }
    }
}
