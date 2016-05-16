package codeforces.contests201_300.problemset242;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BigSegment implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    static class Segment {
        int index;
        int left;
        int right;

        public Segment(int index, int left, int right) {
            this.index = index;
            this.left = left;
            this.right = right;
        }

    } 
    public void solve() {
        int n = in.ni();
        List<Segment> segments = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = 0; 
        for (int i = 1; i <= n; i++) {
            int a = in.ni(), b = in.ni();
            min = Math.min(a, min);
            max = Math.max(b, max);
            segments.add(new Segment(i, a, b));
        }
        int result = -1;
        for (Segment s : segments) {
            if (s.left == min && s.right == max) {
                result = s.index;
                break;
            }
        }
        out.println(result);
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
        new BigSegment().solve();
    }
}
