package topcoder.contests101_200.srm144;

public class Time {

    public String whatTime(int s) {
        int hour = s / (60 * 60); s -= hour * 60 * 60;
        int min = s / 60; s -= min * 60;
        return hour + ":" + min + ":" + s;
    }

}