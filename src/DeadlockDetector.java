import java.util.*;

public class DeadlockDetector {
	
	Map<String, Lock> locks = new HashMap<>();
	
	public DeadlockDetector(Map<String, Lock> locks){
		this.locks = locks;
	}
	
	public void declareLockOrder(Process owner, LinkedList<Lock> orderedLocks) {
		
		Map<Lock, Boolean> touchNodes = new HashMap<>();
		touchNodes.put(orderedLocks.get(0), Boolean.FALSE);
		
		for(int i=1; i<orderedLocks.size(); i++) {
			Lock prev = orderedLocks.get(i-1);
			Lock next = orderedLocks.get(i);
			prev.addNode(next);
			touchNodes.put(next, Boolean.FALSE);
		}	
		
		//Check cycles
		
	}
	


	public static void main(String[] args) {
		

	}
	
	private static class Process {
		String name;
		
		public Process(final String name) {
			this.name = name;
		}
	}
	
	private static class Lock {
		String name;
		List<Lock> childs = new ArrayList<>();

		public Lock(String name) {
			this.name = name;
		}

		public void addNode(Lock childNode) {
			childs.add(childNode);
		}
		
		
	}

}
