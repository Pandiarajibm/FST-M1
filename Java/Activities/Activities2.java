package activities2;

public class Activities2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Activities2 actObj=new Activities2();

//initialise the array
int[] inputArr = {10, 77, 10, 54, -11, 10};

//Set constants
int searchNum = 10;
int fixedSum = 30;

//Print result
System.out.println("Does the sum equal to 30?: " + actObj.result(inputArr, searchNum, fixedSum));

	}
	 public static boolean result(int[] nums, int searchNum, int fixedSum) {
		  int temp_sum = 0;
	        //Loop through array
	        for (int number : nums) {
	            //If value is 10
	            if (number == searchNum) {
	                //Add them
	                temp_sum += searchNum;
	            }

	            //Sum should not be more than 30
	            if (temp_sum > fixedSum) {
	                break;
	            }
	        }

	        //Return true if condition satisfies
	        return temp_sum == fixedSum;
	 }
}
