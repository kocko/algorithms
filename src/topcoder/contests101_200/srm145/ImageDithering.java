package topcoder.contests101_200.srm145;

public class ImageDithering {

    public int count(String dithered, String[] screen) {
        int count = 0;
        for (String s : screen) {
            for (char c : s.toCharArray()) {
                if (dithered.indexOf(c) >= 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
