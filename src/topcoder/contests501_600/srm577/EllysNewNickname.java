package topcoder.contests501_600.srm577;

public class EllysNewNickname {

    public int getLength(String nickname) {
        StringBuilder sb = new StringBuilder(nickname);
        while (true) {
            boolean proceed = false;
            for (int i = 1; i < sb.length(); i++) {
                if (isVowel(sb.charAt(i)) && isVowel(sb.charAt(i - 1))) {
                    sb.deleteCharAt(i - 1);
                    proceed = true;
                    break;
                }
            }
            if (!proceed) break;
        }
        return sb.length();
    }

    private boolean isVowel(char c) {
        return "aeiouy".indexOf(c) >= 0;
    }
    
}
