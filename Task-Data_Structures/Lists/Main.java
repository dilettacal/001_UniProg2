public class Main {

	public static void main(String[] args) {
		
		//Test StackArray
		StackArray stackArr = new StackArray(5);
		stackArr.push(10);
		stackArr.push(9);
		stackArr.push(18);
		stackArr.push(11);
		stackArr.push(22);
		stackArr.content();
		System.out.println(stackArr.pop());
		stackArr.content();
		System.out.println(stackArr.top());
		stackArr.push(111);
		stackArr.content();
		System.out.println(stackArr.top());	
		System.out.println();
		
		Stack st = new Stack();
		System.out.println(st.isEmpty());
		st.push(4);
		st.push(5);
		st.content();
		st.push(17);
		st.push(99);
		System.out.println();
		st.content();
		System.out.println();
		System.out.println(st.top());
		System.out.println(st.isEmpty());
		
		
	}

}
