package hackerrank.contests.codewhiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class PrivateAccess {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		Object o = new PrivateAccess().new Private();
		Class<Private> clazz = Private.class;
		Method method = clazz.getDeclaredMethod("powerof2", int.class);
		method.setAccessible(true);
		Object result = method.invoke(o, num);
		System.out.println(num + " is " + result);
		System.out.println("An instance of class: " + o.getClass().getSimpleName() + " has been created");
	}

	class Private {
		private String powerof2(int num) {
			return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
		}
	}
}
