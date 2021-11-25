package codeforces.contests1601_1700.problemset1611;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TeamCompositionProgrammersAndMathematicians implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public TeamCompositionProgrammersAndMathematicians() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public TeamCompositionProgrammersAndMathematicians(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int a = in.ni(), b = in.ni(), incomplete = Math.min(a, b), rem = Math.max(a, b) - incomplete;
      int teams;
      if (2 * incomplete <= rem) {
        teams = incomplete;
      } else {
        teams = rem / 2;
        incomplete -= teams;
        teams += (incomplete / 2);
      }
      out.println(teams);
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
    try (TeamCompositionProgrammersAndMathematicians instance = new TeamCompositionProgrammersAndMathematicians()) {
      instance.solve();
    }
  }
}
