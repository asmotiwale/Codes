import java.util.*;
public class PalindromeInt {
	
	//Method to find the length of a number
	public static int findLength(int x){
		int len = 1;
		while (x / 10 != 0){
			x /= 10;
			len += 1;
		}
		return len;
	}

	public static void main(String[] args){
		//Input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to check if it is palindrome or not: ");
		int x = sc.nextInt();
		sc.close();
		//Finding the length of the number
		int len = findLength(x);
		if(len ==  1){
			System.out.println("The number is palindrome.");
		}
		else{
			int count = 0;
			for(int i = 0; i < len / 2; i++){
				//Checking the first and last digit of the number
				if(x % 10 == (x / (int)Math.pow(10, len - 1 - (2 * i)))){
					//Trimming the number to remove the first and the last digit of the number
					x = x / 10;
					x = x % (int)Math.pow(10, len - 2 - (2 * i));
					count += 1;
				}
				//Break if the first and last digit does not match
				else{
					break;
				}
			}
			if (count == len / 2)
				System.out.println("The number is palindrome.");
			else
				System.out.println("The number is not palindrome");
		}
	}
}
