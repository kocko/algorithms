package codeforces.contests401_500.problemset488;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class FightTheMonster implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int hy = in.ni(), ay = in.ni(), dy = in.ni();
        int hm = in.ni(), am = in.ni(), dm = in.ni();
        int h = in.ni(), a = in.ni(), d = in.ni(), result = (int) 1e7;
        for (int health = 0; health <= 1000; health++) {
            for (int attack = 0; attack <= 200; attack++) {
                for (int defence = 0; defence <= 200; defence++) {
                    if (ok(hy + health, ay + attack, dy + defence, hm, am, dm)) {
                        result = min(result, health * h + attack * a + defence * d);
                    }
                }
            }
        }
        out.println(result);
    }
    
    private boolean ok(int hy, int ay, int dy, int hm, int am, int dm) {
        if (ay - dm <= 0) return false;
        if (am - dy <= 0) return true;
        int yang = hy / (am - dy);
        if ((hy % (am - dy)) > 0) yang++;
        int monster = hm / (ay - dm);
        if ((hm % (ay - dm)) > 0) monster++;
        return yang > monster;
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
        try (FightTheMonster instance = new FightTheMonster()) {
            instance.solve();
        }
    }
}
