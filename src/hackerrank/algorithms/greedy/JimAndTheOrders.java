package hackerrank.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JimAndTheOrders {

	static class Order {
		Integer time;
		Integer duration;
		Integer index;

		Order(Integer time, Integer duration, Integer index) {
			this.time = time;
			this.duration = duration;
			this.index = index;
		}
		
		Integer getScore() {
			return time + duration;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		List<Order> orders = new ArrayList<>();
		for (int i = 0; i < testCases; i++) {
			Integer time = sc.nextInt();
			Integer duration = sc.nextInt();
			Order order = new Order(time, duration, i + 1);
			orders.add(order);
		}
		sc.close();
		Collections.sort(orders, new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				Integer o1Score = o1.getScore();
				Integer o2Score = o2.getScore();
				if (o1Score == o2Score) {
					return o1.time.compareTo(o2.time);
				} else {
					return o1Score.compareTo(o2Score);
				}
				
			}
		});
		for (int i = 0; i < orders.size(); i++) {
			System.out.print(orders.get(i).index);
			if (i != orders.size() - 1) {
				System.out.print(" ");
			}
		}
	}
}
