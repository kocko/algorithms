package google.kickstart.year2022.warmup;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class MilkTea implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public MilkTea() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  private class Node {
    private Node[] children;
    private int idx;
    private boolean leaf;

    private Node(int idx) {
      this.idx = idx;
      children = new Node[2];
    }

    private void markAsLeaf() {
      leaf = true;
    }

    public boolean isLeaf() {
      return leaf;
    }
  }

  private final Node SINK = new Node(0);

  {
    SINK.children[0] = SINK.children[1] = SINK;
  }

  private class Trie {
    private Node root = new Node(1);
    private List<Node> nodes = new ArrayList<>();
    {
      nodes.add(SINK);
      nodes.add(root);
    }

    private void add(char[] word) {
      Node current = root;
      for (int i = 0; i < word.length; i++) {
        int idx = word[i] - '0';
        if (current.children[idx] == null) {
          current.children[idx] = new Node(nodes.size());
          nodes.add(current.children[idx]);
        }
        current = current.children[idx];
        if (i == word.length - 1) {
          current.markAsLeaf();
        }
      }
    }
  }

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      N = in.ni();
      M = in.ni();
      P = in.ni();
      zeroes = new int[P];
      ones = new int[P];
      for (int i = 0; i < N; i++) {
        char[] x = in.next().toCharArray();
        for (int j = 0; j < P; j++) {
          if (x[j] == '0') {
            zeroes[j]++;
          } else {
            ones[j]++;
          }
        }
      }
      trie = new Trie();
      for (int i = 0; i < M; i++) {
        char[] next = in.next().toCharArray();
        trie.add(next);
      }
      dp = new Integer[P][oo + 1];
      out.printf("Case #%d: %d\n", testCase, recurse(0, 1));
    }
  }

  private final int oo = 10000;
  private Trie trie;
  private int N, M, P;
  private int[] ones, zeroes;
  private Integer[][] dp;

  private int recurse(int idx, int current) {
    if (idx == P) return trie.nodes.get(current).isLeaf() ? oo : 0;

    if (dp[idx][current] != null) return dp[idx][current];

    int result = oo;

    Node now = trie.nodes.get(current), next;
    if (now.children[0] == null) {
      next = trie.nodes.get(0);
    } else {
      next = now.children[0];
    }
    result = min(result, ones[idx] + recurse(idx + 1, next.idx));

    if (now.children[1] == null) {
      next = trie.nodes.get(0);
    } else {
      next = now.children[1];
    }
    result = min(result, zeroes[idx] + recurse(idx + 1, next.idx));

    return dp[idx][current] = result;
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
    try (MilkTea instance = new MilkTea()) {
      instance.solve();
    }
  }
}
