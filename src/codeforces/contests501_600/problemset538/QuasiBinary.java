package codeforces.contests501_600.problemset538;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class QuasiBinary implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            int next = findNext(n);
            n -= next;
            result.add(next);
        }
        out.println(result.size());
        for (int q : result) {
            out.print(q);
            out.print(' ');
        }
    }
    
    private int findNext(int n) {
        char[] value = String.valueOf(n).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : value) {
            sb.append(ch != '0' ? '1' : '0');
        }
        return Integer.parseInt(sb.toString());
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
        try (QuasiBinary instance = new QuasiBinary()) {
            instance.solve();
        }
    }
}
