package Statistics;

import java.util.ArrayList;

public class Statistics {
	public ArrayList<Double> sumMemory = new ArrayList<>(); //Creating an arrayList for sum memory
	//For saving the values on the array:
	public void positiveSum(double num) {
		this.sumMemory.add(num);
	}
	//To calculate t=he average between the numbers:
	public double avg() {
		double result = 0.00;
		for(int i = 0; i < sumMemory.size(); i++) {
			result += this.sumMemory.get(i);
		}
		return result/this.sumMemory.size();
	}
	//To reset the array values:
	public void clearArray() {
		this.sumMemory.clear();
	}
}
