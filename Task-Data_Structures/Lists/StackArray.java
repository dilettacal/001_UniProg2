import java.util.Arrays;

/**
 * 16.06.2017
 * StackArray.java
 * package
 */
public class StackArray {
	
	private int [] stack;
	private int count; //# der Elemente auf dem Stack
	
	public StackArray(int groesse){
		stack = new int[groesse];
		count = 0;
	}
	
	public int[] getStack(){
		return stack;
	}
	
	public void setSpeicher(int [] a){
		stack = a;
	}
	
	public void push(int elem){
		if(count != stack.length){
			stack[count++] = elem;
		}
		else System.out.println("Stack ist voll!");		
	}
	
	public int pop(){
		System.out.print("Entferntes Element: ");
		int zahl = stack[count-1];
		stack[count-1]=0;
		count--;
		return zahl;
	}
	
	public int top(){
		return stack[count-1]; //letztes belegtes Feld
	}
	
	public void content(){
		System.out.println("Stack: ");
		System.out.println(Arrays.toString(stack));
	}
//	private boolean isEmpty(){
//		if(stack[0] != 0) return true;
//		return false;
//	}
//	
	
}
