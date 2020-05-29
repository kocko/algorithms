package codeforces.gyms.gym100090;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProductInnovation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), p = in.ni();
    Node tail = null;
    Node robot = null;
    for (int i = 1; i <= n; i++) {
      int value = in.ni();
      if (tail == null) {
        tail = new Node(value);
      } else {
        Node next = new Node(value);
        tail.next = next;
        next.prev = tail;
        tail = next;
      }
      if (i == p) {
        robot = tail;
      }
    }
    int q = in.ni();
    while (q-- > 0) {
      String command = in.next();
      if ("moveLeft".equals(command)) {
        Node prev = robot.prev;
        if (prev != null) {
          robot = prev;
        }
      } else if ("moveRight".equals(command)) {
        Node next = robot.next;
        if (next != null) {
          robot = next;
        }
      } else if ("insertLeft".equals(command)) {
        int value = in.ni();
        Node node = new Node(value);
        Node prev = robot.prev;
        if (prev == null) {
          robot.prev = node;
          node.next = robot;
        } else {
          prev.next = node;
          robot.prev = node;
          node.prev = prev;
          node.next = robot;
        }
      } else if ("insertRight".equals(command)) {
        int value = in.ni();
        Node node = new Node(value);
        Node next = robot.next;
        if (next == null) {
          robot.next = node;
          node.prev = robot;
        } else {
          next.prev = node;
          node.next = next;
          node.prev = robot;
          robot.next = node;
        }
      } else if ("print".equals(command)) {
        out.println(robot.value);
      }
    }

  }

  private class Node {
    private Node next, prev;
    private int value;

    private Node(int value) {
      this.value = value;
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
    try (ProductInnovation instance = new ProductInnovation()) {
      instance.solve();
    }
  }
}
