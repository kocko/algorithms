package codeforces.contests901_1000.problemset978;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class PetyasExams implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] result = new int[n + 1];
        List<Exam> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            Exam exam = new Exam(i, in.ni(), in.ni(), in.ni());
            list.add(exam);
            result[exam.day] = m + 1;
        }
        list.sort(Comparator.naturalOrder());
        for (Exam exam : list) {
            int day = exam.day, start = exam.start, need = exam.need;
            for (int i = start; i < day; i++) {
                if (need == 0) break;
                if (result[i] == 0) {
                    result[i] = exam.idx;
                    need--;
                }
            }
            if (need != 0) {
                out.println(-1);
                return;
            }
        }
        for (int i = 1; i <= n; i++) {
            out.print(result[i]);
            out.print(' ');
        }
    }

    private class Exam implements Comparable<Exam> {
        private int idx, start, day, need;

        private Exam(int idx, int start, int day, int need) {
            this.idx = idx;
            this.start = start;
            this.day = day;
            this.need = need;
        }

        @Override
        public int compareTo(Exam o) {
            return Integer.compare(day, o.day);
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
        try (PetyasExams instance = new PetyasExams()) {
            instance.solve();
        }
    }
}
