package uva.volume004;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static java.lang.Integer.compare;

public class WordIndex implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        for (char c = 'a'; c <= 'z'; c++) generate(c + "");
        prepareMapping();
        while (in.hasNext()) {
            out.println(index(in.next()));
        }
    }

    private List<String> words = new ArrayList<>();
    private Map<String, Integer> mapping = new TreeMap<>();

    private void generate(String word) {
        if (word.length() == 6) return;
        words.add(word);
        for (char c = (char) (word.charAt(word.length() - 1) + 1); c <= 'z'; c++) {
            generate(word + c);
        }
    }

    private void prepareMapping() {
        words.sort((a, b) -> {
            int s = compare(a.length(), b.length());
            return (s != 0) ? s : a.compareTo(b);
        });
        for (int i = 0; i < words.size(); i++) {
            mapping.put(words.get(i), i + 1);
        }
    }

    private int index(String word) {
        if (isValid(word)) {
            return mapping.get(word);
        } else {
            return 0;
        }
    }

    private boolean isValid(String word) {
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) return false;
        }
        return true;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (WordIndex instance = new WordIndex()) {
            instance.solve();
        }
    }
}
