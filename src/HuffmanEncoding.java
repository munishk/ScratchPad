import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HuffmanEncoding {
	
	CharFrequency[] input;
	
	public HuffmanEncoding(CharFrequency[] input) {
		super();
		this.input = input;
	}

	public List<EncodedOutput> huffmanEncoding() {
	   //first build huffman tree
		HuffmanTreeNode root = buildHuffmanTree();
		List<EncodedOutput> output = new ArrayList<HuffmanEncoding.EncodedOutput>();
		traverseAndAssignCode(root, "", output);
       return output;
	}
	
	private void traverseAndAssignCode(HuffmanTreeNode root, String prefix, List<EncodedOutput> output) {
		if(root == null) {
			return;
		}
		if(root.isLeaf()) {
			output.add(new EncodedOutput(((HuffmanTreeLeafNode)root).c, prefix));
			return;
		}
		
		traverseAndAssignCode(root.left, prefix+ "0", output);
		traverseAndAssignCode(root.right, prefix+ "1", output);
		
	}

	private HuffmanTreeNode buildHuffmanTree() {
		PriorityQueue<HuffmanTreeNode> pq = initializeMinHeap();
		
		//remove first 2 node with min frequencies;
		while(pq.size() > 1) {
			HuffmanTreeNode left = pq.poll();
			HuffmanTreeNode right = pq.poll();
			
			HuffmanTreeNode parent = new HuffmanTreeNode( left.frequency + right.frequency , left, right);
			pq.add(parent);
		}
		return pq.remove();
	}
	
	private PriorityQueue<HuffmanTreeNode> initializeMinHeap() {
		PriorityQueue<HuffmanTreeNode> pq = new PriorityQueue<>(new Comparator<HuffmanTreeNode>() {
			@Override
			public int compare(HuffmanTreeNode o1, HuffmanTreeNode o2) {
				return o1.frequency - o2.frequency;
			}
		});
		
		//insert all elements to PQ
		for(CharFrequency charFreq: input) {
			pq.add(new HuffmanTreeLeafNode(charFreq.c, charFreq.frequency, null, null));
		}
		return pq;
	}
	
	public static void main(String[] args) {
		List<CharFrequency> input = new ArrayList<>();
		input.add(new CharFrequency('a', 5));
		input.add(new CharFrequency('b', 9));
		input.add(new CharFrequency('c', 12));
		input.add(new CharFrequency('d', 13));
		input.add(new CharFrequency('e', 16));
		input.add(new CharFrequency('f', 45));
		
		System.out.println("Input:");
		System.out.println(input);
		
		HuffmanEncoding he = new HuffmanEncoding(input.toArray(new CharFrequency[0]));
		
		List<EncodedOutput> output = he.huffmanEncoding();
		System.out.println("Output:");
		System.out.println(output);
	}
	
	static class HuffmanTreeNode {
		int frequency;
		HuffmanTreeNode left;
		HuffmanTreeNode right;
		public HuffmanTreeNode(int freq, HuffmanTreeNode left,
				HuffmanTreeNode right) {
			super();
			this.frequency = freq;
			this.left = left;
			this.right = right;
		}
		
		boolean isLeaf() {
			return false;
		}
	}
	
	static class HuffmanTreeLeafNode extends HuffmanTreeNode {
		char c;
		public HuffmanTreeLeafNode(char c, int  freq, HuffmanTreeNode left,
				HuffmanTreeNode right) {
			super(freq,left,right);
			this.c =c;
		}
		
		boolean isLeaf() {
			return true;
		}
	}
	static class EncodedOutput {
		char c;
		String encodedBit;
		public EncodedOutput(char c, String encodedBit) {
			super();
			this.c = c;
			this.encodedBit = encodedBit;
		}
		
		@Override
		public String toString() {
			return c + ": " + encodedBit; 
		}
	}
	
	static class CharFrequency {
		char c;
		int frequency;
		public CharFrequency(char c, int frequency) {
			super();
			this.c = c;
			this.frequency = frequency;
		}
		
		@Override
		public String toString() {
			return c + ": " + frequency; 
		}
	}

}
