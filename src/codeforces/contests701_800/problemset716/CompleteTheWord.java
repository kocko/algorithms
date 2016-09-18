package codeforces.contests701_800.problemset716;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CompleteTheWord implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String s = in.next();
        if (s.length() < 26) {
            out.println(-1);
        } else {
            int n = s.length();
            char[] x = s.toCharArray();
            int[] has = new int[26];
            int plus = 0;
            int i;
            for (i = 0; i < 26; i++) {
                if (x[i] == '?') {
                    plus++;
                } else {
                    has[x[i] - 'A']++;
                }
            }
            i--;
            while(true) {
                if (ok(has, plus)) {
                    for (int j = i - 25; j <= i; j++) {
                        if (x[j] == '?') {
                            for (int k = 0; k < 26; k++) {
                                if (has[k] == 0) {
                                    x[j] = (char) ('A' + k);
                                    has[k] = 1;
                                    break;
                                }
                            }
                        }
                    }
                    for (char c : x) {
                        if (c == '?') {
                            out.print('A');
                        } else {
                            out.print(c);
                        }
                       
                    }
                    out.println();
                    break;
                }
                i++;
                if (i == n) {
                    out.println(-1);
                    break;
                }
                char remove = x[i - 26];
                if (remove == '?') {
                    plus--;
                } else {
                    has[remove - 'A']--;
                }
                if (x[i] == '?') {
                    plus++;
                } else {
                    has[x[i] - 'A']++;
                }
            }
        }
    }
    
    private boolean ok(int[] x, int plus) {
        int zeroes = 0;
        for (int i : x) {
            if (i == 0) zeroes++;
        }
        return zeroes == plus;
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
        try (CompleteTheWord instance = new CompleteTheWord()) {
            instance.solve();
        }
    }
}
