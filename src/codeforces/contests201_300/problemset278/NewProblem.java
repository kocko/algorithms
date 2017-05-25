package codeforces.contests201_300.problemset278;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NewProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private String[] data;
    
    public void solve() {
        int n = in.ni();
        data = new String[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.next();
        }
        recurse("");
        out.println(best);
    }
    
    private String best = "zzzzzzzzzzzzzzzzzzzzz";
    
    private void recurse(String value) {
        if (value.length() <= best.length()) {
            boolean ok = value.length() > 0;
            for (String s : data) {
                ok &= !s.contains(value);      
            }
            if (ok && better(value)) {
                best = value;
            } else {
                for (char c = 'a'; c <= 'z'; c++) {
                    recurse(value + c);
                }
            }
        }
    }
    
    private boolean better(String value) {
        if (value.length() < best.length()) return true;
        if (value.length() == best.length()) {
            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) > best.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
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
        try (NewProblem instance = new NewProblem()) {
            instance.solve();
        }
    }
}
