package csadademy.problemset002;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class WordPermutation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        class Word {
            String value;
            int number;
            Word(String value, int number) {
                this.value = value;
                this.number = number;
            }
        }
        Set<Word> list = new TreeSet<>(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.value.compareTo(o2.value);
            }
        });
        for (int i = 0; i < n; i++) {
            list.add(new Word(in.next(), i + 1));
        }
        for (Word w : list) {
            out.print(w.number + " ");
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
        try (WordPermutation instance = new WordPermutation()) {
            instance.solve();
        }
    }
}
