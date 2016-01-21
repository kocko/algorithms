package codeforces.contests001_100.problemset005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatServersOutgoingTraffic {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            String line = reader.readLine();
            if (line == null || "".equals(line)) break;
            char first = line.charAt(0);
            if (first == '+') count++;
            else if (first == '-') count--;
            else {
                String[] message = line.split(":");
                if (message.length > 1) {
                    result += message[1].length() * count;
                }

            }
        }
        System.out.println(result);
        reader.close();
    }

}
