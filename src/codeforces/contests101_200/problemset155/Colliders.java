package codeforces.contests101_200.problemset155;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Colliders implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    init();
    int n = in.ni(), m = in.ni();
    int[] collider = new int[MAX_N];
    boolean[] active = new boolean[MAX_N];
    while (m-- > 0) {
      char type = in.next().charAt(0);
      int number = in.ni();
      int conflict = -1;
      if (type == '+') {
        if (active[number]) {
          out.println("Already on");
        } else {
          int num = number;
          if (number == 1) {
            active[number] = true;
            collider[1] = number;
          } else {
            while (num > 1) {
              if (collider[sieve[num]] == 0) {
                num /= sieve[num];
              } else {
                conflict = collider[sieve[num]];
                break;
              }
            }
          }
          if (conflict == -1) {
            out.println("Success");
            active[number] = true;
            if (number != 1) {
              num = number;
              while (num > 1) {
                int divisor = sieve[num];
                collider[divisor] = number;
                if (num == divisor) break;
                num /= divisor;
              }
            }
          } else {
            out.println("Conflict with " + conflict);
          }
        }
      } else {
        if (active[number]) {
          active[number] = false;
          out.println("Success");
          if (number == 1) {
            collider[1] = 0;
          } else {
            while (number > 1) {
              int divisor = sieve[number];
              collider[divisor] = 0;
              number /= divisor;
            }
          }
        } else {
          out.println("Already off");
        }
      }
    }
  }
  
  private int MAX_N = (int) 1e6;
  private int[] sieve = new int[MAX_N + 1];
  
  private void init() {
    for (int i = 1; i <= MAX_N; i++) {
      sieve[i] = i;
    }
    for (int i = 2; i <= MAX_N; i++) {
      if (sieve[i] == i) {
        for (long j = (long) i * i; j <= MAX_N; j += i) {
          sieve[(int) j] = i;
        }
      }
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
    try (Colliders instance = new Colliders()) {
      instance.solve();
    }
  }
}
