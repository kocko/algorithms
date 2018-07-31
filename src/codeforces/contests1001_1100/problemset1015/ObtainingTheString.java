package codeforces.contests1001_1100.problemset1015;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ObtainingTheString implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] s = in.next().toCharArray(), t = in.next().toCharArray();
        int result = 0;
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s[i] != t[i]) {
                boolean found = false;
                int j;
                for (j = i + 1; j < n; j++) {
                    if (s[j] == t[i]) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    result = -1;
                    break;
                }
                while (j > i) {
                    moves.add(j - 1);
                    char temp = s[j - 1];
                    s[j - 1] = s[j];
                    s[j] = temp;
                    j--;
                    result++;
                }
            }
        }
        out.println(result);
        if (result != -1) {
            for (int i : moves) {
                out.print(i + 1);
                out.print(' ');
            }
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
        try (ObtainingTheString instance = new ObtainingTheString()) {
            instance.solve();
        }
    }
}
