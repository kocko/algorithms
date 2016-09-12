package acm.subregionals.year2015.northamerica.pacificnorthwest;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ClassTime implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class Student implements Comparable<Student> {
        String first;
        String last;
        
        Student(String first, String last) {
            this.first = first;
            this.last = last;
        }

        @Override
        public int compareTo(Student o) {
            int x = this.last.compareTo(o.last);
            if (x == 0) {
                return this.first.compareTo(o.first);
            }
            return x;
        }
    }
    
    public void solve() {
        int n = in.ni();
        Set<Student> set = new TreeSet<>();
        while (2 * n > 0) {
            set.add(new Student(in.next(), in.next()));
            n--;
        }
        for (Student s : set) {
            out.println(s.first + " " + s.last);
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

    public static void main(String[] args) {
        new ClassTime().solve();
    }
}
