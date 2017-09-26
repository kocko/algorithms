package codeforces.contests801_900.problemset864;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class MakeAPermutation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] p = new int[n];
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i] = in.ni();
            cnt[p[i]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                queue.add(i);
            }
        }
        int q = queue.size();
        int[] result = new int[n];
        boolean[] used = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int value = p[i];
            if (cnt[value] == 1) {
                result[i] = value;
            } else {
                int candidate = queue.peekFirst();
                if (candidate < value) {
                    result[i] = queue.pollFirst();
                    cnt[value]--;
                } else {
                    if (!used[value]) {
                        result[i] = value;
                        used[value] = true;
                    } else {
                        result[i] = queue.pollFirst();
                    }
                }
            }
        }
        out.println(q);
        for (int i = 0; i < n; i++) {
            out.print(result[i]);
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
        try (MakeAPermutation instance = new MakeAPermutation()) {
            instance.solve();
        }
    }
}
