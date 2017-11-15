package codeforces.contests301_400.problemset350;

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

import static java.lang.Math.abs;

public class Bombs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Bomb> bombs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bombs.add(new Bomb(in.ni(), in.ni()));
        }
        bombs.sort(Comparator.naturalOrder());
        List<Operation> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Bomb bomb = bombs.get(i);
            List<Walk> walks = walkTo(0, 0, bomb.x, bomb.y);
            result.addAll(walks);
            result.add(new Pick());
            result.addAll(reverse(walks));
            result.add(new Destroy());
        }
        out.println(result.size());
        result.forEach(out::println);
    }
    
    private class Bomb implements Comparable<Bomb> {
        private int x, y, d;

        private Bomb(int x, int y) {
            this.x = x;
            this.y = y;
            d = abs(x) + abs(y);
        }

        @Override
        public int compareTo(Bomb o) {
            return Integer.compare(this.d, o.d);
        }
    }
    
    private List<Walk> reverse(List<Walk> list) {
        List<Walk> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            int dist = list.get(i).k;
            char d = list.get(i).dir;
            if (d == 'U') d = 'D';
            else if (d == 'D') d = 'U';
            else if (d == 'R') d = 'L';
            else if (d == 'L') d = 'R';
            result.add(new Walk(dist, d));
        }
        return result;
    }
    
    private List<Walk> walkTo(int x, int y, int p, int q) {
        List<Walk> result = new ArrayList<>();
        char dir = '?';
        int dist = 0;
        if (x < p) {
            dir = 'R';
            dist = p - x; 
        } else if (x > p) {
            dir = 'L';
            dist = x - p;
        }
        if (x != p) result.add(new Walk(dist, dir));
        dir = '?';
        dist = 0;
        if (y < q) {
            dir = 'U';
            dist = q - y;
        } else if (y > q) {
            dir = 'D';
            dist = y - q;
        }
        if (y != q) result.add(new Walk(dist, dir));
        return result;
    }

    private interface Operation {
        int getType();
    }

    private class Pick implements Operation {
        @Override
        public int getType() {
            return 2;
        }

        @Override
        public String toString() {
            return "" + getType();
        }
    }

    private class Walk implements Operation {
        private int k;
        private char dir;

        private Walk(int k, char dir) {
            this.k = k;
            this.dir = dir;
        }

        @Override
        public int getType() {
            return 1;
        }

        @Override
        public String toString() {
            return getType() + " " + k + " " + dir;
        }
    }

    private class Destroy implements Operation {
        @Override
        public int getType() {
            return 3;
        }

        @Override
        public String toString() {
            return "" + getType();
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
        try (Bombs instance = new Bombs()) {
            instance.solve();
        }
    }
}
