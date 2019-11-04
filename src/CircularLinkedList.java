import java.util.NoSuchElementException;

public class CircularLinkedList {
	
	private static ListNode head,head1,head2;
	private ListNode last;
	
	
	private int length;
	
	public class ListNode{
		private int Data;
		private ListNode Next;
		
		ListNode(int Data){
			this.Data=Data;
		}
	}
	public CircularLinkedList() {
		last=null;
		length=0;
	}
	private int length() {
		return length;
	}
	
	public boolean isEmpty() {
		if(length==0) {
			return true;
		}else
			return false;
	}
	public void createCircularLinkedList() {
		ListNode head=new ListNode(10);
		ListNode second=new ListNode(2);
		ListNode third=new ListNode(4);
		ListNode fourth=new ListNode(5);
		ListNode fifth=new ListNode(1);
		
		head.Next=second;
		second.Next=third;
		third.Next=fourth;
		fourth.Next=fifth;
		fifth.Next=head;
		
		last=fifth;
	}
	public void Display() {
		if(last==null) {
			return ;
		}
		ListNode current=last.Next;
		while(current!=last) {
			System.out.print(current.Data+"--> ");
			current=current.Next;
		}
		System.out.print(current.Data+"\n");
		
	}
	public void insertFirst(int value) {
		ListNode newNode=new ListNode(value);
		if(last==null) {
			last=newNode;
		}else {
			newNode.Next=last.Next;
			
		}
		last.Next=newNode;
		
		length++;
	}
	
	public void InsertEnd(int value) {
		ListNode newNode=new ListNode(value);
		if(last==null) {
			last=newNode;
			last.Next=last;
			
		}else {
			newNode.Next=last.Next;
			last.Next=newNode;
			last=newNode;
		}
		
		length++;
	}
	
	public ListNode removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp=last.Next;
		if(last.Next==last) {
			last=null;
		}
		else {
			last.Next=temp.Next;
			
		}
		temp.Next=null;
		
		length--;
		return temp;
		
	}
	public  void split() {
		ListNode slwpointer=head;
		ListNode fastpointer=head;
		
		if(head==null) {
			return;
		}
		while(fastpointer.Next.Next!=head&&fastpointer.Next!=head) {
			fastpointer=fastpointer.Next.Next;
			slwpointer=slwpointer.Next;
		}
		//For Even nodes
		if(fastpointer.Next.Next==head) {
			fastpointer=fastpointer.Next;
		}
		head1=head;
		
		//for ODD nodes
		if(head.Next!=head) {
			head=slwpointer.Next;
		}
		fastpointer.Next=slwpointer.Next;
		slwpointer.Next=head;
		
	
	}
	public void printList(ListNode node) { 
       ListNode temp = node; 
        if (node != null) { 
            do { 
                System.out.print(temp.Data + " "); 
                temp = temp.Next; 
            } while (temp != node); 
        } 
    } 
	
	public static void main(String args[]) {
		CircularLinkedList CLL=new CircularLinkedList();
		//CLL.createCircularLinkedList();
		CLL.insertFirst(10);
		CLL.insertFirst(2);
		CLL.insertFirst(5);
		CLL.insertFirst(6);
		CLL.insertFirst(1);
		CLL.insertFirst(7);
		
		CLL.InsertEnd(4);
		CLL.InsertEnd(8);
		//CLL.Display();
		
		//CLL.removeFirst();
		//CLL.removeFirst();
		
		
		//CLL.Display();
		
		CLL.printList(head);
		CLL.split(); 
        System.out.println(""); 
        System.out.println("First Circular List "); 
        CLL.printList(head1); 
        System.out.println(""); 
        System.out.println("Second Circular List "); 
        CLL.printList(head2); 
		
	
		
		
	}

}
