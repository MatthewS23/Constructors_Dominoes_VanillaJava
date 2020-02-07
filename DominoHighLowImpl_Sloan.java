package dominoes;
import java.util.Iterator;
import java.util.Set;

public class DominoHighLowImpl_Sloan implements Domino{

	private int highPipCount; 
	private int lowPipCount; 
	
	public static void main(String[]args)
	{
//		Domino domino = new DominoHighLowImpl_Sloan(6, 1);
//		System.out.println("Hi");
	
	}

	//getter
	public int getHighPipCount()
	{
		return this.highPipCount;
	}
	//getter
	public int getLowPipCount()
	{
		return this.lowPipCount;
	}
	//Initial Constructor
	
	
	
	//part of pre: highPipCount >= MINIMUM_PIP_COUNT && highPipCount <= MAXIMUM_PIP_COUNT
	//part of pre: lowPipCount >= MINIMUM_PIP_COUNT && lowPipCount <= MAXIMUM_PIP_COUNT
	//part of pre: highPipCount >= lowPipCount
	public DominoHighLowImpl_Sloan (int highPipCount, int lowPipCount)
	{
		assert highPipCount <= MAXIMUM_PIP_COUNT: "The highpipcount received was larger than the max pip count static variable";
		assert highPipCount >= MINIMUM_PIP_COUNT: "The highpipcount received was smaller than the min pip count static variable";
		
		assert lowPipCount <= MAXIMUM_PIP_COUNT: "The lowPipCount received was larger than the max pip count static variable";
		assert lowPipCount >= MINIMUM_PIP_COUNT: "The lowPipCount received was smaller than the min pip count static variable";
		
		assert highPipCount >= lowPipCount: "The lowPipCount received was larger than the highpipcount received";
		
		this.highPipCount = highPipCount;
		this.lowPipCount = lowPipCount;
	}
	
	// length must be 3 and the high low string seperator must be at index 1
	public static final char HIGH_LOW_STRING_SEPERATOR = ':';
	//Error Checking to make sure I am receiving the correct string format for str
	//part of pre: nothing
	public static boolean isHighLowString(String str)
	{
		boolean validFormatDecider = false;
	//If string is null we are going to return false immediately
		if(str == null)
		{
			return validFormatDecider;
		}
		
		//Finding index of High Low String Seperator
		int indexOfSeperator = str.indexOf(HIGH_LOW_STRING_SEPERATOR);
		
		//If indexOf High Low String seperator is not 1 then we have received an invalid format
		if(!(indexOfSeperator == 1))
		{
			return validFormatDecider;
		}
		
		//Finding the index of pip1 and pip2
		int charOneIntegerLocation = indexOfSeperator -1;
		int charTwoIntegerLocation = indexOfSeperator +1;
		
		//Finding the character of pip1 and pip2 according to their indexes
		char charOne = str.charAt(charOneIntegerLocation);
		char charTwo = str.charAt(charTwoIntegerLocation);
		
		//Making sure the characters contain digits
		if(!Character.isDigit(charOne))
		{
			return validFormatDecider;
		}
		if(!Character.isDigit(charTwo))
		{
			return validFormatDecider;
		}

		//Finding the integer values of pip1 and pip2 according to the characters at this index. 
		int charOneIntValue = Character.getNumericValue(charOne);
		int charTwoIntValue = Character.getNumericValue(charTwo);
		
		if(charOneIntValue < charTwoIntValue)
		{
			return validFormatDecider;
		}
		//Making sure the character values of the integers are between 0 and 6
		if(charOneIntValue >= MINIMUM_PIP_COUNT && charOneIntValue <=MAXIMUM_PIP_COUNT && charTwoIntValue >= MINIMUM_PIP_COUNT && charTwoIntValue <=MAXIMUM_PIP_COUNT)
		{
			validFormatDecider = true;
		}
		return validFormatDecider;
		
	}
	
