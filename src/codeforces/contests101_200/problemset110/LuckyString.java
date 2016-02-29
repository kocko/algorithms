package codeforces.contests101_200.problemset110;

    import java.io.BufferedReader;
    import java.io.Closeable;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.OutputStreamWriter;
    import java.io.PrintWriter;
    import java.util.StringTokenizer;

    public class LuckyString implements Closeable {

        private InputReader in = new InputReader(System.in);
        private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

        public void solve() {
            int n = in.ni(), count = 0;
            char[] letters = new char[n];
            char current = 'a';
            for (int i = 0; i < n; i++) {
                if (count < n) {
                    for (int j = i; j < n; j += 4) {
                        letters[j] = current;
                        count++;
                    }
                    current++;
                }
            }
            for (char c : letters) {
                out.print(c);
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

        public static void main(String[] args) {
            new LuckyString().solve();
        }
    }
