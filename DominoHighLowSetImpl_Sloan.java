package dominoes;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DominoHighLowSetImpl_Sloan implements Domino{

	private Set<Integer> highLowSet;

	
	//First Constructor:
	//part of pre: highPipCount >= MINIMUM_PIP_COUNT && highPipCount <= MAXIMUM_PIP_COUNT
	//part of pre: lowPipCount >= MINIMUM_PIP_COUNT && lowPipCount <= MAXIMUM_PIP_COUNT
	//part of pre: highPipCount >= lowPipCount
	//Initializing hash set and then populating it with the add function.  
	public DominoHighLowSetImpl_Sloan(int highPipCount, int lowPipCount)
	{
		assert highPipCount <= MAXIMUM_PIP_COUNT: "The highpipcount received was larger than the max pip count static variable";
		assert highPipCount >= MINIMUM_PIP_COUNT: "The highpipcount received was smaller than the min pip count static variable";
		
		assert lowPipCount <= MAXIMUM_PIP_COUNT: "The lowPipCount received was larger than the max pip count static variable";
		assert lowPipCount >= MINIMUM_PIP_COUNT: "The lowPipCount received was smaller than the min pip count static variable";
		
		assert highPipCount >= lowPipCount: "The lowPipCount received was larger than the highpipcount received";
		
		highLowSet = new HashSet<Integer>();
		highLowSet.add(highPipCount);
		highLowSet.add(lowPipCount);
	}

	public static final char SUM_DIFFERENCE_DELIMITER = ',';

	//A whole lot of error checking to make sure we receive the string in the correct format:
	public static boolean isSumDifferenceString(String str)
	{

		boolean validFormatDecider = false;

		//If string is null we are going to return false immediately
		if(str == null)
		{
			return validFormatDecider;
		}
		
		//Finding index of High Low String Seperator
		int indexOfSeperator = str.indexOf(SUM_DIFFERENCE_DELIMITER);

		if(indexOfSeperator == -1)
		{
			return validFormatDecider;
		}
		if(!((indexOfSeperator == 1) || (indexOfSeperator == 2)))
		{
			return validFormatDecider;
		}
		if(str.length() > 4 || str.length() <= 0)
		{
			return validFormatDecider;
		}

		//The plan is to split the beginning of the string into a substring, 0 - indexOf ',' and analyze it according to that
		//Creating substring:
		String indexZeroToDelimeter = str.substring(0, indexOfSeperator);

		//		str.length()-1;
		//Now I want to go from indexOfSeperator to the end of the string. The other side of the substring.
		//********How do I get to the end of the string? I know I can put make a substring end at a specific character, but I am looking for 0-6 so--
		//--I am going to make an integer array of (0-6) and try to find the index of that. ORRR I could just make a loop to the end of the string.

		//		int lastIndexHolder = 0;
		//		for(int i = 0; i < str.length(); i++)
		//		{
		//			lastIndexHolder += 1;
		//		}
		//****IS IT GOING TO STORE "LASTINDEXHOLDER" AS A 0 OR THE LENGTH OF THE STRING? HOW DO I CHECK THIS?
		//Creating substring:
		String delimiterToEnd = str.substring(indexOfSeperator + 1, str.length());

		//If indexOf High Low String seperator is not 1 then we have received an invalid format
		//^Logic from last class, but need to adjust for numbers 10-12, which is why I know include the index of 2. 
		//*********Do I need to do an index of 0 also? for cases of "NO VALUE,6"???
		//*********Also do I need 2 "!"s? --- FIXED

		

		//Previous class: Making sure the characters contain digits only
		//loop through string and if the character is not a digit then return false
		//******BAD STYLE^ HOW DO I FIX THIS? haha 

		//Looping through substring and making sure the characters are all digits
		for (int i = 0; i < indexZeroToDelimeter.length(); i++)
		{
			char ch = indexZeroToDelimeter.charAt(i);
			//^Trying to loop through string and analyze individual characters
			if(!Character.isDigit(ch))
			{
				return validFormatDecider;
			}
		}	
		//Making sure my last substring is a digit:
		char differenceCharHolder = 	delimiterToEnd.charAt(0);
		if(!Character.isDigit(differenceCharHolder))
		{
			return validFormatDecider;
		}


		//Finding the index of pip1 and pip2, BEST OPTION: NOW I AM GOING TO TAKE THE VALUES OF THE SUBSTRINGS AND CONVERT THEM TO ARRAYS OF CHARACTERS/DIGITS?
		//********Need to look back 2 indexes in order to account for numbers 10-12? Somehow check if their is a possibility of 2 characters--
		// take the 2 characters and concetanate them into a string? 
		//Convert substrings to integers with parse int function
		int sum = Integer.parseInt(indexZeroToDelimeter);
		int difference = Integer.parseInt(delimiterToEnd);


		//if we recieve a domino that has an odd sum and zero then it is incorrect format:
		int sumPlusDifference = (sum + difference);

		if(!(sumPlusDifference % 2 == 0))
		{
			return validFormatDecider;
		}


		//		int charOneIntegerLocation = indexOfSeperator -1;
		//		int charTwoIntegerLocation = indexOfSeperator +1;

		//Finding the character of pip1 and pip2 according to their indexes
		//		char charOne = str.charAt(charOneIntegerLocation);
		//		char charTwo = str.charAt(charTwoIntegerLocation);

		//Previous class:Finding the integer values of pip1 and pip2 according to the characters at this index. 
		//		Previous class:int charOneIntValue = Character.getNumericValue(charOne);
		//		Previous class:int charTwoIntValue = Character.getNumericValue(charTwo);

		//Making sure the character values of the integers are between 0 and 12
		//***********Problem is that it is more than one character, thus a string, so I need to have it stored as an integer by this time. 

//		if(sum % 2 == 1 && difference == 0)
//		{
//			return 
//		}
		//sum must be between 0 and 12, and difference must be between 0 and 6. If so then it has passed all of our tests and we are going to return a true boolean. 
		if(sum >= MINIMUM_PIP_COUNT && sum <= MAXIMUM_PIP_COUNT * 2 && difference >= 0 && difference <= MAXIMUM_PIP_COUNT)
		{
			validFormatDecider = true;
		}

		return validFormatDecider;
	}
	//********How do I inherit the code from above?? So that I don't have to write it all out again?
	//Exact same train of thought as code above, but this time we are going to perform the constructors function and initialize a hash set and populate it with the pips. 
	//part of pre: isSumDifferenceString(sumDifferenceString) == true
		public DominoHighLowSetImpl_Sloan(String sumDifferenceString)
		{
			assert isSumDifferenceString(sumDifferenceString): "The sumDifferenceString passed in was out of parameters";
			
			int pipOne = 0;
			int pipTwo = 0;
//			if(isSumDifferenceString(sumDifferenceString) == true)
//			{
			int indexOfSeperator = sumDifferenceString.indexOf(SUM_DIFFERENCE_DELIMITER);
			String indexZeroToDelimeter = sumDifferenceString.substring(0, indexOfSeperator);
			String delimiterToEnd = sumDifferenceString.substring(indexOfSeperator + 1, sumDifferenceString.length());
			int sum = Integer.parseInt(indexZeroToDelimeter);
			int difference = Integer.parseInt(delimiterToEnd);
			
			
				pipOne = (sum + difference)/2;
				pipTwo = ((sum + difference)/2) - difference;
				
				highLowSet = new HashSet<Integer>();
				highLowSet.add(pipOne);
				highLowSet.add(pipTwo);
//			}
			//if we did not receive the correct format by our helper method above we are going to return a print statement of the innaplicability of the string received. Then we are going to return 
			// the string that was entered so we can check the behavior of these methods. 
//			else
//			{
//				System.out.println("There is no real domino for the sumDifference string sent in " + sumDifferenceString);
//			}
			
			//add pip one and pip two to set
		}
		
		
		//********DO I INTIALIZE THE SET WITH THE ADD FUNCTION?
	
		//The highest value the integer can be from k = low + 8high is 54, and the smallest it can be is 0. Because the largest domino is 6,6 and the smallest is 0,0
		//k/8 in integer division is the high. Thus, k%8 is the low. 
		//Error checking to make sure the high and low are within the paramaters of the 6, 6 and 0,0 domino range. 
		
		public static boolean isLowPlus8TimesHighInteger(int k)
		{
			boolean correctIntegerTest = false;
            //test that number is in range
            
            if(k > 54 || k < 0) 
            {
                return correctIntegerTest;
            }
            //testers for invalid numbers inside range
            else if (k >= 1 && k <=7)
            {
            	return correctIntegerTest;
            }
            else if (k >= 10 && k <=15)
            {
            	return correctIntegerTest;
            }
            else if (k >=  19 && k <=23)
            {
            	return correctIntegerTest;
            }
            else if (k >= 28 && k <= 31)
            {
            	return correctIntegerTest;
            }
            else if (k >= 37 && k <= 39)
            {
            	return correctIntegerTest;
            }
            else if (k >= 46 && k <=47)
            {
            	return correctIntegerTest;
            }
            else
            {
            	correctIntegerTest = true;
            }
            return correctIntegerTest;
//			boolean validFormatDecider = false;
//			if(k > 54 || k<0)
//			{
//				return validFormatDecider;
//			}
//			else if(k/8 > 6 || k/8 < 0)
//			{
//				return validFormatDecider;
//			}
//			else if(k % 8 > 6 || k % 8 < 0)
//			{
//				return validFormatDecider;
//			}
//			else if(k % 8 >= 7 || k % 8 > k/8)
//			{
//				return validFormatDecider;
//			}
//			else
//			{
//				validFormatDecider = true;
//			}
//			return validFormatDecider;
			
		}
	//Same as this methods helper method above, but we initialize and populate the set. 
		//part of pre: isLowPlus8TimesHighInteger(lowPlus8TimesHigh) == true; 
		public DominoHighLowSetImpl_Sloan(int lowPlus8TimesHigh)
		{
			assert isLowPlus8TimesHighInteger(lowPlus8TimesHigh): "The lowPlus8TimesHigh integer passed in was out of parameters";
			
			int low = 0;
			int high = 0;
//			if(isLowPlus8TimesHighInteger(lowPlus8TimesHigh)== true)
//			{
				low = lowPlus8TimesHigh % 8;
				high = lowPlus8TimesHigh/8;
//			}
			
			highLowSet = new HashSet<Integer>();
			highLowSet.add(low);
			highLowSet.add(high);
			
		}


	//******IS USING THE ITERATOR THE CORRECT WAY TO FIND THE HIGH AND LOW VALUES? - YES
		//Iterate through set with iterator and use iterate functions from the java api. Populate the highpcount and return highpipcount. 
		public int getHighPipCount() 
		{
			int highPipCount =0;

			Iterator<Integer> iterateBadBoy = highLowSet.iterator();
			int valOne = iterateBadBoy.next();
			if(!iterateBadBoy.hasNext())
			{
				highPipCount = valOne;
				return highPipCount;
			}
			else
			{
				int valTwo = iterateBadBoy.next();

				//BELOW: ********SHOULD I PERFORM THE HASNEXT() WITH IF STATEMENT OR WHILE LOOP??
				//******HOW DO I ASSIGN THE HIGHPIPCOUNT AND LOWPIPCOUNT IF I DO NOT HAVE PRIVATE VARIABLES IN THIS --
				//---- CLASS TO INITIALIZE?
				if(valOne <= valTwo)
				{
					highPipCount += valTwo;
				}
				if(valOne > valTwo)
				{
					highPipCount += valOne;
				}
				if(valOne == valTwo)
				{
					highPipCount += valOne;
				}
			}

			return highPipCount;
		}
		//if has next, since there is 2 choices



		//BELOW: Modified getMaximum() from previous challenge
		//		while(iterateBadBoy.hasNext())
		//		{
		//			int valTwo = iterateBadBoy.next();
		//			if(valOne <= valTwo)
		//			{
		////				int valOneHolder = valOne;
		//				
		//				valOne = valTwo;
		//				highPipCount = valOne;
		//				lowPipCount = valOneHolder;
		//			}
		//		}
		

		//Iterate through set with iterator and use iterate functions from the java api. Populate the lowpcount and return lowpipcount. 
		public int getLowPipCount() 
		{
			int lowPipCount = 0;
			Iterator<Integer> iterateBadBoy = highLowSet.iterator();
			int valOne = iterateBadBoy.next();

			if(!iterateBadBoy.hasNext())
			{
				lowPipCount = valOne;
				return lowPipCount;
			}
			else
			{
				int valTwo = iterateBadBoy.next();
				if(valOne < valTwo)
				{
					lowPipCount = valOne;
				}
				if(valOne > valTwo)
				{
					lowPipCount = valTwo;
				}
				if(valOne == valTwo)
				{
					lowPipCount = valOne;
				}
			}

			return lowPipCount;

		}
		
	
	//GET LOW PIP COUNT RUN #1:
//	Iterator<Integer> iterateBadBoy = highLowSet.iterator();
//	int valOne = iterateBadBoy.next();
//	int valTwo = iterateBadBoy.next();
//	
//	while(iterateBadBoy.hasNext())
//	{
//		if(valOne < valTwo)
//		{
//			valOne = lowPipCount;
//		}
//		if(valOne > valTwo)
//		{
//			valTwo = lowPipCount;
//		}
//	}
//	return lowPipCount;
		
//		int highPipCount =0;
//		int lowPipCount = 0;
//		Iterator<Integer> iterateBadBoy = highLowSet.iterator();
//		int valOne = iterateBadBoy.next();
//		while(iterateBadBoy.hasNext())
//		{
//			int valTwo = iterateBadBoy.next();
//			if(valOne <= valTwo)
//			{
//				int valOneHolder = valOne;
//
//				valOne = valTwo;
//				highPipCount = valOne;
//				lowPipCount = valOneHolder;
//			}
//		}
}

