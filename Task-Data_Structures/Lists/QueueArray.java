/**
 * 17.06.2017
 * QueueArray.java
 * package
 */
public class QueueArray {
	
	public int [] queue;
	public int index;
	public int first = -1;
	public int last = -1;
	
	public QueueArray(int groesse){
		queue = new int[groesse];
		index = queue.length -1;
		first = index;
	}
	
	public void push(int x){
		if(index >= 0){
			queue[index] = x;
			last = index;
			index--;
		} else {
			System.out.println("Queue ist voll!");
		}
	}
	
	public int pop() {
		System.out.print("Entferntes Element: ");
		int zahl = queue[first];
		queue[first] = 0;
		index++;
		first = first -1;
		
		return zahl;
	}
	
	public int first(){
		return queue[queue.length-1];
	}
	
	public void print(){
		if(index == queue.length-1){
			if(queue[queue.length-1] == 0){
				System.out.println("Queue ist leer!");
			}
		}
		else{
			System.out.print("--> ");
			for(int i = index +1; i < queue.length; i++){
				if(i != queue.length -1){
					System.out.print(queue[i] + " ");
				}
				else {
					System.out.println(queue[i] + " -->");
				}
				
			}
		}
				
	}
	
	public int[] getQueueArray(){
		return queue;
	}
	
	
}
