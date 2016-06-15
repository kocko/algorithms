package csadademy.problemset001;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class WordOrdering implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    class WordOrderingComparator implements Comparator<String> {

        private int[] order = new int[26];

        public WordOrderingComparator(String rules) {
            for (int i = 0; i < 26; i++) {
                order[rules.charAt(i) - 'a'] = i;
            }
        }

        @Override
        public int compare(String o1, String o2) {
            int size = Math.min(o1.length(), o2.length());
            for (int i = 0; i < size; i++) {
                char a = o1.charAt(i), b = o2.charAt(i);
                int v1 = ('a' <= a && a <= 'z') ? order[a - 'a'] : order[a - 'A'] + 26;
                int v2 = ('a' <= b && b <= 'z') ? order[b - 'a'] : order[b - 'A'] + 26;
                if (v1 < v2) return -1;
                if (v1 > v2) return 1;
            }
            return Integer.compare(o1.length(), o2.length());
        }

    }

    public void solve() {
        String order = in.next();
        int n = in.ni();
        String[] set = new String[n];
        while (n-- > 0) {
            set[n] = in.next();
        }
        Arrays.sort(set, new WordOrderingComparator(order));
        for (String s : set) {
            out.println(s);
        }
    }

    @Override
    public void close() throws IOException {
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

        public void close() throws IOException{
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (WordOrdering instance = new WordOrdering()) {
            instance.solve();
        }
    }
}
