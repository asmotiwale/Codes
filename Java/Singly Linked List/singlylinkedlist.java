import java.util.Scanner;

public class singlylinkedlist {
	public static void main(String[] args){
		
		System.out.println("This is the demo program for Singly Linked List");
		Scanner sc = new Scanner(System.in);
		Linked_List l = new Linked_List();
		char ch;
		do{
			System.out.println("\nSelect an operation:");
			System.out.println("1. Get the size of the linked list.");
			System.out.println("2. Check if the list is empty.");
			System.out.println("3. Insert Node at the beginning.");
			System.out.println("4. Insert Node at the end.");
			System.out.println("5. Insert Node at a position.");
			System.out.println("6. Delete a Node at a position.");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1: System.out.println("Size = "+l.returnsize());
					break;
			case 2: System.out.println("Empty status = "+l.isEmpty());
					break;
			case 3: System.out.println("Enter the data to be inserted: ");
					l.Insert_Beginning(sc.nextInt());
					break;
			case 4: System.out.println("Enter the data to be inserted: ");
					l.Insert_End(sc.nextInt());
					break;
			case 5: System.out.println("Enter the data to be inserted: ");
					int data = sc.nextInt();
					System.out.println("Enter the position: ");
					int pos = sc.nextInt();
					if (pos < 1 || pos > l.returnsize()){
						System.out.println("Please enter valid position.");
					}
					else{
						l.Insert_Pos(data, pos);
					}
					break;
			case 6: System.out.println("Enter the position: ");
					int p = sc.nextInt();
					if (p < 1 || p > l.returnsize()){
						System.out.println("Please enter valid position.");
					}
					else{
						l.Del_Pos(p);
					}
					break;
			default: System.out.println("Please enter a valid option.");	
					 break;
			}
			l.display();
			System.out.println("Do you want to continue(y or n):");
			ch = sc.next().charAt(0);
		}
		while(ch == 'y' || ch == 'Y');
		sc.close();
	}
}



// Node class representing each node in a linked list
class Node{
	protected int data;
	protected Node next;
	
	//Constructor
	public Node(){
		data = 0;
		next = null;
	}
	
	//Constructor
	public Node(int d, Node n){
		data = d;
		next = n;
	}
	
	//Method to add link to the next node
	public void setLink(Node n){
		next = n;
	}
	
	//Method to set data to current node
	public void setdata(int d){
		data = d;
	}
	
	//Method to get data from current node
	public int getdata(){
		return data;
	}
	
	//Method to get the link to next node
	public Node getlink(){
		return next;
	}
}


// Linked list class
class Linked_List{
	
	// Declaring the start and end nodes of the linked list
	protected Node start;
	protected Node end;
	// Keeping the count of the size of the linked list
	protected int count; 
	
	public Linked_List(){
		start = null;
		end = null;
		count = 0;
	}
	
	// Method to return the size of the linked list
	public int returnsize(){
		return count;
	}
	
	//Method to check if the list is empty
	public boolean isEmpty(){
		return start == null;
	}
	
	//Method to insert element at the beginning of the linked list
	public void Insert_Beginning(int data){
		
		Node n = new Node(data, null);
		count++;
		
		if (start == null){
			start = n;
			end = start;
		}
		else{
			n.setLink(start);
			start = n;
		}
	}
	
	//Method to add the node at the end of the Linked List
	public void Insert_End(int data){
		Node n = new Node(data, null);
		count++;
		
		if (start == null){
			start = n;
			end = start;
		}
		else{
			end.setLink(n);
			end = n;
		}
	}
	
	//Method to add the element at a position in Linked List
	public void Insert_Pos(int data, int pos){
		Node n = new Node(data, null);
		
		// temp node stores the starting Node of the linked list
		Node temp = start;
		
		pos -= 1;
		for(int i = 1; i < count; i++){
			if(i == pos){
				n.setLink(temp.getlink());
				temp.setLink(n);
				break;
			}
			
			temp = temp.getlink();
		}
		count++;		
	}
	
	//Method to delete the element at a certain position
	public void Del_Pos(int pos){
		// If the node to be deleted is the beginning node
		if (pos == 1){
			start = start.getlink();
			count--;
			return;
		}
		
		// If the node to be deleted is the last node
		if (pos == count){
			
			Node s = start;
			Node t = start;
			
			while(s != end){
				t = s;
				s = s.getlink();
			}
			end = t;
			t.setLink(null);
			count--;
			return;
		}
		
		// If the node to be deleted is not the start or the end node
		pos -= 1;
		Node temp = start;
		for(int i = 1; i < count; i++){
			if (i == pos){
				Node temp1 = temp.getlink();
				temp.setLink(temp1.getlink());
				temp1 = null;
				break;
			}
			temp = temp.getlink();
		}
		count--;
	}
	
	//Method to display all the elements of the Linked List
	public void display(){
		System.out.println("Elements in the linked list are:");
		//If the liinked list is empty
		if(count == 0){
			System.out.println("Empty linked list.");
			return;
		}
		// If the Linked list has single element
		if(start.getlink() == null){
			System.out.println(start.getdata());
			return;
		}
		
		Node temp = start;
		while(temp.getlink() != null){
			System.out.print(temp.getdata()+"->");
			temp = temp.getlink();
		}
		System.out.print(temp.getdata());
	}
	
}