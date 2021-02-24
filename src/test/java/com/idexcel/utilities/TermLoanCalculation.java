package com.idexcel.utilities;

public class TermLoanCalculation {
	
	
	public static double calculateRegularPaymentDue(double openingBalance, double rate, int terms, int currentPeriod) {
        int power = terms - currentPeriod + 1;
        double temp = Math.pow(1 + rate, power);
        return openingBalance * (rate * temp) / (temp - 1);
    }

	public static double calculateInterestOnDayWise(double openingBalance ,double Interest,int days) {
		Double cal1=openingBalance*Interest/100;
		Double cal2=cal1/360;
		Double Interestcal=cal2*days;
		return Interestcal;
	}
}
