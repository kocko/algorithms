package codeforces.contests301_400.problemset358;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class DimaAndTextMessages implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("<3").append(in.next());
        }
        sb.append("<3");
        char[] minimal = sb.toString().toCharArray();
        char[] message = in.next().toCharArray();
        int i = 0, j = 0;
        if (minimal.length > message.length) {
            out.println("no");
            return;
        }
        boolean ok;
        while (true) {
            if (i >= minimal.length) {
                ok = true;
                break;
            }
            if (j >= message.length) {
                ok = false;
                break;
            }
            while (i < minimal.length && j < message.length && minimal[i] == message[j]) {
                i++;
                j++;
            }
            while (i < minimal.length && j < message.length && minimal[i] != message[j]) {
                j++;
            }
        }
        out.println(ok ? "yes" : "no");
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
        try (DimaAndTextMessages instance = new DimaAndTextMessages()) {
            instance.solve();
        }
    }
}
