package codeforces.contests201_300.problemset254;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class CardsWithNumbers implements Closeable {

    private InputReader in;
    private PrintWriter out;

    private CardsWithNumbers() throws IOException {
        in = new InputReader(new FileInputStream(new File("input.txt")));
        out = new PrintWriter(new FileOutputStream(new File("output.txt")));
    }
    
    public void solve() {
        int n = in.ni();
        List<List<Integer>> idx = new ArrayList<>();
        for (int i = 0; i <= 5000; i++) {
            idx.add(new ArrayList<>());
        }
        for (int i = 1; i <= 2 * n; i++) {
            idx.get(in.ni()).add(i);   
        }
        StringJoiner result = new StringJoiner("\n");
        for (int i = 1; i <= 5000; i++) {
            List<Integer> x = idx.get(i);
            if (x.size() % 2 == 1) {
                out.println(-1);
                return;
            } else {
                for (int j = 0; j < x.size(); j += 2) {
                    result.add(x.get(j) + " " + x.get(j + 1));
                }
            }
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
        try (CardsWithNumbers instance = new CardsWithNumbers()) {
            instance.solve();
        }
    }
}
