package codeforces.contests801_900.problemset816;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KarenAndMorning implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] time = in.next().split(":");
        int result = 0;
        while (!isPalindrome(time)) {
            time = increase(time);
            result++;
        }
        out.println(result);
    }
    
    private boolean isPalindrome(String[] time) {
        return time[0].charAt(0) == time[1].charAt(1) && time[0].charAt(1) == time[1].charAt(0);
    }
    
    private String[] increase(String[] time) {
        String[] result = new String[2];
        int hour = Integer.parseInt(time[0]), minutes = Integer.parseInt(time[1]);
        minutes++;
        boolean increaseHour = false;
        if (minutes == 60) {
            minutes = 0;
            increaseHour = true; 
        }
        if (increaseHour) {
            hour++;
        }
        if (hour == 24) hour = 0;
        result[0] = String.format("%02d", hour);
        result[1] = String.format("%02d", minutes);
        return result;
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
        try (KarenAndMorning instance = new KarenAndMorning()) {
            instance.solve();
        }
    }
}
