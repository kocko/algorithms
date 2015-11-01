package codeforces.contests001_100.problemset002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Winner {

    static class Round {
        String player;
        int score;
        
        Round(String player, int score) {
            this.player = player;
            this.score = score;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rounds = Integer.parseInt(sc.nextLine());
        List<Round> list = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            String[] split = sc.nextLine().split("\\s+");
            Round round = new Round(split[0], Integer.parseInt(split[1]));
            list.add(round);
        }
        System.out.println(findWinner(list));
        sc.close();
    }
    
    static String findWinner(List<Round> list) {
    	Map<String, Integer> scores = calculateFinalScores(list);
        int max = findMaxScore(scores);
        Set<String> winners = findWinners(scores, max);
        String winner = null;
        int winningRound = list.size();
        for (String player : winners) {
        	int score = 0;
        	for (int i = 0; i < list.size(); i++) {
        		Round round = list.get(i);
        		if (round.player.equals(player)) {
        			score += round.score;
        			if (score >= max) {
        				if (i < winningRound) {
        					winner = round.player;
        					winningRound = i;
        				}
        			}
        		}
        	}
        }
        
        return winner;
    }

	private static Set<String> findWinners(Map<String, Integer> scores, int max) {
		Set<String> winners = new HashSet<>();
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
        	if (entry.getValue() == max) {
        		winners.add(entry.getKey());
        	}
        }
        return winners;
	}

	private static int findMaxScore(Map<String, Integer> scores) {
		int max = 0;
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
        	if (entry.getValue() > max) {
        		max = entry.getValue();
        	}
        }
        return max;
	}

	private static Map<String, Integer> calculateFinalScores(List<Round> list) {
		Map<String, Integer> scores = new HashMap<>();
        for (Round round : list) {
            String player = round.player;
            int score = round.score;
            if (scores.containsKey(player)) {
                score += scores.get(player);
            }
            scores.put(player, score);
        }
        return scores;
	}
	
}
