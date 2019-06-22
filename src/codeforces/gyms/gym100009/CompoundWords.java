package codeforces.gyms.gym100009;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CompoundWords implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);
  
  private class Node {
    private Map<Character, Node> map = new HashMap<>();
    private boolean end;
    
    private Node next(char c) {
      return map.getOrDefault(c, null);
    }
  }
  
  private Node root = new Node();

  public void solve() {
    List<char[]> words = new ArrayList<>();
    while (in.hasNext()) {
      char[] word = in.next().toCharArray();
      words.add(word);
      updateTrie(word);
    }
    
    for (char[] word : words) {
      this.word = word;
      compound = false;
      match(0, root, 0, 0);
      if (compound) {
        out.println(word);
      }
    }
  }
  
  private boolean compound;
  private char[] word;
  
  private void match(int idx, Node node, int count, int unmatchedCharacters) {
    if (idx == word.length) {
      compound |= (count == 2) && (unmatchedCharacters == 0);
    } else {
      Node next = node.next(word[idx]);
      if (next != null) {
        if (next.end) {
          match(idx + 1, root, count + 1, 0);
        }
        match(idx + 1, next, count, unmatchedCharacters + 1);
      }
    }
  }
  
  private void updateTrie(char[] word) {
    int idx = -1;
    Node current = root;
    while (++idx < word.length) {
      char letter = word[idx];
      Node node = current.next(letter);
      if (node == null) {
        node = new Node();
        current.map.put(letter, node);
      }
      current = node;
    }
    current.end = true;
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (CompoundWords instance = new CompoundWords()) {
      instance.solve();
    }
  }
}
