public class IntSearch {

	/**
	* Matches object that represents where and how often the query
	* argument appeared in the values array.
	**/
    public static void main(String[] args) {
    	//				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12    		
    	int[] values = {1,2,3,3,3,4,5,5,5,5,6,7,7}; // A pre-sorted array of integers. 
    	int query = 5; // The integer to search for.
    	
    	Matches matches = findMatches(values, query); // Search results in Matches object
    	
    	// Print out the position of the first match and 
    	// the number of occurrences of integer in array.
    	System.out.println("position of the first match: " + matches.firstMatchIndex);
    	System.out.println("number of occurrences of integer in array: " + matches.numberOfMatches);
    }
    
	/**
	* Returns a Matches object that represents where and how often the query
	* argument appeared in the values array.
	*
	* @param values A pre-sorted array of integers, possibly containing
	*               duplicates.
	* @param query  The integer to search for.
	*/
	public static Matches findMatches(int[] values, int query) {
		
		int firstMatchIndex = -1,lastMatchIndex=-1;
		int low = 0,mid = 0,high = values.length - 1;
		while (low <= high){
			mid = (low + high)/2;

			if(values[mid]==query){
				lastMatchIndex=mid;
				firstMatchIndex=mid;
				
				while(lastMatchIndex+1<values.length&&values[lastMatchIndex+1]==query)
					lastMatchIndex++;
				while(firstMatchIndex-1>=0&&values[firstMatchIndex-1]==query)
					firstMatchIndex--; 
				
				return new Matches(firstMatchIndex,lastMatchIndex-firstMatchIndex+1); 
			} else if(values[mid]>query)
				high=mid-1;
			else low=mid+1;
		}
		
		return new Matches(-1,0);
	}
	/** 
	* Encapsulates the position of the first match and the number of
	￼* occurrences of an integer in an array.
	￼*/
	public static class Matches{
		private int firstMatchIndex;
		private int numberOfMatches;
		
		public Matches(int firstMatchIndex, int numberOfMatches) {
			this.firstMatchIndex = firstMatchIndex;
			this.numberOfMatches = numberOfMatches;
		}

		public int getFirstMatchIndex() {
			return this.firstMatchIndex;
		}
		
		public int getNumberOfMatches() {
			return this.numberOfMatches;
		}
	}
}
