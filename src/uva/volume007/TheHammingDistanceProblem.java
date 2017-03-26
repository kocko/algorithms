package uva.volume007;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheHammingDistanceProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int tests = in.ni();
        while (tests-- > 0) {
            int bits = in.ni(), distance = in.ni();
            char[] result = new char[bits];
            Arrays.fill(result, '0');
            for (int i = 0; i < distance; i++) {
                result[bits - i - 1] = '1';
            }
            do {
                out.println(new String(result));
            } while (nextPermutation(result));
            if (tests >= 1) {
                out.println();
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
        try (TheHammingDistanceProblem instance = new TheHammingDistanceProblem()) {
            instance.solve();
        }
    }
}
