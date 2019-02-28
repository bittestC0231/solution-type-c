package problem03;

public class MyStack {

	private String[] buffer;
	private int top = -1;

	public MyStack(int size) {
		buffer = new String[size];
	}

	public void push(String item) {
		if (size() - 1 == top) {
			String tempArr[] = buffer;
			buffer = new String[buffer.length * 2];
			for (int i = 0; i < tempArr.length; i++) {
				buffer[i] = tempArr[i];
			}
		}
		buffer[++top] = item;
	}

	public String pop() {
		if (top != -1)
			return buffer[top--];

		return null;
	}

	public boolean isEmpty() {
		if (top == -1)
			return true;
		
		return false;
	}

	public int size() {
		return buffer.length;
	}
}