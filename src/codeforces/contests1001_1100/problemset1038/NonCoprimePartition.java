package codeforces.contests1001_1100.problemset1038;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class NonCoprimePartition implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni();
        if (n <= 2) {
            out.println("No");
            return;
        }
        out.println("Yes");
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        int odds = (n + 1) / 2;
        if (n % 2 == 0 || odds % 2 == 0) {
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 1) a.add(i);
                else b.add(i);
            }
        } else {
            int half = n / 2;
            for (int i = 1; i <= half; i++) {
                a.add(i);
            }
            for (int i = half + 1; i <= n; i++) {
                b.add(i);
            }
        }
        print(a);
        print(b);
    }
    
    private void print(List<? extends Integer> list) {
        out.print(list.size());
        out.print(' ');
        for (Integer value : list) {
            out.print(value);
            out.print(' '); 
        }
        out.println();
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
        try (NonCoprimePartition instance = new NonCoprimePartition()) {
            instance.solve();
        }
    }
}
