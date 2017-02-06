import java.util.LinkedList;
import java.util.List;

public class A022_GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		LinkedList<String> r = new LinkedList<String>();
		
		if (n == 0) return r;
		else if (n == 1) {
			r.add("()");
			return r;
		}
		else {
			LinkedList priorList = (LinkedList) generateParenthesis(n - 1);
			
		}
		
		return r;
	}

}
