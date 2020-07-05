import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Fail {
	static String S;
	static Stack<Character> stack = new Stack<Character>();
	static int ans;
	static boolean visit[] = new boolean[51];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();

		for (int i = 0; i < S.length(); i++) {

			if (S.charAt(i) == ')') {
				func();
			} else {
				stack.push(S.charAt(i));
			}
		}


		System.out.println(ans + stack.size());
	}

	static void func() {
		int K, Q;
		int qlen=0;
		char ch = stack.pop();
		
		while(ch!='(') {
			qlen++;
			ch= stack.pop();
		}
		
		K = stack.pop()-'0';
		ans = ans+ qlen*K;
	}

}
