package codeforces.contests301_400.problemset358;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class DimaAndContinuousLine implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Arc {
        private int start, end;
        
        private Arc(int x, int y) {
            this.start = Math.min(x, y);
            this.end = Math.max(x, y);
        }
    }

    public void solve() {
        int n = in.ni(), prev = -1;
        List<Arc> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prev = in.ni();
            } else {
                int value = in.ni();
                list.add(new Arc(value, prev));
                prev = value; 
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Arc a = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Arc b = list.get(j);
                boolean intersect = a.start > b.start && a.start < b.end && a.end > b.end;
                intersect |= a.end > b.start && a.end < b.end && a.start < b.start;
                if (intersect) {
                    out.println("yes");
                    return;
                }
            }
        }
        out.println("no");
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
        try (DimaAndContinuousLine instance = new DimaAndContinuousLine()) {
            instance.solve();
        }
    }
}
