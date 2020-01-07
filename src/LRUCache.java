import java.util.LinkedHashMap;

public class LRUCache {
	
	    LinkedHashMap<Integer, Integer> cache;
	    
	    @SuppressWarnings("unchecked")
		public LRUCache(int capacity) {
	        cache = new LinkedHashMap(){
	        	@SuppressWarnings("rawtypes")
				@Override
	        	protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
	        	return size() > capacity;
	        	}
	        };
	    }
	    
	    public int get(int key) {
	     Integer value =   cache.get(key);
	     if(value == null) {
	    	 return -1;
	     }
	     return value;
	    }
	    
	    public void set(int key, int value) {
	        cache.put(key, value);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
