public class AnagramAllAscii {
	
	private static boolean checkEqual(int[] textArr, int[] patternArr){
		for(int i = 0; i < textArr.length; i++){
			if(textArr[i] != patternArr[i]){
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean searchAnagramSubstring(String text, String pattern){
		boolean result = false;
		int textLen = text.length();
		int patternLen = pattern.length();
		
		if(textLen < patternLen | patternLen == 0 | textLen == 0){
			return result;
		}
			
		//taking 256 size array only to cover all ascii values....
		//If there is a case for only alphabets, then we can use 26 elements 
		int textArr[] = new int[256];
		int patternArr[] = new int[256];
		
		//initialize the array with the elements with pattern length... starting from 0
		int i = 0;
		for(i = 0; i < patternLen; i++){
			patternArr[pattern.charAt(i)]++;
			textArr[text.charAt(i)]++;
		}
	
		//search the pattern in a sliding window of text 
		while(i < textLen){
			//O(1) time check as array size is constant
			if(checkEqual(textArr, patternArr)){
				result=true;
				break;
			}
			
			//slide the text window by 1 position to the right and check for anagram
			textArr[text.charAt(i)]++;
			textArr[text.charAt(i-patternLen)]--;
			
			i++;
		} 
		
		// Check for the last window in text
		if(!result && checkEqual(textArr, patternArr)){
			result=true;
		}
		
		return result;
	}
	
	

	public static void main(String[] args) {
		
		//Considering all ascii values. Input values are Case sensitive. 
		String s="Google";
		String t="Goo";
		
		if(searchAnagramSubstring(s,t))
			System.out.println("True");
		else
			System.out.println("False");
		
	}

}
