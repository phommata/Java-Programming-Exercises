/**
 * Facilitates dispensing stamps for a postage stamp machine.
 */
public class StampDispenser
{
	private int[] stampDenominations;

	/**
     * Constructs a new StampDispenser that will be able to dispense the given 
     * types of stamps.
     *
     * @param stampDenominations The values of the types of stamps that the 
     *     machine should have.  Should be sorted in descending order and 
     *     contain at least a 1.
     */
    public StampDispenser(int[] stampDenominations)
    {
    	int i = stampDenominations.length - 1; // Init to lowest value stamp
    	
    	// Check if last stamp denomination is a 1c stamp
    	assert(stampDenominations[stampDenominations.length - 1] == 1) : "Last stamp denomination is NOT a 1c stamp!";
    	
    	// Loop in reverse through stampDenominations array and check if sorted in descending order
    	while (i >= 1){ 
    		
    		assert ( stampDenominations[i - 1] >= stampDenominations[i]) : "stampDenominations NOT sorted in descending order!";
    		
    		i--;
    	}

    	this.stampDenominations = stampDenominations;
    }
 
    /**
     * Returns the minimum number of stamps that the machine can dispense to
     * fill the given request.
     *
     * @param request The total value of the stamps to be dispensed.
     */
    public int calcMinNumStampsToFillRequest(int request)
    {  
    	// 2D array for saving intermediate recursive results 
    	// (0 will be included as ranges for 0 request and 0 stampDenominations)
    	
    	int[][] tab = new int[request+1][stampDenominations.length+1]; 
    	
    	// Recursion base case: When request is non-zero and cannot calcMinNumStampsToFillRequest 
    	// Init last column (1c stamp) to infinity/Integer.MAX_VALUE
    	
    	for(int i = 0; i <= request; i++) {
    		tab[i][stampDenominations.length] = Integer.MAX_VALUE;
    	}
    	
    	// Recursion base case: When request of 0, needs no stamps
    	// Init 1st column to 0		
    	
    	for(int j = 0; j < stampDenominations.length; j++) {
    		tab[0][j] = 0;
    	}
    	
    	// Forward loop 1c -> requested amount
    	for(int i = 1; i <= request; i++) {
    		// Reverse loop 1c stamp -> most expensive stamp
	    	for(int j = stampDenominations.length-1; j >= 0; j--) {	 
	    		
	    		// Determine minNumStampsToFillRequest
	    		
		    	if (i < stampDenominations[j]) { // No need to calculate
		    		
		    		tab[i][j] = tab[i][j+1]; // Use already computed value/last intermediate result
		    		
		    	} else { // i > stampDenominations[j]
		    		
		    		// Computing the previous entries tab[i][j+1] and tab[i- stampDenominations[j]][j] before the entry tab[i][j]
		    		
		    		int minNumStamps1 = tab[i][j+1]; // Use already computed value/last intermediate result in row
			    	int minNumStamps2 = 1 + tab[i-stampDenominations[j]][j]; // Use already computed value/last intermediate result in previous column (offset start at 1c request column after 0c request column) 
			    				    	
			    	// Save minNumStampsToFillRequest, which is an already computed value/last intermediate result in row/previous column

			    	if (minNumStamps1 < minNumStamps2){ 
			    		tab[i][j] = minNumStamps1; 
			    	}
			    	else {
			    		tab[i][j] = minNumStamps2;
			    	}
		    	} 
	    	}
    	}
    	
    	return(tab[request][0]); // Final calculated minNumStampsToFillRequest
    }
    
    public static void main(String[] args)
    {
        int[] denominations = { 90, 30, 24, 10, 6, 2, 1 };
//        int[] denominations = { 9000, 3000, 2400, 1000, 600, 200, 1 };
        StampDispenser stampDispenser = new StampDispenser(denominations);
        assert stampDispenser.calcMinNumStampsToFillRequest(18) == 3 : "Incorrect calculated minNumStampsToFillRequest!";
    }

	public int[] getStampDenominations() {
		return stampDenominations;
	}
}
