package codeforces.contests1001_1100.problemset1082;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.util.Comparator.comparingInt;

public class MultiSubjectCompetition implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Student(in.ni() - 1, in.ni()));
        }
        list.sort(comparingInt((Student x) -> x.power).reversed());
        int[] size = new int[m], subjectPrefix = new int[m], peopleMax = new int[n + 1];
        int result = 0;
        for (Student student : list) {
            int subject = student.subject, power = student.power;
            subjectPrefix[subject] += power;
            size[subject]++;
            if (subjectPrefix[subject] > 0) {
                peopleMax[size[subject]] += subjectPrefix[subject];
            }
            result = max(peopleMax[size[subject]], result);
        }
        out.println(result);
    }

    private class Student {
        private int subject, power;

        private Student(int subject, int power) {
            this.subject = subject;
            this.power = power;
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
        try (MultiSubjectCompetition instance = new MultiSubjectCompetition()) {
            instance.solve();
        }
    }
}
