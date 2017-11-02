package topcoder.contests300_400.srm354;

public class Thimbles {

    public int thimbleWithBall(String[] swaps) {
        int place = 1;
        for (String s : swaps) {
            int from = s.charAt(0) - '0', to = s.charAt(2) - '0';
            if (place == from) {
                place = to;
            } else if (place == to) {
                place = from;
            }
        }
        return place;
    }
}
