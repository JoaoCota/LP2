import java.util.ArrayList;

public class ArrayStack implements IStackable{
	private ArrayList<Integer> listaArray = new ArrayList<Integer>();
	
	public int size() {
		return listaArray.size();
	}

	public void push(int v) {
		listaArray.add(v);
	}

	public int pop() {
		return (int) listaArray.remove(listaArray.size()-1);
	}

}