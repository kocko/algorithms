package codeforces.contests201_300.problemset230;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Dragons implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Dragon {
        private int s;
        private int b;
        
        Dragon(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
    
    public void solve() {
        int s = in.ni(), n = in.ni();
        List<Dragon> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Dragon(in.ni(), in.ni()));
        }
        Collections.sort(list, (a, b) -> Integer.compare(a.s, b.s));
        
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            Dragon next = list.get(i);
            if (next.s < s) {
                s += next.b;
            } else {
                ok = false;
                break;
            }
        }
        out.println(ok ? "YES" : "NO");
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
        try (Dragons instance = new Dragons()) {
            instance.solve();
        }
    }
}
