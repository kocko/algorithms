package codeforces.contests1001_1100.problemset1015;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.comparing;

public class SongsCompression implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long m = in.ni();
        List<Song> songs = new ArrayList<>();
        long original = 0, compressed = 0;
        for (int i = 0; i < n; i++) {
            long a = in.ni(), b = in.nl();
            songs.add(new Song(a, b));
            original += a;
            compressed += b;
        }
        if (compressed > m) {
            out.println(-1);
            return;
        }
        songs.sort(comparing(Song::getDiff));
        
        int idx = 0;
        while (original > m && idx < n) {
            original -= songs.get(idx).original;
            original += songs.get(idx).compressed;
            idx++;
        }
        out.println(idx);
    }
    
    
    private class Song {
        private long original, compressed;

        private Song(long original, long compressed) {
            this.original = original;
            this.compressed = compressed;
        }
        
        private long getDiff() {
            return compressed - original;
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
        try (SongsCompression instance = new SongsCompression()) {
            instance.solve();
        }
    }
}
