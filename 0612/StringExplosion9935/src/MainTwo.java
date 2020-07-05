import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainTwo {
	static String input;
	static String str_explosion;
	static Stack<Character> stack = new Stack<Character>();
	static String ans;
	static int ilen, elen;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		input = br.readLine();
		str_explosion = br.readLine();

		ilen = input.length();
		elen = str_explosion.length();

		func();
		
		for (Character c : stack) {
			sb.append(c);
		}

		ans = sb.toString();

		System.out.println((ans.length() == 0) ? "FRULA" : ans);

	}

	static void func() {
		for (int i = 0; i < ilen; i++) {
			stack.push(input.charAt(i));
			if (isExplosion()) {
				for (int j = 0; j < elen; j++)
					stack.pop();
			}
		}
	}

	static boolean isExplosion() {
		if (stack.size() < elen)
			return false;

		for (int i = 0; i < elen; i++) {
			char sc = stack.get(stack.size() - elen + i);
			char ec = str_explosion.charAt(i);
			if (sc != ec) {
				return false;
			}
		}

		return true;
	}

}
