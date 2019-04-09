package codeforces.contests1101_1200.problemset1140;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Long.max;
import static java.util.Comparator.comparingLong;

public class Playlist implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Song {
    private long time, beauty;

    private Song(long time, long beauty) {
      this.time = time;
      this.beauty = beauty;
    }
  }
  
  public void solve() {
    int n = in.ni(), k = in.ni();
    List<Song> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new Song(in.nl(), in.nl()));
    }
    list.sort(comparingLong(a -> a.beauty));
    PriorityQueue<Long> queue = new PriorityQueue<>();
    long total = 0, result = 0;
    for (int i = n - 1; i >= 0; i--) {
      Song song = list.get(i);
      queue.add(song.time);
      total += song.time;
      while (queue.size() > k) {
        total -= queue.remove();
      }
      result = max(result, total * song.beauty);
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
    try (Playlist instance = new Playlist()) {
      instance.solve();
    }
  }
}
