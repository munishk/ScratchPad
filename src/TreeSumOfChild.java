public class TreeSumOfChild {

	static class Node {
		int content;

		Node[] childs;

	}

	private static boolean isSumSatisfied(Node node) {
		boolean isSumSatisfied = false;

		if (node == null) {
			return true;
		}
		
		if(node.childs == null) {
			return true;
		}

		int sum = 0;

		for (Node child : node.childs) {
			sum += child.content;
		}

		if (sum == node.content) {
			isSumSatisfied = true;
		}
		if (node.childs != null) {
			for (Node child : node.childs) {
				isSumSatisfied = isSumSatisfied && isSumSatisfied(child);
			}
		}

		return isSumSatisfied;
	}

	public static void main(String[] args) {
		// Create happy path
		Node ROOT = new Node();
		ROOT.content = 10;
	

		Node[] childs = new Node[3];
		childs[0] = getNode(2);

		childs[1] = getNode(5);
		childs[1].childs = new Node[3];
		childs[1].childs[0] = getNode(1);
		childs[1].childs[1] = getNode(2);
		childs[1].childs[2] = getNode(2);

		childs[2] = getNode(3);
		childs[2].childs = new Node[3];
		childs[2].childs[0] = getNode(1);
		childs[2].childs[1] = getNode(1);
		childs[2].childs[2] = getNode(1);
		
		ROOT.childs = childs;
		
		System.out.println(isSumSatisfied(ROOT));

	}

	private static Node getNode(final int content) {
		Node node = new Node();
		node.content = content;
		return node;
	}

}
