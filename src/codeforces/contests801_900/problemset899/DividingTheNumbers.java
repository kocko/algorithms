package codeforces.contests801_900.problemset899;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DividingTheNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Integer> list = new ArrayList<>();
        if (n % 2 == 0) {
            out.println(n % 4 == 0 ? 0 : 1);
            boolean takeEven = true;
            for (int i = n; i >= 1; i -= 2) {
                if (takeEven) {
                    list.add(i);
                } else {
                    list.add(i - 1);
                }
                takeEven = !takeEven;
            }
        } else {
            out.println((n + 1) % 4 == 0 ? 0 : 1);
            boolean takeOdd = true;
            for (int i = n; i >= 1; i -= 2) {
                if (takeOdd) {
                    list.add(i);
                } else {
                    if (i > 1) {
                        list.add(i - 1);
                    }
                }
                takeOdd = !takeOdd;
            }
        }
        out.print(list.size());
        out.print(' ');
        for (Integer integer : list) {
            out.print(integer);
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
        try (DividingTheNumbers instance = new DividingTheNumbers()) {
            instance.solve();
        }
    }
}
