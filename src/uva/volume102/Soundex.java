package uva.volume102;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Soundex implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNextLine()) {
      char[] x = in.nextLine().toCharArray();
      int last = -1;
      for (char c : x) {
        int code = code(c);
        if (code != last && code > 0) {
          out.print(code);
        }
        last = code;
      }
      out.println();
    }
  }

  private int code(char c) {
    switch(c) {
        case 'B':case 'F':case 'P':case 'V':
            return 1;
        case 'C':case 'G':case 'J':case 'K':case 'Q':case 'S':case 'X':case 'Z':
            return 2;
        case 'D':case 'T':
            return 3;
        case 'L':
            return 4;
        case 'M':case 'N':
            return 5;
        case 'R':
            return 6;
    }
    return -1;
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
    try (Soundex instance = new Soundex()) {
      instance.solve();
    }
  }
}
