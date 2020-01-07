public class Box<T> {
	
	private T t;
	
	

	public T getT() {
		return t;
	}



	public void setT(T t) {
		this.t = t;
	}
	
	
	public <U> void inspect(U u, T t) {
		System.out.println("Method type:" + u.getClass());
		System.out.println("Class type:" + t.getClass());
	}



	public static void main(String[] args) {
		Box<Integer> b1 = new Box<>();

	}

}
