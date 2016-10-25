package codeforces.contests501_600.problemset515;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DrazilAndFactorial implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] powers = new int[10];
        char[] s = in.next().toCharArray();
        for (char c : s) {
            f(c - '0', powers);
        }
        String result = "";
        while (true) {
            int next = hasNext(powers);
            if (next == -1) break;
            else {
                g(next, powers);
                result += next;
            }
        }
        out.println(result);
    }
    
    private int hasNext(int[] powers) {
        for (int i = 7; i >= 2; i--) {
            if (powers[i] >= 1) return i;
        }
        return -1;
    }
    
    private void f(int value, int[] powers) {
        switch (value) {
            case 1: break;
            case 2:
            case 3:
                for (int i = 2; i <= value; i++) {
                    powers[i]++;
                }
                break;
            case 4:
                powers[2] += 3;
                powers[3]++;
                break;
            case 5:
                powers[2] += 3;
                powers[3]++;
                powers[5]++;
                break;
            case 6:
                powers[2] += 4;
                powers[3] += 2;
                powers[5]++;
                break;
            case 7:
                powers[2] += 4;
                powers[3] += 2;
                powers[5]++;
                powers[7]++;
                break;
            case 8:
                powers[2] += 7;
                powers[3] += 2;
                powers[5]++;
                powers[7]++;
                break;
            case 9:
                powers[2] += 7;
                powers[3] += 4;
                powers[5]++;
                powers[7]++;
                break;
        }
    }
    
    private void g(int value, int[] powers) {
        switch (value) {
            case 2:
                powers[2]--;
                break;
            case 3:
                powers[2]--;
                powers[3]--;
                break;
            case 5:
                powers[2] -= 3;
                powers[3]--;
                powers[5]--;
                break;
            case 7:
                powers[2] -= 4;
                powers[3] -= 2;
                powers[5]--;
                powers[7]--;
                break;
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
        try (DrazilAndFactorial instance = new DrazilAndFactorial()) {
            instance.solve();
        }
    }
}
