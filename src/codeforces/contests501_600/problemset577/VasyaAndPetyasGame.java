package codeforces.contests501_600.problemset577;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class VasyaAndPetyasGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n == 1) {
            out.println(0);
            return;
        }
        sieve();
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                int temp = i;
                while (temp <= n) {
                    result.add(temp);
                    temp *= i;
                }
            }
        }
        out.println(result.size());
        for (int num : result) {
            out.print(num);
            out.print(' ');
        }
    }
    
    private boolean[] prime = new boolean[1001];
    
    private void sieve() {
        Arrays.fill(prime, true);
        int n = 1000;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    prime[j] = false;
                }
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
        try (VasyaAndPetyasGame instance = new VasyaAndPetyasGame()) {
            instance.solve();
        }
    }
}
