import java.util.NoSuchElementException;

public class DoublyLinkedList {
	private ListNode head;
	private ListNode tail;
	private int length;
	private class ListNode{
		private int data;
		private ListNode previous;
		private ListNode Next;
		
		public ListNode(int Data){
			this.data=Data;
			
		}
	}
	public  DoublyLinkedList() {
		this.head=null;
		this.tail=null;
		this.length=0;
	}
	
	public boolean isEmpty() {
		if(head==null) {		//length is 0
			return true;
		}
		return false;
	
	}
	
	public int length() {
		int length=0;
		if(head==tail) {
			return 1;
		}
		ListNode current=head;
		while(current!=null) {
			current=current.Next;
			length++;
		}
		return length;
	}
	public void InsertFirst(int value) {
		ListNode newNode=new ListNode(value);
		if(isEmpty()) {
			tail=newNode;
		}else {
			head.previous=newNode;
		}
		newNode.Next=head;
		head=newNode;
		

	}
	public void InsertEnd(int value) {
		ListNode newNode= new ListNode(value);
		if(isEmpty()) {
			head=newNode;
		}else {
			tail.Next=newNode;
			newNode.previous=tail;
		}
		tail=newNode;
	}
	
	public void DisplayForward() {
		if(head==null) {
			return;
		}
		ListNode temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"-->");
			temp=temp.Next;
		}
		System.out.println("null");
	}
	public void DisplayBackward() {
		if(head==null) {
			return;
		}
			ListNode temp=tail;
			while(temp!=null) {
				System.out.print(temp.data+ "-->");
				temp=temp.previous;
			}
			System.out.println("null");
	}
	public ListNode removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp=head;
		if(head==tail) {
			tail=null;
		}else {
			head.Next.previous=null;
			
		}
		head=head.Next;
		temp.Next=null;
		length--;
		return temp;
	}
	public ListNode removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp=tail;
		if(tail==head) {
			tail=null;
		}else {
			tail.previous.Next=null;
		}
		tail=tail.previous;
		temp.Next=null;
		length--;
		return temp;
		
	}
	public static void main(String args[]) {
		
		DoublyLinkedList DLL=new DoublyLinkedList();
		DLL.InsertFirst(10);
		DLL.InsertFirst(5);
		DLL.InsertFirst(20);
		DLL.InsertFirst(4);
		DLL.DisplayForward();
		
		DLL.DisplayBackward();
		
		DLL.InsertEnd(1);
		DLL.DisplayForward();
		
		DLL.removeLast();
		
		DLL.DisplayForward();
		System.out.println(DLL.length());
		
		
	}

}