	//part of pre: isHighLowString(highLowString) == false
	public DominoHighLowImpl_Sloan(String highLowString)
	{
		//***** How do I take the code above and use it within this method without rewriting all of the code?
		
		assert isHighLowString(highLowString): "The highLowString domino provided did not meet conditions of boolean helper method";
		
//		if(DominoHighLowImpl_Sloan.isHighLowString(highLowString) == true)
//		{
			//Finding index of High Low String Seperator
			int indexOfSeperator = highLowString.indexOf(HIGH_LOW_STRING_SEPERATOR);
			
			//Finding the index of pip1 and pip2
			int charOneIntegerLocation = indexOfSeperator -1;
			int charTwoIntegerLocation = indexOfSeperator +1;
			
			//Finding the character of pip1 and pip2 according to their indexes
			char charOne = highLowString.charAt(charOneIntegerLocation);
			char charTwo = highLowString.charAt(charTwoIntegerLocation);
			
			//Finding the integer values of pip1 and pip2 according to the characters at this index. 
			int charOneIntValue = Character.getNumericValue(charOne);
			int charTwoIntValue = Character.getNumericValue(charTwo);
			
			//Evaluating which value of the pips is larger/smaller
			if(charOneIntValue > charTwoIntValue)
			{
				highPipCount = charOneIntValue;
				lowPipCount = charTwoIntValue;
			}
			if(charOneIntValue < charTwoIntValue)
			{
				highPipCount = charTwoIntValue;
				lowPipCount = charOneIntValue;
			}
			if(charOneIntValue == charTwoIntValue)
			{
				highPipCount = charTwoIntValue;
				highPipCount = charOneIntValue;
				lowPipCount = charOneIntValue;
				lowPipCount = charTwoIntValue;
			}
			
//		}
		//Testing:
//		System.out.println("From Constructor 1: This is the high pip count:" + this.getHighPipCount());
//		System.out.println("From Constructor 1: This is the low pip count:" + this.getLowPipCount());
		
		//************HOW DO I TEST A CONSTRUCTOR?
	}
	
	
	public static final int INDEX_OF_SUM = 0; 
	public static final int INDEX_OF_DIFFERENCE = 1;
	
	
	//part of pre: !sumDifference.contains(null) //CHECK THIS LATER
	//part of pre: sumDifference.length() == 2
	//part of pre: sumDifference[INDEX_OF_SUM] >= MINIMUM_PIP_COUNT && sumDifference[INDEX_OF_SUM] <= MAXIMUM_PIP_COUNT * 2
	//part of pre: sumDifference[INDEX_OF_DIFFERENCE] >= MINIMUM_PIP_COUNT && sumDifference[INDEX_OF_DIFFERENCE] <=  MAXIMUM_PIP_COUNT
	//part of pre: sumDifference[INDEX_OF_SUM] > sumDifference[INDEX_OF_DIFFERENCE]
	public DominoHighLowImpl_Sloan(int[] sumDifference)
	{
		
		assert sumDifference.length == 2: "The array of integers was not the correct length";
		assert sumDifference[INDEX_OF_SUM] >= MINIMUM_PIP_COUNT && sumDifference[INDEX_OF_SUM] <= MAXIMUM_PIP_COUNT * 2: "The sum was either too small, below zero, or too big, and above 12";
		assert sumDifference[INDEX_OF_DIFFERENCE] >= MINIMUM_PIP_COUNT && sumDifference[INDEX_OF_DIFFERENCE] <= MAXIMUM_PIP_COUNT:"The difference was either too small, below zero, or too big, above 6";
		assert sumDifference[INDEX_OF_SUM] >= sumDifference[INDEX_OF_DIFFERENCE]: "The difference was larger than the sum";
//		assert (sumDifference[INDEX_OF_SUM] + sumDifference[INDEX_OF_DIFFERENCE]) % 2 == 0: "There are 3 types of people in the world - those who understand tertiary, those who don't, and those who thought this was a binary joke";
		assert sumDifference[INDEX_OF_SUM] % 2 == sumDifference[INDEX_OF_DIFFERENCE] % 2: "There are 3 types of people in the world - those who understand tertiary, those who don't, and those who thought this was a binary joke"; 	
		//storing the sum and difference so that I can manipulate them algebraically 
		int sumDomino =sumDifference[INDEX_OF_SUM];
		int differenceDomino =sumDifference[INDEX_OF_DIFFERENCE];
		//algebraic manipulation:
		int pipOne = (differenceDomino + sumDomino)/2;
		int pipTwo = ((differenceDomino + sumDomino)/2) - differenceDomino;
		//Assigning high and low pip counts with conditional statements
		if(pipOne > pipTwo)
		{
			highPipCount = pipOne;
			lowPipCount = pipTwo;
		}
		if(pipOne < pipTwo)
		{
			lowPipCount = pipOne;
			highPipCount = pipTwo;
		}
		if(pipOne == pipTwo)
		{
			lowPipCount = pipOne;
			highPipCount = pipOne;
		}
		//testing:
//		System.out.println("From Constructor 2: This is the high pip count:" + this.getHighPipCount());
//		System.out.println("From Constructor 2: This is the low pip count:" + this.getLowPipCount());
	}
	
	
	//Iterating over set of integers using the iterator function for sets, and storing values using .next. 
	//Then Comparing them with conditional statements; assigning the low and high pip counts accordingly. 
	//part of pre: !highLowSet.contains(null)
	//part of pre: highLowSet.size() > 0 && highLowSet.size() <= 2
	//part of pre:largestPip <= MAXIMUM_PIP_COUNT:"Pip is out of range";
	//part of pre:largestPip >= MINIMUM_PIP_COUNT:"Pip is out of range";
	//part of pre:lowestPip >= MINIMUM_PIP_COUNT:"Pip is out of range";
	//part of pre:lowestPip >= MINIMUM_PIP_COUNT:"Pip is out of range";
	//part of pre:largestPip >= lowestPip: "high pip is less than low pip";
	public DominoHighLowImpl_Sloan(Set<Integer> highLowSet)
	{
		assert !highLowSet.contains(null): "The set contains null";
		assert highLowSet.size() > 0: "The set was empty";
		assert highLowSet.size() <= 2: "The set was too big and had a size bigger than 2";
		
		int largestPip = dominoUtils_Sloan.getLargestValue(highLowSet);
		int lowestPip = dominoUtils_Sloan.getSmallestValue(highLowSet);
		
		assert largestPip <= MAXIMUM_PIP_COUNT:"Pip is out of range";
		assert largestPip >= MINIMUM_PIP_COUNT:"Pip is out of range";
		assert lowestPip <= MAXIMUM_PIP_COUNT:"Pip is out of range";
		assert lowestPip >= MINIMUM_PIP_COUNT:"Pip is out of range";
		assert largestPip >= lowestPip: "high pip is less than low pip";
		

		highPipCount = largestPip;
		lowPipCount = lowestPip;
	}
	
