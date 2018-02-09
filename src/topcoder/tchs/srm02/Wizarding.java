package topcoder.tchs.srm02;

public class Wizarding {

    public String counterspell(String spell, String rules) {
        this.n = spell.length();
        this.spell = spell.toCharArray();
        this.rules = rules.toCharArray();
        result = spell + spell;
        for (int i = 0; i < n; i++) {
            best *= (spell.charAt(i) - 'A' + 1);
            best %= MOD;
        }
        recurse(0, 0, "");
        return result;
    }

    private int n, MOD = 77077;
    private char[] spell, rules;
    private int best = 1;
    private String result;

    private void recurse(int idx, int score, String current) {
        if (idx == n) {
            if (score > best) {
                best = score;
                result = current;
            } else if (score == best) {
                if (current.length() < result.length()) {
                    result = current;
                } else if (current.length() == result.length()) {
                    if (current.compareTo(result) < 0) {
                        result = current;
                    }
                }
            }
        } else {
            //keep
            recurse(idx + 1, ((score == 0 ? 1 : score) * (spell[idx] - 'A' + 1)) % MOD, current + spell[idx]);

            //change
            char change = rules[spell[idx] - 'A'];
            if (change != '-') {
                recurse(idx + 1, ((score == 0 ? 1 : score) * (change - 'A' + 1)) % MOD, current + change);
            }

            //delete
            recurse(idx + 1, score, current);
        }
    }
    
}
