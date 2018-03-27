package codeforces.contests301_400.problemset400;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Arrays.fill;

public class InnaAndChooseOptions implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            process(in.next().toCharArray());
        }
    }
    
    private void process(char[] x) {
        int count = 0;
        StringJoiner result = new StringJoiner(" ");
        int n = x.length;
        for (int rows = 1; rows <= n; rows++) {
            if (n % rows == 0) {
                int cols = n / rows;
                boolean[] ok = new boolean[cols];
                fill(ok, true);
                for (int i = 0; i < n; i++) {
                    ok[i % cols] &= x[i] == 'X';
                }
                for (boolean b : ok) {
                    if (b) {
                        count++;
                        result.add(rows + "x" + cols);
                        break;
                    }
                }
            }
        }
        out.print(count);
        if (count > 0) {
            out.print(' ');
            out.print(result.toString());
        }
        out.println();
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
        try (InnaAndChooseOptions instance = new InnaAndChooseOptions()) {
            instance.solve();
        }
    }
}
