package codeforces.contests501_600.problemset501;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class MishaAndChangingHandles implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    static class Pair {
        String head;
        String tail;

        Pair(String head, String tail) {
            this.head = head;
            this.tail = tail;
        }

        static Pair of(String head, String tail) {
            return new Pair(head, tail);
        }
    }

    static class DSU {
        private List<Pair> list = new ArrayList<>();

        void join(Pair pair) {
            Iterator<Pair> iterator = list.iterator();
            while (iterator.hasNext()) {
                Pair next = iterator.next();
                if (next.tail.equals(pair.head)) {
                    pair.head = next.head;
                    iterator.remove();
                    break;
                }
            }
            list.add(pair);
        }

        Pair get(int index) {
            return list.get(index);
        }

        int size() {
            return list.size();
        }
    }

    public void solve() {
        int n = in.ni();
        DSU dsu = new DSU();
        for (int i = 0; i < n; i++) {
            String from = in.next(), to = in.next();
            dsu.join(Pair.of(from, to));
        }
        int size = dsu.size();
        out.println(size);
        for (int i = 0; i < size; i++) {
            Pair pair = dsu.get(i);
            out.println(pair.head + " " + pair.tail);
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
        new MishaAndChangingHandles().solve();
    }
}
