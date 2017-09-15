package codeforces.contests401_500.problemset479;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Towers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni(), max = 0, min = 100004, maxIdx = -1, minIdx = -1;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = in.ni();
            if (t[i] > max) {
                maxIdx = i;
                max = t[i];
            }
            if (t[i] < min) {
                minIdx = i;
                min = t[i];
            }
        }
        List<int[]> result = new ArrayList<>();
        int instability = max - min;
        for (int i = 0; i < k; i++) {
            if (instability == 0) break;
            int[] entry = new int[]{maxIdx + 1, minIdx + 1};
            t[maxIdx]--; 
            t[minIdx]++;
            max = 0;
            min = 100004;
            for (int j = 0; j < n; j++) {
                if (t[j] > max) {
                    max = t[j];
                    maxIdx = j;
                }
                if (t[j] < min) {
                    min = t[j];
                    minIdx = j;
                }
            }
            if (max - min <= instability) {
                instability = max - min;
                result.add(entry);
            } else break;
        }
        out.println(instability + " " + result.size());
        for (int[] move : result) {
            out.println(move[0] + " " + move[1]);
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
        try (Towers instance = new Towers()) {
            instance.solve();
        }
    }
}
