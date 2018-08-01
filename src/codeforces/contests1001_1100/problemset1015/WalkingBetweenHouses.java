package codeforces.contests1001_1100.problemset1015;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class WalkingBetweenHouses implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        long s = in.nl();
        long max = n - 1;
        
        if (k * max < s || k > s) {
            out.println("NO");
            return;
        }
        
        out.println("YES");
        s -= k;
        int house = 1;
        for (int i = 0; i < k; i++) {
            long step = min(s, n - 2) + 1;
            s -= step - 1;
            
            if (house + step > n) house -= step;
            else house += step;
            
            out.print(house);
            out.print(' ');
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
        try (WalkingBetweenHouses instance = new WalkingBetweenHouses()) {
            instance.solve();
        }
    }
}
