package codeforces.contests501_600.problemset535;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TavasAndNafas implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n < 10) {
            single(n);
        } else if (n >= 11 && n < 20) {
            teen(n);
        } else {
            bigger(n);
        }
    }
    
    private void single(int n) {
        switch (n) {
            case 0: { out.println("zero"); break; }
            case 1: { out.println("one"); break; }
            case 2: { out.println("two"); break; }
            case 3: { out.println("three"); break; }
            case 4: { out.println("four"); break; }
            case 5: { out.println("five"); break; }
            case 6: { out.println("six"); break; }
            case 7: { out.println("seven"); break; }
            case 8: { out.println("eight"); break; }
            case 9: { out.println("nine"); break; }
        }
    }
    
    private void teen(int n) {
        switch (n) {
            case 11: { out.println("eleven"); break; }
            case 12: { out.println("twelve"); break; }
            case 13: { out.println("thirteen"); break; }
            case 14: { out.println("fourteen"); break; }
            case 15: { out.println("fifteen"); break; }
            case 16: { out.println("sixteen"); break; }
            case 17: { out.println("seventeen"); break; }
            case 18: { out.println("eighteen"); break; }
            case 19: { out.println("nineteen"); break; }
        }
    }
    
    private void bigger(int n) {
        int a = n / 10;
        switch (a) {
            case 1: { out.print("ten"); break; }
            case 2: { out.print("twenty"); break; }
            case 3: { out.print("thirty"); break; }
            case 4: { out.print("forty"); break; }
            case 5: { out.print("fifty"); break; }
            case 6: { out.print("sixty"); break; }
            case 7: { out.print("seventy"); break; }
            case 8: { out.print("eighty"); break; }
            case 9: { out.print("ninety"); break; }
        }
        if (n % 10 != 0) {
            out.print("-");
            single(n % 10);
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
        try (TavasAndNafas instance = new TavasAndNafas()) {
            instance.solve();
        }
    }
}
