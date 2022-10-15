public class MyLinkedList {
	
	private ListNode head;
	private int size;
	/**
	 * inner class for ListNode
	 */
	private class ListNode {
		private Object data;
		private ListNode next;
		private ListNode(Object d) {
			this.data = d;
			this.next = null;
		}
		private ListNode() {
		}
	}
	/**
	 * Constructor of linked list, creating an empty linked list
	 * with a dummy head node.
	 */
	public MyLinkedList() {
		this.head = new ListNode(null); //an empty list with a dummy head node
		this.size = 0;
	}


	public MyLinkedList reverse() {
		return reverse(this.head.next);
	}
	

	private MyLinkedList reverse(ListNode node) {

		//End condition for when the whole list has been traversed
		if (node == null) {
			return new MyLinkedList();
		}

		MyLinkedList remain = reverse(node.next);
		remain.addLast(node.data);

		return remain;
	}

	//Helper method for reverse() method. Adds new node to the end of the linked list
	public void addLast (Object data) {
		ListNode cur = this.head;
		ListNode nn = new ListNode(data);
		int i = 0;
		while(i < size) {
			cur = cur.next;
			i++;
		}
		cur.next = nn;
		this.size++;
	}
	

	public void reverse2() {
		if(this.size <= 1) 
			return;
		// The following method call works on a *sublist* without a Dummy Node.
		// Namely, we preserved the OLD dummy head node in the reversed list.
		this.head.next = reverse(this.head.next, this.head.next.next);
	}
	

	private ListNode reverse(ListNode first, ListNode second) {
		ListNode h = null;

		//End condition for when the second node is null, meaning whole list was traversed.
		if (second != null) {
			h = reverse(second, second.next);
			second.next = first;
			first.next = null;
		}else {
			return first;
		}
		return h;
	}
	

	public void addFirst(Object elem) {
		ListNode nn = new ListNode(elem);
		nn.next = this.head.next;
		this.head.next = nn;
		this.size ++;
	}
	

	public String toString() {
		String result = "{";
	    for (ListNode node = this.head.next; node != null;
	    		node = node.next) {
	    		result += node.data;
	    	
	    		if(node.next != null)
	    			result += "->";
	    }
	    return result + "}";
	  }

}

