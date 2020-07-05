import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static String input;
	static int max = Integer.MIN_VALUE;
	static ArrayList<Integer> nums;
	static ArrayList<Character> ops;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = br.readLine();

		nums = new ArrayList<Integer>();
		ops = new ArrayList<Character>();
		
		StringTokenizer st = new StringTokenizer(input, "+*-");
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == '*' || input.charAt(i)=='+' || input.charAt(i)=='-') {
				ops.add(input.charAt(i));
			} else {
				nums.add(input.charAt(i)-'0');
			}
		}
		
		dfs(nums.get(0), 0);
		System.out.println(max);
	}

	static void dfs(int result, int opIdx) {
		if(opIdx>= ops.size()) {
			System.out.println(result);
			if(max < result) 
				max= result;
			return ;
		}
		
		int res1= cal(result, ops.get(opIdx), nums.get(opIdx+1));
		dfs(res1, opIdx+1);
		
		if(opIdx + 1 < ops.size()) {  //연산자가 최소 2개는 남아야 되므로
			int res2 = cal(nums.get(opIdx+1), ops.get(opIdx+1), nums.get(opIdx+2));
			dfs(cal(result, ops.get(opIdx), res2), opIdx+2);
		}
	}

	
	static int cal(int a, char op, int b) {
		if (op == '+')	return a + b;
		else if (op == '-')	return a - b;
		else return a * b;
	}
}
