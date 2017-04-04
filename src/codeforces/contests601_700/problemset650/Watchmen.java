package codeforces.contests601_700.problemset650;

import java.awt.*;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Watchmen implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Map<Integer, Long> a = new HashMap<>(); 
        Map<Integer, Long> b = new HashMap<>();
        Map<Point, Long> seen = new HashMap<>();
        long result = 0L;
        while (n-- > 0) {
            int x = in.ni(), y = in.ni();
            Point point = new Point(x, y);
            if (seen.keySet().contains(point)) {
                result -= seen.get(point);
                seen.put(point, seen.get(point) + 1);
            } else {
                seen.put(point, 1L);
            }
            a.put(x, a.getOrDefault(x, 0L) + 1);
            b.put(y, b.getOrDefault(y, 0L) + 1);
        }
        for (Map.Entry<Integer, Long> entry : a.entrySet()) {
            long value = entry.getValue();
            result += (value * (value - 1)) / 2;
        }
        for (Map.Entry<Integer, Long> entry : b.entrySet()) {
            long value = entry.getValue();
            result += (value * (value - 1)) / 2;
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

    public static void main(String[] args) throws IOException {
        try (Watchmen instance = new Watchmen()) {
            instance.solve();
        }
    }
}
