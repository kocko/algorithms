package codeforces.contests401_500.problemset471;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.String.valueOf;
import static java.util.Arrays.sort;

public class MUHAndImportantThings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(i + 1, in.ni());
        }
        List<int[]> swaps = new ArrayList<>();
        sort(tasks);
        for (int i = 1; i < n && swaps.size() < 2; i++) {
            if (tasks[i].difficulty == tasks[i - 1].difficulty) {
                swaps.add(new int[]{i - 1, i});
            }
        }
        if (swaps.size() < 2) {
            out.println("NO");
        } else {
            out.println("YES");
            print(tasks);
            swap(tasks, swaps.get(0));
            print(tasks);
            swap(tasks, swaps.get(1));
            print(tasks);
        }
    }

    private void print(Task[] tasks) {
        for (Task task : tasks) {
            out.print(task.idx);
            out.print(' ');
        }
        out.println();
    }

    private void swap(Task[] tasks, int[] pair) {
        Task temp = tasks[pair[0]];
        tasks[pair[0]] = tasks[pair[1]];
        tasks[pair[1]] = temp;
    }

    private class Task implements Comparable<Task> {
        private int idx, difficulty;

        private Task(int idx, int difficulty) {
            this.idx = idx;
            this.difficulty = difficulty;
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(difficulty, o.difficulty);
        }

        @Override
        public String toString() {
            return valueOf(difficulty);
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
        try (MUHAndImportantThings instance = new MUHAndImportantThings()) {
            instance.solve();
        }
    }
}
