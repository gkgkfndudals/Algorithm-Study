import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static String input;
	static String str_explosion;
	static Stack<Character> stack = new Stack<Character>();
	static String[] s1;
	static String ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		input = br.readLine();
		str_explosion = br.readLine();

		func();

		for (Character c : stack) {
			sb.append(c);
		}

		ans = sb.toString();

		System.out.println((ans.length() == 0) ? "FRULA" : ans);

	}

	static void func() {
		int elen = str_explosion.length();
		
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));

			if (stack.size() >= elen) {
				boolean flag = true;

				for (int j = 0; j <elen; j++) {
					if (stack.get(stack.size() + j - elen) != str_explosion.charAt(j)) {
						flag = false;
                        break;
					}
				}

				if (flag) {
					for (int k = 0; k < elen; k++)
						stack.pop();
				}
			}
		}
		
	}
	
}
