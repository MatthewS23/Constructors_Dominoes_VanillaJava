package dominoes;
import java.util.List;
import java.util.Set;

public class DominoLowDifferenceStringImpl_Sloan implements Domino{
	
	private String lowDifferenceString;
	
	private static final char LOW_DIFFERENCE_DELIMITER = '*';
	
//	public static boolean isLowPlus8TimesHighInteger(int k)
//	{
//		int low = k % 8;
//		int high = k/8;
//		boolean validFormatDecider = false;
//		if(k > 54 || k<0)
//		{
//			return validFormatDecider;
//		}
//		else if(high > 6 || high < 0)
//		{
//			
//			return validFormatDecider;
//		}
//		else if(low > 6 || low < 0)
//		{
//			return validFormatDecider;
//		}
//		else if(low > high)
//		{
//			return validFormatDecider;
//		}
//		else
//		{
//			validFormatDecider = true;
//		}
//		return validFormatDecider;
//		
//	}
	
	//algebraic manipulation of integer received, as described in previous class using division and modding. 
	//populate string accordingly with += low, DELIMITER, difference. 
	//part of pre: DominoLowDifferenceStringImpl_Sloan.isLowPlus8TimesHighInteger(lowPlus8TimesHigh) == true
	public DominoLowDifferenceStringImpl_Sloan(int lowPlus8TimesHigh)
	{
		assert DominoHighLowSetImpl_Sloan.isLowPlus8TimesHighInteger(lowPlus8TimesHigh): "Received an integer that was not able to be converted to a domino from the formula lowPlus8TimesHigh";
		String temp = "";
		int low = 0;
		int high = 0;
		int difference = 0;
//		if(isLowPlus8TimesHighInteger(lowPlus8TimesHigh)== true)
//		{
			low = lowPlus8TimesHigh % 8;
			high = lowPlus8TimesHigh/8;
			difference = high - low;
			temp+= low;
			temp += LOW_DIFFERENCE_DELIMITER;
			temp += difference;
			
//		}
		lowDifferenceString = temp;
	}
	
	public static final int INDEX_OF_HIGH = 0;
	public static final int INDEX_OF_SUM = 1;
	//Due to knowing the indexes and what the values represent we are able to go directly to their indexes and then perform algebraic manipulation to find the low and difference
	//Then we populate our string above accordingly. Algrbraic manipulation and string populating consolidated into one line. 
	//part of pre: !highSum.contains(null)
	//part of pre: highSum.size() == 2
	//part of pre: sumOfPips - highNumber <= highNumber

	public DominoLowDifferenceStringImpl_Sloan(List<Integer> highSum)
	{
		assert !highSum.contains(null):"The list contained Null";
		assert highSum.size() == 2:"the list did not have a size of 2";
		
		int sumOfPips = highSum.get(INDEX_OF_SUM);
		int highNumber = highSum.get(INDEX_OF_HIGH);
		int lowPips = sumOfPips - highNumber;
		assert lowPips >= MINIMUM_PIP_COUNT:"Smallest pip count was below the minimum pip count";
		assert highNumber <= MAXIMUM_PIP_COUNT:"Highest pip count was above the maximum pip count";
		assert highNumber >= MINIMUM_PIP_COUNT:"Highest pip count was below the minimum pip count";
		
		assert lowPips <= highNumber:"The lowest pip was larger than the highest pip";
		
		this.lowDifferenceString = "" + (lowPips) + LOW_DIFFERENCE_DELIMITER + (highNumber -(lowPips));
		
	}
//same train of thought as previous class substrings. 
	//find index of delimiter. Take substring from 0 to index of the delimiter. Another substring from index of delim+1(in order to not include the delim I use +1) to the end of string(the length). 
	//parse int the substrings in order to change their data type to integer. Add the difference to the low to get the highpipcount and then return highpipcount. 
	public int getHighPipCount() 
	{
		int indexOfDelimiter = lowDifferenceString.indexOf(LOW_DIFFERENCE_DELIMITER);
		String indexZeroToDelimeter = lowDifferenceString.substring(0, indexOfDelimiter);
		String delimiterToEnd = lowDifferenceString.substring(indexOfDelimiter + 1, lowDifferenceString.length());
		int low = Integer.parseInt(indexZeroToDelimeter);
	    int difference = Integer.parseInt(delimiterToEnd);
	    int highPipCount = difference + low;
	    return highPipCount;
	}
	//same train of thought as previous class substrings. 
		//find index of delimiter. Take substring from 0 to index of the delimiter. Another substring from index of delim+1(in order to not include the delim I use +1) to the end of string(the length). 
		//parse int the substrings in order to change their data type to integer.  Return lowpipcount. 
	public int getLowPipCount() 
	{
		int indexOfDelimiter = lowDifferenceString.indexOf(LOW_DIFFERENCE_DELIMITER);
		String indexZeroToDelimeter = lowDifferenceString.substring(0, indexOfDelimiter);
		String delimiterToEnd = lowDifferenceString.substring(indexOfDelimiter + 1, lowDifferenceString.length());
		int low = Integer.parseInt(indexZeroToDelimeter);
//	    int difference = Integer.parseInt(delimiterToEnd);
//	    int high = difference + low;
//	    int lowPipCount = low;
	    return low;
	}
	

}

