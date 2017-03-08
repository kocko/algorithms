package codeforces.contests401_500.problemset441;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ValeraAndFruits implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni(), volume = in.ni();
        int[] day = new int[3003];
        int[] extra = new int[3003];
        while (n-- > 0) {
            int a = in.ni(), b = in.ni();
            day[a] += b;
        }
        int total = 0;
        for (int i = 1; i <= 3001; i++) {
            int current = extra[i];
            if (current > volume) {
                total += volume;
                extra[i + 1] = day[i];
            } else {
                int diff = volume - current;
                if (diff <= day[i]) {
                    current += diff;
                    day[i] -= diff; 
                    extra[i + 1] = day[i];
                } else {
                    current += day[i];
                }
                total += current;
            }
        }
        out.println(total);
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
        try (ValeraAndFruits instance = new ValeraAndFruits()) {
            instance.solve();
        }
    }
}
