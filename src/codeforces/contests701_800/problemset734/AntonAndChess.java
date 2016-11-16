package codeforces.contests701_800.problemset734;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AntonAndChess implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Figure {
        int x;
        int y;
        char type;
        
        private Figure(char type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
    
    public void solve() {
        int n = in.ni();
        int a = in.ni(), b = in.ni();
        boolean[] paths = new boolean[8];
        Figure[] closest = new Figure[8];
        for (int i = 0; i < n; i++) {
            char type = in.next().charAt(0);
            int x = in.ni(), y = in.ni();
            Figure figure = new Figure(type, x, y);
            int path = findPath(a, b, x, y);
            if (path != -1) {
                Figure f = closest[path];
                if (f != null) {
                    if (dist(x, y, a, b) < dist(f.x, f.y, a, b)) {
                        closest[path] = figure;
                        paths[path] = canDefeat(figure, a, b);
                    }
                } else {
                    paths[path] = canDefeat(figure, a, b);
                    closest[path] = figure;
                }
            }
        }
        boolean ans = false;
        for (boolean c : paths) {
            ans |= c;
        }
        out.println(ans ? "YES" : "NO");
    }
    
    private int dist(int x, int y, int a, int b) {
        if (x == a) {
            return Math.abs(y - b);
        } else if (y == b) {
            return Math.abs(x - a);
        } else {
            return Math.abs(x - a);
        }
    }
    
    private boolean canDefeat(Figure f, int a, int b) {
        int x = f.x, y = f.y;
        switch (f.type) {
            case 'R': {
                return (x == a || y == b);
            }
            case 'B': {
                return Math.abs(x - a) == Math.abs(y - b);
            }
            case 'Q': {
                return (x == a || y == b || Math.abs(x - a) == Math.abs(y - b));
            }
        }
        return false;
    }
    
    private int findPath(int a, int b, int x, int y) {
        if (x == a && y > b) return 1;
        if (x > a && y == b) return 3;
        if (x == a && y < b) return 5;
        if (x < a && y == b) return 7;
        if (x < a && y > b) {
            if (Math.abs(x - a) == Math.abs(y - b)) return 2;
            else return -1;
        }
        if (x > a && y > b) {
            if (Math.abs(x - a) == Math.abs(y - b)) return 4;
            else return -1;
        }
        if (x > a && y < b) {
            if (Math.abs(x - a) == Math.abs(y - b)) return 6;
            else return -1;
        }
        if (x < a && y < b) {
            if (Math.abs(x - a) == Math.abs(y - b)) return 0;
            else return -1;
        }
        return -1;
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
        try (AntonAndChess instance = new AntonAndChess()) {
            instance.solve();
        }
    }
}
