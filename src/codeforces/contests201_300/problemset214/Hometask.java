package codeforces.contests201_300.problemset214;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Hometask implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int zeroes = 0;
        List<Integer> x = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            if (next == 0) {
                zeroes++;
            } else {
                x.add(next);
                sum += next;
            }
        }
        if (zeroes == 0) {
            out.println(-1);
            return;
        }
        int rem = sum % 3;
        Collections.sort(x);
        if (rem != 0) {
            boolean removed = false;
            Iterator<Integer> iterator = x.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() % 3 == rem) {
                    iterator.remove();
                    removed = true;
                    break;
                }
            }
            if (!removed) {
                rem = ((rem - 1) ^ 1) + 1;
                iterator = x.iterator();
                int cnt = 0;
                while (iterator.hasNext()) {
                    if (cnt == 2) break;
                    if (iterator.next() % 3 == rem) {
                        iterator.remove();
                        cnt++;
                    }
                }
            }
        }
        if (zeroes < n) {
            if (x.isEmpty()) {
                out.println(0);
            } else {
                for (int i = x.size() - 1; i >= 0; i--) {
                    out.print(x.get(i));
                }
                for (int i = 0; i < zeroes; i++) {
                    out.print(0);
                }
            }
        } else {
            out.println(0);
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
        try (Hometask instance = new Hometask()) {
            instance.solve();
        }
    }
}
