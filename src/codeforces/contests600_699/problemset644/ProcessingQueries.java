package codeforces.contests600_699.problemset644;

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

public class ProcessingQueries implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class Query {
        int index;
        long duration;

        Query(int index, long duration) {
            this.index = index;
            this.duration = duration;
        }
    }

    public void solve() {
        int n = in.ni(), b = in.ni();
        List<Query> queue = new ArrayList<>();
        long[] result = new long[n];
        long busyUntil = in.nl() + in.nl();
        result[0] = busyUntil;
        for (int i = 1; i < n; i++) {
            long arrival = in.nl();
            long duration = in.nl();
            Query query = new Query(i, duration);
            if (arrival < busyUntil) {
                if (queue.size() == b) {
                    result[i] = -1;
                } else {
                    queue.add(query);
                }
            } else {
                if (queue.isEmpty()) {
                    busyUntil += duration;
                    result[i] = busyUntil;
                } else {
                    Query top = queue.get(0);
                    busyUntil += top.duration;
                    queue.remove(0);
                    result[top.index] = busyUntil;
                    queue.add(query);
                }
            }
        }
        for (Query query : queue) {
            busyUntil += query.duration;
            result[query.index] = busyUntil;
        }
        for (long i : result) {
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
        new ProcessingQueries().solve();
    }
}
