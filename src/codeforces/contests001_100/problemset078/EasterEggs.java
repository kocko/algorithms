package codeforces.contests001_100.problemset078;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class EasterEggs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        result = new char[2 * n];
        for (int i = 0; i < 7; i++) {
            result[i] = result[n + i] = colors[i];
        }
        for (int i = 7; i < 2 * n; i++) {
            result[i] = '?';
        }
        for (int idx = 7; idx < n; idx++) {
            List<Character> no = getBanned(idx);
            for (char color : colors) {
                boolean can = true;
                for (char ban : no) {
                    if (ban == color) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    result[idx] = result[n + idx] = color;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(result[i]);
        }
    }
    
    private char[] colors = {'R', 'O', 'Y', 'G', 'B', 'I', 'V'};
    private char[] result;
    
    private List<Character> getBanned(int idx) {
        List<Character> list = new ArrayList<>();
        for (int i = max(0, idx - 3); i <= idx + 3; i++) {
            if (result[i] != '?') {
                list.add(result[i]);
            }
        }
        return list;
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
        try (EasterEggs instance = new EasterEggs()) {
            instance.solve();
        }
    }
}
