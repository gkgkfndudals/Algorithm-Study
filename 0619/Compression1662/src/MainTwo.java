import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MainTwo {
	private static final char CLOSE = ')';
	private static final char OPEN = '(';
	
	private static int res = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String compressed = br.readLine();
		
		Stack<Elements> lifo = new Stack<>();
		
		for(char c: compressed.toCharArray()) {
			if(c != CLOSE) {
				if(c == OPEN) lifo.push(new Elements(-1, false));
				else lifo.push(new Elements((c - '0'), false));
			}
			else {
				int leng = 0;
				
				while(lifo.peek().num != -1) {
					Elements peek = lifo.pop();
					
					if(peek.isSum) leng += peek.num;
					else leng++;
				}
				
				lifo.pop();
				
				leng *= lifo.pop().num;
				lifo.push(new Elements(leng, true));
			}
		}
		
		while(!lifo.isEmpty()) {
			Elements tmp = lifo.pop();
			res += tmp.isSum ? tmp.num : 1;
		}
		
		System.out.println(res);
	}
	
	private static class Elements{
		int num;
		boolean isSum;
		
		public Elements(int num, boolean isSum) {
			this.num = num;
			this.isSum = isSum;
		}
	}
}
