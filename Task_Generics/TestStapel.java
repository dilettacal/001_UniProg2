import stapel.StapelGenerisch;
import stapel.StapelSchnittstelle;

/**
 * 03.07.2017
 * TestStapel.java
 * package stapel
 * 
 * Klasse zum Testen des generischen Stapels
 */
public class TestStapel {

	public static void main(String[] args) {
		StapelSchnittstelle<Long> stackLong = new StapelGenerisch<Long>();
		stackLong.push(2L);
		stackLong.push(35626L);
		stackLong.push(26028L);
		stackLong.push(10L);
		System.out.println(stackLong);
		System.out.println(stackLong.top());
		System.out.println(stackLong.pop());
		System.out.println(stackLong);
		System.out.println("Stack is Empty? " + stackLong.isEmpty());
		
		StapelGenerisch<Double> stackDouble = new StapelGenerisch<>();
		for(int i = 0; i < 8; i++){
			stackDouble.push((double) (i+1)*3);
		}
		System.out.println(stackDouble);
		System.out.println(stackDouble.top());
		for(int i = stackDouble.size(); i > 0; i--){
			stackDouble.pop();
		}
		System.out.println("Stack is Empty? " + stackDouble.isEmpty());
	}

}