	//Reversing equations on the data received. For example: highPipCountDivisionBy2Quotient * 2. Then storing the reversed data in 2 different variables. Due to integer division rounding--->
	//----down on the quotient there are 2 different possible answers. We then mod both of those values against three and compare that answer to the highPipCountDivisionBy3Remainder integer received---->
	//----in order to distinguish the correct possible answer of the 2 possible values. This process is completed for the high and low pip counts. 
	
	//part of pre: (MINIMUM_PIP_COUNT/2) <= highPipCountDivisionBy2Quotient <= (MAXIMUM_PIP_COUNT/2) 
	//part of pre: 0 <= highPipCountDivisionby3Remainder < 3
	//part of pre: (MINIMUM_PIP_COUNT/2) <= lowPipCountDivisionBy2Quotient <= (MAXIMUM_PIP_COUNT/2)
	//part of pre: 0 <= lowPipCountDivisionBy3Remainder < 3
	public DominoHighLowImpl_Sloan(int highPipCountDivisionBy2Quotient, int highPipCountDivisionBy3Remainder, int lowPipCountDivisionBy2Quotient, int lowPipCountDivisionBy3Remainder)
	{
		
		assert (MINIMUM_PIP_COUNT/2) <= highPipCountDivisionBy2Quotient:"Not a domino";
		assert highPipCountDivisionBy2Quotient <= (MAXIMUM_PIP_COUNT/2):"Not a domino";
		assert  highPipCountDivisionBy3Remainder >= 0:"Not a domino";
		assert  highPipCountDivisionBy3Remainder < 3:"Not a domino";
		assert (MINIMUM_PIP_COUNT/2) <= lowPipCountDivisionBy2Quotient:"Not a domino";
		assert lowPipCountDivisionBy2Quotient <= (MAXIMUM_PIP_COUNT/2):"Not a domino";
		assert lowPipCountDivisionBy3Remainder >= 0:"Not a domino";
		assert lowPipCountDivisionBy3Remainder < 3:"Not a domino";
		
		if(highPipCountDivisionBy2Quotient == 3)
		{
			assert highPipCountDivisionBy3Remainder == 0;
		}
		if(lowPipCountDivisionBy2Quotient == 3)
		{
			assert lowPipCountDivisionBy3Remainder == 0;
		}
		
		if(highPipCountDivisionBy2Quotient == 0)
		{
			assert (highPipCountDivisionBy3Remainder == 0 || highPipCountDivisionBy3Remainder == 1);
		}
		if(lowPipCountDivisionBy2Quotient == 0)
		{
			assert (lowPipCountDivisionBy3Remainder == 0 || lowPipCountDivisionBy3Remainder == 1);
		}
		
		if(highPipCountDivisionBy2Quotient == 1)
		{
			assert (highPipCountDivisionBy3Remainder == 2 || highPipCountDivisionBy3Remainder == 0);
		}
		if(lowPipCountDivisionBy2Quotient == 1)
		{
			assert (lowPipCountDivisionBy3Remainder == 2 || lowPipCountDivisionBy3Remainder == 0);
		}
		if(highPipCountDivisionBy2Quotient == 2)
		{
			assert (highPipCountDivisionBy3Remainder == 1 || highPipCountDivisionBy3Remainder == 2);
		}
		if(lowPipCountDivisionBy2Quotient == 2)
		{
			assert (lowPipCountDivisionBy3Remainder == 1 || lowPipCountDivisionBy3Remainder == 2);
		}
		
		
		int integerDivisionLowPossibility = highPipCountDivisionBy2Quotient * 2;
		int integerDivisionHighPossibility = (highPipCountDivisionBy2Quotient * 2) + 1;
		int highPipCountHolder = 0;
		if(integerDivisionLowPossibility % 3 == highPipCountDivisionBy3Remainder)
		{
			highPipCountHolder = integerDivisionLowPossibility;
		}
		if(integerDivisionHighPossibility % 3 == highPipCountDivisionBy3Remainder)
		{
			highPipCountHolder = integerDivisionHighPossibility;
		}
		
		int integerDivisionLowPossibility2 = lowPipCountDivisionBy2Quotient * 2;
		int integerDivisionHighPossibility2 = (lowPipCountDivisionBy2Quotient * 2) + 1;
		int lowPipCountHolder = 0;
		if(integerDivisionLowPossibility2 % 3 == lowPipCountDivisionBy3Remainder)
		{
			lowPipCountHolder = integerDivisionLowPossibility2;
		}
		if(integerDivisionHighPossibility2 % 3 == lowPipCountDivisionBy3Remainder)
		{
			lowPipCountHolder = integerDivisionHighPossibility2;
		}
		
		highPipCount = highPipCountHolder;
		lowPipCount = lowPipCountHolder;
		
		
	}
	
	
	
	
	
	
}

	
	


