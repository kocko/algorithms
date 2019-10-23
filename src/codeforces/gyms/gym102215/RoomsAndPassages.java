package codeforces.gyms.gym102215;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RoomsAndPassages implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] passage = new int[n];
    int[] lostOn = new int[n + 1];
    int[] lastSeen = new int[n + 1];
    for (int i = 0; i < n; i++) {
      passage[i] = in.ni();
    }
    for (int i = 0; i <= n; i++) {
      lostOn[i] = n;
      lastSeen[i] = n;
    }
    int[] result = new int[n + 1];

    int lastBlockedRoom = n;
    for (int room = n - 1; room >= 0; room--) {
      int p = passage[room];
      if (p > 0) {
        lastSeen[p] = room;
        if (lostOn[p] == n) {
          result[room] = 1 + result[room + 1];
        } else {
          int dist = lastBlockedRoom - room;
          result[room] = Math.min(1 + result[room + 1], dist);
        }
      } else {
        lostOn[-p] = room;
        lastBlockedRoom = Math.min(lastBlockedRoom, lastSeen[-p]);
        result[room] = Math.min(1 + result[room + 1], lastBlockedRoom - room);
      }
    }
    for (int i = 0; i < n; i++) {
      out.print(result[i]);
      out.print(' ');
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
    try (RoomsAndPassages instance = new RoomsAndPassages()) {
      instance.solve();
    }
  }
}
