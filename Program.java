package practice.demo;

public class Program {
      
	public static void main(String[] args) {
		
		String s = "Neudesic is good company";
		String[] words = s.split(" ");
		String reversedString = "";
		for (int i = 0; i < words.length; i++)
	    {
	       String word = words[i]; 
	       String reverseWord = "";
	       for (int j = word.length()-1; j >= 0; j--) 
		   {		
			reverseWord = reverseWord + word.charAt(j);
		   }
		   reversedString = reversedString + reverseWord + " ";
		}
		System.out.println(reversedString);

	}

}
