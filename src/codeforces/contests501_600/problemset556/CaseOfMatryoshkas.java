package codeforces.contests501_600.problemset556;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CaseOfMatryoshkas implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        boolean[] disassembled = new boolean[n + 1];
        int[] number = new int[n + 1];
        int[][] chains = new int[m][]; 
        for (int i = 0; i < m; i++) {
            int cnt = in.ni();
            chains[i] = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                int value = in.ni();
                chains[i][j] = value;
                number[value] = i;
            }
        }
        int result = 0;
        int idx = 1;
        int chain = number[idx];
        for (int i = 0; i < chains[chain].length; i++) {
            int value = chains[chain][i];
            if (value == idx) idx++;
            else {
                disassembled[value] = true;
                result++;
            }
        }
        while (idx <= n) {
            if (!disassembled[idx]) {
                chain = number[idx];
                int i = chains[chain].length;
                while (chains[chain][i - 1] != idx) {
                    if (!disassembled[chains[chain][i - 1]]) {
                        disassembled[chains[chain][i - 1]] = true;
                        result++;
                        i--;
                    }
                }
            }
            result++;
            idx++;
        }
        out.println(result);
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
        try (CaseOfMatryoshkas instance = new CaseOfMatryoshkas()) {
            instance.solve();
        }
    }
}
