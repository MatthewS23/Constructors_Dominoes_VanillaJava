package dominoes;

import java.util.Iterator;
import java.util.Set;

public class dominoUtils_Sloan {


	public static int getLargestValue(Set<Integer> numberSet)
	{
		Iterator<Integer> iterateBadBoy =numberSet.iterator();
		int valOne = iterateBadBoy.next();
		
		while(iterateBadBoy.hasNext())
		{
			int valTwo = iterateBadBoy.next();
			//			int valTwo = iterateBadBoy.next();
			if( valOne <= valTwo)
			{
				valOne =  valTwo;
				//				int valOneHolder = valOne;
				//				
				//				valOne = valTwo;

			}
		}
		return valOne;

	}
	
	
	public static int getSmallestValue(Set<Integer> numberSet)
	{
		Iterator<Integer> iterateBadBoy2 =numberSet.iterator();
		
		int valOne = iterateBadBoy2.next();
		while(iterateBadBoy2.hasNext())
		{
			int valTwo = iterateBadBoy2.next();
			if(valOne >= valTwo)
			{
				valOne =  valTwo;
			}
		}
		return valOne;

	}


	
	
	
	
	
	
	
	
	
}
