import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardValidation {

	public static void main(String[] args) throws NullPointerException{
	long creditCardNumber= 4012888888881881L;
	System.out.println(isValid(creditCardNumber));
	}
	public static List<Long> toDigits(long l) {

		List<Long> intList= new ArrayList<>();

		/**
		 * convert the long number to list
		 */
		while (l > 0) {
	        intList.add(0, l % 10);
	        l /= 10;
	    }
	    return intList;

		}
	public static List<Long> doubleSecond(List<Long> list) {

		/**
		 * for this method, the passed list is every second digit of list
		 * declare long arrays as belows
		 */
		long[] number1=new long [list.size()];
		@SuppressWarnings("unused")
		long[] number2=new long [number1.length];
		/**
		 * get the list size and convert it to long array
		 */
		int returnval = list.size();
		for(int i = 0; i< returnval;i++){
			number1[i]=list.get(i);
		}
		/**
		 * double the value of long array
		 */
		for (int j = 0; j < number1.length; j++)
	    {
			number1[j] = number1[j] * 2;
	        }
		/**
		 * If the number is greater than 9,then sum the digits to one number
		 */
		for (int k = 0; k < number1.length; k++)
	    {
	        if (number1[k] > 9)
	        {
	        	number1[k]= (number1[k] % 10) + 1;
	        }
	    }
		/**
		System.out.println(num4[0]);
		System.out.println(num4[1]);
		System.out.println(num4[2]);
		System.out.println(num4[3]);
		System.out.println(num4[4]);
		System.out.println(num4[5]);
		System.out.println(num4[6]);
		System.out.println(num4[7]);*/
		/**
		 * convert the long array to list and return it
		 */
		List<Long> intList2 = new ArrayList<>();
		for(int m=0; m<number1.length;m++){
		 intList2.add(number1[m]);
		 }
		//System.out.println(ints2);
		return intList2;
	    }

	public static List<Long> toDigitsReverse(long l) {
		/**
		 * reverse the long number(credit card number) and
		 * return the list
		 */
		 List<Long> intList1 = new ArrayList<>();
		 while (l > 0) {
		        intList1.add(0, l % 10);
		        l /= 10;
		    }
		 Collections.reverse(intList1);
		 return intList1;
	}

	@SuppressWarnings("unused")
	public static long sumDigits(List<Long> list) {
		long[] number3=new long [list.size()];

		List<Long> intList2 = new ArrayList<>();
		List<Long> intList3 = new ArrayList<>();
		List<Long> intList4 = new ArrayList<>();
		/**
		 * get every second digit and first digit and call todigits fucntion
		 */
		int j=1;
		long sum =0;
		for(int i = 0; i< list.size();i++){
			if(j%2==0){
				intList2.add(list.get(i));
		}
		else
		{
			intList4 = toDigits(list.get(i));
			for(int k = 0; k < intList4.size(); k++)
				sum += intList4.get(k);

		}
			j++;
		}


		long sum1=0;
		long total=0;
		/**
		 *Pass every second digit to "doublSecond" method
		 */
			intList3 = doubleSecond(intList);
			/**
			 * calculate the sum of every second digit
			 */
		 for(int l = 0; l< intList3.size();l++){
				sum1+=intList3.get(l);
			}
		 /**
			 * calculate the sum of every second digit plus sum of every first digit
			 */
		 total=sum + sum1;

		return total;

	}
	public static boolean isValid(long l) {

		/**
		 * pass the credit card number to "toDigitsReverse"method to
		 * reverse credit card number's order
		 */
		List<Long> number2 = toDigitsReverse(l);
		 /**
		 * define a long type number and pass the list to sumDigit
		*/
		long number1=sumDigits(number2);

		/**
		 * to valide the credit card number is valid or not
		 */
		if (number1 % 10 == 0) {
			 return true;
			 }else
			 {
			return false;
			 }
}
}

