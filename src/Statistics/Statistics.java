package Statistics;

import java.util.ArrayList;
/* To find the sampling variation use the result of standard deviation ^ 2 */

public class Statistics {
	public ArrayList<Double> sumMemory = new ArrayList<>(); //Creating an arrayList for sum memory
	public ArrayList<Double> weight = new ArrayList<>();
	private double avg  = 0.00;
	private double deviation;
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
		avg = result/this.sumMemory.size();
		return avg;
	}
	//To calculate evaluated average:
	public void evaluateAVG(double num){
		this.weight.add(num);
	}
	public double evaluatedAVGRESULT() {
		for(int i = 0; i < sumMemory.size(); i++) {
			this.avg += (this.sumMemory.get(i) * this.weight.get(i));
		}
		return this.avg/this.sumMemory.size();
	}
	//To calculate standard deviation:
	public double deviation() {
		for(int i = 0; i < sumMemory.size(); i++) {
			this.deviation = sumMemory.get(i) - avg;
		}
		return this.deviation/sumMemory.size();
	}
	//To reset the array values:
	public void clearArray() {
		this.sumMemory.clear();
		this.weight.clear();
		this.deviation = 0.00;
		this.avg = 0.00;
		
	}
}
