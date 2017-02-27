package codeforces.gyms.gym100004;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Numbersrebmun implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        int[] map = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
        while (t-- > 0) {
            char[] next = in.next().toLowerCase().toCharArray();
            int n = next.length;
            int[] phone = new int[n];
            for (int i = 0; i < n; i++) {
                phone[i] = map[next[i] - 'a'];
            }
            out.println(isPalindrome(phone) ? "YES" : "NO");
        }
    }
    
    private boolean isPalindrome(int[] phone) {
        int n = phone.length;
        int limit = n / 2 - 1;
        int i = 0;
        while (phone[i] == phone[n - i - 1] && i <= limit) {
            i++;
        }
        return i > limit;
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
        try (Numbersrebmun instance = new Numbersrebmun()) {
            instance.solve();
        }
    }
}
