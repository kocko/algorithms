package uva.volume108;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConcatenationOfLanguages implements Closeable {

  private final Scanner in;
  private final PrintWriter out;

  public ConcatenationOfLanguages() {
    in = new Scanner(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = Integer.parseInt(in.nextLine());
    for (int testCase = 1; testCase <= t; testCase++) {
      String nm = in.nextLine();
      String[] split = nm.split(" ");
      int n = Integer.parseInt(split[0]);
      int m = Integer.parseInt(split[1]);
      String[] first = new String[n];
      String[] second = new String[m];
      for (int i = 0; i < n; i++) first[i] = in.nextLine();
      for (int i = 0; i < m; i++) second[i] = in.nextLine();
      Set<String> concatenation = new HashSet<>();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          concatenation.add(first[i] + second[j]);
        }
      }
      out.printf("Case %d: %d\n", testCase, concatenation.size());
    }
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (ConcatenationOfLanguages instance = new ConcatenationOfLanguages()) {
      instance.solve();
    }
  }
}
