package codeforces.contests600_699.problemset644;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ProcessingQueries implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni(), b = in.ni();
        long[] time = new long[n];
        long[] duration = new long[n];
        long[] end = new long[n];
        Queue<Integer> q = new ArrayDeque<>();
        long free = 0;
        for (int i = 0; i < n; i++) {
            time[i] = in.ni();
            duration[i] = in.ni();
            while (free <= time[i] && q.size() > 0) {
                int id = q.poll();
                free = Math.max(free, time[id]) + duration[id];
                end[id] = free;
            }
            if (q.size() < b) {
                q.add(i);
            } else {
                end[i] = -1;
            }
        }
        while (q.size() > 0) {
            int id = q.poll();
            free = Math.max(free, time[id]) + duration[id];
            end[id] = free;
        }
        for (int i = 0; i < n; i++) {
            out.print(end[i] + " ");
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
