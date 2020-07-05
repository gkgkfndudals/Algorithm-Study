import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static String S;
	static Stack<Node> stack = new Stack<Node>();
	static int ans;
	static char arr[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		arr = new char[S.length()];

		for (int i = 0; i < S.length(); i++) {
			arr[i] = S.charAt(i);
		}

		func();

		while(!stack.isEmpty()) {
			Node node = stack.pop();
			
			ans += node.isSum ? node.num : 1;
		}
		
		System.out.println(ans);
	}

	static void func() {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				stack.push(new Node(-1, false));
			} else if (arr[i] == ')') {
				int len = 0;

				while (stack.peek().num != -1) {
					Node node = stack.pop();

					if (node.isSum == true) {
						len = len + node.num; // 압축된 문자열의 길이를 len에 저장
					} else {
						len++;
					}
				}
				stack.pop(); // ( 없애기 위해서
				
				len = len * stack.pop().num;
				stack.push(new Node(len, true)); // 압축한 새로운 문자열은 앞에꺼랑 합쳐야 된다.
				
			} else {
				stack.push(new Node(arr[i] - '0', false));
			}
		}

	}

	static class Node {
		int num;
		boolean isSum;

		public Node(int num, boolean isSum) {
			this.num = num;
			this.isSum = isSum;
		}
	}
}
