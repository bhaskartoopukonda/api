package com.idexcel.utilities;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class DecimalFormater {
	
	public static double covertodecimal(double x) {
		DecimalFormat df2 = new DecimalFormat("#.##");
    	String d1= df2.format(x);
    	Double regularPaymentDue_cal = Double.valueOf(d1);
		return regularPaymentDue_cal;
        
    }

}
