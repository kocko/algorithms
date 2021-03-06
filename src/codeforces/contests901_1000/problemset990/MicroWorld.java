package codeforces.contests901_1000.problemset990;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MicroWorld implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            list.add(next);
        }
        Collections.sort(list);
        
        int alive = n;
        for (int j = 0; j < list.size(); j++) {
            int current = list.get(j);
            boolean dead = false;
            int left = j + 1, right = list.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int value = list.get(mid);
                if (value == current) {
                    left = mid + 1;
                } else {
                    if (current + k >= value) {
                        dead = true;
                        break;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            if (dead) alive--;
        }
        out.println(alive);
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
        try (MicroWorld instance = new MicroWorld()) {
            instance.solve();
        }
    }
}
