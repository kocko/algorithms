package codeforces.contests401_500.problemset479;

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

public class Exams implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Exam implements Comparable<Exam> {
        private int a, b;

        private Exam(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Exam o) {
            int x = Integer.compare(a, o.a);
            return x != 0 ? x : Integer.compare(b, o.b);
        }
    }

    public void solve() {
        List<Exam> exams = new ArrayList<>();
        int n = in.ni();
        for (int i = 0; i < n; i++) {
            exams.add(new Exam(in.ni(), in.ni()));
        }
        Collections.sort(exams);
        int result = exams.get(0).b;
        for (int i = 1; i < n; i++) {
            Exam current = exams.get(i);
            if (current.b >= result) {
                result = current.b;
            } else {
                result = current.a;
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
        try (Exams instance = new Exams()) {
            instance.solve();
        }
    }
}
