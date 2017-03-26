package uva.volume001;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IDCodes implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() throws IOException {
        String line;
        while (!"#".equals(line = in.readLine())) {
            char[] chars = line.toCharArray();
            if (nextPermutation(chars)) {
                out.println(new String(chars));
            } else {
                out.println("No Successor");
            }
        }
    }
    
    private boolean nextPermutation(char[] input) {
        int n = input.length;
        int p = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (input[i] < input[i + 1]) {
                p = i;
                break;
            }
        }
        if (p == -1) return false;
        int q = 0;
        for (int i = n - 1; i > p; i--) {
            if (input[i] > input[p]) {
                q = i;
                break;
            }
        }
        char temp = input[p];
        input[p] = input[q];
        input[q] = temp;
        if (p < n - 1) {
            int left = p + 1, right = n - 1;
            while (left < right) {
                temp = input[left];
                input[left] = input[right];
                input[right] = temp;
                left++; right--;
            }
        }
        return true;
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
        try (IDCodes instance = new IDCodes()) {
            instance.solve();
        }
    }
}
