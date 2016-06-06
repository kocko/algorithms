package codeforces.contests600_699.problemset665;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SimpleStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
    
    char[] result;
    
    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        result = new char[n];
        char last = x[0];
        result[0] = last;
        int size = 1;
        for (int i = 1; i < n; i++) {
            if (x[i] == last) {
                size++;
                result[i] = x[i];
            } else {
                if (size > 1) {
                    replaceCharacters(x[i], last, size, i);
                    size = 1;
                }
                last = x[i];
                result[i] = x[i];
            }
        }
        if (size > 1) {
            replaceCharacters(x[n - 1], last, size, n);
        }
        for (char c : result) {
            out.print(c);
        }
        out.println();
    }

    private void replaceCharacters(char a, char b, int size, int i) {
        char with = 'a';
        for (char x = 'a'; x <= 'z'; x++) {
            if (x != a && x != b) {
                with = x;
                break;
            }
        }
        int start = size % 2;
        for (int j = start; j < size; j += 2) {
            result[i - j - 1] = with;
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

    public static void main(String[] args) {
        new SimpleStrings().solve();
    }
}
