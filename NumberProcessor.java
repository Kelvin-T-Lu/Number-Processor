public class NumberProcessor {
  
 /** 
     *   A number is defined to be the one that is positive integer and has at least one divisor other than 1 and itself.  
     *   For example, 4 and 6 are composite whereas 3 and 5 are not. 
     *  @return Returns true if its integer argument is composite, otherwise it returns false.
   */
      public static boolean isComposite(int input) {
        
        for(int x = 2; x<input; x++){
          if((x != input)){
            if(input%x == 0){
                  return true; 
            }
          }
        }
        return false;
     }
     /** @return Determines the Aliquot Divisors of a number and places them into an array */
     public static int[] findAliquotDivisors(int num){
       
       //Turns all negative numbers into positive
       int temp = num;
       if(temp<0){
         temp = -1 * num; 
       }
       //Used to determine the size of the array
       int size = 0;  
       
       //Determines the size of an array, where the aliquot divisors will be placed 
       for(int x = 1; x < temp; x++){
         if(num%x ==0)
           size++; 
       }
       
       //Places Aliquot divisors into Array
       int[] divisors = new int[size]; 
       int index = 0; 
       for(int x = 1; x < temp; x++){
         if(temp%x ==0){
           divisors[index] = x; 
           index++;
         }
       }
       
       return divisors; 
     }
     /** @return the sums of the content in the array */
     public static int sumOfArray(int[] array){
       int sum = 0; 
       
       for(int x = 0; x<array.length; x++){
          sum += array[x];
       }
       return sum; 
     }
      
   /**
     * Two numbers are called Friendly, if each of which is the sum of the other's aliquot divisors. 
     * Aliquot divisors are all positive divisors of the number other than itself. 
     * For example, 1184 and 1210 are friendly numbers, whereas 1500 and 6700 are not
     * @return Returns true if two numbers are Friendly, false otherwise. 
     */
      public static boolean isFriendly(int num1, int num2) {   
        int sum1 = sumOfArray(findAliquotDivisors(num1)); 
        int sum2 = sumOfArray(findAliquotDivisors(num2)); 
        
        //Returns true if friendly, else returns false
        //Compares the two sums of aliquot divisors
        return((sum1 == num2) && (sum2 == num1) && (sum1!=0) && (sum2 != 0));
     }
  
   /** 
     * Equivalent numbers are numbers where the sum of the aliquot divisors are equal.
     * For instance, 159 and 703 are equivalent numbers whereas 200 and 346 are not
     * @return Returns true if two integers are Equivalent, false otherwise
     */
      public static boolean isEquivalent(int num1, int num2) {
        //Temporary var. to shorten code length
        int sum1 = sumOfArray(findAliquotDivisors(num1));
        int sum2 = sumOfArray(findAliquotDivisors(num2));
        
        return ((sum1 == sum2) && (sum1!=0) && (sum2 != 0));
     }
  
   /** * @return Returns the inverse of the integer. */
      public static int reverseNum(int num){
      
        int temp1 = 0; //Stores reverse Number
        int temp2 = num; //Temporary storage to manipulate num
      
        //Reverses the order of the number and places it into temp1
        while(temp2 !=0){
          temp1 *= 10; 
          temp1 += temp2%10; 
          temp2 /= 10; 
          System.out.print(temp1); 
        }
        
      return temp1; 
     }
  
   /** 
     * Two integers are said to be ReverseEquivalent,  if the reverse of one of the numbers is equal to the other number.  
     * For example, 255 and 552 are ReverseEquivalent, whereas 100 and 876 are not.
     * @return Returns true if integers are ReverseEquivalent, false otherwise
     */
      public static boolean isReverseEquivalent(int num1, int num2) {
        return (reverseNum(num1)==num2);
     }
  
     
   /** 
    * An array is said to be ListEven  if its elements are in ascending order and each element appears two or more times.  
    * For example, {1, 1, 2, 2, 3, 3} is ListEven, whereas {1,2,3,4} is not.
    * @param array Takes an array of integers
    * @return Returns true if array is "ListEven", false otherwise
     */  
      public static boolean isListEven(int[] array) {
        
        if(array.length < 1) //Ensures there are elements in array
          return false; 
        
        int temp = array[0]; //Used to skip loop for efficiency
        for(int i = 0; i < array.length; i++){
          if (temp > array[i]) //Ensures ascending order
            return false;
          
          if (temp == array[i]) //Skips loop if the array was already compared
            continue; 
          
          int counter =0; //Counter to compare elements
          for(int j = i+1; j< array.length; j++){ 
            if((i!=j) && (array[i] == array[j])){ //Counter for asscending order
              counter++; 
            }
            if(counter > 0){ //breaks j loop if there's more than one of an element
              temp = array[i];
              continue; 
            }  
          }
          if(counter ==0) //if no matching element, break
            return false;
        }
        return true; 
     }

   /** @return This method evaluate and returns the solution of the polynomial anxn + an-1xn-1 + ... + a1x1 + a0 */
      public static double evaluate(double x, int[] coefficient) {
        double sum = coefficient[0]; 
        
        if(coefficient.length<2) //Ensures there are x variable present
          return sum; 
        
        for(int i = 1; i<coefficient.length; i++){
          sum += coefficient[i] * (Math.pow(x,i)); 
          System.out.print(Math.pow(x,i)+ " ");
        }
        return sum; 
     }
  
   /** 
     * An array is called MasonA if it has the following properties:
     *        - The value of the first element equals the sum of the next two elements, which is equals to the next three elements, equals to the sum of the next four elements, etc.
     *        - It has a size of x*(x+1)/2 for some positive integer x .
     * For example {6, 2, 4, 2, 2, 2, 1, 5, 0, 0} is MasonA, whereas {2, 1, 2, 3, 5, 6} is not
     * @return Returns true if the array is MasonA false otherwise. 
     */
      public static boolean isMasonA(int array[]) { //FIXME
        
        //Checks for array length
        if(array.length < 3){
          return false; 
        }
        
        int counter = 3; 
        int x = 0; 
        for(int i = 3; ; i+= counter){
          if(array.length == i)
            break;
          if((array.length < i)){
            return false; 
          }
          if(i == 3){
            continue;
          }
          counter ++; 
        }
        
        //Checks for sum 
        counter = 2; 

        
        for(int i = 1; i<=array.length - counter; i+= (counter-1)){
          int sum = 0; 
          for(int j = 0; j<counter; j++){
            sum += array[i+j];
          }
          if(sum!= array[0])
            return false; 
          counter ++; 
        }
        
        return true;

     }
  
   /** 
     * An array is called Dual if it can be divided into two non-empty sub arrays, 
     * where the sum of elements of the first sub array equals the sum of elements of the second sub array. 
     * For example, {6, 2, 4, 2, 2, 2, 1, 5, 0, 0} is Dual as it can give the sub arrays {6,2,4} and {2,2,2,1,5,0,0}
     *               {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, -2, -1} is also Dual as it gives sub arrays {0,0,0,0,0,0,0,0,0,0} and {1,1,1,-2,-1})
     * @return Returns true if the array is dual, false otherwise.
     */
      public static boolean isDual(int array[]) {
        if(sumOfArray(array) % 2  != 0) //Odd numbers can't be split with integers
          return false; 
        
        int x = sumOfArray(array)/ 2; //checker
        int sum = 0; //Adds content of first half of array
        
        for(int i = array.length - 1; i>= 0; i --){
          sum += array[i]; 
          if(sum > x){
            return false;
          }
          if(sum == x){
            break; 
          }
        }
        return true; 
     }
    
   /** @return Returns the int representation of the charaters */
      public static int [ ] representASCII(char [ ] input) {
        int[] temp = new int[input.length];
        for(int i = 0; i < input.length; i++){
          temp[i] = (int) input[i];
        }
        return temp; 
     }
     
 
   /**
     * An array is called Additive if the nth element (assuming n is a natural number) of the array is the sum of the first n elements. 
     * For example, {2, 2, 4, 8, 16, 32, 64} is Additive, whereas {1, 1, 2, 4, 9, 17} is not.
     * @return This method returns true if the array is Additive, false otherwise.
     */    
      public static boolean isAdditive(int[] array ) {
        if (array.length == 1)
          return true;
        
      int sum = array[0];
      
      //Implements first index
      if(sum!=array[1]){
            return false;
      }
      else
        sum += array[1];
      //Implements any index > 2
      if(array.length > 2){
        for(int i = 1; i<(array.length - 1); i++){
          if(sum != array[i+1]){
            return false; 
          }
          sum += array[i+1];  
        }
      }
        return true;
     }
}