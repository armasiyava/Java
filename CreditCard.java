import java.util.*;
import java.io.*;
@SuppressWarnings("serial")
public class CreditCard implements Serializable {
	long CardNumber;
	boolean flag;
	//default constructor set card number value zero and flag as true.	
	CreditCard(){
		CardNumber=0L;
		flag=true;
	}
	//default constructor assign two values in class .
	CreditCard(long cn, boolean f){
		CardNumber=cn;
		flag=f;
	}

	public long getCardNumber(){//getters method
		return CardNumber;
	}

	public void setCardNumber(long CardNumber){//setters method  
		this.CardNumber = CardNumber;
	}
	
	public void setFlag(boolean flag){
		this.flag = flag;
	}
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (CardNumber ^ (CardNumber >>> 32));
		result = prime * result + (flag ? 1231 : 1237);
		return result;
	}
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (CardNumber != other.CardNumber)
			return false;
		if (flag != other.flag)
			return false;
		return true;
	}
	public String toString(){
		return "CreditCard [CardNumber=" + CardNumber + ", flag=" + flag + "]";
	}
	}

