package codeforces.contests501_600.problemset596;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WilburAndPoints implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return x - o.x;
        }
    }

    public void solve() {
        int n = in.ni();
        Map<Integer, PriorityQueue<Point>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = in.ni(), y = in.ni();
            PriorityQueue<Point> list = map.getOrDefault(y - x, new PriorityQueue<>());
            list.add(new Point(x, y));
            map.put(y - x, list);
        }
        Point[] result = new Point[n];
        boolean valid = true;
        for (int i = 0; i < n; i++) {
            int key = in.ni();
            PriorityQueue<Point> queue = map.get(key);
            if (queue == null || queue.isEmpty()) {
                valid = false;
                break;
            } else {
                result[i] = queue.poll();
            }
        }
        if (valid && valid(result)) {
            out.println("YES");
            for (Point point : result) {
                out.println(point.x + " " + point.y);
            }
        } else {
            out.println("NO");
        }
    }

    boolean valid(Point[] list) {
        int x = -1;
        int y = -1;
        for (Point p : list) {
            if (p.x <= x && p.y <= y) return false;
            else if (p.x >= x && p.y >= y) {
                x = p.x;
                y = p.y;
            }

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
        try (WilburAndPoints instance = new WilburAndPoints()) {
            instance.solve();
        }
    }
}
