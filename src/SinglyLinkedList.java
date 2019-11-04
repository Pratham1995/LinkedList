
public class SinglyLinkedList {
	
	private static ListNode head;//Instance Variable
	public static class ListNode{
		private ListNode Next;
		private int Data;
		
		  ListNode(int Data){
			this.Data=Data;
			this.Next=null;
		}
		
		  
	}
	public void Display() {
		ListNode current=head;
		
		while(current!=null) {
			System.out.print(current.Data+"--->");
			current=current.Next;
			
		}
		System.out.println("null");
		
		
		
		
	}
	
	public int length() {
		int count=0;
		
		ListNode current=head;
		if(head==null) {
			return 0;
		}
		while(current!=null) {
			count++;
			current=current.Next;
		}
		return count;
		
		
	}
	
	public void insertFirst(int value) {
		ListNode newNode=new ListNode(value);
		newNode.Next=head;
		head=newNode;
	}
	
	public void insertLast(int value) {
		ListNode newNode=new ListNode(value);
		
		if(head==null) {
			head=newNode;
			return;
		}
		ListNode current=head;
		while(null!=current.Next) {
			current=current.Next;
		}
		current.Next=newNode;
		
	}
	public boolean find(int searchKey ) {
		
		if(head==null) {
			return false;
		}
		ListNode current=head;
		
		while(current!=null) {
		if(current.Data==searchKey) {
			
			return true;
			}
		
		current=current.Next;

		}
		return false;
		
		
	}
	public ListNode reverse() {
		if(head==null) {
			return head;
		}
		ListNode current=head;
		ListNode previous=null;
		ListNode next=null;
		
		while(current!=null) {
			next=current.Next;
			current.Next=previous;
			previous=current;
			current=next;
			
		}
		return previous;
		
		
		
	}
	public ListNode getMiddle() {
		ListNode slowptr=head;
		ListNode fastptr=head;
		while(fastptr!=null && fastptr.Next!=null) {
			slowptr=slowptr.Next;
			fastptr=fastptr.Next.Next;
		}
		return slowptr;
	}
	
	public ListNode getnthnode(int n) {
		if(head==null) {
			return null;
		}
		if(n<=0) {
			throw new IllegalArgumentException("Invalid Input");
		}
		ListNode refptr=head;
		ListNode mainptr=head;
		int count=0;
		while(count<n) {
			refptr=refptr.Next;
			count++;
		}
		while(refptr!=null& refptr.Next!=null) {
			refptr=refptr.Next;
			mainptr=mainptr.Next;
		}
		return mainptr;
	}
	
	public void  removeDuplicates() {
		if(head==null) {
			return ;
		}
		ListNode current=head;
		while(current!=null && current.Next!=null) {
			if(current.Data==current.Next.Data) {
				current.Next=current.Next.Next;
			}
			else {
				current=current.Next;
			}
		}
		
		
	}
	
	public ListNode insertinlist(int value) {
		if(head==null) {
			return null;
		}
		ListNode current=head;
		ListNode temp=null;
		ListNode newNode=new ListNode(value);
		while(current!=null &&current.Next!=null && current.Data<newNode.Data) {
			temp=current;
			current=current.Next;
		}
		temp.Next=newNode;
		newNode.Next=current;
		return head;
	}
	public void removeKey(int key) {
		if(head==null)
			return ;
		ListNode current=head;
		ListNode temp=null;
		if(current!=null && current.Data==key) {
			head=current.Next;
			return;
		}
		while(current!=null && current.Next!=null && current.Data!=key) {
			temp=current;
			current=current.Next;
		}
		temp.Next=current.Next;
		
	}
	public boolean  detectLoop() {
		ListNode fastptr=head;
		ListNode slowptr=head;
		if(head==null) {
			return false;
		}
		while(fastptr!=null&& fastptr.Next!=null) {
			slowptr=slowptr.Next;
			fastptr=fastptr.Next.Next;
			if(slowptr==fastptr) {
				return true;
			}
			
		}
		return false;
	}
	
	public void containsloop() {
		ListNode first=new ListNode(10);
		ListNode second=new ListNode(1);
		ListNode third= new ListNode(8);
		ListNode fourth= new ListNode(2);
		ListNode fifth= new ListNode(5);
		ListNode sixth= new ListNode(1);
		ListNode seventh= new ListNode(22);
		//Connecting Them Together
		
		head=first;
		first.Next=second;
		second.Next=third;
		third.Next=fourth;
		fourth.Next=fifth;
		fifth.Next=sixth;
		sixth.Next=seventh;
		seventh.Next=third;
	}
	
	public static void main(String args[]) {
		SinglyLinkedList SLL =new SinglyLinkedList();//gives null to head
		//SLL.containsloop();
		//System.out.print(SLL.detectLoop());
		/*ListNode head=new ListNode(10);
		ListNode second=new ListNode(1);
		ListNode third= new ListNode(8);
		ListNode fourth= new ListNode(2);
		ListNode fifth= new ListNode(5);
		ListNode sixth= new ListNode(1);
		ListNode seventh= new ListNode(22);*/
		//Connecting Them Together
		/*head.Next=second;
		second.Next=third;
		third.Next=fourth;
		fourth.Next=fifth;
		fifth.Next=sixth;
		sixth.Next=third;*/
		
		SLL.insertFirst(11);
		SLL.insertFirst(8);
		SLL.insertFirst(10);
		
		
		SLL.insertLast(5);
		SLL.insertLast(2);
		SLL.insertFirst(21);
		SLL.insertFirst(4);
		SLL.insertFirst(15);
		SLL.insertFirst(15);
		SLL.insertLast(5);
		SLL.Display();
		ListNode reverseList=SLL.reverse();
		SLL.head=reverseList;
		SLL.Display();
		ListNode middle =SLL.getMiddle();
		System.out.println("Middle is:"+ middle.Data);
		ListNode nthnode=SLL.getnthnode(1);
		System.out.println("The node is:"+nthnode.Data);
		
		
	    
		System.out.println("Length is:"+" "+SLL.length());
		
		
		if(SLL.find(5)) {
			System.out.println("Found");
			
		}else
			System.out.println("not Found");
		SLL.removeDuplicates();
		
		SLL.Display();
		
		SLL.insertinlist(22);
		SLL.Display();
		
		SLL.removeKey(15);
		SLL.Display();
	}
	
	
	

}
