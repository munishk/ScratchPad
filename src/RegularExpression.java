import java.util.PriorityQueue;

public class RegularExpression {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();

		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;

		for (int j = 2; j <= n; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 2];
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) == '.' || (s.charAt(i - 1) == p.charAt(j - 1))) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*' && s.charAt(i - 1) == p.charAt(j - 2)) {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[m][n];

	}

	public ListNode mergeKLists(ListNode[] lists) {
	        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);  
	        for(ListNode node: lists) {
	            pq.offer(node);
	        }
	        ListNode head = new ListNode(0);
	        ListNode curr = head;
	        while(!pq.isEmpty()) {
	            ListNode removed = pq.poll();
	            curr.next = removed;
	            curr = removed;
	            if(removed.next != null) {
	                pq.offer(removed.next);
	            }
	        }
	        return head.next;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
