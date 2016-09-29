package codeforces.contests501_600.problemset514;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HanSoloAndLazerGun implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Trooper {
        int x;
        int y;
        boolean alive = true;
        
        private Trooper(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public void solve() {
        int n = in.ni(), x = in.ni(), y = in.ni();
        List<Trooper> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Trooper(in.ni(), in.ni()));
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            Trooper next = list.get(i);
            if (next.alive) {
                next.alive = false;
                result++;
                for (int j = 0; j < n; j++) {
                    Trooper p = list.get(j);
                    if (p.alive && onTheSameLineAs(x, y, next, p)) {
                        p.alive = false;
                    }
                }
            }
        }
        out.println(result);
    }
    
    private boolean onTheSameLineAs(int x, int y, Trooper a, Trooper b) {
        int x2 = a.x, y2 = a.y;
        int x3 = b.x, y3 = b.y;
        return (x2 - x) * (y3 - y) == (x3 - x) * (y2 - y);
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
        try (HanSoloAndLazerGun instance = new HanSoloAndLazerGun()) {
            instance.solve();
        }
    }
}
