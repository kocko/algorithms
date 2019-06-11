package codeforces.contests1101_1200.problemset1182;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BeautifulLyrics implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Word {
    private int idx;
    private String content;
    private int vowels;
    private char last;

    private Word(int idx, String content) {
      this.idx = idx;
      this.content = content;
      for (char c : content.toCharArray()) {
        if (isVowel(c)) {
          vowels++;
          last = c;
        }
      }
    }

    private char getLast() {
      return last;
    }

    private int getVowels() {
      return vowels;
    }

    @Override
    public String toString() {
      return content;
    }
  }

  private class Lyric {
    private Word[] first, second;

    private Lyric(Word[] first, Word[] second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public String toString() {
      return first[0] + " " + second[0] + "\n" + first[1] + " " + second[1];
    }
  }

  private boolean isVowel(char c) {
    return "aeiou".indexOf(c) >= 0;
  }

  public void solve() {
    int n = in.ni();
    Map<Character, Map<Integer, List<Word>>> lastVowelMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      Word word = new Word(i, in.next());
      Character vowel = word.getLast();
      int vowels = word.getVowels();

      Map<Integer, List<Word>> vowelsCountMap = lastVowelMap.getOrDefault(vowel, new HashMap<>());

      List<Word> list = vowelsCountMap.getOrDefault(vowels, new ArrayList<>());
      list.add(word);
      vowelsCountMap.put(vowels, list);
      lastVowelMap.put(vowel, vowelsCountMap);
    }

    ArrayDeque<Word> second = new ArrayDeque<>();
    Map<Integer, ArrayDeque<Word>> remaining = new HashMap<>();

    for (Map.Entry<Character, Map<Integer, List<Word>>> entry : lastVowelMap.entrySet()) {
      Map<Integer, List<Word>> value = entry.getValue();
      for (Map.Entry<Integer, List<Word>> twin : value.entrySet()) {
        List<Word> words = twin.getValue();
        int count = words.size() - words.size() % 2;
        for (int i = 0; i < count; i += 2) {
          second.add(words.get(i));
          second.add(words.get(i + 1));
        }
        if (words.size() % 2 == 1) {
          Word last = words.get(words.size() - 1);
          ArrayDeque<Word> lst = remaining.getOrDefault(last.getVowels(), new ArrayDeque<>());
          lst.add(last);
          remaining.put(last.getVowels(), lst);
        }
      }
    }
    List<Lyric> result = new ArrayList<>();
    Word[] a, b;
    while ((a = getFirst(remaining)) != null) {
      b = getSecond(second);
      if (b != null) {
        result.add(new Lyric(a, b));
      } else break;
    }
    while ((a = getSecond(second)) != null) {
      b = getSecond(second);
      if (b != null) {
        result.add(new Lyric(a, b));
      } else break;
    }
    out.println(result.size());
    result.forEach(out::println);
  }

  private Word[] getFirst(Map<Integer, ArrayDeque<Word>> map) {
    for (Map.Entry<Integer, ArrayDeque<Word>> entry : map.entrySet()) {
      ArrayDeque<Word> words = entry.getValue();
      if (words.size() >= 2) {
        return new Word[]{words.pollFirst(), words.pollFirst()};
      }
    }
    return null;
  }

  private Word[] getSecond(ArrayDeque<Word> deque) {
    if (deque.size() >= 2) {
      return new Word[]{deque.pollFirst(), deque.pollFirst()};
    }
    return null;
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
    try (BeautifulLyrics instance = new BeautifulLyrics()) {
      instance.solve();
    }
  }
}