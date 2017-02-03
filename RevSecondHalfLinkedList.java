import java.util.*;
public class RevSecondHalfLinkedList {

	public static void main(String[] args) {
		
		//Taking the input.
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of elements in the linked list: ");
		int n = sc.nextInt();
		System.out.println("Please enter the " +n+ " elements in the linked list: ");
		Linked_List l = new Linked_List();
		for(int i = 0; i < n; i++){
			//Calling the insert method on linked list to insert the new element.
			l.insert(sc.nextInt());
		}
		sc.close();
		//Displaying the linked list
		l.display();
		if(!l.isEmpty()){
			//Calling the method to find the middle element of the linked list.
			Node mid = l.findMiddle();
			System.out.println("\nThe middle element is: " + mid.getData());
			//Calling the method to reverse the linked list.
			l.reverse(mid);
			//Displaying the reversed linked list.
			System.out.println("The linked list with second half being reversed is:");
			l.display();
		}
	}
}
//Node class.
class Node{
	protected int data;
	protected Node next;
	//Constructor
	public Node(){
		data = 0;
		next = null;
	}
	public Node(int d, Node n){
		data = d;
		next = n;
	}
	public void setData(int d){
		data = d;
	}
	public int getData(){
		return data;
	}
}

//Linkedlist class
class Linked_List{
	protected Node start;
	public Linked_List(){
		start = null;
	}
	public boolean isEmpty(){
		return start == null;
	}
	//Method to insert the new node.
	public void insert(int d){
		Node n = new Node(d, null);
		if(start == null){
			start = n;
		}
		else{
			Node temp = start;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = n;
		}
	}
	//Method to display the linked list.
	public void display(){
		System.out.println("The linked list is:");
		if(start == null){
			System.out.println("Empty linked list");
		}
		else if(start.next == null){
			System.out.println(start.data);
		}
		else{
			Node temp = start;
			while(temp.next != null){
				System.out.print(temp.getData()+"->");
				temp = temp.next;
			}
			System.out.print(temp.getData());
		}
	}
	//Method to find the middle element of the linked list.
	public Node findMiddle(){
		Node tslow = start;
		Node tfast = start;
		while(tfast != null){
			tfast = tfast.next;
			if(tfast != null && tfast.next != null){
				tslow = tslow.next;
				tfast = tfast.next;
			}
		}
		return tslow; 
	}
	//Method to reverse the linked list
	public void reverse(Node n){
		Node st = n;
		//For linked list with length = 1 or 2
		if(st.next == null || st.next.next == null){
			return;
		}
		//For linked list with length = 3 or more
		Node s = st.next;
		Node t = s.next;
		Node temp = t.next;
		s.next = null;
		while(temp != null){
			t.next = s;
			s = t;
			t = temp;
			temp = temp.next;
		}
		t.next = s;
		st.next = t;
	}
}