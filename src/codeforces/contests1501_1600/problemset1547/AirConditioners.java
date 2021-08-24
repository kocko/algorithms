package codeforces.contests1501_1600.problemset1547;

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

public class AirConditioners implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public AirConditioners() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public AirConditioners(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  private class Device {
    private long position, power;

    private Device(long position, long power) {
      this.position = position;
      this.power = power;
    }

    public long getPosition() {
      return position;
    }
  }

  public void solve() {
    final long oo = (long) 1e15;
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), k = in.ni();
      long[] a = new long[k], t = new long[k];

      for (int i = 0; i < k; i++) a[i] = in.nl();
      for (int i = 0; i < k; i++) t[i] = in.nl();

      List<Device> list = new ArrayList<>();
      for (int i = 0; i < k; i++) {
        list.add(new Device(a[i], t[i]));
      }
      list.sort(Comparator.comparingLong(Device::getPosition));

      PriorityQueue<Long> previous = new PriorityQueue<>();
      int next = 0;
      long[] left = new long[n + 1];
      for (int i = 1; i <= n; i++) {
        left[i] = oo;
        while (next < k && list.get(next).position <= i) {
          Device device = list.get(next);
          previous.add(device.power - device.position);
          next++;
        }
        if (previous.size() > 0) {
          left[i] = previous.peek() + i;
        }
      }

      long[] right = new long[n + 1];
      previous = new PriorityQueue<>();
      next = k - 1;
      for (int i = n; i >= 1; i--) {
        right[i] = oo;
        while (next >= 0 && list.get(next).position >= i) {
          Device device = list.get(next);
          previous.add(device.position + device.power);
          next--;
        }
        if (previous.size() > 0) {
          right[i] = previous.peek() - i;
        }
      }

      for (int i = 1; i <= n; i++) {
        out.print(Math.min(left[i], right[i]));
        out.print(' ');
      }
      out.println();
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
    try (AirConditioners instance = new AirConditioners()) {
      instance.solve();
    }
  }
}
