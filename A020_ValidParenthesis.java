import java.util.Stack;

public class A020_ValidParenthesis {
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char leftP;
			
			switch (c) {
			case '(': 
			case '[':
			case '{':
				stack.push(c); 
				break;
			case ')':
				if (stack.isEmpty()) return false;
				
				leftP = stack.pop();
				if (leftP != '(') return false;
				break;
			case ']':
				if (stack.isEmpty()) return false;
				
				leftP = stack.pop();
				if (leftP != '[') return false;
				break;
			case '}':
				if (stack.isEmpty()) return false;
				
				leftP = stack.pop();
				if (leftP != '{') return false;
				break;
			}
		}
		
		return stack.isEmpty();
	}
	
	public static boolean isValid_Another(String input) {
		Stack<Character> st = new Stack<Character>();
		char[] parenthesis =  {
			'(', '[', '{',
			')', ']', '}'
		};
		char[] open_parenthesis =  {
			'(', '[', '{',
		};
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
//			print("Char at Position " + i + "\n");
			
			if (c == '{' || c == '[' || c == '(') {
				st.push(c);
//				print(st.toString() + "\n");
			}
			else {
				if (st.isEmpty()) return false;
				
				char top = (char) st.pop();
				
				if (top == '(' && c != ')'
						|| top == '[' && c != ']'
						|| top == '{' && c != '}') {
					return false;
				}
			}			
			
		}
		
		if (! st.isEmpty()) return false;
		else return true;
	}
	
	public static void main(String[] args) {
		while (true) {
			String string = randomParenthesisString();
			boolean rf = isValid(string);
			boolean rn = isValid_Another(string);
			if (rf != rn) {
				System.out.println("Input String " + string);
				System.out.println("Fast  Method " + rf);
				System.out.println("Naive Method " + rn);
				break;
			}
		}
	}
	
	public static String randomParenthesisString() {
		int pairsCnt = (int) (Math.random() * 100);
		
		StringBuilder output = new StringBuilder();
		
		for (int i = 1; i <= 2 * pairsCnt; i++) {
			double seed = Math.random();
			
			if (seed <= 1.0 / 6) output.append('(');
			else if (seed <= 2.0 / 6) output.append('[');
			else if (seed <= 3.0 / 6) output.append('{');
			else if (seed <= 4.0 / 6) output.append(')');
			else if (seed <= 5.0 / 6) output.append(']');
			else output.append('}');
		}
		
		return output.toString();
		
	}
}
