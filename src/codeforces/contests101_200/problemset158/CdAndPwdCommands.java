package codeforces.contests101_200.problemset158;

import java.util.Scanner;
import java.util.Stack;

public class CdAndPwdCommands {

	@SuppressWarnings("serial")
	static Stack<String> stack = new Stack<String>() {{
		push("");
	}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String command = sc.nextLine();
			applyCommand(command);
		}
		sc.close();
	}
	
	static void applyCommand(String command) {
		String[] split = command.split("\\s+");
		if ("pwd".equals(split[0])) {
			for (String s : stack) {
				System.out.print(s + "/");
			}
			System.out.println();
		} else if ("cd".equals(split[0])) {
			if ("..".equals(split[1])) {
				stack.pop();
			} else {
				String[] args = split[1].split("/");
				for (String s : args) {
					if ("".equals(s)) {
						stack.clear();
						stack.push("");
					} else if ("..".equals(s)) {
						stack.pop();
					} else {
						stack.push(s);
					}
				}
			}
		}
	}
}
