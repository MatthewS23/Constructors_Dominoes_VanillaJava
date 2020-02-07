package dominoes;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class testCase_Sloan {

	public static void main(String[]args)
	{
//		test_isHighLowString();
//		test_isSumDifferenceString();
//		test_isLowPlus8TimesHighInteger();
		
		//Constructor 1 Test:
//		Domino domino = new DominoHighLowImpl_Sloan("6:1");
//		System.out.println("This is the high pip count:" + domino.getHighPipCount());

		//Constructor 2 Test:
		int[] sumDifference = new int[2];
		sumDifference[0] = 6;
		sumDifference[1] = 1;
		Domino domino2 = new DominoHighLowImpl_Sloan(sumDifference);
		System.out.println("This is the high pip count for sumDifference:" + domino2.getHighPipCount());
		
		//Constructor 3 Test: 
		int hP = 1;
//		int lP = 2;
		Set<Integer> highLowSet = new HashSet<Integer>();
		highLowSet.add(hP);
//		highLowSet.add(lP);
		Domino domino3 = new DominoHighLowImpl_Sloan(highLowSet);
//		System.out.println("This is the high pip count:" + domino3.getHighPipCount());
		
		
		//Testing concepts for Class 2: 
		
		String testSubString = "Matthew";
		String testSubStringWithDelim = "10,2";
		String mToH = testSubString.substring(0, 5);
		String delimToEnd = testSubStringWithDelim.substring(3, 4);
		char chONe = delimToEnd.charAt(0);
		String zeroToDelim = testSubStringWithDelim.substring(0, 2);
//		System.out.println(mToH);
//		System.out.println(chONe);
//		System.out.println(zeroToDelim);
//		System.out.println(zeroToDelim);
		
		//Testing parseInt
		
		String strTest = "2468";
		String indexZeroToDelimeterTest = strTest.substring(0, 2);
		int parseTest = Integer.parseInt(indexZeroToDelimeterTest);
//		System.out.println(parseTest);
		
		int k = 45;
		int m = k/8;
//		System.out.println(m);
		int z = k % 8;
//		System.out.println(z);
		
		
		//Testing Class 2 getters:
		
		Domino domino22 = new DominoHighLowSetImpl_Sloan(0,6);
//		System.out.println("This is the high pip count:" + domino22.getHighPipCount());
//		System.out.println("This is the low pip count:" + domino22.getLowPipCount());
		//***********Getter breaks on domino with the same pips 
		
		
		//checking behavior of set.next() function
		Set<Integer> highLowSetTest;
		highLowSetTest = new HashSet<Integer>();
		highLowSetTest.add(1);
		highLowSetTest.add(3);
		
		Iterator<Integer> iterateBadBoy1 = highLowSetTest.iterator();
		int valOne = iterateBadBoy1.next();
		int valTwo = iterateBadBoy1.next();
//		System.out.println(valOne);
//		System.out.println(valTwo);
		
		//testing class 2 sumDifference for data type string
		Domino domino23 = new DominoHighLowSetImpl_Sloan("8,4");
		Domino domino24 = new DominoHighLowSetImpl_Sloan("0,0");
//		Domino domino25 = new DominoHighLowSetImpl_Sloan("5,0");
//		Domino domino26 = new DominoHighLowSetImpl_Sloan("Hello");
//		System.out.println("This is the high pip count:" + domino24.getHighPipCount());
//		System.out.println("This is the low pip count:" + domino24.getLowPipCount());
//		System.out.println("This is the high pip count:" + domino26.getHighPipCount());
//		System.out.println("This is the low pip count:" + domino26.getLowPipCount());
		
		
		
//		Domino domino26 = new DominoHighLowSetImpl_Sloan(44);
//		System.out.println("This is the high pip count:" + domino26.getHighPipCount());
//		System.out.println("This is the low pip count:" + domino26.getLowPipCount());
		
		//Checking the behavior of adding "+=" to a string
		
		
		String temp = "";
		int low = 5;
		char delim = '*';
		int high = 6;
		int difference = 1;
		temp += difference;
		temp += delim;
		temp+= low;
//		System.out.println("This is the temp string:" + temp);
		
		
		
		//Testing boolean function class 3: 
		Domino domino30 = new DominoLowDifferenceStringImpl_Sloan(44);
//		System.out.println("This is the high pip count:" + domino30.getHighPipCount());
		
		
		String indeTest = "Hello";
		char tesTer = indeTest.charAt(2);
//		System.out.println(tesTer);
	}
	
	
	private static void test_isHighLowString()
	{
		String test1 = "6:1";
		assert DominoHighLowImpl_Sloan.isHighLowString(test1) == true;
		String test2 = "9:1";
		assert DominoHighLowImpl_Sloan.isHighLowString(test2) == false;
		String test3 = "x:1";
		assert DominoHighLowImpl_Sloan.isHighLowString(test3) == false;
		//will also send empty string - any string really, and null 
		
		assert (DominoHighLowImpl_Sloan.isHighLowString(test1)== true);
		
	}

	private static void test_isSumDifferenceString()
	{
		//Code runs well with individual characters and comma. But code does not run well with numbers of 10 or bigger
		String test1 = "10,2";
		assert DominoHighLowSetImpl_Sloan.isSumDifferenceString(test1) == true;
		String test2 = "13,2";
		assert DominoHighLowSetImpl_Sloan.isSumDifferenceString(test2) == false;
		String test3 = "12,,2";
		assert DominoHighLowSetImpl_Sloan.isSumDifferenceString(test3) == false;
		String test4 = "12,12";
		assert DominoHighLowSetImpl_Sloan.isSumDifferenceString(test4) == false;
		String test5 = "x,1";
		assert DominoHighLowSetImpl_Sloan.isSumDifferenceString(test5) == false;
		String test6 = "0,0";
		assert DominoHighLowSetImpl_Sloan.isSumDifferenceString(test6) == true;
		String test7 = "100,0";
		assert DominoHighLowSetImpl_Sloan.isSumDifferenceString(test7) == false;
	}
	
	private static void test_isLowPlus8TimesHighInteger()
	{
		int test1 = 44;
		assert DominoHighLowSetImpl_Sloan.isLowPlus8TimesHighInteger(test1) == true;
		int test2 = 55;
		assert DominoHighLowSetImpl_Sloan.isLowPlus8TimesHighInteger(test2) == false;
//		int test3 = 37;
//		assert DominoHighLowSetImpl_Sloan.isLowPlus8TimesHighInteger(test3) == true: "37 does not correspond to a domino";
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

