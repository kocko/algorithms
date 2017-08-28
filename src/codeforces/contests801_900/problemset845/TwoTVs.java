package codeforces.contests801_900.problemset845;

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

public class TwoTVs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Show> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new Show(in.ni(), in.ni()));
        Collections.sort(list);
        int[] busy = {-1, -1};
        for (int i = 0; i < n; i++) {
            Show show = list.get(i);
            if (busy[0] < show.start) {
                busy[0] = show.end;
            } else if (busy[1] < show.start) {
                busy[1] = show.end;
            } else {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    }

    private class Show implements Comparable<Show> {
        private int start, end;

        private Show(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Show o) {
            int x = Integer.compare(this.start, o.start);
            int y = Integer.compare(this.end, o.end);
            return x == 0 ? y : x;
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
        try (TwoTVs instance = new TwoTVs()) {
            instance.solve();
        }
    }
}
