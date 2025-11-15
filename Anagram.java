/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Ld Voldemort")); // false

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(randomAnagram("hello"));
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		int i = 0;
		int count2 = 0;
		boolean ifExists = true; 
		String newStr1 = preProcess(str1);
		String newStr2 = preProcess(str2);
		int count1 = newStr1.length();

		if((int) newStr1.length() != (int) newStr2.length()){
			ifExists = false;
		}

		while (i < count1) {
			char strChar = newStr1.charAt(i);
			if(newStr2.indexOf(strChar) != -1){
				i++;
				count2++;
			}

			else{
				i = count1;
				ifExists = false;
			}
			}
			
			if(count1 != count2){
				ifExists = false;
		}
		return ifExists;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String lowerStr = str.toLowerCase();
		String noSpace = lowerStr.replace(" ","");
		String noMark = noSpace.replace("!","");
		String noQMark = noMark.replace("?","");

		return noQMark;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String processedStr = preProcess(str);
		int i = 0;
		String newstr = "";

		while(i < processedStr.length()){
			int j = (int)(Math.random() * processedStr.length());
			char letter = processedStr.charAt(j);
			newstr += letter;
			processedStr = processedStr.substring(0, j) + processedStr.substring(j + 1);
		}
		return newstr;
	}
}
