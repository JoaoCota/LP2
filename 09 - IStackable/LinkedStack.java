import java.util.LinkedList;

public class LinkedStack implements IStackable{
	private LinkedList<Integer> listaEncadeada = new LinkedList<Integer>();
	
	public int size() {
		return listaEncadeada.size();
	}

	public void push(int v) {
		listaEncadeada.addFirst(v);
	}

	public int pop() {
		return (int) listaEncadeada.removeFirst();
	}

}