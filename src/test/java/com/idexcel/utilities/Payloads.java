
	package com.idexcel.utilities;

	 

	import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.stream.DoubleStream;

import org.testng.annotations.Test;

	 

	public class Payloads {
		
		
		
	    public String getPayloadforPreviewToCheckLoanNumberPositive(String LoanNumber) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": null,\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"11622\",\r\n" + 
	        		"    \"name\": \"ABH-001\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"currency\": {\r\n" + 
	        		"    \"id\": 5,\r\n" + 
	        		"    \"currencyCode\": \"USD\",\r\n" + 
	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	        		"    \"decimalPrecision\": 2,\r\n" + 
	        		"    \"systemDefined\": true\r\n" + 
	        		"  },\r\n" + 
	        		"  \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
	        		"  \"loanName\": \"Loan\",\r\n" + 
	        		"  \"principalAmount\": \"700000\",\r\n" + 
	        		"  \"disbursementDate\": null,\r\n" + 
	        		"  \"initialPaymentDate\": null,\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"months\",\r\n" + 
	        		"    \"display\": \"Months\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \"5\",\r\n" + 
	        		"  \"originationDate\": \"05/12/2020\",\r\n" + 
	        		"  \"maturityDate\": \"10/12/2020\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": 4,\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"revisedInterestRate\": null,\r\n" + 
	        		"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	        		"  \"comments\": null,\r\n" + 
	        		"  \"interestRateType\": \"fixed\",\r\n" + 
	        		"  \"interestRateCode\": null,\r\n" + 
	        		"  \"rateAdjustment\": null,\r\n" + 
	        		"  \"totalInterest\": null,\r\n" + 
	        		"  \"amortizationType\": \"normal\",\r\n" + 
	        		"  \"baseInterestRate\": null,\r\n" + 
	        		"  \"intRatePrecision\": 12,\r\n" + 
	        		"  \"dailyDivisor\": 365,\r\n" + 
	        		"  \"loanStatus\": {\r\n" + 
	        		"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"displayName\": \"Active\",\r\n" + 
	        		"    \"value\": \"active\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"paidOffDate\": null,\r\n" + 
	        		"  \"totalOutStandingBalance\": 0,\r\n" + 
	        		"  \"preview\": null\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	    public String latefee() {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": null,\r\n" + 
	        		"  \"lateFeePercentage\": 0,\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \"4441fc32-f9aa-41df-be9e-8ad50b5b0c15\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"pastDueDays\": 10,\r\n" + 
	        		"  \"feeBasedOn\": {\r\n" + 
	        		"    \"id\": \"eba0a5fc-c363-11e9-9d62-12e987db82ac\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"lateFeeValue\": 500\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public String addlatefee(String termloanId,String pastDueDays,String feeBasedOnid,String lateFeeValue) {
	    	String addlatefee="{\r\n" + 
	    			"  \"id\": null,\r\n" + 
	    			"  \"lateFeePercentage\": 0,\r\n" + 
	    			"  \"termLoan\": {\r\n" + 
	    			"    \"id\": \""+termloanId+"\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"pastDueDays\": "+pastDueDays+",\r\n" + 
	    			"  \"feeBasedOn\": {\r\n" + 
	    			"    \"id\": \""+feeBasedOnid+"\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"lateFeeValue\": "+lateFeeValue+"\r\n" + 
	    			"}";
			return addlatefee;
	    	
	    }
	    public String latefeePUt() {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \"e18a3700-db54-4b1d-83f2-63564577b3a2\",\r\n" + 
	        		"  \"lateFeePercentage\": 0,\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \"4441fc32-f9aa-41df-be9e-8ad50b5b0c15\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"pastDueDays\": 10,\r\n" + 
	        		"  \"feeBasedOn\": {\r\n" + 
	        		"    \"id\": \"eba0a5fc-c363-11e9-9d62-12e987db82ac\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"lateFeeValue\": 5000\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	   

	    public String getLoanDetails(String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String	Intrest,String Originationdate,String InitialPaymentdate,String	Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": null,\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"11622\",\r\n" + 
	        		"    \"name\": \"ABH-001\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"currency\": {\r\n" + 
	        		"    \"id\": 5,\r\n" + 
	        		"    \"currencyCode\": \"USD\",\r\n" + 
	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	        		"    \"decimalPrecision\": 3,\r\n" + 
	        		"    \"systemDefined\": true\r\n" + 
	        		"  },\r\n" + 
	        		"  \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
	        		"  \"loanName\": \""+LoanName+"\",\r\n" + 
	        		"  \"principalAmount\": \""+PrincipalAmount+"\",\r\n" + 
	        		"  \"disbursementDate\":\""+Disburnsmentdate+"\",\r\n" + 
	        		"  \"initialPaymentDate\": \""+InitialPaymentdate+"\",\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \""+Termtype+"\",\r\n" + 
	        		"    \"display\": \""+Termtype+"\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \""+Term+"\",\r\n" + 
	        		"  \"originationDate\": \""+Originationdate+"\",\r\n" + 
	        		"  \"maturityDate\": \""+MaturityDate+"\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": "+Intrest+",\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"revisedInterestRate\": null,\r\n" + 
	        		"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	        		"  \"comments\": null,\r\n" + 
	        		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	        		"  \"interestRateCode\": null,\r\n" + 
	        		"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
	        		"  \"totalInterest\": null,\r\n" + 
	        		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	        		"  \"baseInterestRate\": null,\r\n" + 
	        		"  \"intRatePrecision\": 12,\r\n" + 
	        		"  \"dailyDivisor\": 360,\r\n" + 
	        		"  \"loanStatus\": {\r\n" + 
	        		"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"displayName\": \"Active\",\r\n" + 
	        		"    \"value\": \"active\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"paidOffDate\": null,\r\n" + 
	        		"  \"totalOutStandingBalance\": 0,\r\n" + 
	        		"  \"preview\": null\r\n" + 
	        		"}";	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
       public String termloanFloatingPreview(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String loanStatus_id,String disbursementAmount) {
	    	
    	   int inum1 = Integer.valueOf(principalAmount);
	    	int inum2 = Integer.valueOf(terms);
	    	float inum3= inum1/inum2;
	    	BigDecimal bd = new BigDecimal(inum3).setScale(2, RoundingMode.HALF_UP);
	    	double salary = bd.doubleValue();
	    	//String fixedPrincipal = Float.toString(inum3); 
	    	String fixedPrincipal = String.valueOf(salary);
	    	String termloanFloatingPreview="{\r\n" + 
	    			"  \"id\": null,\r\n" + 
	    			"  \"loanType\": {\r\n" + 
	    			"    \"id\": \""+loanType_id+"\",\r\n" + 
	    			"    \"value\": \"term_loan\",\r\n" + 
	    			"    \"display\": \"Term Loan\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"borrower\": {\r\n" + 
	    			"    \"id\": \""+borrower_id+"\",\r\n" + 
	    			"    \"name\": \""+name+"\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"currency\": {\r\n" + 
	    			"    \"id\": 5,\r\n" + 
	    			"    \"currencyCode\": \"USD\",\r\n" + 
	    			"    \"description\": \"USD : US Dollar\",\r\n" + 
	    			"    \"decimalPrecision\": 3,\r\n" + 
	    			"    \"systemDefined\": true\r\n" + 
	    			"  },\r\n" + 
	    			"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
	    			"  \"loanName\": \""+loanName+"\",\r\n" + 
	    			"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
	    			"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	    			"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	    			"  \"termType\": {\r\n" + 
	    			"    \"id\": \""+termType_id+"\",\r\n" + 
	    			"    \"value\": \""+value+"\",\r\n" + 
	    			"    \"display\": \""+display+"\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"terms\": \""+terms+"\",\r\n" + 
	    			"  \"originationDate\": \""+originationDate+"\",\r\n" + 
	    			"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
	    			"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	    			"  \"interestRate\": null,\r\n" + 
	    			"  \"divisor\": "+divisor+",\r\n" + 
	    			"  \"revisedInterestRate\": null,\r\n" + 
	    			"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	    			"  \"comments\": null,\r\n" + 
	    			"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	    			"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
	    			"  \"rateAdjustment\": \""+rateAdjustment+"\",\r\n" + 
	    			"  \"totalInterest\": "+totalInterest+",\r\n" + 
	    			"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	    			"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
	    			"  \"editedFixedPrincipal\": false,\r\n" + 
	    			"  \"baseInterestRate\": null,\r\n" + 
	    			"  \"intRatePrecision\": 8,\r\n" + 
	    			"  \"dailyDivisor\": 360,\r\n" + 
	    			"  \"loanStatus\": {\r\n" + 
	    			"    \"id\": \""+loanStatus_id+"\",\r\n" + 
	    			"    \"displayName\": \"Active\",\r\n" + 
	    			"    \"value\": \"active\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"paidOffDate\": null,\r\n" + 
	    			"  \"totalOutStandingBalance\": 0,\r\n" + 
	    			"  \"preview\": null,\r\n" + 
	    			"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
	    			"}";
			return termloanFloatingPreview;
	    	
	    }
       public String createMonthlyChargeCode(String natSignid,String natSign_value,String natSign_displayName,String frequencyid,String frequency_value,String frequency_displayName,String chargeTypeid,String chargeType_value,String chargeType_displayName,String chargeType_calculationType,String postingTypeid,String postingType_value,String postingType_displayName,String value,String autoNewClient) {
    	   String createMonthlyChargeCode="{\r\n" + 
    	   		"  \"id\": \"\",\r\n" + 
    	   		"  \"chargeCode\": \""+getChargeCode()+"\",\r\n" + 
    	   		"  \"transactionCode\": \""+getTransactionCode()+"\",\r\n" + 
    	   		"  \"natSign\": {\r\n" + 
    	   		"    \"id\": \""+natSignid+"\",\r\n" + 
    	   		"    \"value\": \""+natSign_value+"\",\r\n" + 
    	   		"    \"displayName\": \""+natSign_displayName+"\"\r\n" + 
    	   		"  },\r\n" + 
    	   		"  \"frequency\": {\r\n" + 
    	   		"    \"id\": \""+frequencyid+"\",\r\n" + 
    	   		"    \"value\": \""+frequency_value+"\",\r\n" + 
    	   		"    \"displayName\": \""+frequency_displayName+"\"\r\n" + 
    	   		"  },\r\n" + 
    	   		"  \"chargeType\": {\r\n" + 
    	   		"    \"id\": \""+chargeTypeid+"\",\r\n" + 
    	   		"    \"value\": \""+chargeType_value+"\",\r\n" + 
    	   		"    \"displayName\": \""+chargeType_displayName+"\",\r\n" + 
    	   		"    \"calculationType\": \""+chargeType_calculationType+"\"\r\n" + 
    	   		"  },\r\n" + 
    	   		"  \"postingType\": {\r\n" + 
    	   		"    \"id\": \""+postingTypeid+"\",\r\n" + 
    	   		"    \"value\": \""+postingType_value+"\",\r\n" + 
    	   		"    \"displayName\": \""+postingType_displayName+"\"\r\n" + 
    	   		"  },\r\n" + 
    	   		"  \"value\": \""+value+"\",\r\n" + 
    	   		"  \"autoNewClient\": "+autoNewClient+"\r\n" + 
    	   		"}";
		return createMonthlyChargeCode;
       }
       
       public String getFloatingFixedCommit(String responseOfPreview,String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value ,String display,String terms,String originationDate,String maturityDate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String loanStatus_id,String disbursementAmount) {
    	   
    	   int inum1 = Integer.valueOf(principalAmount);
	    	int inum2 = Integer.valueOf(terms);
	    	float inum3= inum1/inum2;
	    	BigDecimal bd = new BigDecimal(inum3).setScale(2, RoundingMode.HALF_UP);
	    	double salary = bd.doubleValue();
	    	//String fixedPrincipal = Float.toString(inum3); 
	    	String fixedPrincipal = String.valueOf(salary);
    	   String getFloatingFixedCommit="{\r\n" + 
    	   		"  \"id\": \""+responseOfPreview+"\",\r\n" + 
    	   		"  \"loanType\": {\r\n" + 
    	   		"    \"id\": \""+loanType_id+"\",\r\n" + 
    	   		"    \"value\": \"term_loan\",\r\n" + 
    	   		"    \"display\": \"Term Loan\"\r\n" + 
    	   		"  },\r\n" + 
    	   		"  \"borrower\": {\r\n" + 
    	   		"    \"id\": \""+borrower_id+"\",\r\n" + 
    	   		"    \"name\": \""+name+"\"\r\n" + 
    	   		"  },\r\n" + 
    	   		"  \"currency\": {\r\n" + 
    	   		"    \"id\": 5,\r\n" + 
    	   		"    \"currencyCode\": \"USD\",\r\n" + 
    	   		"    \"description\": \"USD : US Dollar\",\r\n" + 
    	   		"    \"decimalPrecision\": 3,\r\n" + 
    	   		"    \"systemDefined\": true\r\n" + 
    	   		"  },\r\n" + 
    	   		"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
    	   		"  \"loanName\": \""+loanName+"\",\r\n" + 
    	   		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
    	   		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
    	   		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
    	   		"  \"termType\": {\r\n" + 
    	   		"    \"id\": \""+termType_id+"\",\r\n" + 
    	   		"    \"value\": \""+value+"\",\r\n" + 
    	   		"    \"display\": \""+display+"\"\r\n" + 
    	   		"  },\r\n" + 
    	   		"  \"terms\": \""+terms+"\",\r\n" + 
    	   		"  \"originationDate\": \""+originationDate+"\",\r\n" + 
    	   		"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
    	   		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
    	   		"  \"interestRate\": null,\r\n" + 
    	   		"  \"divisor\": "+divisor+",\r\n" + 
    	   		"  \"revisedInterestRate\": null,\r\n" + 
    	   		"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
    	   		"  \"comments\": null,\r\n" + 
    	   		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
    	   		"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
    	   		"  \"rateAdjustment\": \""+rateAdjustment+"\",\r\n" + 
    	   		"  \"totalInterest\": "+totalInterest+",\r\n" + 
    	   		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
    	   		"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
    	   		"  \"editedFixedPrincipal\": false,\r\n" + 
    	   		"  \"baseInterestRate\": 10,\r\n" + 
    	   		"  \"intRatePrecision\": 8,\r\n" + 
    	   		"  \"dailyDivisor\": 360,\r\n" + 
    	   		"  \"loanStatus\": {\r\n" + 
    	   		"    \"id\": \""+loanStatus_id+"\",\r\n" + 
    	   		"    \"displayName\": \"Active\",\r\n" + 
    	   		"    \"value\": \"active\"\r\n" + 
    	   		"  },\r\n" + 
    	   		"  \"paidOffDate\": null,\r\n" + 
    	   		"  \"totalOutStandingBalance\": 0,\r\n" + 
    	   		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
    	   		"}";
		return getFloatingFixedCommit;
       }
	    public String getLoanDetailsWithTermType(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
	       
	    	int inum1 = Integer.valueOf(principalAmount);
	    	int inum2 = Integer.valueOf(terms);
	    	float inum3= inum1/inum2;
	    	BigDecimal bd = new BigDecimal(inum3).setScale(2, RoundingMode.HALF_UP);
	    	double salary = bd.doubleValue();
	    	//String fixedPrincipal = Float.toString(inum3); 
	    	fixedPrincipal = String.valueOf(salary);
	    	
	    	String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": null,\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \""+loanType_id+"\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \""+borrower_id+"\",\r\n" + 
	        		"    \"name\": \""+name+"\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"currency\": {\r\n" + 
	        		"    \"id\": 5,\r\n" + 
	        		"    \"currencyCode\": \"USD\",\r\n" + 
	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	        		"    \"decimalPrecision\": 3,\r\n" + 
	        		"    \"systemDefined\": true\r\n" + 
	        		"  },\r\n" + 
	        		"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
	        		"  \"loanName\": \""+loanName+"\",\r\n" + 
	        		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
	        		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	        		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \""+termType_id+"\",\r\n" + 
	        		"    \"value\": \""+value+"\",\r\n" + 
	        		"    \"display\": \""+display+"\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \""+terms+"\",\r\n" + 
	        		"  \"originationDate\": \""+originationDate+"\",\r\n" + 
	        		"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": "+interestRate+",\r\n" + 
	        		"  \"divisor\": "+divisor+",\r\n" + 
	        		"  \"revisedInterestRate\": null,\r\n" + 
	        		"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	        		"  \"comments\": null,\r\n" + 
	        		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	        		"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
	        		"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
	        		"  \"totalInterest\": null,\r\n" + 
	        		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	        		"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
	        		"  \"editedFixedPrincipal\": null,\r\n" + 
	        		"  \"baseInterestRate\": null,\r\n" + 
	        		"  \"intRatePrecision\": 12,\r\n" + 
	        		"  \"dailyDivisor\": 360,\r\n" + 
	        		"  \"loanStatus\": {\r\n" + 
	        		"    \"id\": \""+loanStatus_id+"\",\r\n" + 
	        		"    \"displayName\": \"Active\",\r\n" + 
	        		"    \"value\": \"active\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"paidOffDate\": null,\r\n" + 
	        		"  \"totalOutStandingBalance\": 0,\r\n" + 
	        		"  \"preview\": null,\r\n" + 
	        		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
	        		"}";
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public String getLoanCommitsWithTermType(String responseOfPreview,String loanType_id,String borrower_id,String name,String loanNumber,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String loanStatus_id,String disbursementAmount) {
	       
	    	int inum1 = Integer.valueOf(principalAmount);
	    	int inum2 = Integer.valueOf(terms);
	    	float inum3= inum1/inum2;
	    	BigDecimal bd = new BigDecimal(inum3).setScale(2, RoundingMode.HALF_UP);
	    	double salary = bd.doubleValue();
	    	//String fixedPrincipal = Float.toString(inum3); 
	    	String fixedPrincipal = String.valueOf(salary);
	    	
	    	String requestBodyForChargeCode="{\r\n" + 
	    			"  \"id\": \""+responseOfPreview+"\",\r\n" + 
	    			"  \"loanType\": {\r\n" + 
	    			"    \"id\": \""+loanType_id+"\",\r\n" + 
	    			"    \"value\": \"term_loan\",\r\n" + 
	    			"    \"display\": \"Term Loan\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"borrower\": {\r\n" + 
	    			"    \"id\": \""+borrower_id+"\",\r\n" + 
	    			"    \"name\": \""+name+"\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"currency\": {\r\n" + 
	    			"    \"id\": 5,\r\n" + 
	    			"    \"currencyCode\": \"USD\",\r\n" + 
	    			"    \"description\": \"USD : US Dollar\",\r\n" + 
	    			"    \"decimalPrecision\": 3,\r\n" + 
	    			"    \"systemDefined\": true\r\n" + 
	    			"  },\r\n" + 
	    			"  \"loanNumber\": \""+loanNumber+"\",\r\n" + 
	    			"  \"loanName\": \""+loanName+"\",\r\n" + 
	    			"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
	    			"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	    			"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	    			"  \"termType\": {\r\n" + 
	    			"    \"id\": \""+termType_id+"\",\r\n" + 
	    			"    \"value\": \""+value+"\",\r\n" + 
	    			"    \"display\": \""+display+"\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"terms\": \""+terms+"\",\r\n" + 
	    			"  \"originationDate\": \""+originationDate+"\",\r\n" + 
	    			"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
	    			"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	    			"  \"interestRate\": "+interestRate+",\r\n" + 
	    			"  \"divisor\": "+divisor+",\r\n" + 
	    			"  \"revisedInterestRate\": null,\r\n" + 
	    			"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	    			"  \"comments\": null,\r\n" + 
	    			"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	    			"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
	    			"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
	    			"  \"totalInterest\": "+interestRate+",\r\n" + 
	    			"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	    			"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
	    			"  \"editedFixedPrincipal\": null,\r\n" + 
	    			"  \"baseInterestRate\": 10,\r\n" + 
	    			"  \"intRatePrecision\": 12,\r\n" + 
	    			"  \"dailyDivisor\": 360,\r\n" + 
	    			"  \"loanStatus\": {\r\n" + 
	    			"    \"id\": \""+loanStatus_id+"\",\r\n" + 
	    			"    \"displayName\": \"Active\",\r\n" + 
	    			"    \"value\": \"active\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"paidOffDate\": null,\r\n" + 
	    			"  \"totalOutStandingBalance\": 0,\r\n" + 
	    			"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
	    			"}";
	        
	     return requestBodyForChargeCode;
	        
	    }
	   
	    public String periodRevisionLoan(String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String	Intrest,String Originationdate,String InitialPaymentdate,String	Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": null,\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"11622\",\r\n" + 
	        		"    \"name\": \"ABH-001\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"currency\": {\r\n" + 
	        		"    \"id\": 5,\r\n" + 
	        		"    \"currencyCode\": \"USD\",\r\n" + 
	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	        		"    \"decimalPrecision\": 3,\r\n" + 
	        		"    \"systemDefined\": true\r\n" + 
	        		"  },\r\n" + 
	        		"  \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
	        		"  \"loanName\": \""+LoanName+"\",\r\n" + 
	        		"  \"principalAmount\": \""+PrincipalAmount+"\",\r\n" + 
	        		"  \"disbursementDate\":\""+Disburnsmentdate+"\",\r\n" + 
	        		"  \"initialPaymentDate\": \""+InitialPaymentdate+"\",\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \""+Termtype+"\",\r\n" + 
	        		"    \"display\": \""+Termtype+"\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \""+Term+"\",\r\n" + 
	        		"  \"originationDate\": \""+Originationdate+"\",\r\n" + 
	        		"  \"maturityDate\": \""+MaturityDate+"\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": "+Intrest+",\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"revisedInterestRate\": null,\r\n" + 
	        		"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	        		"  \"comments\": null,\r\n" + 
	        		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	        		"  \"interestRateCode\": null,\r\n" + 
	        		"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
	        		"  \"totalInterest\": null,\r\n" + 
	        		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	        		"  \"baseInterestRate\": null,\r\n" + 
	        		"  \"intRatePrecision\": 12,\r\n" + 
	        		"  \"dailyDivisor\": 360,\r\n" + 
	        		"  \"loanStatus\": {\r\n" + 
	        		"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"displayName\": \"Active\",\r\n" + 
	        		"    \"value\": \"active\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"paidOffDate\": null,\r\n" + 
	        		"  \"totalOutStandingBalance\": 0,\r\n" + 
	        		"  \"preview\": null\r\n" + 
	        		"}";	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public String floating(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount)			
{
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": null,\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \""+loanType_id+"\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \""+borrower_id+"\",\r\n" + 
	        		"    \"name\": \""+name+"\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"currency\": {\r\n" + 
	        		"    \"id\": 5,\r\n" + 
	        		"    \"currencyCode\": \"USD\",\r\n" + 
	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	        		"    \"decimalPrecision\": 3,\r\n" + 
	        		"    \"systemDefined\": true\r\n" + 
	        		"  },\r\n" + 
	        		"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
	        		"  \"loanName\": \""+loanName+"\",\r\n" + 
	        		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
	        		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	        		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \""+termType_id+"\",\r\n" + 
	        		"    \"value\": \""+value+"\",\r\n" + 
	        		"    \"display\": \""+display+"\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \""+terms+"\",\r\n" + 
	        		"  \"originationDate\": \""+originationDate+"\",\r\n" + 
	        		"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": "+interestRate+",\r\n" + 
	        		"  \"divisor\": "+divisor+",\r\n" + 
	        		"  \"revisedInterestRate\": "+revisedInterestRate+",\r\n" + 
	        		"  \"revisedInterestRateEffectiveDate\": "+revisedInterestRateEffectiveDate+",\r\n" + 
	        		"  \"comments\": null,\r\n" + 
	        		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	        		"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
	        		"  \"rateAdjustment\": \""+rateAdjustment+"\",\r\n" + 
	        		"  \"totalInterest\": "+totalInterest+",\r\n" + 
	        		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	        		"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
	        		"  \"editedFixedPrincipal\": null,\r\n" + 
	        		"  \"baseInterestRate\": null,\r\n" + 
	        		"  \"intRatePrecision\": 8,\r\n" + 
	        		"  \"dailyDivisor\": 360,\r\n" + 
	        		"  \"loanStatus\": {\r\n" + 
	        		"    \"id\": \""+loanStatus_id+"\",\r\n" + 
	        		"    \"displayName\": \"Active\",\r\n" + 
	        		"    \"value\": \"active\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"paidOffDate\": null,\r\n" + 
	        		"  \"totalOutStandingBalance\": 0,\r\n" + 
	        		"  \"preview\": null,\r\n" + 
	        		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
	        		"}";
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public String floatingcommit(String responseOfPreview,String loanType_id,String borrower_id,String name,String loanNumber,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String loanStatus_id,String disbursementAmount)			
	    {
	    	        String requestBodyForChargeCode="{\r\n" + 
	    	        		"  \"id\": \""+responseOfPreview+"\",\r\n" + 
	    	        		"  \"loanType\": {\r\n" + 
	    	        		"    \"id\": \""+loanType_id+"\",\r\n" + 
	    	        		"    \"value\": \"term_loan\",\r\n" + 
	    	        		"    \"display\": \"Term Loan\"\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"borrower\": {\r\n" + 
	    	        		"    \"id\": \""+borrower_id+"\",\r\n" + 
	    	        		"    \"name\": \""+name+"\"\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"currency\": {\r\n" + 
	    	        		"    \"id\": 5,\r\n" + 
	    	        		"    \"currencyCode\": \"USD\",\r\n" + 
	    	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	    	        		"    \"decimalPrecision\": 3,\r\n" + 
	    	        		"    \"systemDefined\": true\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"loanNumber\": \""+loanNumber+"\",\r\n" + 
	    	        		"  \"loanName\": \""+loanName+"\",\r\n" + 
	    	        		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
	    	        		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	    	        		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	    	        		"  \"termType\": {\r\n" + 
	    	        		"    \"id\": \""+termType_id+"\",\r\n" + 
	    	        		"    \"value\": \""+value+"\",\r\n" + 
	    	        		"    \"display\": \""+display+"\"\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"terms\": \""+terms+"\",\r\n" + 
	    	        		"  \"originationDate\": \""+originationDate+"\",\r\n" + 
	    	        		"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
	    	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	    	        		"  \"interestRate\": "+interestRate+",\r\n" + 
	    	        		"  \"divisor\": "+divisor+",\r\n" + 
	    	        		"  \"revisedInterestRate\": "+revisedInterestRate+",\r\n" + 
	    	        		"  \"revisedInterestRateEffectiveDate\": "+revisedInterestRateEffectiveDate+",\r\n" + 
	    	        		"  \"comments\": null,\r\n" + 
	    	        		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	    	        		"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
	    	        		"  \"rateAdjustment\": \""+rateAdjustment+"\",\r\n" + 
	    	        		"  \"totalInterest\": "+totalInterest+",\r\n" + 
	    	        		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	    	        		"  \"fixedPrincipal\": null,\r\n" + 
	    	        		"  \"editedFixedPrincipal\": null,\r\n" + 
	    	        		"  \"baseInterestRate\": 10,\r\n" + 
	    	        		"  \"intRatePrecision\": 8,\r\n" + 
	    	        		"  \"dailyDivisor\": 360,\r\n" + 
	    	        		"  \"loanStatus\": {\r\n" + 
	    	        		"    \"id\": \""+loanStatus_id+"\",\r\n" + 
	    	        		"    \"displayName\": \"Active\",\r\n" + 
	    	        		"    \"value\": \"active\"\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"paidOffDate\": null,\r\n" + 
	    	        		"  \"totalOutStandingBalance\": 0,\r\n" + 
	    	        		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
	    	        		"}";
	    	        
//	    	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	    	        
	    	     return requestBodyForChargeCode;
	    	        
	    	    }
	   
	    
	   
	    public String  getPayloadforPreviewToCheckLoanNameNegative(String Id,String Loanname) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \""+Id+"\",\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"8205\",\r\n" + 
	        		"    \"name\": \"LOAN-009\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"currency\": {\r\n" + 
	        		"    \"id\": 5,\r\n" + 
	        		"    \"currencyCode\": \"USD\",\r\n" + 
	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	        		"    \"decimalPrecision\": 6,\r\n" + 
	        		"    \"systemDefined\": false\r\n" + 
	        		"  },\r\n" + 
	        		"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
	        		"  \"loanName\": \""+Loanname+"\",\r\n" + 
	        		"  \"principalAmount\": \"3600\",\r\n" + 
	        		"  \"disbursementDate\": null,\r\n" + 
	        		"  \"initialPaymentDate\": null,\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"months\",\r\n" + 
	        		"    \"display\": \"Months\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \"7\",\r\n" + 
	        		"  \"originationDate\": \"09/12/2019\",\r\n" + 
	        		"  \"maturityDate\": \"04/12/2020\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": 2,\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"comments\": \"HI\"\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }

	    public String   getPayloadforPreviewToCheckEditOperationforNegative(String PaidOffDate,String LoanName,String loanID) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"    \"id\": \""+loanID+"\",\r\n" + 
	        		"    \"loanType\": {\r\n" + 
	        		"        \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"term_loan\",\r\n" + 
	        		"        \"display\": \"Term Loan\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"borrower\": {\r\n" + 
	        		"        \"id\": \"8992\",\r\n" + 
	        		"        \"name\": \"LOAN-1031\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"currency\": {\r\n" + 
	        		"        \"id\": 5,\r\n" + 
	        		"        \"currencyCode\": \"USD\",\r\n" + 
	        		"        \"description\": \"USD : US Dollar\",\r\n" + 
	        		"        \"decimalPrecision\": 6,\r\n" + 
	        		"        \"systemDefined\": false\r\n" + 
	        		"    },\r\n" + 
	        		"    \"loanNumber\": \"1035\",\r\n" + 
	        		"    \"loanName\": \""+LoanName+"\",\r\n" + 
	        		"    \"principalAmount\": 60,\r\n" + 
	        		"    \"disbursementDate\": null,\r\n" + 
	        		"    \"initialPaymentDate\": \"08/01/2019\",\r\n" + 
	        		"    \"termType\": {\r\n" + 
	        		"        \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"months\",\r\n" + 
	        		"        \"display\": \"Months\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"terms\": 12,\r\n" + 
	        		"    \"originationDate\": \"07/01/2019\",\r\n" + 
	        		"    \"maturityDate\": \"07/01/2020\",\r\n" + 
	        		"    \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"    \"interestRate\": 2,\r\n" + 
	        		"    \"divisor\": 12,\r\n" + 
	        		"    \"comments\": null,\r\n" + 
	        		"    \"loanStatus\": {\r\n" + 
	        		"        \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"displayName\": \"Active\",\r\n" + 
	        		"        \"value\": \"active\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"paidOffDate\": \""+PaidOffDate+"\",\r\n" + 
	        		"    \"clientId\": \"8992\",\r\n" + 
	        		"    \"clientName\": \"LOAN-1031\"\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }

	    public String  getPayloadforChargeTemplatePost(String termLoan) {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \""+termLoan+"\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeCode\": {\r\n" + 
	        		"      \"id\": \"26887bba-3927-4679-b44d-435f3b379710\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"natSign\": \"+\",\r\n" + 
	        		"    \"frequency\": \"manual\",\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"3b7a9ac4-c623-11e9-8128-0efdfcf6f638\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"value\": 5\r\n" + 
	        		"  }\r\n" + 
	        		"]";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	   
	    public String  getPayloadforChargeTemplatePut(String termLoan) {
	        String requestBodyForChargeCode="  {\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \""+termLoan+"\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeCode\": {\r\n" + 
	        		"      \"id\": \"Audit15\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"natSign\": \"+\",\r\n" + 
	        		"    \"frequency\": \"manual\",\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"3b7a9ac4-c623-11e9-8128-0efdfcf6f638\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"value\": \""+getValue()+"\",\r\n" + 
	        		"    \"id\": \"f87c9a61-1ba0-4d32-a152-3433b4f48bd1\"\r\n" + 
	        		"  }\r\n" + 
	        		"]";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public String   getPayloadforChargeTemplatePUTFloat(String termLoan) {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \""+termLoan+"\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeCode\": {\r\n" + 
	        		"      \"id\": \"231232\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"natSign\": \"+\",\r\n" + 
	        		"    \"frequency\": \"manual\",\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"value\": \""+ getValues()+"\",\r\n" + 
	        		"    \"id\": \"0733e948-243e-4061-be9a-0d4e191c5e4e\"\r\n" + 
	        		"  }\r\n" + 
	        		"]";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	    
	    
	    public String getPayloadforchargecodes() {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \"\",\r\n" + 
	        		"  \"chargeCode\": \""+getChargeCode()+"\",\r\n" + 
	        		"  \"transactionCode\": \""+getTransactionCode()+"\",\r\n" + 
	        		"  \"natSign\": {\r\n" + 
	        		"    \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"+\",\r\n" + 
	        		"    \"displayName\": \"Plus\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"frequency\": {\r\n" + 
	        		"    \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"manual\",\r\n" + 
	        		"    \"displayName\": \"Manual\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"chargeType\": {\r\n" + 
	        		"    \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"original_loan_amount\",\r\n" + 
	        		"    \"displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"    \"calculationType\": \"percentage\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"postingType\": {\r\n" + 
	        		"    \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"in_bal\",\r\n" + 
	        		"    \"displayName\": \"In Balance\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"value\": \"3\",\r\n" + 
	        		"  \"autoNewClient\": true\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	    
	    public String  getPayloadforManualFeePost() {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"id\": \"ca153a60-16fc-46d6-8565-50bf515c30cc\",\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \"fcdc84ef-a602-4bbd-aa81-a34e3f8a6f74\",\r\n" + 
	        		"      \"loanNumber\": \"33\",\r\n" + 
	        		"      \"loanName\": \"idexcel5\",\r\n" + 
	        		"      \"loanType\": {\r\n" + 
	        		"        \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"term_loan\",\r\n" + 
	        		"        \"display\": null\r\n" + 
	        		"      },\r\n" + 
	        		"      \"currency\": {\r\n" + 
	        		"        \"id\": 5,\r\n" + 
	        		"        \"currencyCode\": \"USD\",\r\n" + 
	        		"        \"description\": \"US Dollar\",\r\n" + 
	        		"        \"decimalPrecision\": 6,\r\n" + 
	        		"        \"systemDefined\": false\r\n" + 
	        		"      },\r\n" + 
	        		"      \"principalAmount\": 1000,\r\n" + 
	        		"      \"interestRate\": 2,\r\n" + 
	        		"      \"divisor\": 12,\r\n" + 
	        		"      \"interestStartDate\": null,\r\n" + 
	        		"      \"termType\": {\r\n" + 
	        		"        \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"months\",\r\n" + 
	        		"        \"display\": null\r\n" + 
	        		"      },\r\n" + 
	        		"      \"terms\": 2,\r\n" + 
	        		"      \"originationDate\": \"8/28/19 12:00 AM\",\r\n" + 
	        		"      \"disbursementDate\": \"7/7/19 12:00 AM\",\r\n" + 
	        		"      \"maturityDate\": \"10/29/19 12:00 AM\",\r\n" + 
	        		"      \"initialPaymentDate\": \"04/23/2020\",\r\n" + 
	        		"      \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"      \"borrower\": {\r\n" + 
	        		"        \"id\": 11622,\r\n" + 
	        		"        \"name\": ABH-001\r\n" + 
	        		"      },\r\n" + 
	        		"      \"interestRevised\": false,\r\n" + 
	        		"      \"revisedInterestRate\": 0,\r\n" + 
	        		"      \"revisedInterestDateEffectiveDate\": null,\r\n" + 
	        		"      \"comments\": null,\r\n" + 
	        		"      \"precision\": 3\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeCode\": {\r\n" + 
	        		"      \"id\": \"dbb98edb-65bc-47b0-a138-b80ba9e3eba7\",\r\n" + 
	        		"      \"chargeCode\": \"77883949\",\r\n" + 
	        		"      \"transactionCode\": 1636886,\r\n" + 
	        		"      \"sequence\": 1,\r\n" + 
	        		"      \"natSign\": {\r\n" + 
	        		"        \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"+\",\r\n" + 
	        		"        \"displayName\": \"Plus\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"frequency\": {\r\n" + 
	        		"        \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"manual\",\r\n" + 
	        		"        \"displayName\": \"Manual\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"chargeType\": {\r\n" + 
	        		"        \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"original_loan_amount\",\r\n" + 
	        		"        \"displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"        \"calculationType\": \"percentage\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"postingType\": {\r\n" + 
	        		"        \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"in_bal\",\r\n" + 
	        		"        \"displayName\": \"In Balance\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"value\": 9,\r\n" + 
	        		"      \"autoNewClient\": true\r\n" + 
	        		"    },\r\n" + 
	        		"    \"natSign\": \"+\",\r\n" + 
	        		"    \"sequence\": 1,\r\n" + 
	        		"    \"frequency\": \"manual\",\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"      \"value\": \"original_loan_amount\",\r\n" + 
	        		"      \"displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"      \"calculationType\": \"percentage\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"value\": null,\r\n" + 
	        		"    \"inBalance\": false,\r\n" + 
	        		"    \"accruedToLoan\": false,\r\n" + 
	        		"    \"percentage\": \""+ getPercentage()+"\",\r\n" + 
	        		"    \"chargeType.displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"    \"chargeTemplate\": {\r\n" + 
	        		"      \"id\": \"01f2710d-1c3c-49ea-9565-d45c3c2d2bfb\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"activityDate\": \"08/17/2020\",\r\n" + 
	        		"    \"selectedCharge\": true,\r\n" + 
	        		"    \"chargedAmount\": 300\r\n" + 
	        		"  }\r\n" + 
	        		"]\r\n" + 
	        		"";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	    public String getPayloadforManualFeePostWithArg(String id,String termLoan_id,String loanNumber,String loanName,String loanType_id,String principalAmount,String interestRate,String totalInterest,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String divisor,String termType_id,String terms,String originationDate,String disbursementDate,String maturityDate,String initialPaymentDate,String loanStatus_id,String gracePeriodDays,String amortizationType,String soFarDisbursement,String balanceDisbursement,String disbursementAmount,String chargeCode_id,String chargeCode,String transactionCode,String natSign_id,String frequency_id,String chargeType_id,String chargeType_value,String displayName,String calculationType,String postingType_id,String postingType_value,String displayName_postingType,String chargeType_displayName,String chargeType_calculationType,String chargeType_DisplayName,String activityDate) {
	    	String getPayloadforManualFeePostWithArg="[\r\n" + 
	    			"  {\r\n" + 
	    			"    \"id\": \""+id+"\",\r\n" + 
	    			"    \"termLoan\": {\r\n" + 
	    			"      \"id\": \""+termLoan_id+"\",\r\n" + 
	    			"      \"loanNumber\": \""+loanNumber+"\",\r\n" + 
	    			"      \"loanName\": \""+loanName+"\",\r\n" + 
	    			"      \"formattedTermloanName\": null,\r\n" + 
	    			"      \"totalOutStandingBalance\": 0,\r\n" + 
	    			"      \"loanType\": {\r\n" + 
	    			"        \"id\": \""+loanType_id+"\",\r\n" + 
	    			"        \"value\": \"term_loan\",\r\n" + 
	    			"        \"display\": \"Term Loan\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"currency\": {\r\n" + 
	    			"        \"id\": 5,\r\n" + 
	    			"        \"currencyCode\": \"USD\",\r\n" + 
	    			"        \"description\": \"USD : US Dollar\",\r\n" + 
	    			"        \"decimalPrecision\": 3,\r\n" + 
	    			"        \"systemDefined\": true\r\n" + 
	    			"      },\r\n" + 
	    			"      \"principalAmount\": "+principalAmount+",\r\n" + 
	    			"      \"interestRate\": "+interestRate+",\r\n" + 
	    			"      \"totalInterest\": "+totalInterest+",\r\n" + 
	    			"      \"rateAdjustment\": 0,\r\n" + 
	    			"      \"revisedInterestRateEffectiveDate\": \""+revisedInterestRateEffectiveDate+"\",\r\n" + 
	    			"      \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	    			"      \"interestRateCode\": "+interestRateCode+",\r\n" + 
	    			"      \"divisor\": "+divisor+",\r\n" + 
	    			"      \"termType\": {\r\n" + 
	    			"        \"id\": \""+termType_id+"\",\r\n" + 
	    			"        \"value\": \"months\",\r\n" + 
	    			"        \"display\": \"Months\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"terms\": "+terms+",\r\n" + 
	    			"      \"originationDate\": \""+originationDate+"\",\r\n" + 
	    			"      \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	    			"      \"maturityDate\": \""+maturityDate+"\",\r\n" + 
	    			"      \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	    			"      \"includeLoanBalanceInReserve\": false,\r\n" + 
	    			"      \"borrower\": {\r\n" + 
	    			"        \"id\": 11622,\r\n" + 
	    			"        \"name\": \"ABH-001\",\r\n" + 
	    			"        \"clientNumber\": \"NABH6\",\r\n" + 
	    			"        \"active\": true,\r\n" + 
	    			"        \"emailId\": \"mahesh.b@idexcel.com\",\r\n" + 
	    			"        \"mailAddresses\": [\r\n" + 
	    			"          {\r\n" + 
	    			"            \"id\": 391,\r\n" + 
	    			"            \"addressCode\": \"23092020\",\r\n" + 
	    			"            \"primaryName\": \"MAHESH\",\r\n" + 
	    			"            \"alternateName\": \"\",\r\n" + 
	    			"            \"streetAddress\": \"BTM 2ND STAGE BANGALORE\",\r\n" + 
	    			"            \"city\": \"BANGALORE\",\r\n" + 
	    			"            \"stateProvince\": \"205\",\r\n" + 
	    			"            \"zipCode\": \"2002\",\r\n" + 
	    			"            \"country\": \"United States\",\r\n" + 
	    			"            \"phoneNumber\": \"+918553432171\",\r\n" + 
	    			"            \"primaryAddr\": true\r\n" + 
	    			"          }\r\n" + 
	    			"        ]\r\n" + 
	    			"      },\r\n" + 
	    			"      \"comments\": null,\r\n" + 
	    			"      \"precision\": 2,\r\n" + 
	    			"      \"loanStatus\": {\r\n" + 
	    			"        \"id\": \""+loanStatus_id+"\",\r\n" + 
	    			"        \"displayName\": \"Active\",\r\n" + 
	    			"        \"value\": \"active\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"paidOffDate\": null,\r\n" + 
	    			"      \"allowNegative\": false,\r\n" + 
	    			"      \"gracePeriodDays\": "+gracePeriodDays+",\r\n" + 
	    			"      \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	    			"      \"interestRatePrecision\": 0,\r\n" + 
	    			"      \"fixedPrincipal\": 0,\r\n" + 
	    			"      \"editedFixedPrincipal\": false,\r\n" + 
	    			"      \"soFarDisbursement\": "+soFarDisbursement+",\r\n" + 
	    			"      \"balanceDisbursement\": "+balanceDisbursement+",\r\n" + 
	    			"      \"disbursementAmount\": "+disbursementAmount+"\r\n" + 
	    			"    },\r\n" + 
	    			"    \"chargeCode\": {\r\n" + 
	    			"      \"id\": \""+chargeCode_id+"\",\r\n" + 
	    			"      \"chargeCode\": \""+chargeCode+"\",\r\n" + 
	    			"      \"transactionCode\": "+transactionCode+",\r\n" + 
	    			"      \"sequence\": 1,\r\n" + 
	    			"      \"natSign\": {\r\n" + 
	    			"        \"id\": \""+natSign_id+"\",\r\n" + 
	    			"        \"value\": \"+\",\r\n" + 
	    			"        \"displayName\": \"Plus\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"frequency\": {\r\n" + 
	    			"        \"id\": \""+frequency_id+"+\",\r\n" + 
	    			"        \"value\": \"manual\",\r\n" + 
	    			"        \"displayName\": \"Manual\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"chargeType\": {\r\n" + 
	    			"        \"id\": \""+chargeType_id+"\",\r\n" + 
	    			"        \"value\": \""+chargeType_value+"\",\r\n" + 
	    			"        \"displayName\": \""+displayName+"\",\r\n" + 
	    			"        \"calculationType\": \""+calculationType+"\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"postingType\": {\r\n" + 
	    			"        \"id\": \""+postingType_id+"\",\r\n" + 
	    			"        \"value\": \""+postingType_value+"\",\r\n" + 
	    			"        \"displayName\": \""+displayName_postingType+"\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"value\": 20,\r\n" + 
	    			"      \"autoNewClient\": true\r\n" + 
	    			"    },\r\n" + 
	    			"    \"natSign\": \"+\",\r\n" + 
	    			"    \"sequence\": 1,\r\n" + 
	    			"    \"frequency\": \"manual\",\r\n" + 
	    			"    \"chargeType\": {\r\n" + 
	    			"      \"id\": \""+chargeType_id+"\",\r\n" + 
	    			"      \"value\": \""+chargeType_value+"\",\r\n" + 
	    			"      \"displayName\": \""+displayName+"\",\r\n" + 
	    			"      \"calculationType\": \""+calculationType+"\"\r\n" + 
	    			"    },\r\n" + 
	    			"    \"value\": null,\r\n" + 
	    			"    \"inBalance\": false,\r\n" + 
	    			"    \"accruedToLoan\": false,\r\n" + 
	    			"    \"percentage\": 20,\r\n" + 
	    			"    \"chargeType.displayName\": \""+displayName+"\",\r\n" + 
	    			"    \"selectedCharge\": true,\r\n" + 
	    			"    \"chargeTemplate\": {\r\n" + 
	    			"      \"id\": \"004742be-f12d-41a0-9407-fabb16527cc2\"\r\n" + 
	    			"    },\r\n" + 
	    			"    \"activityDate\": \""+activityDate+"\"\r\n" + 
	    			"  }\r\n" + 
	    			"]";
			return getPayloadforManualFeePostWithArg;
	    }
public String getPayloadforManualFeePostWithArgument(String LoanNumber,String LoanName,String PrincipalAmount,String Intrest,String Originationdate,String Disburnsmentdate,String MaturityDate,String InitialPaymentdate,String responseOfPreview) {
			
	    	String requestBodyForChargeCode="[\r\n" + 
	    			"  {\r\n" + 
	    			"    \"id\": \"0107b426-7a75-432f-aef2-fd0f29eda527\",\r\n" + 
	    			"    \"termLoan\": {\r\n" + 
	    			"      \"id\": \"30fbc4dc-68d2-4c79-8e9a-f2139315dd86\",\r\n" + 
	    			"      \"loanNumber\": \"kutgv5\",\r\n" + 
	    			"      \"loanName\": \"kutgv5 : tanshun\",\r\n" + 
	    			"      \"formattedTermloanName\": null,\r\n" + 
	    			"      \"totalOutStandingBalance\": 0,\r\n" + 
	    			"      \"loanType\": {\r\n" + 
	    			"        \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	    			"        \"value\": \"term_loan\",\r\n" + 
	    			"        \"display\": \"Term Loan\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"currency\": {\r\n" + 
	    			"        \"id\": 5,\r\n" + 
	    			"        \"currencyCode\": \"USD\",\r\n" + 
	    			"        \"description\": \"USD : US Dollar\",\r\n" + 
	    			"        \"decimalPrecision\": 3,\r\n" + 
	    			"        \"systemDefined\": true\r\n" + 
	    			"      },\r\n" + 
	    			"      \"principalAmount\": 4000,\r\n" + 
	    			"      \"interestRate\": 2,\r\n" + 
	    			"      \"totalInterest\": 2,\r\n" + 
	    			"      \"rateAdjustment\": 2,\r\n" + 
	    			"      \"revisedInterestRateEffectiveDate\": \"07/07/2020\",\r\n" + 
	    			"      \"interestRateType\": \"fixed\",\r\n" + 
	    			"      \"interestRateCode\": 0,\r\n" + 
	    			"      \"divisor\": 12,\r\n" + 
	    			"      \"termType\": {\r\n" + 
	    			"        \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	    			"        \"value\": \"months\",\r\n" + 
	    			"        \"display\": \"Months\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"terms\": 12,\r\n" + 
	    			"      \"originationDate\": \"07/07/2020\",\r\n" + 
	    			"      \"disbursementDate\": \"08/06/2020\",\r\n" + 
	    			"      \"maturityDate\": \"07/07/2021\",\r\n" + 
	    			"      \"initialPaymentDate\": \"08/07/2020\",\r\n" + 
	    			"      \"includeLoanBalanceInReserve\": false,\r\n" + 
	    			"      \"borrower\": {\r\n" + 
	    			"        \"id\": 11536,\r\n" + 
	    			"        \"name\": \"MAHESH_TEST\",\r\n" + 
	    			"        \"clientNumber\": \"21052020\",\r\n" + 
	    			"        \"active\": true,\r\n" + 
	    			"        \"emailId\": \"\",\r\n" + 
	    			"        \"mailAddresses\": []\r\n" + 
	    			"      },\r\n" + 
	    			"      \"comments\": null,\r\n" + 
	    			"      \"precision\": 2,\r\n" + 
	    			"      \"loanStatus\": {\r\n" + 
	    			"        \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	    			"        \"displayName\": \"Active\",\r\n" + 
	    			"        \"value\": \"active\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"paidOffDate\": null,\r\n" + 
	    			"      \"allowNegative\": false,\r\n" + 
	    			"      \"gracePeriodDays\": 0,\r\n" + 
	    			"      \"amortizationType\": \"normal\",\r\n" + 
	    			"      \"interestRatePrecision\": 0\r\n" + 
	    			"    },\r\n" + 
	    			"    \"chargeCode\": {\r\n" + 
	    			"      \"id\": \"ada75570-5b5b-4a9e-b3c5-41024a00b81e\",\r\n" + 
	    			"      \"chargeCode\": \"70162660\",\r\n" + 
	    			"      \"transactionCode\": 4788792,\r\n" + 
	    			"      \"sequence\": 1,\r\n" + 
	    			"      \"natSign\": {\r\n" + 
	    			"        \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	    			"        \"value\": \"+\",\r\n" + 
	    			"        \"displayName\": \"Plus\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"frequency\": {\r\n" + 
	    			"        \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	    			"        \"value\": \"manual\",\r\n" + 
	    			"        \"displayName\": \"Manual\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"chargeType\": {\r\n" + 
	    			"        \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	    			"        \"value\": \"original_loan_amount\",\r\n" + 
	    			"        \"displayName\": \"On Original Loan Amount\",\r\n" + 
	    			"        \"calculationType\": \"percentage\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"postingType\": {\r\n" + 
	    			"        \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	    			"        \"value\": \"in_bal\",\r\n" + 
	    			"        \"displayName\": \"In Balance\"\r\n" + 
	    			"      },\r\n" + 
	    			"      \"value\": 90,\r\n" + 
	    			"      \"autoNewClient\": true\r\n" + 
	    			"    },\r\n" + 
	    			"    \"natSign\": \"+\",\r\n" + 
	    			"    \"sequence\": 1,\r\n" + 
	    			"    \"frequency\": \"manual\",\r\n" + 
	    			"    \"chargeType\": {\r\n" + 
	    			"      \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	    			"      \"value\": \"original_loan_amount\",\r\n" + 
	    			"      \"displayName\": \"On Original Loan Amount\",\r\n" + 
	    			"      \"calculationType\": \"percentage\"\r\n" + 
	    			"    },\r\n" + 
	    			"    \"value\": null,\r\n" + 
	    			"    \"inBalance\": false,\r\n" + 
	    			"    \"accruedToLoan\": false,\r\n" + 
	    			"    \"percentage\": 90,\r\n" + 
	    			"    \"chargeType.displayName\": \"On Original Loan Amount\",\r\n" + 
	    			"    \"selectedCharge\": true,\r\n" + 
	    			"    \"chargeTemplate\": {\r\n" + 
	    			"      \"id\": \"0107b426-7a75-432f-aef2-fd0f29eda527\"\r\n" + 
	    			"    },\r\n" + 
	    			"    \"activityDate\": \"09/24/2020\"\r\n" + 
	    			"  }\r\n" + 
	    			"]";
	    	return requestBodyForChargeCode;
	    	
	    }
	        
public String getPayloadforAddManualFeePostWithArgument(String LoanNumber,String LoanName,String PrincipalAmount,String Intrest,String Originationdate,String Disburnsmentdate,String MaturityDate,String InitialPaymentdate,String responseOfPreview) {
	
	String requestBodyForChargeCode="[\r\n" + 
			"  {\r\n" + 
			"    \"id\": \"0107b426-7a75-432f-aef2-fd0f29eda527\",\r\n" + 
			"    \"termLoan\": {\r\n" + 
			"      \"id\": \"30fbc4dc-68d2-4c79-8e9a-f2139315dd86\",\r\n" + 
			"      \"loanNumber\": \"kutgv5\",\r\n" + 
			"      \"loanName\": \"kutgv5 : tanshun\",\r\n" + 
			"      \"formattedTermloanName\": null,\r\n" + 
			"      \"totalOutStandingBalance\": 0,\r\n" + 
			"      \"loanType\": {\r\n" + 
			"        \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
			"        \"value\": \"term_loan\",\r\n" + 
			"        \"display\": \"Term Loan\"\r\n" + 
			"      },\r\n" + 
			"      \"currency\": {\r\n" + 
			"        \"id\": 5,\r\n" + 
			"        \"currencyCode\": \"USD\",\r\n" + 
			"        \"description\": \"USD : US Dollar\",\r\n" + 
			"        \"decimalPrecision\": 3,\r\n" + 
			"        \"systemDefined\": true\r\n" + 
			"      },\r\n" + 
			"      \"principalAmount\": 4000,\r\n" + 
			"      \"interestRate\": 2,\r\n" + 
			"      \"totalInterest\": 2,\r\n" + 
			"      \"rateAdjustment\": 2,\r\n" + 
			"      \"revisedInterestRateEffectiveDate\": \"07/07/2020\",\r\n" + 
			"      \"interestRateType\": \"fixed\",\r\n" + 
			"      \"interestRateCode\": 0,\r\n" + 
			"      \"divisor\": 12,\r\n" + 
			"      \"termType\": {\r\n" + 
			"        \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
			"        \"value\": \"months\",\r\n" + 
			"        \"display\": \"Months\"\r\n" + 
			"      },\r\n" + 
			"      \"terms\": 12,\r\n" + 
			"      \"originationDate\": \"07/07/2020\",\r\n" + 
			"      \"disbursementDate\": \"08/06/2020\",\r\n" + 
			"      \"maturityDate\": \"07/07/2021\",\r\n" + 
			"      \"initialPaymentDate\": \"08/07/2020\",\r\n" + 
			"      \"includeLoanBalanceInReserve\": false,\r\n" + 
			"      \"borrower\": {\r\n" + 
			"        \"id\": 11536,\r\n" + 
			"        \"name\": \"MAHESH_TEST\",\r\n" + 
			"        \"clientNumber\": \"21052020\",\r\n" + 
			"        \"active\": true,\r\n" + 
			"        \"emailId\": \"\",\r\n" + 
			"        \"mailAddresses\": []\r\n" + 
			"      },\r\n" + 
			"      \"comments\": null,\r\n" + 
			"      \"precision\": 2,\r\n" + 
			"      \"loanStatus\": {\r\n" + 
			"        \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
			"        \"displayName\": \"Active\",\r\n" + 
			"        \"value\": \"active\"\r\n" + 
			"      },\r\n" + 
			"      \"paidOffDate\": null,\r\n" + 
			"      \"allowNegative\": false,\r\n" + 
			"      \"gracePeriodDays\": 0,\r\n" + 
			"      \"amortizationType\": \"normal\",\r\n" + 
			"      \"interestRatePrecision\": 0\r\n" + 
			"    },\r\n" + 
			"    \"chargeCode\": {\r\n" + 
			"      \"id\": \"ada75570-5b5b-4a9e-b3c5-41024a00b81e\",\r\n" + 
			"      \"chargeCode\": \"70162660\",\r\n" + 
			"      \"transactionCode\": 4788792,\r\n" + 
			"      \"sequence\": 1,\r\n" + 
			"      \"natSign\": {\r\n" + 
			"        \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
			"        \"value\": \"+\",\r\n" + 
			"        \"displayName\": \"Plus\"\r\n" + 
			"      },\r\n" + 
			"      \"frequency\": {\r\n" + 
			"        \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
			"        \"value\": \"manual\",\r\n" + 
			"        \"displayName\": \"Manual\"\r\n" + 
			"      },\r\n" + 
			"      \"chargeType\": {\r\n" + 
			"        \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
			"        \"value\": \"original_loan_amount\",\r\n" + 
			"        \"displayName\": \"On Original Loan Amount\",\r\n" + 
			"        \"calculationType\": \"percentage\"\r\n" + 
			"      },\r\n" + 
			"      \"postingType\": {\r\n" + 
			"        \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
			"        \"value\": \"in_bal\",\r\n" + 
			"        \"displayName\": \"In Balance\"\r\n" + 
			"      },\r\n" + 
			"      \"value\": 90,\r\n" + 
			"      \"autoNewClient\": true\r\n" + 
			"    },\r\n" + 
			"    \"natSign\": \"+\",\r\n" + 
			"    \"sequence\": 1,\r\n" + 
			"    \"frequency\": \"manual\",\r\n" + 
			"    \"chargeType\": {\r\n" + 
			"      \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
			"      \"value\": \"original_loan_amount\",\r\n" + 
			"      \"displayName\": \"On Original Loan Amount\",\r\n" + 
			"      \"calculationType\": \"percentage\"\r\n" + 
			"    },\r\n" + 
			"    \"value\": null,\r\n" + 
			"    \"inBalance\": false,\r\n" + 
			"    \"accruedToLoan\": false,\r\n" + 
			"    \"percentage\": 90,\r\n" + 
			"    \"chargeType.displayName\": \"On Original Loan Amount\",\r\n" + 
			"    \"selectedCharge\": true,\r\n" + 
			"    \"chargeTemplate\": {\r\n" + 
			"      \"id\": \"0107b426-7a75-432f-aef2-fd0f29eda527\"\r\n" + 
			"    },\r\n" + 
			"    \"activityDate\": \"09/24/2020\"\r\n" + 
			"  }\r\n" + 
			"]";
	return requestBodyForChargeCode;
	
}
    
 public  String getPayloadForCreateBatch(String batch_date,String ref_batch_no,String total_amount) {
	String requestBodyForCreateBatch = "{\r\n" + 
			"   \"batch\":{\r\n" + 
			"      \"batch_date\":\""+batch_date+"\",\r\n" + 
			"      \"ref_batch_no\":"+ref_batch_no+",\r\n" + 
			"      \"total_amount\":\""+total_amount+"\",\r\n" + 
			"      \"image_split\":false\r\n" + 
			"   },\r\n" + 
			"   \"check_parameters\":[\r\n" + 
			"      \r\n" + 
			"   ]\r\n" + 
			"}";
	return requestBodyForCreateBatch;
	
}
	    public String  getPayloadforManualFeePostValue() {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"id\": \"ca153a60-16fc-46d6-8565-50bf515c30cc\",\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \"fcdc84ef-a602-4bbd-aa81-a34e3f8a6f74\",\r\n" + 
	        		"      \"loanNumber\": \"33\",\r\n" + 
	        		"      \"loanName\": \"idexcel5\",\r\n" + 
	        		"      \"loanType\": {\r\n" + 
	        		"        \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"term_loan\",\r\n" + 
	        		"        \"display\": null\r\n" + 
	        		"      },\r\n" + 
	        		"      \"currency\": {\r\n" + 
	        		"        \"id\": 5,\r\n" + 
	        		"        \"currencyCode\": \"USD\",\r\n" + 
	        		"        \"description\": \"US Dollar\",\r\n" + 
	        		"        \"decimalPrecision\": 6,\r\n" + 
	        		"        \"systemDefined\": false\r\n" + 
	        		"      },\r\n" + 
	        		"      \"principalAmount\": 1000,\r\n" + 
	        		"      \"interestRate\": 2,\r\n" + 
	        		"      \"divisor\": 12,\r\n" + 
	        		"      \"interestStartDate\": null,\r\n" + 
	        		"      \"termType\": {\r\n" + 
	        		"        \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"months\",\r\n" + 
	        		"        \"display\": null\r\n" + 
	        		"      },\r\n" + 
	        		"      \"terms\": 2,\r\n" + 
	        		"      \"originationDate\": \"8/28/19 12:00 AM\",\r\n" + 
	        		"      \"disbursementDate\": \"7/7/19 12:00 AM\",\r\n" + 
	        		"      \"maturityDate\": \"10/29/19 12:00 AM\",\r\n" + 
	        		"      \"initialPaymentDate\": \"9/29/19 12:00 AM\",\r\n" + 
	        		"      \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"      \"borrower\": {\r\n" + 
	        		"        \"id\": 8205,\r\n" + 
	        		"        \"name\": null\r\n" + 
	        		"      },\r\n" + 
	        		"      \"interestRevised\": false,\r\n" + 
	        		"      \"revisedInterestRate\": 0,\r\n" + 
	        		"      \"revisedInterestDateEffectiveDate\": null,\r\n" + 
	        		"      \"comments\": null,\r\n" + 
	        		"      \"precision\": 3\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeCode\": {\r\n" + 
	        		"      \"id\": \"e71703aa-bda8-4c72-9df0-cc846e7cbac7\",\r\n" + 
	        		"      \"chargeCode\": \"popp\",\r\n" + 
	        		"      \"transactionCode\": 8989,\r\n" + 
	        		"      \"sequence\": 1,\r\n" + 
	        		"      \"natSign\": {\r\n" + 
	        		"        \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"+\",\r\n" + 
	        		"        \"displayName\": \"Plus\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"frequency\": {\r\n" + 
	        		"        \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"manual\",\r\n" + 
	        		"        \"displayName\": \"Manual\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"chargeType\": {\r\n" + 
	        		"        \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"original_loan_amount\",\r\n" + 
	        		"        \"displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"        \"calculationType\": \"percentage\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"postingType\": {\r\n" + 
	        		"        \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"in_bal\",\r\n" + 
	        		"        \"displayName\": \"In Balance\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"value\": 9,\r\n" + 
	        		"      \"autoNewClient\": true\r\n" + 
	        		"    },\r\n" + 
	        		"    \"natSign\": \"+\",\r\n" + 
	        		"    \"sequence\": 1,\r\n" + 
	        		"    \"frequency\": \"manual\",\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"      \"value\": \"original_loan_amount\",\r\n" + 
	        		"      \"displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"      \"calculationType\": \"percentage\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"value\": null,\r\n" + 
	        		"    \"inBalance\": false,\r\n" + 
	        		"    \"accruedToLoan\": false,\r\n" + 
	        		"    \"percentage\": \""+ getPercentage()+"\",\r\n" + 
	        		"    \"chargeType.displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"    \"chargeTemplate\": {\r\n" + 
	        		"      \"id\": \"ca153a60-16fc-46d6-8565-50bf515c30cc\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"activityDate\": \"09/24/2019\",\r\n" + 
	        		"    \"selectedCharge\": true,\r\n" + 
	        		"    \"chargedAmount\": 300\r\n" + 
	        		"  }\r\n" + 
	        		"]\r\n" + 
	        		"";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    

		public String getPayloadsforManualNegativePercentage(String data) {
			String rqst="[\r\n" + 
					"  {\r\n" + 
					"    \"id\": \"ca153a60-16fc-46d6-8565-50bf515c30cc\",\r\n" + 
					"    \"termLoan\": {\r\n" + 
					"      \"id\": \"fcdc84ef-a602-4bbd-aa81-a34e3f8a6f74\",\r\n" + 
					"      \"loanNumber\": \"33\",\r\n" + 
					"      \"loanName\": \"idexcel5\",\r\n" + 
					"      \"loanType\": {\r\n" + 
					"        \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"term_loan\",\r\n" + 
					"        \"display\": null\r\n" + 
					"      },\r\n" + 
					"      \"currency\": {\r\n" + 
					"        \"id\": 5,\r\n" + 
					"        \"currencyCode\": \"USD\",\r\n" + 
					"        \"description\": \"US Dollar\",\r\n" + 
					"        \"decimalPrecision\": 6,\r\n" + 
					"        \"systemDefined\": false\r\n" + 
					"      },\r\n" + 
					"      \"principalAmount\": 1000,\r\n" + 
					"      \"interestRate\": 2,\r\n" + 
					"      \"divisor\": 12,\r\n" + 
					"      \"interestStartDate\": null,\r\n" + 
					"      \"termType\": {\r\n" + 
					"        \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"months\",\r\n" + 
					"        \"display\": null\r\n" + 
					"      },\r\n" + 
					"      \"terms\": 2,\r\n" + 
					"      \"originationDate\": \"8/28/19 12:00 AM\",\r\n" + 
					"      \"disbursementDate\": \"7/7/19 12:00 AM\",\r\n" + 
					"      \"maturityDate\": \"10/29/19 12:00 AM\",\r\n" + 
					"      \"initialPaymentDate\": \"9/29/19 12:00 AM\",\r\n" + 
					"      \"includeLoanBalanceInReserve\": false,\r\n" + 
					"      \"borrower\": {\r\n" + 
					"        \"id\": 8205,\r\n" + 
					"        \"name\": null\r\n" + 
					"      },\r\n" + 
					"      \"interestRevised\": false,\r\n" + 
					"      \"revisedInterestRate\": 0,\r\n" + 
					"      \"revisedInterestDateEffectiveDate\": null,\r\n" + 
					"      \"comments\": null,\r\n" + 
					"      \"precision\": 3\r\n" + 
					"    },\r\n" + 
					"    \"chargeCode\": {\r\n" + 
					"      \"id\": \"e71703aa-bda8-4c72-9df0-cc846e7cbac7\",\r\n" + 
					"      \"chargeCode\": \"popp\",\r\n" + 
					"      \"transactionCode\": 8989,\r\n" + 
					"      \"sequence\": 1,\r\n" + 
					"      \"natSign\": {\r\n" + 
					"        \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"+\",\r\n" + 
					"        \"displayName\": \"Plus\"\r\n" + 
					"      },\r\n" + 
					"      \"frequency\": {\r\n" + 
					"        \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"manual\",\r\n" + 
					"        \"displayName\": \"Manual\"\r\n" + 
					"      },\r\n" + 
					"      \"chargeType\": {\r\n" + 
					"        \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"original_loan_amount\",\r\n" + 
					"        \"displayName\": \"On Original Loan Amount\",\r\n" + 
					"        \"calculationType\": \"percentage\"\r\n" + 
					"      },\r\n" + 
					"      \"postingType\": {\r\n" + 
					"        \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"in_bal\",\r\n" + 
					"        \"displayName\": \"In Balance\"\r\n" + 
					"      },\r\n" + 
					"      \"value\": 9,\r\n" + 
					"      \"autoNewClient\": true\r\n" + 
					"    },\r\n" + 
					"    \"natSign\": \"+\",\r\n" + 
					"    \"sequence\": 1,\r\n" + 
					"    \"frequency\": \"manual\",\r\n" + 
					"    \"chargeType\": {\r\n" + 
					"      \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"      \"value\": \"original_loan_amount\",\r\n" + 
					"      \"displayName\": \"On Original Loan Amount\",\r\n" + 
					"      \"calculationType\": \"percentage\"\r\n" + 
					"    },\r\n" + 
					"    \"value\": null,\r\n" + 
					"    \"inBalance\": false,\r\n" + 
					"    \"accruedToLoan\": false,\r\n" + 
					"    \"percentage\": \""+data+"\",\r\n" + 
					"    \"chargeType.displayName\": \"On Original Loan Amount\",\r\n" + 
					"    \"chargeTemplate\": {\r\n" + 
					"      \"id\": \"ca153a60-16fc-46d6-8565-50bf515c30cc\"\r\n" + 
					"    },\r\n" + 
					"    \"activityDate\": \"09/28/2019\",\r\n" + 
					"    \"selectedCharge\": true,\r\n" + 
					"    \"chargedAmount\": 300\r\n" + 
					"  }\r\n" + 
					"]";
			return rqst;
		}
	    

		public String getPayloadforManualFeePostValue(String data) {
			String rqst="[\r\n" + 
					"  {\r\n" + 
					"    \"id\": \"4511de84-3073-4538-90b1-19fee4845cfa\",\r\n" + 
					"    \"termLoan\": {\r\n" + 
					"      \"id\": \"fcdc84ef-a602-4bbd-aa81-a34e3f8a6f74\",\r\n" + 
					"      \"loanNumber\": \"33\",\r\n" + 
					"      \"loanName\": \"idexcel5\",\r\n" + 
					"      \"loanType\": {\r\n" + 
					"        \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"term_loan\",\r\n" + 
					"        \"display\": null\r\n" + 
					"      },\r\n" + 
					"      \"currency\": {\r\n" + 
					"        \"id\": 5,\r\n" + 
					"        \"currencyCode\": \"USD\",\r\n" + 
					"        \"description\": \"US Dollar\",\r\n" + 
					"        \"decimalPrecision\": 6,\r\n" + 
					"        \"systemDefined\": false\r\n" + 
					"      },\r\n" + 
					"      \"principalAmount\": 1000,\r\n" + 
					"      \"interestRate\": 2,\r\n" + 
					"      \"divisor\": 12,\r\n" + 
					"      \"interestStartDate\": null,\r\n" + 
					"      \"termType\": {\r\n" + 
					"        \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"months\",\r\n" + 
					"        \"display\": null\r\n" + 
					"      },\r\n" + 
					"      \"terms\": 2,\r\n" + 
					"      \"originationDate\": \"8/28/19 12:00 AM\",\r\n" + 
					"      \"disbursementDate\": \"7/7/19 12:00 AM\",\r\n" + 
					"      \"maturityDate\": \"10/29/19 12:00 AM\",\r\n" + 
					"      \"initialPaymentDate\": \"9/29/19 12:00 AM\",\r\n" + 
					"      \"includeLoanBalanceInReserve\": false,\r\n" + 
					"      \"borrower\": {\r\n" + 
					"        \"id\": 8205,\r\n" + 
					"        \"name\": null\r\n" + 
					"      },\r\n" + 
					"      \"interestRevised\": false,\r\n" + 
					"      \"revisedInterestRate\": 0,\r\n" + 
					"      \"revisedInterestDateEffectiveDate\": null,\r\n" + 
					"      \"comments\": null,\r\n" + 
					"      \"precision\": 3\r\n" + 
					"    },\r\n" + 
					"    \"chargeCode\": {\r\n" + 
					"      \"id\": \"e9bb1eae-655a-4cf7-850c-0e0504e8facc\",\r\n" + 
					"      \"chargeCode\": \"fragment1\",\r\n" + 
					"      \"transactionCode\": 4878,\r\n" + 
					"      \"sequence\": 1,\r\n" + 
					"      \"natSign\": {\r\n" + 
					"        \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"+\",\r\n" + 
					"        \"displayName\": \"Plus\"\r\n" + 
					"      },\r\n" + 
					"      \"frequency\": {\r\n" + 
					"        \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"manual\",\r\n" + 
					"        \"displayName\": \"Manual\"\r\n" + 
					"      },\r\n" + 
					"      \"chargeType\": {\r\n" + 
					"        \"id\": \"eba0a5fc-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"value\",\r\n" + 
					"        \"displayName\": \"Value\",\r\n" + 
					"        \"calculationType\": \"absolute\"\r\n" + 
					"      },\r\n" + 
					"      \"postingType\": {\r\n" + 
					"        \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"in_bal\",\r\n" + 
					"        \"displayName\": \"In Balance\"\r\n" + 
					"      },\r\n" + 
					"      \"value\": 478,\r\n" + 
					"      \"autoNewClient\": true\r\n" + 
					"    },\r\n" + 
					"    \"natSign\": \"+\",\r\n" + 
					"    \"sequence\": 1,\r\n" + 
					"    \"frequency\": \"manual\",\r\n" + 
					"    \"chargeType\": {\r\n" + 
					"      \"id\": \"eba0a5fc-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"      \"value\": \"value\",\r\n" + 
					"      \"displayName\": \"Value\",\r\n" + 
					"      \"calculationType\": \"absolute\"\r\n" + 
					"    },\r\n" + 
					"    \"value\": \""+getValueforFee()+"\",\r\n" + 
					"    \"inBalance\": false,\r\n" + 
					"    \"accruedToLoan\": false,\r\n" + 
					"    \"chargeType.displayName\": \"Value\",\r\n" + 
					"    \"selectedCharge\": true,\r\n" + 
					"    \"chargeTemplate\": {\r\n" + 
					"      \"id\": \"4511de84-3073-4538-90b1-19fee4845cfa\"\r\n" + 
					"    },\r\n" + 
					"    \"activityDate\": \"09/24/2019\",\r\n" + 
					"    \"chargedAmount\": 500\r\n" + 
					"  }\r\n" + 
					"]";
			return rqst;
		}
	    
		

		public String getPayloadforManualValueNegative(String Data) {
			String rqst="[\r\n" + 
					"  {\r\n" + 
					"    \"id\": \"4511de84-3073-4538-90b1-19fee4845cfa\",\r\n" + 
					"    \"termLoan\": {\r\n" + 
					"      \"id\": \"fcdc84ef-a602-4bbd-aa81-a34e3f8a6f74\",\r\n" + 
					"      \"loanNumber\": \"33\",\r\n" + 
					"      \"loanName\": \"idexcel5\",\r\n" + 
					"      \"loanType\": {\r\n" + 
					"        \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"term_loan\",\r\n" + 
					"        \"display\": null\r\n" + 
					"      },\r\n" + 
					"      \"currency\": {\r\n" + 
					"        \"id\": 5,\r\n" + 
					"        \"currencyCode\": \"USD\",\r\n" + 
					"        \"description\": \"US Dollar\",\r\n" + 
					"        \"decimalPrecision\": 6,\r\n" + 
					"        \"systemDefined\": false\r\n" + 
					"      },\r\n" + 
					"      \"principalAmount\": 1000,\r\n" + 
					"      \"interestRate\": 2,\r\n" + 
					"      \"divisor\": 12,\r\n" + 
					"      \"interestStartDate\": null,\r\n" + 
					"      \"termType\": {\r\n" + 
					"        \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"months\",\r\n" + 
					"        \"display\": null\r\n" + 
					"      },\r\n" + 
					"      \"terms\": 2,\r\n" + 
					"      \"originationDate\": \"8/28/19 12:00 AM\",\r\n" + 
					"      \"disbursementDate\": \"7/7/19 12:00 AM\",\r\n" + 
					"      \"maturityDate\": \"10/29/19 12:00 AM\",\r\n" + 
					"      \"initialPaymentDate\": \"9/29/19 12:00 AM\",\r\n" + 
					"      \"includeLoanBalanceInReserve\": false,\r\n" + 
					"      \"borrower\": {\r\n" + 
					"        \"id\": 8205,\r\n" + 
					"        \"name\": null\r\n" + 
					"      },\r\n" + 
					"      \"interestRevised\": false,\r\n" + 
					"      \"revisedInterestRate\": 0,\r\n" + 
					"      \"revisedInterestDateEffectiveDate\": null,\r\n" + 
					"      \"comments\": null,\r\n" + 
					"      \"precision\": 3\r\n" + 
					"    },\r\n" + 
					"    \"chargeCode\": {\r\n" + 
					"      \"id\": \"e9bb1eae-655a-4cf7-850c-0e0504e8facc\",\r\n" + 
					"      \"chargeCode\": \"fragment1\",\r\n" + 
					"      \"transactionCode\": 4878,\r\n" + 
					"      \"sequence\": 1,\r\n" + 
					"      \"natSign\": {\r\n" + 
					"        \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"+\",\r\n" + 
					"        \"displayName\": \"Plus\"\r\n" + 
					"      },\r\n" + 
					"      \"frequency\": {\r\n" + 
					"        \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"manual\",\r\n" + 
					"        \"displayName\": \"Manual\"\r\n" + 
					"      },\r\n" + 
					"      \"chargeType\": {\r\n" + 
					"        \"id\": \"eba0a5fc-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"value\",\r\n" + 
					"        \"displayName\": \"Value\",\r\n" + 
					"        \"calculationType\": \"absolute\"\r\n" + 
					"      },\r\n" + 
					"      \"postingType\": {\r\n" + 
					"        \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"        \"value\": \"in_bal\",\r\n" + 
					"        \"displayName\": \"In Balance\"\r\n" + 
					"      },\r\n" + 
					"      \"value\": 478,\r\n" + 
					"      \"autoNewClient\": true\r\n" + 
					"    },\r\n" + 
					"    \"natSign\": \"+\",\r\n" + 
					"    \"sequence\": 1,\r\n" + 
					"    \"frequency\": \"manual\",\r\n" + 
					"    \"chargeType\": {\r\n" + 
					"      \"id\": \"eba0a5fc-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"      \"value\": \"value\",\r\n" + 
					"      \"displayName\": \"Value\",\r\n" + 
					"      \"calculationType\": \"absolute\"\r\n" + 
					"    },\r\n" + 
					"    \"value\": \""+Data+"\",\r\n" + 
					"    \"inBalance\": false,\r\n" + 
					"    \"accruedToLoan\": false,\r\n" + 
					"    \"chargeType.displayName\": \"Value\",\r\n" + 
					"    \"selectedCharge\": true,\r\n" + 
					"    \"chargeTemplate\": {\r\n" + 
					"      \"id\": \"4511de84-3073-4538-90b1-19fee4845cfa\"\r\n" + 
					"    },\r\n" + 
					"    \"activityDate\": \"09/24/2019\",\r\n" + 
					"    \"chargedAmount\": 500\r\n" + 
					"  }\r\n" + 
					"]";
			return rqst;
		}
		

	    public static String   getPayloadforCollateralSetupDecimal(String loanID) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \""+loanID+"\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"id\": \"\",\r\n" + 
	        		"  \"source\": \"Inventory\",\r\n" + 
	        		"  \"description\": \"Loan\",\r\n" + 
	        		"  \"asOfDate\": \"09/25/2019\",\r\n" + 
	        		"  \"actualValue\": \"1000\",\r\n" + 
	        		"  \"ineligibleCode\": \"Deductible\",\r\n" + 
	        		"  \"ineligibleValue\": \"900\",\r\n" + 
	        		"  \"eligibleValue\": \"\",\r\n" + 
	        		"  \"advanceRate\": \"2.5\",\r\n" + 
	        		"  \"collateralValue\": \"\"\r\n" + 
	        		"}";
	        
	        return requestBodyForChargeCode;}
	    
	    

	    public String  getPayloadforCollateralSetup(String loanID) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \""+loanID+"\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"id\": \"\",\r\n" + 
	        		"  \"source\": \"Inventory\",\r\n" + 
	        		"  \"description\": \"Loan\",\r\n" + 
	        		"  \"asOfDate\": \"09/25/2019\",\r\n" + 
	        		"  \"actualValue\": \"1000\",\r\n" + 
	        		"  \"ineligibleCode\": \"Deductible\",\r\n" + 
	        		"  \"ineligibleValue\": \"900\",\r\n" + 
	        		"  \"eligibleValue\": \"\",\r\n" + 
	        		"  \"advanceRate\": \"2\",\r\n" + 
	        		"  \"collateralValue\": \"\"\r\n" + 
	        		"}";
	        
	        return requestBodyForChargeCode;}
	    
	    
	    
	    
	    
	    
	    
	    
	    public String  getpenaltyRequestbody(String percentage) {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"chargeTemplate\": {\r\n" + 
	        		"      \"id\": \"93d4af94-078c-4876-9458-88ae7a193de9\",\r\n" + 
	        		"      \"termLoan\": {\r\n" + 
	        		"        \"id\": \"62c2d445-a05d-4321-ac42-5e04101af6ca\",\r\n" + 
	        		"        \"loanNumber\": \"01\",\r\n" + 
	        		"        \"loanName\": \"01 : Loan\",\r\n" + 
	        		"        \"formattedTermloanName\": null,\r\n" + 
	        		"        \"totalOutStandingBalance\": 0,\r\n" + 
	        		"        \"loanType\": {\r\n" + 
	        		"          \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"term_loan\",\r\n" + 
	        		"          \"display\": \"Term Loan\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"currency\": {\r\n" + 
	        		"          \"id\": 5,\r\n" + 
	        		"          \"currencyCode\": \"USD\",\r\n" + 
	        		"          \"description\": \"USD : US Dollar\",\r\n" + 
	        		"          \"decimalPrecision\": 4,\r\n" + 
	        		"          \"systemDefined\": false\r\n" + 
	        		"        },\r\n" + 
	        		"        \"principalAmount\": 50000,\r\n" + 
	        		"        \"interestRate\": 2,\r\n" + 
	        		"        \"divisor\": 12,\r\n" + 
	        		"        \"interestStartDate\": \"03/31/2020\",\r\n" + 
	        		"        \"termType\": {\r\n" + 
	        		"          \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"months\",\r\n" + 
	        		"          \"display\": \"Months\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"terms\": 12,\r\n" + 
	        		"        \"originationDate\": \"03/31/2020\",\r\n" + 
	        		"        \"disbursementDate\": null,\r\n" + 
	        		"        \"maturityDate\": \"03/31/2021\",\r\n" + 
	        		"        \"initialPaymentDate\": \"04/30/2020\",\r\n" + 
	        		"        \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"        \"borrower\": {\r\n" + 
	        		"          \"id\": 11040,\r\n" + 
	        		"          \"name\": \"LOAN-3031\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"interestRevised\": false,\r\n" + 
	        		"        \"revisedInterestRate\": 0,\r\n" + 
	        		"        \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	        		"        \"comments\": null,\r\n" + 
	        		"        \"precision\": 4,\r\n" + 
	        		"        \"loanStatus\": {\r\n" + 
	        		"          \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"displayName\": \"Active\",\r\n" + 
	        		"          \"value\": \"active\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"paidOffDate\": null,\r\n" + 
	        		"        \"allowNegative\": false,\r\n" + 
	        		"        \"gracePeriodDays\": 0,\r\n" + 
	        		"        \"rateAdjustment\": 0,\r\n" + 
	        		"        \"totalInterest\": 2\r\n" + 
	        		"      },\r\n" + 
	        		"      \"chargeCode\": {\r\n" + 
	        		"        \"id\": \"64602559-2e12-11ea-9d62-12e987db82ac\",\r\n" + 
	        		"        \"chargeCode\": \"Late Fee Penalty\",\r\n" + 
	        		"        \"transactionCode\": 0,\r\n" + 
	        		"        \"sequence\": 1,\r\n" + 
	        		"        \"natSign\": {\r\n" + 
	        		"          \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"+\",\r\n" + 
	        		"          \"displayName\": \"Plus\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"frequency\": {\r\n" + 
	        		"          \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"manual\",\r\n" + 
	        		"          \"displayName\": \"Manual\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"chargeType\": {\r\n" + 
	        		"          \"id\": \"645eca61-2e12-11ea-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"principal_balance\",\r\n" + 
	        		"          \"displayName\": \"On Payment Due of All Principal Balance Periods\",\r\n" + 
	        		"          \"calculationType\": \"percentage\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"postingType\": {\r\n" + 
	        		"          \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"in_bal\",\r\n" + 
	        		"          \"displayName\": \"In Balance\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"value\": 0,\r\n" + 
	        		"        \"autoNewClient\": true\r\n" + 
	        		"      },\r\n" + 
	        		"      \"natSign\": \"+\",\r\n" + 
	        		"      \"sequence\": 1,\r\n" + 
	        		"      \"frequency\": \"manual\",\r\n" + 
	        		"      \"chargeType\": {\r\n" + 
	        		"        \"id\": \"645eca61-2e12-11ea-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"principal_balance\",\r\n" + 
	        		"        \"displayName\": \"On Payment Due of All Principal Balance Periods\",\r\n" + 
	        		"        \"calculationType\": \"percentage\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"value\": 0,\r\n" + 
	        		"      \"inBalance\": false,\r\n" + 
	        		"      \"accruedToLoan\": false\r\n" + 
	        		"    },\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \"62c2d445-a05d-4321-ac42-5e04101af6ca\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"      \"value\": \"original_loan_amount\",\r\n" + 
	        		"      \"displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"      \"calculationType\": \"percentage\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"activityDate\": \"03/31/2020\",\r\n" + 
	        		"    \"percentage\": "+percentage+",\r\n" + 
	        		"    \"value\": 0,\r\n" + 
	        		"    \"chargedAmount\": 0,\r\n" + 
	        		"    \"principalAmount\": null,\r\n" + 
	        		"    \"outstandingPrincipal\": null,\r\n" + 
	        		"    \"totalPaymentDue\": null,\r\n" + 
	        		"    \"balanceDue\": null,\r\n" + 
	        		"    \"principalBalance\": null,\r\n" + 
	        		"    \"pastDueDays\": 2\r\n" + 
	        		"  }]\r\n" + 
	        		"";
	        
	        return requestBodyForChargeCode;}
	    
	    
	    public String getpenaltyRequestbodyForvalue(String value) {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"chargeTemplate\": {\r\n" + 
	        		"      \"id\": \"8abf38ee-24b9-4114-a3ac-b0bd8c7fa530\",\r\n" + 
	        		"      \"termLoan\": {\r\n" + 
	        		"        \"id\": \"5e5b2290-c573-43fc-a249-49b7ca172cce\",\r\n" + 
	        		"        \"loanNumber\": \"0r1\",\r\n" + 
	        		"        \"loanName\": \"0r1 : Loan\",\r\n" + 
	        		"        \"formattedTermloanName\": null,\r\n" + 
	        		"        \"totalOutStandingBalance\": 0,\r\n" + 
	        		"        \"loanType\": {\r\n" + 
	        		"          \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"term_loan\",\r\n" + 
	        		"          \"display\": \"Term Loan\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"currency\": {\r\n" + 
	        		"          \"id\": 5,\r\n" + 
	        		"          \"currencyCode\": \"USD\",\r\n" + 
	        		"          \"description\": \"USD : US Dollar\",\r\n" + 
	        		"          \"decimalPrecision\": 4,\r\n" + 
	        		"          \"systemDefined\": false\r\n" + 
	        		"        },\r\n" + 
	        		"        \"principalAmount\": 8000,\r\n" + 
	        		"        \"interestRate\": 2,\r\n" + 
	        		"        \"divisor\": 12,\r\n" + 
	        		"        \"interestStartDate\": \"01/01/2020\",\r\n" + 
	        		"        \"termType\": {\r\n" + 
	        		"          \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"months\",\r\n" + 
	        		"          \"display\": \"Months\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"terms\": 12,\r\n" + 
	        		"        \"originationDate\": \"01/01/2020\",\r\n" + 
	        		"        \"disbursementDate\": null,\r\n" + 
	        		"        \"maturityDate\": \"01/01/2021\",\r\n" + 
	        		"        \"initialPaymentDate\": \"02/01/2020\",\r\n" + 
	        		"        \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"        \"borrower\": {\r\n" + 
	        		"          \"id\": 11040,\r\n" + 
	        		"          \"name\": \"LOAN-3031\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"interestRevised\": false,\r\n" + 
	        		"        \"revisedInterestRate\": 0,\r\n" + 
	        		"        \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	        		"        \"comments\": null,\r\n" + 
	        		"        \"precision\": 4,\r\n" + 
	        		"        \"loanStatus\": {\r\n" + 
	        		"          \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"displayName\": \"Active\",\r\n" + 
	        		"          \"value\": \"active\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"paidOffDate\": null,\r\n" + 
	        		"        \"allowNegative\": false,\r\n" + 
	        		"        \"gracePeriodDays\": 0,\r\n" + 
	        		"        \"rateAdjustment\": 0,\r\n" + 
	        		"        \"totalInterest\": 2\r\n" + 
	        		"      },\r\n" + 
	        		"      \"chargeCode\": {\r\n" + 
	        		"        \"id\": \"64602559-2e12-11ea-9d62-12e987db82ac\",\r\n" + 
	        		"        \"chargeCode\": \"Late Fee Penalty\",\r\n" + 
	        		"        \"transactionCode\": 0,\r\n" + 
	        		"        \"sequence\": 1,\r\n" + 
	        		"        \"natSign\": {\r\n" + 
	        		"          \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"+\",\r\n" + 
	        		"          \"displayName\": \"Plus\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"frequency\": {\r\n" + 
	        		"          \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"manual\",\r\n" + 
	        		"          \"displayName\": \"Manual\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"chargeType\": {\r\n" + 
	        		"          \"id\": \"645eca61-2e12-11ea-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"principal_balance\",\r\n" + 
	        		"          \"displayName\": \"On Payment Due of All Principal Balance Periods\",\r\n" + 
	        		"          \"calculationType\": \"percentage\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"postingType\": {\r\n" + 
	        		"          \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"          \"value\": \"in_bal\",\r\n" + 
	        		"          \"displayName\": \"In Balance\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"value\": 0,\r\n" + 
	        		"        \"autoNewClient\": true\r\n" + 
	        		"      },\r\n" + 
	        		"      \"natSign\": \"+\",\r\n" + 
	        		"      \"sequence\": 1,\r\n" + 
	        		"      \"frequency\": \"manual\",\r\n" + 
	        		"      \"chargeType\": {\r\n" + 
	        		"        \"id\": \"645eca61-2e12-11ea-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"principal_balance\",\r\n" + 
	        		"        \"displayName\": \"On Payment Due of All Principal Balance Periods\",\r\n" + 
	        		"        \"calculationType\": \"percentage\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"value\": 0,\r\n" + 
	        		"      \"inBalance\": false,\r\n" + 
	        		"      \"accruedToLoan\": false\r\n" + 
	        		"    },\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \"5e5b2290-c573-43fc-a249-49b7ca172cce\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"eba0a5fc-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"      \"value\": \"value\",\r\n" + 
	        		"      \"displayName\": \"Value\",\r\n" + 
	        		"      \"calculationType\": \"absolute\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"activityDate\": \"03/31/2020\",\r\n" + 
	        		"    \"percentage\": 0,\r\n" + 
	        		"    \"value\": "+value+",\r\n" + 
	        		"    \"chargedAmount\": 0,\r\n" + 
	        		"    \"principalAmount\": null,\r\n" + 
	        		"    \"outstandingPrincipal\": null,\r\n" + 
	        		"    \"totalPaymentDue\": null,\r\n" + 
	        		"    \"balanceDue\": null,\r\n" + 
	        		"    \"principalBalance\": null,\r\n" + 
	        		"    \"pastDueDays\": 10\r\n" + 
	        		"  }\r\n" + 
	        		"]"; 
	        		
	        
	        return requestBodyForChargeCode;}
	    
	  
	    
	    public String getPayloadforCollateralSetupPut(String loanID,String collateralLoanId) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \""+loanID+"\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"id\": \""+collateralLoanId+"\",\r\n" + 
	        		"  \"source\": \"Inventory\",\r\n" + 
	        		"  \"description\": \"Loan\",\r\n" + 
	        		"  \"asOfDate\": \"09/25/2019\",\r\n" + 
	        		"  \"actualValue\": "+getActualValue()+",\r\n" + 
	        		"  \"ineligibleCode\": \"Deductible\",\r\n" + 
	        		"  \"ineligibleValue\": 900,\r\n" + 
	        		"  \"eligibleValue\": 100,\r\n" + 
	        		"  \"advanceRate\": \"10\",\r\n" + 
	        		"  \"collateralValue\": 2\r\n" + 
	        		"}";
	        
	        return requestBodyForChargeCode;}
	    
	    public static String   getPayloadforCollateralSetupdecimal(String loanID,String collateralLoanId) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \""+loanID+"\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"id\": \""+collateralLoanId+"\",\r\n" + 
	        		"  \"source\": \"Inventory\",\r\n" + 
	        		"  \"description\": \"Loan\",\r\n" + 
	        		"  \"asOfDate\": \"09/25/2019\",\r\n" + 
	        		"  \"actualValue\": "+getActualValue()+",\r\n" + 
	        		"  \"ineligibleCode\": \"Deductible\",\r\n" + 
	        		"  \"ineligibleValue\": "+getinligbleValuedecimal()+",\r\n" + 
	        		"  \"eligibleValue\": 100,\r\n" + 
	        		"  \"advanceRate\": \""+getAdvanceValuedecimal()+"\",\r\n" + 
	        		"  \"collateralValue\": 2\r\n" + 
	        		"}";
	        
	        return requestBodyForChargeCode;}
	    
	    public String getAllocateRequestBody(String batchDate,String clientId,String loanNumber,String allocationAmount) {
	        String requestBodyForAutoAllocation=" {\r\n" + 
	        		"\r\n" + 
	        		"  \"batchDate\": \""+batchDate+"\",\r\n" + 
	        		"\r\n" + 
	        		"  \"clientId\": "+clientId+",\r\n" + 
	        		"\r\n" + 
	        		"  \"loanNumber\": \""+loanNumber+"\",\r\n" + 
	        		"\r\n" + 
	        		"  \"allocationAmount\": "+allocationAmount+"\r\n" + 
	        		"\r\n" + 
	        		"}";
	        
	        return requestBodyForAutoAllocation;}

	    public String getAllocateRequestBodyForPEriod(String batchDate, String clientId, String loanNumber,String  allocationAmount,String Period) {
	        String requestBodyForAutoAllocationPerion="{\r\n" + 
	        		"    \"batchDate\": \""+batchDate+"\",\r\n" + 
	        		"    \"clientId\": "+clientId+",\r\n" + 
	        		"    \"loanNumber\": \""+loanNumber+"\",\r\n" + 
	        		"    \"allocationAmount\": "+allocationAmount+",\r\n" + 
	        		"    \"period\": "+Period+"\r\n" + 
	        		"}";
	        
	        return requestBodyForAutoAllocationPerion;
	        }
	    public String initPayloadforAllocation(String batch_id,String batchNumber,String clientId,String clientName,String chequeId,String chequeNumber,String loanNumber,String period,String principalPaidAmount,String paymentDate) {
	    	String initPayloadforAllocation="{\r\n" + 
	    			"  \"batchId\": \""+batch_id+"\",\r\n" + 
	    			"  \"batchNumber\": \""+batchNumber+"\",\r\n" + 
	    			"  \"clientPayments\": [\r\n" + 
	    			"    {\r\n" + 
	    			"      \"clientId\": "+clientId+",\r\n" + 
	    			"      \"clientName\": \""+clientName+"\",\r\n" + 
	    			"      \"paymentDetails\": [\r\n" + 
	    			"        {\r\n" + 
	    			"          \"chequeId\": \""+chequeId+"\",\r\n" + 
	    			"          \"chequeNumber\": \""+chequeNumber+"\",\r\n" + 
	    			"          \"interestPaidAmount\": 0,\r\n" + 
	    			"          \"loanNumber\": \""+loanNumber+"\",\r\n" + 
	    			"          \"otherFeePaidAmount\": 0,\r\n" + 
	    			"          \"period\": "+period+",\r\n" + 
	    			"          \"principalPaidAmount\": "+principalPaidAmount+"\r\n" + 
	    			"        }\r\n" + 
	    			"      ]\r\n" + 
	    			"    }\r\n" + 
	    			"  ],\r\n" + 
	    			"  \"paymentDate\": \""+paymentDate+"\",\r\n" + 
	    			"  \"transactionId\": \""+getTransactionId()+"\"\r\n" + 
	    			"}";
			return initPayloadforAllocation;
	    }
	    //Using this
	    public String getAllocateRequestBody(String batch_date, String clientId, String loanNumber,String  allocationAmount,String Period) {
	        String requestBodyForAutoAllocationPerion="{\r\n" + 
	        		"    \"batchDate\": \""+batch_date+"\",\r\n" + 
	        		"    \"clientId\": "+clientId+",\r\n" + 
	        		"    \"loanNumber\": \""+loanNumber+"\",\r\n" + 
	        		"    \"allocationAmount\": "+allocationAmount+",\r\n" + 
	        		"    \"period\": "+Period+"\r\n" + 
	        		"}";
	        
	        return requestBodyForAutoAllocationPerion;}
	    public String notelevelEqualstoPeriod(String termLoanId,String period) {
	    	String notelevelEqualstoPeriod="[\r\n" + 
	    			"  {\r\n" + 
	    			"    \"termLoanId\": \""+termLoanId+"\",\r\n" + 
	    			"    \"period\": \""+period+"\"\r\n" + 
	    			"  }\r\n" + 
	    			"]";
			return notelevelEqualstoPeriod;
	    }
	    
	    public String getPayloadforAmortizationPost() {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"clientPayments\": [\r\n" + 
	        		"    {\r\n" + 
	        		"      \"clientName\": \"MAHESHQA\",\r\n" + 
	        		"      \"clientId\": 5160,\r\n" + 
	        		"      \"paymentDetails\": [\r\n" + 
	        		"        {\r\n" + 
	        		"          \"interestPaidAmount\": 83.33,\r\n" + 
	        		"          \"loanNumber\": \"12\",\r\n" + 
	        		"          \"otherFeePaidAmount\": 0,\r\n" + 
	        		"          \"period\": 1,\r\n" + 
	        		"          \"principalPaidAmount\":16.67,\r\n" + 
	        		"          \"chequeNumber\": \"998774\"\r\n" + 
	        		"        }\r\n" + 
	        		"      ]\r\n" + 
	        		"    }\r\n" + 
	        		"  ],\r\n" + 
	        		"  \"paymentDate\": \"08/20/2019\",\r\n" + 
	        		"  \"batchId\": \"1135\",\r\n" + 
	        		"  \"batchNumber\": \"1135_batch\",\r\n" + 
	        		"  \"transactionId\": \""+getTransactionId()+"\"\r\n" + 
	        		"}";
	        
	        return requestBodyForChargeCode;}
	    
	    
	    public String  getPayloadforAmortizationUPdateRegularDate(String ResponseID,String period,String interestRate,String paymentDate,String openingBalance,String regularInterest,String regularPrincipal,String regularPaymentDue,String totalPaymentDue,String endingBalance,String balanceDue,String termLoan_id,String loanNumber,String loanName,String loanType_id,String principalAmount,String totalInterest,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String divisor,String termType_id,String value,String display,String terms,String originationDate,String disbursementDate,String maturityDate,String initialPaymentDate,String loanStatus_id,String amortizationType,String soFarDisbursement,String balanceDisbursement,String disbursementAmount ,String periodStartDate,String periodEndDate,String additionalDisbursement) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \""+ResponseID+"\",\r\n" + 
	        		"  \"period\": "+period+",\r\n" + 
	        		"  \"interestRate\": "+interestRate+",\r\n" + 
	        		"  \"paymentDate\": \""+paymentDate+"\",\r\n" + 
	        		"  \"openingBalance\": "+openingBalance+",\r\n" + 
	        		"  \"regularInterest\": "+regularInterest+",\r\n" + 
	        		"  \"regularPrincipal\": "+regularPrincipal+",\r\n" + 
	        		"  \"regularPaymentDue\": \""+regularPaymentDue+"\",\r\n" + 
	        		"  \"fee\": 0,\r\n" + 
	        		"  \"totalPaymentDue\": "+totalPaymentDue+",\r\n" + 
	        		"  \"totalPaymentDone\": 0,\r\n" + 
	        		"  \"totalInterestPayment\": 0,\r\n" + 
	        		"  \"totalFeePayment\": 0,\r\n" + 
	        		"  \"totalPrincipalPayment\": 0,\r\n" + 
	        		"  \"extraPrincipalPayment\": 0,\r\n" + 
	        		"  \"endingBalance\": "+endingBalance+",\r\n" + 
	        		"  \"balanceDue\": "+balanceDue+",\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \""+termLoan_id+"\",\r\n" + 
	        		"    \"loanNumber\": \""+loanNumber+"\",\r\n" + 
	        		"    \"loanName\": \""+loanName+"\",\r\n" + 
	        		"    \"formattedTermloanName\": null,\r\n" + 
	        		"    \"totalOutStandingBalance\": 0,\r\n" + 
	        		"    \"loanType\": {\r\n" + 
	        		"      \"id\": \""+loanType_id+"\",\r\n" + 
	        		"      \"value\": \"term_loan\",\r\n" + 
	        		"      \"display\": \"Term Loan\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"currency\": {\r\n" + 
	        		"      \"id\": 5,\r\n" + 
	        		"      \"currencyCode\": \"USD\",\r\n" + 
	        		"      \"description\": \"USD : US Dollar\",\r\n" + 
	        		"      \"decimalPrecision\": 3,\r\n" + 
	        		"      \"systemDefined\": true\r\n" + 
	        		"    },\r\n" + 
	        		"    \"principalAmount\": "+principalAmount+",\r\n" + 
	        		"    \"interestRate\": "+interestRate+",\r\n" + 
	        		"    \"totalInterest\": "+totalInterest+",\r\n" + 
	        		"    \"rateAdjustment\": 0,\r\n" + 
	        		"    \"revisedInterestRateEffectiveDate\": \""+revisedInterestRateEffectiveDate+"\",\r\n" + 
	        		"    \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	        		"    \"interestRateCode\": "+interestRateCode+",\r\n" + 
	        		"    \"divisor\": "+divisor+",\r\n" + 
	        		"    \"termType\": {\r\n" + 
	        		"      \"id\": \""+termType_id+"\",\r\n" + 
	        		"      \"value\": \""+value+"\",\r\n" + 
	        		"      \"display\": \""+display+"\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"terms\": "+terms+",\r\n" + 
	        		"    \"originationDate\": \""+originationDate+"\",\r\n" + 
	        		"    \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	        		"    \"maturityDate\": \""+maturityDate+"\",\r\n" + 
	        		"    \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	        		"    \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"    \"borrower\": {\r\n" + 
	        		"      \"id\": 11622,\r\n" + 
	        		"      \"name\": \"ABH-001\",\r\n" + 
	        		"      \"clientNumber\": \"NABH6\",\r\n" + 
	        		"      \"active\": true,\r\n" + 
	        		"      \"emailId\": \"mahesh.b@idexcel.com\",\r\n" + 
	        		"      \"mailAddresses\": [\r\n" + 
	        		"        {\r\n" + 
	        		"          \"id\": 391,\r\n" + 
	        		"          \"addressCode\": \"23092020\",\r\n" + 
	        		"          \"primaryName\": \"MAHESH\",\r\n" + 
	        		"          \"alternateName\": \"\",\r\n" + 
	        		"          \"streetAddress\": \"BTM 2ND STAGE BANGALORE\",\r\n" + 
	        		"          \"city\": \"BANGALORE\",\r\n" + 
	        		"          \"stateProvince\": \"205\",\r\n" + 
	        		"          \"zipCode\": \"2002\",\r\n" + 
	        		"          \"country\": \"United States\",\r\n" + 
	        		"          \"phoneNumber\": \"+918553432171\",\r\n" + 
	        		"          \"primaryAddr\": true\r\n" + 
	        		"        }\r\n" + 
	        		"      ]\r\n" + 
	        		"    },\r\n" + 
	        		"    \"comments\": null,\r\n" + 
	        		"    \"precision\": 2,\r\n" + 
	        		"    \"loanStatus\": {\r\n" + 
	        		"      \"id\": \""+loanStatus_id+"\",\r\n" + 
	        		"      \"displayName\": \"Active\",\r\n" + 
	        		"      \"value\": \"active\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"paidOffDate\": null,\r\n" + 
	        		"    \"allowNegative\": false,\r\n" + 
	        		"    \"gracePeriodDays\": 0,\r\n" + 
	        		"    \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	        		"    \"interestRatePrecision\": 0,\r\n" + 
	        		"    \"fixedPrincipal\": 0,\r\n" + 
	        		"    \"editedFixedPrincipal\": false,\r\n" + 
	        		"    \"soFarDisbursement\": "+soFarDisbursement+",\r\n" + 
	        		"    \"balanceDisbursement\": "+balanceDisbursement+",\r\n" + 
	        		"    \"disbursementAmount\": "+disbursementAmount+"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"payments\": null,\r\n" + 
	        		"  \"periodStartDate\": \""+periodStartDate+"\",\r\n" + 
	        		"  \"periodEndDate\": \""+periodEndDate+"\",\r\n" + 
	        		"  \"graceDays\": 0,\r\n" + 
	        		"  \"graceDaysEdited\": false,\r\n" + 
	        		"  \"additionalDisbursement\": "+additionalDisbursement+",\r\n" + 
	        		"  \"paymentDone\": false,\r\n" + 
	        		"  \"paymentDueEdited\": false,\r\n" + 
	        		"  \"periodCharged\": false,\r\n" + 
	        		"  \"isEditAllowed\": true\r\n" + 
	        		"}";
	        
	        return requestBodyForChargeCode;}
	    
	    public String  getPayloadforAmortizationRecalculateForPreview(String ResponseID,String RegularPaymentDue) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \""+ResponseID+"\",\r\n" + 
	        		"  \"period\": 1,\r\n" + 
	        		"  \"interestRate\": 4,\r\n" + 
	        		"  \"paymentDate\": \"04/04/2020\",\r\n" + 
	        		"  \"openingBalance\": 25000,\r\n" + 
	        		"  \"regularInterest\": 83.3333,\r\n" + 
	        		"  \"regularPrincipal\": 4966.7776,\r\n" + 
	        		"  \"regularPaymentDue\": \""+RegularPaymentDue+"\",\r\n" + 
	        		"  \"fee\": 0,\r\n" + 
	        		"  \"totalPaymentDue\": 5050.1109,\r\n" + 
	        		"  \"totalPaymentDone\": 0,\r\n" + 
	        		"  \"totalInterestPayment\": 0,\r\n" + 
	        		"  \"totalFeePayment\": 0,\r\n" + 
	        		"  \"totalPrincipalPayment\": 0,\r\n" + 
	        		"  \"extraPrincipalPayment\": 0,\r\n" + 
	        		"  \"endingBalance\": 20033.2224,\r\n" + 
	        		"  \"balanceDue\": 5050.1109,\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \"1710c242-194c-44b6-bd6c-5b8fd3aed62e\",\r\n" + 
	        		"    \"loanNumber\": \"365\",\r\n" + 
	        		"    \"loanName\": \"365 : Loan\",\r\n" + 
	        		"    \"formattedTermloanName\": null,\r\n" + 
	        		"    \"totalOutStandingBalance\": 0,\r\n" + 
	        		"    \"loanType\": {\r\n" + 
	        		"      \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"      \"value\": \"term_loan\",\r\n" + 
	        		"      \"display\": \"Term Loan\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"currency\": {\r\n" + 
	        		"      \"id\": 5,\r\n" + 
	        		"      \"currencyCode\": \"USD\",\r\n" + 
	        		"      \"description\": \"USD : US Dollar\",\r\n" + 
	        		"      \"decimalPrecision\": 4,\r\n" + 
	        		"      \"systemDefined\": false\r\n" + 
	        		"    },\r\n" + 
	        		"    \"principalAmount\": 25000,\r\n" + 
	        		"    \"interestRate\": 4,\r\n" + 
	        		"    \"divisor\": 12,\r\n" + 
	        		"    \"interestStartDate\": \"03/04/2020\",\r\n" + 
	        		"    \"termType\": {\r\n" + 
	        		"      \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"      \"value\": \"months\",\r\n" + 
	        		"      \"display\": \"Months\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"terms\": 5,\r\n" + 
	        		"    \"originationDate\": \"03/04/2020\",\r\n" + 
	        		"    \"disbursementDate\": null,\r\n" + 
	        		"    \"maturityDate\": \"08/04/2020\",\r\n" + 
	        		"    \"initialPaymentDate\": \"04/04/2020\",\r\n" + 
	        		"    \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"    \"borrower\": {\r\n" + 
	        		"      \"id\": 10846,\r\n" + 
	        		"      \"name\": \"LOAN-2023\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"interestRevised\": false,\r\n" + 
	        		"    \"revisedInterestRate\": 0,\r\n" + 
	        		"    \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	        		"    \"comments\": null,\r\n" + 
	        		"    \"precision\": 4,\r\n" + 
	        		"    \"loanStatus\": {\r\n" + 
	        		"      \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"      \"displayName\": \"Active\",\r\n" + 
	        		"      \"value\": \"active\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"paidOffDate\": null,\r\n" + 
	        		"    \"allowNegative\": false,\r\n" + 
	        		"    \"rateAdjustment\": 0,\r\n" + 
	        		"    \"totalInterest\": 4\r\n" + 
	        		"  },\r\n" + 
	        		"  \"payments\": null,\r\n" + 
	        		"  \"paymentDueEdited\": false,\r\n" + 
	        		"  \"paymentDone\": false,\r\n" + 
	        		"  \"periodCharged\": false,\r\n" + 
	        		"  \"isEditAllowed\": true\r\n" + 
	        		"}";
	        
	        return requestBodyForChargeCode;}
	    
	  public String addChargecodeOnLoan(String id,String responseOfPreview,String loanNumber,String loanName,String loanType_id,String principalAmount,String interestRate,String totalInterest,String rateAdjustment,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String divisor,String termType_id,String value,String display,String terms,String originationDate,String disbursementDate,String maturityDate,String initialPaymentDate,String borrower_id,String loanStatus_id,String gracePeriodDays,String amortizationType,String soFarDisbursement,String balanceDisbursement,String disbursementAmount,String chargeCode_id,String chargeCode,String transactionCode,String natSign,String natSign_value,String natSign_displayName,String frequency,String frequency_value,String frequency_displayName,String chargeType_id,String chargeType_value,String chargeType_displayName,String calculationType,String postingType,String postingType_value,String postingType_displayName,String charge_value,String sign,String activityDate) {
		   String addChargecodeOnLoan="[\r\n" + 
		   		"  {\r\n" + 
		   		"    \"id\": \""+id+"\",\r\n" + 
		   		"    \"termLoan\": {\r\n" + 
		   		"      \"id\": \""+responseOfPreview+"\",\r\n" + 
		   		"      \"loanNumber\": \""+loanNumber+"\",\r\n" + 
		   		"      \"loanName\": \""+loanName+"\",\r\n" + 
		   		"      \"formattedTermloanName\": null,\r\n" + 
		   		"      \"totalOutStandingBalance\": 0,\r\n" + 
		   		"      \"loanType\": {\r\n" + 
		   		"        \"id\": \""+loanType_id+"\",\r\n" + 
		   		"        \"value\": \"term_loan\",\r\n" + 
		   		"        \"display\": \"Term Loan\"\r\n" + 
		   		"      },\r\n" + 
		   		"      \"currency\": {\r\n" + 
		   		"        \"id\": 5,\r\n" + 
		   		"        \"currencyCode\": \"USD\",\r\n" + 
		   		"        \"description\": \"USD : US Dollar\",\r\n" + 
		   		"        \"decimalPrecision\": 3,\r\n" + 
		   		"        \"systemDefined\": true\r\n" + 
		   		"      },\r\n" + 
		   		"      \"principalAmount\": "+principalAmount+",\r\n" + 
		   		"      \"interestRate\": "+interestRate+",\r\n" + 
		   		"      \"totalInterest\": "+totalInterest+",\r\n" + 
		   		"      \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
		   		"      \"revisedInterestRateEffectiveDate\": \""+revisedInterestRateEffectiveDate+"\",\r\n" + 
		   		"      \"interestRateType\": \""+interestRateType+"\",\r\n" + 
		   		"      \"interestRateCode\": "+interestRateCode+",\r\n" + 
		   		"      \"divisor\": "+divisor+",\r\n" + 
		   		"      \"termType\": {\r\n" + 
		   		"        \"id\": \""+termType_id+"\",\r\n" + 
		   		"        \"value\": \""+value+"\",\r\n" + 
		   		"        \"display\": \""+display+"\"\r\n" + 
		   		"      },\r\n" + 
		   		"      \"terms\": "+terms+",\r\n" + 
		   		"      \"originationDate\": \""+originationDate+"\",\r\n" + 
		   		"      \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
		   		"      \"maturityDate\": \""+maturityDate+"\",\r\n" + 
		   		"      \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
		   		"      \"includeLoanBalanceInReserve\": false,\r\n" + 
		   		"      \"borrower\": {\r\n" + 
		   		"        \"id\": "+borrower_id+",\r\n" + 
		   		"        \"name\": \"ABH-001\",\r\n" + 
		   		"        \"clientNumber\": \"NABH6\",\r\n" + 
		   		"        \"active\": true,\r\n" + 
		   		"        \"emailId\": \"mahesh.b@idexcel.com\",\r\n" + 
		   		"        \"mailAddresses\": [\r\n" + 
		   		"          {\r\n" + 
		   		"            \"id\": 391,\r\n" + 
		   		"            \"addressCode\": \"23092020\",\r\n" + 
		   		"            \"primaryName\": \"MAHESH\",\r\n" + 
		   		"            \"alternateName\": \"\",\r\n" + 
		   		"            \"streetAddress\": \"BTM 2ND STAGE BANGALORE\",\r\n" + 
		   		"            \"city\": \"BANGALORE\",\r\n" + 
		   		"            \"stateProvince\": \"205\",\r\n" + 
		   		"            \"zipCode\": \"2002\",\r\n" + 
		   		"            \"country\": \"United States\",\r\n" + 
		   		"            \"phoneNumber\": \"+918553432171\",\r\n" + 
		   		"            \"primaryAddr\": true\r\n" + 
		   		"          }\r\n" + 
		   		"        ]\r\n" + 
		   		"      },\r\n" + 
		   		"      \"comments\": null,\r\n" + 
		   		"      \"precision\": 2,\r\n" + 
		   		"      \"loanStatus\": {\r\n" + 
		   		"        \"id\": \""+loanStatus_id+"\",\r\n" + 
		   		"        \"displayName\": \"Active\",\r\n" + 
		   		"        \"value\": \"active\"\r\n" + 
		   		"      },\r\n" + 
		   		"      \"paidOffDate\": null,\r\n" + 
		   		"      \"allowNegative\": false,\r\n" + 
		   		"      \"gracePeriodDays\": "+gracePeriodDays+",\r\n" + 
		   		"      \"amortizationType\": \""+amortizationType+"\",\r\n" + 
		   		"      \"interestRatePrecision\": 0,\r\n" + 
		   		"      \"fixedPrincipal\": 0,\r\n" + 
		   		"      \"editedFixedPrincipal\": false,\r\n" + 
		   		"      \"soFarDisbursement\": "+soFarDisbursement+",\r\n" + 
		   		"      \"balanceDisbursement\": "+balanceDisbursement+",\r\n" + 
		   		"      \"disbursementAmount\": "+disbursementAmount+"\r\n" + 
		   		"    },\r\n" + 
		   		"    \"chargeCode\": {\r\n" + 
		   		"      \"id\": \""+chargeCode_id+"\",\r\n" + 
		   		"      \"chargeCode\": \""+chargeCode+"\",\r\n" + 
		   		"      \"transactionCode\": "+transactionCode+",\r\n" + 
		   		"      \"sequence\": 1,\r\n" + 
		   		"      \"natSign\": {\r\n" + 
		   		"        \"id\": \""+natSign+"\",\r\n" + 
		   		"        \"value\": \""+natSign_value+"\",\r\n" + 
		   		"        \"displayName\": \""+natSign_displayName+"\"\r\n" + 
		   		"      },\r\n" + 
		   		"      \"frequency\": {\r\n" + 
		   		"        \"id\": \""+frequency+"\",\r\n" + 
		   		"        \"value\": \""+frequency_value+"\",\r\n" + 
		   		"        \"displayName\": \""+frequency_displayName+"\"\r\n" + 
		   		"      },\r\n" + 
		   		"      \"chargeType\": {\r\n" + 
		   		"        \"id\": \""+chargeType_id+"\",\r\n" + 
		   		"        \"value\": \""+chargeType_value+"\",\r\n" + 
		   		"        \"displayName\": \""+chargeType_displayName+"\",\r\n" + 
		   		"        \"calculationType\": \""+calculationType+"\"\r\n" + 
		   		"      },\r\n" + 
		   		"      \"postingType\": {\r\n" + 
		   		"        \"id\": \""+postingType+"\",\r\n" + 
		   		"        \"value\": \""+postingType_value+"\",\r\n" + 
		   		"        \"displayName\": \""+postingType_displayName+"\"\r\n" + 
		   		"      },\r\n" + 
		   		"      \"value\": "+charge_value+",\r\n" + 
		   		"      \"autoNewClient\": true\r\n" + 
		   		"    },\r\n" + 
		   		"    \"natSign\": \""+sign+"\",\r\n" + 
		   		"    \"sequence\": 1,\r\n" + 
		   		"    \"frequency\": \"manual\",\r\n" + 
		   		"    \"chargeType\": {\r\n" + 
		   		"      \"id\": \""+chargeType_id+"\",\r\n" + 
		   		"      \"value\": \""+chargeType_value+"\",\r\n" + 
		   		"      \"displayName\": \""+chargeType_displayName+"\",\r\n" + 
		   		"      \"calculationType\": \""+calculationType+"\"\r\n" + 
		   		"    },\r\n" + 
		   		"    \"value\": null,\r\n" + 
		   		"    \"inBalance\": false,\r\n" + 
		   		"    \"accruedToLoan\": false,\r\n" + 
		   		"    \"lastCronRunDate\": null,\r\n" + 
		   		"    \"percentage\": "+charge_value+",\r\n" + 
		   		"    \"chargeType.displayName\": \""+chargeType_displayName+"\",\r\n" + 
		   		"    \"selectedCharge\": true,\r\n" + 
		   		"    \"chargeTemplate\": {\r\n" + 
		   		"      \"id\": \""+id+"\"\r\n" + 
		   		"    },\r\n" + 
		   		"    \"activityDate\": \""+activityDate+"\"\r\n" + 
		   		"  }\r\n" + 
		   		"]";
		return addChargecodeOnLoan;
	   }
	 
        public String addChargecodeOnLoancommit(String id,String responseOfPreview,String loanNumber,String loanName,String loanType_id,String principalAmount,String interestRate,String totalInterest,String rateAdjustment,String revisedInterestRateEffectiveDate,String termType_id,String value,String display,String terms,String originationDate,String disbursementDate,String maturityDate,String initialPaymentDate,String borrower_id,String loanStatus_id,String soFarDisbursement,String balanceDisbursement,String disbursementAmount,String chargeCode_id,String chargeCode,String transactionCode,String natSign,String natSign_value,String natSign_displayName,String frequency,String chargeType_id,String chargeType_value,String chargeType_displayName,String calculationType,String postingType,String postingType_value,String postingType_displayName,String charge_value,String sign,String activityDate,String chargedAmount) {
        	String addChargecodeOnLoancommit="[\r\n" + 
        			"  {\r\n" + 
        			"    \"id\": \""+id+"\",\r\n" + 
        			"    \"termLoan\": {\r\n" + 
        			"      \"id\": \""+responseOfPreview+"\",\r\n" + 
        			"      \"loanNumber\": \""+loanNumber+"\",\r\n" + 
        			"      \"loanName\": \""+loanName+"\",\r\n" + 
        			"      \"formattedTermloanName\": null,\r\n" + 
        			"      \"totalOutStandingBalance\": 0,\r\n" + 
        			"      \"loanType\": {\r\n" + 
        			"        \"id\": \""+loanType_id+"\",\r\n" + 
        			"        \"value\": \"term_loan\",\r\n" + 
        			"        \"display\": \"Term Loan\"\r\n" + 
        			"      },\r\n" + 
        			"      \"currency\": {\r\n" + 
        			"        \"id\": 5,\r\n" + 
        			"        \"currencyCode\": \"USD\",\r\n" + 
        			"        \"description\": \"USD : US Dollar\",\r\n" + 
        			"        \"decimalPrecision\": 3,\r\n" + 
        			"        \"systemDefined\": true\r\n" + 
        			"      },\r\n" + 
        			"      \"principalAmount\": "+principalAmount+",\r\n" + 
        			"      \"interestRate\": "+interestRate+",\r\n" + 
        			"      \"totalInterest\": "+totalInterest+",\r\n" + 
        			"      \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
        			"      \"revisedInterestRateEffectiveDate\": \""+revisedInterestRateEffectiveDate+"\",\r\n" + 
        			"      \"interestRateType\": \"fixed\",\r\n" + 
        			"      \"interestRateCode\": 0,\r\n" + 
        			"      \"divisor\": 12,\r\n" + 
        			"      \"termType\": {\r\n" + 
        			"        \"id\": \""+termType_id+"\",\r\n" + 
        			"        \"value\": \""+value+"\",\r\n" + 
        			"        \"display\": \""+display+"\"\r\n" + 
        			"      },\r\n" + 
        			"      \"terms\": "+terms+",\r\n" + 
        			"      \"originationDate\": \""+originationDate+"\",\r\n" + 
        			"      \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
        			"      \"maturityDate\": \""+maturityDate+"\",\r\n" + 
        			"      \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
        			"      \"includeLoanBalanceInReserve\": false,\r\n" + 
        			"      \"borrower\": {\r\n" + 
        			"        \"id\": "+borrower_id+",\r\n" + 
        			"        \"name\": \"ABH-001\",\r\n" + 
        			"        \"clientNumber\": \"NABH6\",\r\n" + 
        			"        \"active\": true,\r\n" + 
        			"        \"emailId\": \"mahesh.b@idexcel.com\",\r\n" + 
        			"        \"mailAddresses\": [\r\n" + 
        			"          {\r\n" + 
        			"            \"id\": 391,\r\n" + 
        			"            \"addressCode\": \"23092020\",\r\n" + 
        			"            \"primaryName\": \"MAHESH\",\r\n" + 
        			"            \"alternateName\": \"\",\r\n" + 
        			"            \"streetAddress\": \"BTM 2ND STAGE BANGALORE\",\r\n" + 
        			"            \"city\": \"BANGALORE\",\r\n" + 
        			"            \"stateProvince\": \"205\",\r\n" + 
        			"            \"zipCode\": \"2002\",\r\n" + 
        			"            \"country\": \"United States\",\r\n" + 
        			"            \"phoneNumber\": \"+918553432171\",\r\n" + 
        			"            \"primaryAddr\": true\r\n" + 
        			"          }\r\n" + 
        			"        ]\r\n" + 
        			"      },\r\n" + 
        			"      \"comments\": null,\r\n" + 
        			"      \"precision\": 2,\r\n" + 
        			"      \"loanStatus\": {\r\n" + 
        			"        \"id\": \""+loanStatus_id+"\",\r\n" + 
        			"        \"displayName\": \"Active\",\r\n" + 
        			"        \"value\": \"active\"\r\n" + 
        			"      },\r\n" + 
        			"      \"paidOffDate\": null,\r\n" + 
        			"      \"allowNegative\": false,\r\n" + 
        			"      \"gracePeriodDays\": 0,\r\n" + 
        			"      \"amortizationType\": \"normal\",\r\n" + 
        			"      \"interestRatePrecision\": 0,\r\n" + 
        			"      \"fixedPrincipal\": 0,\r\n" + 
        			"      \"editedFixedPrincipal\": false,\r\n" + 
        			"      \"soFarDisbursement\": "+soFarDisbursement+",\r\n" + 
        			"      \"balanceDisbursement\": "+balanceDisbursement+",\r\n" + 
        			"      \"disbursementAmount\": "+disbursementAmount+"\r\n" + 
        			"    },\r\n" + 
        			"    \"chargeCode\": {\r\n" + 
        			"      \"id\": \""+chargeCode_id+"\",\r\n" + 
        			"      \"chargeCode\": \""+chargeCode+"\",\r\n" + 
        			"      \"transactionCode\": "+transactionCode+",\r\n" + 
        			"      \"sequence\": 1,\r\n" + 
        			"      \"natSign\": {\r\n" + 
        			"        \"id\": \""+natSign+"\",\r\n" + 
        			"        \"value\": \""+natSign_value+"\",\r\n" + 
        			"        \"displayName\": \""+natSign_displayName+"\"\r\n" + 
        			"      },\r\n" + 
        			"      \"frequency\": {\r\n" + 
        			"        \"id\": \""+frequency+"\",\r\n" + 
        			"        \"value\": \"manual\",\r\n" + 
        			"        \"displayName\": \"Manual\"\r\n" + 
        			"      },\r\n" + 
        			"      \"chargeType\": {\r\n" + 
        			"        \"id\": \""+chargeType_id+"\",\r\n" + 
        			"        \"value\": \""+chargeType_value+"\",\r\n" + 
        			"        \"displayName\": \""+chargeType_displayName+"\",\r\n" + 
        			"        \"calculationType\": \""+calculationType+"\"\r\n" + 
        			"      },\r\n" + 
        			"      \"postingType\": {\r\n" + 
        			"        \"id\": \""+postingType+"\",\r\n" + 
        			"        \"value\": \""+postingType_value+"\",\r\n" + 
        			"        \"displayName\": \""+postingType_displayName+"\"\r\n" + 
        			"      },\r\n" + 
        			"      \"value\": "+charge_value+",\r\n" + 
        			"      \"autoNewClient\": true\r\n" + 
        			"    },\r\n" + 
        			"    \"natSign\": \""+sign+"\",\r\n" + 
        			"    \"sequence\": 1,\r\n" + 
        			"    \"frequency\": \"manual\",\r\n" + 
        			"    \"chargeType\": {\r\n" + 
        			"      \"id\": \""+chargeType_id+"\",\r\n" + 
        			"      \"value\": \""+chargeType_value+"\",\r\n" + 
        			"      \"displayName\": \""+chargeType_displayName+"\",\r\n" + 
        			"      \"calculationType\": \""+calculationType+"\"\r\n" + 
        			"    },\r\n" + 
        			"    \"value\": null,\r\n" + 
        			"    \"inBalance\": false,\r\n" + 
        			"    \"accruedToLoan\": false,\r\n" + 
        			"    \"lastCronRunDate\": null,\r\n" + 
        			"    \"percentage\": "+charge_value+",\r\n" + 
        			"    \"chargeType.displayName\": \""+chargeType_displayName+"\",\r\n" + 
        			"    \"selectedCharge\": true,\r\n" + 
        			"    \"chargeTemplate\": {\r\n" + 
        			"      \"id\": \""+id+"\"\r\n" + 
        			"    },\r\n" + 
        			"    \"activityDate\": \""+activityDate+"\",\r\n" + 
        			"    \"chargedAmount\": "+chargedAmount+"\r\n" + 
        			"  }\r\n" + 
        			"]";
			return addChargecodeOnLoancommit;
        }

		public String getCommitRequestBody(String Orignaldate) {
			String rqst ="{\r\n" + 
					"  \"id\": null,\r\n" + 
					"  \"loanType\": {\r\n" + 
					"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"term_loan\",\r\n" + 
					"    \"display\": \"Term Loan\"\r\n" + 
					"  },\r\n" + 
					"  \"borrower\": {\r\n" + 
					"    \"id\": \"9033\",\r\n" + 
					"    \"name\": \"LOAN-1105\"\r\n" + 
					"  },\r\n" + 
					"  \"currency\": {\r\n" + 
					"    \"id\": 5,\r\n" + 
					"    \"currencyCode\": \"USD\",\r\n" + 
					"    \"description\": \"USD : US Dollar\",\r\n" + 
					"    \"decimalPrecision\": 6,\r\n" + 
					"    \"systemDefined\": false\r\n" + 
					"  },\r\n" + 
					"  \"loanNumber\": \"1212\",\r\n" + 
					"  \"loanName\": \"Loan\",\r\n" + 
					"  \"principalAmount\": \"985585\",\r\n" + 
					"  \"disbursementDate\": null,\r\n" + 
					"  \"initialPaymentDate\": null,\r\n" + 
					"  \"termType\": {\r\n" + 
					"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"months\",\r\n" + 
					"    \"display\": \"Months\"\r\n" + 
					"  },\r\n" + 
					"  \"terms\": \"33\",\r\n" + 
					"  \"originationDate\": "+Orignaldate+",\r\n" + 
					"  \"maturityDate\": \"08/05/2022\",\r\n" + 
					"  \"includeLoanBalanceInReserve\": null,\r\n" + 
					"  \"interestRate\": 3,\r\n" + 
					"  \"divisor\": 12,\r\n" + 
					"  \"comments\": null,\r\n" + 
					"  \"loanStatus\": {\r\n" + 
					"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"displayName\": \"Active\",\r\n" + 
					"    \"value\": \"active\"\r\n" + 
					"  },\r\n" + 
					"  \"paidOffDate\": null\r\n" + 
					"}";
			return rqst;
		}


		
		public static String requestBodyForMaturitydate(String Orignaldate,String  Maturitydate) {
			String rqst ="{\r\n" + 
					"  \"id\": null,\r\n" + 
					"  \"loanType\": {\r\n" + 
					"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"term_loan\",\r\n" + 
					"    \"display\": \"Term Loan\"\r\n" + 
					"  },\r\n" + 
					"  \"borrower\": {\r\n" + 
					"    \"id\": \"9033\",\r\n" + 
					"    \"name\": \"LOAN-1105\"\r\n" + 
					"  },\r\n" + 
					"  \"currency\": {\r\n" + 
					"    \"id\": 5,\r\n" + 
					"    \"currencyCode\": \"USD\",\r\n" + 
					"    \"description\": \"USD : US Dollar\",\r\n" + 
					"    \"decimalPrecision\": 6,\r\n" + 
					"    \"systemDefined\": false\r\n" + 
					"  },\r\n" + 
					"  \"loanNumber\": \"1212\",\r\n" + 
					"  \"loanName\": \"Loan\",\r\n" + 
					"  \"principalAmount\": \"985585\",\r\n" + 
					"  \"disbursementDate\": null,\r\n" + 
					"  \"initialPaymentDate\": null,\r\n" + 
					"  \"termType\": {\r\n" + 
					"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"months\",\r\n" + 
					"    \"display\": \"Months\"\r\n" + 
					"  },\r\n" + 
					"  \"terms\": \"33\",\r\n" + 
					"  \"originationDate\": \""+Orignaldate+"\",\r\n" + 
					"  \"maturityDate\": \""+Maturitydate+"\",\r\n" + 
					"  \"includeLoanBalanceInReserve\": null,\r\n" + 
					"  \"interestRate\": 3,\r\n" + 
					"  \"divisor\": 12,\r\n" + 
					"  \"comments\": null,\r\n" + 
					"  \"loanStatus\": {\r\n" + 
					"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"displayName\": \"Active\",\r\n" + 
					"    \"value\": \"active\"\r\n" + 
					"  },\r\n" + 
					"  \"paidOffDate\": null\r\n" + 
					"}";
			return rqst;
		}
		
		public String getCommitRequestBodyOfLoan(String responseOfPreview,String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String	Intrest,String Originationdate,String InitialPaymentdate,String Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate)			
	     {
			String rqst ="{\r\n" + 
					"  \"id\": \""+responseOfPreview+"\",\r\n" + 
					"  \"loanType\": {\r\n" + 
					"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"term_loan\",\r\n" + 
					"    \"display\": \"Term Loan\"\r\n" + 
					"  },\r\n" + 
					"  \"borrower\": {\r\n" + 
					"    \"id\": \"11622\",\r\n" + 
					"    \"name\": \"ABH-001\"\r\n" + 
					"  },\r\n" + 
					"  \"currency\": {\r\n" + 
					"    \"id\": 5,\r\n" + 
					"    \"currencyCode\": \"USD\",\r\n" + 
					"    \"description\": \"USD : US Dollar\",\r\n" + 
					"    \"decimalPrecision\": 2,\r\n" + 
					"    \"systemDefined\": true\r\n" + 
					"  },\r\n" + 
					"  \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
					"  \"loanName\": \""+LoanName+"\",\r\n" + 
					"  \"principalAmount\": \""+PrincipalAmount+"\",\r\n" + 
					"  \"disbursementDate\": \""+Disburnsmentdate+"\",\r\n" + 
					"  \"initialPaymentDate\": \""+InitialPaymentdate+"\",\r\n" + 
					"  \"termType\": {\r\n" + 
					"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \""+Termtype+"\",\r\n" + 
					"    \"display\": \""+Termtype+"\"\r\n" + 
					"  },\r\n" + 
					"  \"terms\": \""+Term+"\",\r\n" + 
					"  \"originationDate\": \""+Originationdate+"\",\r\n" + 
					"  \"maturityDate\": \""+MaturityDate+"\",\r\n" + 
					"  \"includeLoanBalanceInReserve\": null,\r\n" + 
					"  \"interestRate\": "+Intrest+",\r\n" + 
					"  \"divisor\": 12,\r\n" + 
					"  \"revisedInterestRate\": null,\r\n" + 
					"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
					"  \"comments\": null,\r\n" + 
					"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
					"  \"interestRateCode\": null,\r\n" + 
					"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
					"  \"totalInterest\": 6,\r\n" + 
					"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
					"  \"baseInterestRate\": 6,\r\n" + 
					"  \"intRatePrecision\": 12,\r\n" + 
					"  \"dailyDivisor\": 360,\r\n" + 
					"  \"loanStatus\": {\r\n" + 
					"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"displayName\": \"Active\",\r\n" + 
					"    \"value\": \"active\"\r\n" + 
					"  },\r\n" + 
					"  \"paidOffDate\": null,\r\n" + 
					"  \"totalOutStandingBalance\": 0\r\n" + 
					"}";
			return rqst;
		}

    
		public String getCommitRequestforPeriodRevision(String responseOfPreview,String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String Intrest,String Originationdate,String InitialPaymentdate,String Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate)			
	     {
			String rqst ="{\r\n" + 
					"  \"id\": \""+responseOfPreview+"\",\r\n" + 
					"  \"loanType\": {\r\n" + 
					"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"term_loan\",\r\n" + 
					"    \"display\": \"Term Loan\"\r\n" + 
					"  },\r\n" + 
					"  \"borrower\": {\r\n" + 
					"    \"id\": \"11622\",\r\n" + 
					"    \"name\": \"ABH-001\"\r\n" + 
					"  },\r\n" + 
					"  \"currency\": {\r\n" + 
					"    \"id\": 5,\r\n" + 
					"    \"currencyCode\": \"USD\",\r\n" + 
					"    \"description\": \"USD : US Dollar\",\r\n" + 
					"    \"decimalPrecision\": 2,\r\n" + 
					"    \"systemDefined\": true\r\n" + 
					"  },\r\n" + 
					"  \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
					"  \"loanName\": \""+LoanName+"\",\r\n" + 
					"  \"principalAmount\": \""+PrincipalAmount+"\",\r\n" + 
					"  \"disbursementDate\": \""+Disburnsmentdate+"\",\r\n" + 
					"  \"initialPaymentDate\": \""+InitialPaymentdate+"\",\r\n" + 
					"  \"termType\": {\r\n" + 
					"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \""+Termtype+"\",\r\n" + 
					"    \"display\": \""+Termtype+"\"\r\n" + 
					"  },\r\n" + 
					"  \"terms\": \""+Term+"\",\r\n" + 
					"  \"originationDate\": \""+Originationdate+"\",\r\n" + 
					"  \"maturityDate\": \""+MaturityDate+"\",\r\n" + 
					"  \"includeLoanBalanceInReserve\": null,\r\n" + 
					"  \"interestRate\": "+Intrest+",\r\n" + 
					"  \"divisor\": 12,\r\n" + 
					"  \"revisedInterestRate\": null,\r\n" + 
					"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
					"  \"comments\": null,\r\n" + 
					"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
					"  \"interestRateCode\": null,\r\n" + 
					"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
					"  \"totalInterest\": 6,\r\n" + 
					"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
					"  \"baseInterestRate\": 6,\r\n" + 
					"  \"intRatePrecision\": 12,\r\n" + 
					"  \"dailyDivisor\": 360,\r\n" + 
					"  \"loanStatus\": {\r\n" + 
					"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"displayName\": \"Active\",\r\n" + 
					"    \"value\": \"active\"\r\n" + 
					"  },\r\n" + 
					"  \"paidOffDate\": null,\r\n" + 
					"  \"totalOutStandingBalance\": 0\r\n" + 
					"}";
			return rqst;
		}

		
		public String getChargecodeRequestBodyForNEgativeScenario(String chargeCode) {
			String Request="{\r\n" + 
					"  \"id\": \"\",\r\n" + 
					"  \"chargeCode\": \""+chargeCode+"\",\r\n" + 
					"  \"transactionCode\": \"35634565\",\r\n" + 
					"  \"natSign\": {\r\n" + 
					"    \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"+\",\r\n" + 
					"    \"displayName\": \"Plus\"\r\n" + 
					"  },\r\n" + 
					"  \"frequency\": {\r\n" + 
					"    \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"manual\",\r\n" + 
					"    \"displayName\": \"Manual\"\r\n" + 
					"  },\r\n" + 
					"  \"chargeType\": {\r\n" + 
					"    \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"original_loan_amount\",\r\n" + 
					"    \"displayName\": \"On Original Loan Amount\",\r\n" + 
					"    \"calculationType\": \"percentage\"\r\n" + 
					"  },\r\n" + 
					"  \"postingType\": {\r\n" + 
					"    \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"in_bal\",\r\n" + 
					"    \"displayName\": \"In Balance\"\r\n" + 
					"  },\r\n" + 
					"  \"value\": \"6\",\r\n" + 
					"  \"autoNewClient\": false\r\n" + 
					"}";
			return Request;
		}


		
		public String getChargeType(String chargeType,String percentage,String Autonewclient) {
			String Request="{\r\n" + 
					"  \"id\": \"\",\r\n" + 
					"  \"chargeCode\": \""+getChargeCode()+"\",\r\n" + 
					"  \"transactionCode\": \""+getTransactionCode()+"\",\r\n" + 
					"  \"natSign\": {\r\n" + 
					"    \"id\": \"eb97ca65-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"+\",\r\n" + 
					"    \"displayName\": \"Plus\"\r\n" + 
					"  },\r\n" + 
					"  \"frequency\": {\r\n" + 
					"    \"id\": \"eb93abc2-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"manual\",\r\n" + 
					"    \"displayName\": \"Manual\"\r\n" + 
					"  },\r\n" + 
					"  \"chargeType\": {\r\n" + 
					"    \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \""+chargeType+"\",\r\n" + 
					"    \"displayName\": \""+chargeType+"\",\r\n" + 
					"    \"calculationType\": \"percentage\"\r\n" + 
					"  },\r\n" + 
					"  \"postingType\": {\r\n" + 
					"    \"id\": \"eb9c4c64-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \""+chargeType+"\",\r\n" + 
					"    \"displayName\": \""+chargeType+"\"\r\n" + 
					"  },\r\n" + 
					"  \"value\": \""+percentage+"\",\r\n" + 
					"  \"autoNewClient\": "+Autonewclient+"\r\n" + 
					"}";
			return Request;
		}
		
		
		public String followUpLoanNotifyRequest(String templateId,String reminderDate,String termLoanId,String period) {
			String followUpLoanNotifyRequest="{\r\n" + 
					"  \"templateId\": \""+templateId+"\",\r\n" + 
					"  \"reminderDate\": \""+reminderDate+"\",\r\n" + 
					"  \"notificationType\": \"email\",\r\n" + 
					"  \"notifyDetails\": [\r\n" + 
					"    {\r\n" + 
					"      \"termLoanId\": \""+termLoanId+"\",\r\n" + 
					"      \"period\": \""+period+"\"\r\n" + 
					"    }\r\n" + 
					"  ]\r\n" + 
					"}";
			return followUpLoanNotifyRequest;
		}
		
		 
		 public String payloadforDeleteLoan(String termLoanId) {
			 String requestBody="[\r\n" + 
			 		"  \""+termLoanId+"\"\r\n" + 
			 		"]";
			return requestBody;
		 }
		 public String processBatch(String batches) {
			 String processBatch="{\r\n" + 
			 		"   \"batches\":\""+batches+"\"\r\n" + 
			 		"}";
			return processBatch;
			 
		 }

		 
		 public String createBatch(String Batchdate,String TotalAmount) {
		        String requestBodyForChargeCode="{ \n" + 
		        		"   \"batch\":{ \n" + 
		        		"      \"batch_date\":\""+Batchdate+"\",\n" + 
		        		"      \"ref_batch_no\":12,\n" + 
		        		"      \"total_amount\":\""+TotalAmount+"\",\n" + 
		        		"      \"image_split\":true\n" + 
		        		"   },\n" + 
		        		"   \"check_parameters\":[ \n" + 
		        		"\n" + 
		        		"   ]\n" + 
		        		"}";
		        
//		        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
		        
		     return requestBodyForChargeCode;
		        
		    }
		 public String smsNotificationPayload(String templateId,String termLoanId) {
			 String smsNotificationPayload="{\r\n" + 
			 		"  \"templateId\": \"512948b6-f357-11ea-b0b4-12e987db82ac\",\r\n" + 
			 		"  \"notificationType\": \"text\",\r\n" + 
			 		"  \"notifyDetails\": [\r\n" + 
			 		"    {\r\n" + 
			 		"      \"termLoanId\": \"2ab4d824-abb4-403e-836a-86cb08dbf880\",\r\n" + 
			 		"      \"period\": \"1\"\r\n" + 
			 		"    }\r\n" + 
			 		"  ]\r\n" + 
			 		"}";
			 return smsNotificationPayload;
		 }
		 public String smsNotificationPayloadForMultipletermloanId() {
			 String smsNotificationPayload="{\r\n" + 
			 		"  \"templateId\": \"512948b6-f357-11ea-b0b4-12e987db82ac\",\r\n" + 
			 		"  \"notificationType\": \"text\",\r\n" + 
			 		"  \"notifyDetails\": [\r\n" + 
			 		"    {\r\n" + 
			 		"      \"termLoanId\": \"31724c55-3bc7-4f82-aa6b-f9cfa1c31e79\",\r\n" + 
			 		"      \"period\": \"1\"\r\n" + 
			 		"    },\r\n" + 
			 		"    {\r\n" + 
			 		"      \"termLoanId\": \"7d13fb4e-e9f7-4400-b717-8bea2621ce73\",\r\n" + 
			 		"      \"period\": \"1\"\r\n" + 
			 		"    },\r\n" + 
			 		"    {\r\n" + 
			 		"      \"termLoanId\": \"51c7fbb6-2c18-41cf-8970-65f6255ca374\",\r\n" + 
			 		"      \"period\": \"1\"\r\n" + 
			 		"    },\r\n" + 
			 		"    {\r\n" + 
			 		"      \"termLoanId\": \"0c13fa55-29a8-460f-b0ce-201f3ca0a020\",\r\n" + 
			 		"      \"period\": \"1\"\r\n" + 
			 		"    }\r\n" + 
			 		"  ]\r\n" + 
			 		"}";
			 return smsNotificationPayload;
		 }
		 public String getFollowUpTermLoanNotes(String period,String termLoanId) {
			 String getFollowUpTermLoanNotesPaylod ="[\r\n" + 
			 		"   {\r\n" + 
			 		"      \"period\":"+period+",\r\n" + 
			 		"      \"termLoanId\":\""+termLoanId+"\"\r\n" + 
			 		"   }\r\n" + 
			 		"]";
			return getFollowUpTermLoanNotesPaylod;
			 
		 }
		 public String followupMaturingLoan(String termLoanId,String period) {
			 String maturingloan="[\r\n" + 
			 		"  {\r\n" + 
			 		"    \"termLoanId\": \""+termLoanId+"\",\r\n" + 
			 		"    \"period\": \""+period+"\"\r\n" + 
			 		"  }\r\n" + 
			 		"]";
			return maturingloan;
		 }

		 public String createNoteOnPeriodLevel(String notes,String reminderDate,String termLoanId,String period) {
			 String createNote="{\r\n" + 
			 		"  \"notes\": \""+notes+"\",\r\n" + 
			 		"  \"reminderDate\": \""+reminderDate+"\",\r\n" + 
			 		"  \"periodDetails\": [\r\n" + 
			 		"    {\r\n" + 
			 		"      \"termLoanId\": \""+termLoanId+"\",\r\n" + 
			 		"      \"period\": \""+period+"\"\r\n" + 
			 		"    }\r\n" + 
			 		"  ]\r\n" + 
			 		"}";
			return createNote;
		 }
		 
		 //Using this in script
		 public String createNoteWithoutreminderDate(String notes,String termLoanId,String period) {
			 String createNoteWithoutreminderDate="{\r\n" + 
			 		"  \"notes\": \""+notes+"\",\r\n" + 
			 		"  \"reminderDate\": \"\",\r\n" + 
			 		"  \"periodDetails\": [\r\n" + 
			 		"    {\r\n" + 
			 		"      \"termLoanId\": \""+termLoanId+"\",\r\n" + 
			 		"      \"period\": \""+period+"\"\r\n" + 
			 		"    }\r\n" + 
			 		"  ]\r\n" + 
			 		"}";
			return createNoteWithoutreminderDate;
			 
		 }
		 public String create(String notes,String reminderDate,String termLoanIds) {
			 
			 String createNoteWithoutreminderDate="{\r\n" + 
			 		"  \"notes\": \""+notes+"\",\r\n" + 
			 		"  \"reminderDate\": \""+reminderDate+"\",\r\n" + 
			 		"  \"termLoanIds\": [\r\n" + 
			 		"    \""+termLoanIds+"\"\r\n" + 
			 		"  ]\r\n" + 
			 		"}";
			 
			 return createNoteWithoutreminderDate;
			 
		 }
		 public static String   getPayloadforPreviewToCheckLoanNumberNegative(String LoanNumber) {
		        String requestBodyForChargeCode="{\r\n" + 
		        		"  \"id\": null,\r\n" + 
		        		"  \"loanType\": {\r\n" + 
		        		"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
		        		"    \"value\": \"term_loan\",\r\n" + 
		        		"    \"display\": \"Term Loan\"\r\n" + 
		        		"  },\r\n" + 
		        		"  \"borrower\": {\r\n" + 
		        		"    \"id\": \"8205\",\r\n" + 
		        		"    \"name\": \"LOAN-009\"\r\n" + 
		        		"  },\r\n" + 
		        		"  \"currency\": {\r\n" + 
		        		"    \"id\": 5,\r\n" + 
		        		"    \"currencyCode\": \"USD\",\r\n" + 
		        		"    \"description\": \"USD : US Dollar\",\r\n" + 
		        		"    \"decimalPrecision\": 6,\r\n" + 
		        		"    \"systemDefined\": false\r\n" + 
		        		"  },\r\n" + 
		        		"  \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
		        		"  \"loanName\": \"LOAN\",\r\n" + 
		        		"  \"principalAmount\": \"3600\",\r\n" + 
		        		"  \"disbursementDate\": null,\r\n" + 
		        		"  \"initialPaymentDate\": null,\r\n" + 
		        		"  \"termType\": {\r\n" + 
		        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
		        		"    \"value\": \"months\",\r\n" + 
		        		"    \"display\": \"Months\"\r\n" + 
		        		"  },\r\n" + 
		        		"  \"terms\": \"12\",\r\n" + 
		        		"  \"originationDate\": \"09/12/2019\",\r\n" + 
		        		"  \"maturityDate\": \"09/12/2020\",\r\n" + 
		        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
		        		"  \"interestRate\": 2,\r\n" + 
		        		"  \"divisor\": 12,\r\n" + 
		        		"  \"comments\": null\r\n" + 
		        		"}";
		        
//		        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
		        
		     return requestBodyForChargeCode;
		        
		    }
		
		 
		 public String masterTermLoanCommit(String responseOfPreview,String loanType_id,String borrower_id,String name,String loanNumber,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
			 String masterTermLoanCommit="{\r\n" + 
			 		"  \"id\": \""+responseOfPreview+"\",\r\n" + 
			 		"  \"loanType\": {\r\n" + 
			 		"    \"id\": \""+loanType_id+"\",\r\n" + 
			 		"    \"value\": \"term_loan\",\r\n" + 
			 		"    \"display\": \"Term Loan\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"borrower\": {\r\n" + 
			 		"    \"id\": \""+borrower_id+"\",\r\n" + 
			 		"    \"name\": \""+name+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"currency\": {\r\n" + 
			 		"    \"id\": 5,\r\n" + 
			 		"    \"currencyCode\": \"USD\",\r\n" + 
			 		"    \"description\": \"USD : US Doll\",\r\n" + 
			 		"    \"decimalPrecision\": 2,\r\n" + 
			 		"    \"systemDefined\": false\r\n" + 
			 		"  },\r\n" + 
			 		"  \"loanNumber\": \""+loanNumber+"\",\r\n" + 
			 		"  \"loanName\": \""+loanName+"\",\r\n" + 
			 		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
			 		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
			 		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
			 		"  \"termType\": {\r\n" + 
			 		"    \"id\": \""+termType_id+"\",\r\n" + 
			 		"    \"value\": \""+value+"\",\r\n" + 
			 		"    \"display\": \""+display+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"terms\": \""+terms+"\",\r\n" + 
			 		"  \"originationDate\": \""+originationDate+"\",\r\n" + 
			 		"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
			 		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
			 		"  \"interestRate\": "+interestRate+",\r\n" + 
			 		"  \"divisor\": "+divisor+",\r\n" + 
			 		"  \"revisedInterestRate\": null,\r\n" + 
			 		"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
			 		"  \"comments\": null,\r\n" + 
			 		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
			 		"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
			 		"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
			 		"  \"totalInterest\": 10,\r\n" + 
			 		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
			 		"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
			 		"  \"editedFixedPrincipal\": null,\r\n" + 
			 		"  \"baseInterestRate\": 10,\r\n" + 
			 		"  \"intRatePrecision\": 12,\r\n" + 
			 		"  \"dailyDivisor\": 360,\r\n" + 
			 		"  \"loanStatus\": {\r\n" + 
			 		"    \"id\": \""+loanStatus_id+"\",\r\n" + 
			 		"    \"displayName\": \"Active\",\r\n" + 
			 		"    \"value\": \"active\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"paidOffDate\": null,\r\n" + 
			 		"  \"totalOutStandingBalance\": 0,\r\n" + 
			 		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
			 		"}";
			return masterTermLoanCommit;
		 }
		 public String masterTermLoanCommit1(String responseOfPreview,String loanType_id,String borrower_id,String name,String loanNumber,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
			 String masterTermLoanCommit="{\r\n" + 
			 		"  \"id\": \""+responseOfPreview+"\",\r\n" + 
			 		"  \"loanType\": {\r\n" + 
			 		"    \"id\": \""+loanType_id+"\",\r\n" + 
			 		"    \"value\": \"term_loan\",\r\n" + 
			 		"    \"display\": \"Term Loan\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"borrower\": {\r\n" + 
			 		"    \"id\": \""+borrower_id+"\",\r\n" + 
			 		"    \"name\": \""+name+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"currency\": {\r\n" + 
			 		"    \"id\": 5,\r\n" + 
			 		"    \"currencyCode\": \"USD\",\r\n" + 
			 		"    \"description\": \"USD : US Doll\",\r\n" + 
			 		"    \"decimalPrecision\": 2,\r\n" + 
			 		"    \"systemDefined\": false\r\n" + 
			 		"  },\r\n" + 
			 		"  \"loanNumber\": \""+loanNumber+"\",\r\n" + 
			 		"  \"loanName\": \""+loanName+"\",\r\n" + 
			 		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
			 		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
			 		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
			 		"  \"termType\": {\r\n" + 
			 		"    \"id\": \""+termType_id+"\",\r\n" + 
			 		"    \"value\": \""+value+"\",\r\n" + 
			 		"    \"display\": \""+display+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"terms\": \""+terms+"\",\r\n" + 
			 		"  \"originationDate\": \""+originationDate+"\",\r\n" + 
			 		"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
			 		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
			 		"  \"interestRate\": "+interestRate+",\r\n" + 
			 		"  \"divisor\": "+divisor+",\r\n" + 
			 		"  \"revisedInterestRate\": null,\r\n" + 
			 		"  \"revisedInterestRateEffectiveDate\": "+revisedInterestRateEffectiveDate+",\r\n" + 
			 		"  \"comments\": null,\r\n" + 
			 		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
			 		"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
			 		"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
			 		"  \"totalInterest\": "+totalInterest+",\r\n" + 
			 		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
			 		"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
			 		"  \"editedFixedPrincipal\": null,\r\n" + 
			 		"  \"baseInterestRate\": 10,\r\n" + 
			 		"  \"intRatePrecision\": 12,\r\n" + 
			 		"  \"dailyDivisor\": 360,\r\n" + 
			 		"  \"loanStatus\": {\r\n" + 
			 		"    \"id\": \""+loanStatus_id+"\",\r\n" + 
			 		"    \"displayName\": \"Active\",\r\n" + 
			 		"    \"value\": \"active\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"paidOffDate\": null,\r\n" + 
			 		"  \"totalOutStandingBalance\": 0,\r\n" + 
			 		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
			 		"}";
			return masterTermLoanCommit;
		 }
		 public String masterTermLoanCommitAmt(String responseOfPreview,String loanType_id,String borrower_id,String name,String loanNumber,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
			 String masterTermLoanCommit="{\r\n" + 
			 		"  \"id\": \""+responseOfPreview+"\",\r\n" + 
			 		"  \"loanType\": {\r\n" + 
			 		"    \"id\": \""+loanType_id+"\",\r\n" + 
			 		"    \"value\": \"term_loan\",\r\n" + 
			 		"    \"display\": \"Term Loan\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"borrower\": {\r\n" + 
			 		"    \"id\": \""+borrower_id+"\",\r\n" + 
			 		"    \"name\": \""+name+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"currency\": {\r\n" + 
			 		"    \"id\": 5,\r\n" + 
			 		"    \"currencyCode\": \"USD\",\r\n" + 
			 		"    \"description\": \"USD : US Doll\",\r\n" + 
			 		"    \"decimalPrecision\": 2,\r\n" + 
			 		"    \"systemDefined\": false\r\n" + 
			 		"  },\r\n" + 
			 		"  \"loanNumber\": \""+loanNumber+"\",\r\n" + 
			 		"  \"loanName\": \""+loanName+"\",\r\n" + 
			 		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
			 		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
			 		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
			 		"  \"termType\": {\r\n" + 
			 		"    \"id\": \""+termType_id+"\",\r\n" + 
			 		"    \"value\": \""+value+"\",\r\n" + 
			 		"    \"display\": \""+display+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"terms\": \""+terms+"\",\r\n" + 
			 		"  \"originationDate\": \""+originationDate+"\",\r\n" + 
			 		"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
			 		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
			 		"  \"interestRate\": "+interestRate+",\r\n" + 
			 		"  \"divisor\": "+divisor+",\r\n" + 
			 		"  \"revisedInterestRate\": null,\r\n" + 
			 		"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
			 		"  \"comments\": null,\r\n" + 
			 		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
			 		"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
			 		"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
			 		"  \"totalInterest\": 10,\r\n" + 
			 		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
			 		"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
			 		"  \"editedFixedPrincipal\": null,\r\n" + 
			 		"  \"baseInterestRate\": 10,\r\n" + 
			 		"  \"intRatePrecision\": 12,\r\n" + 
			 		"  \"dailyDivisor\": 360,\r\n" + 
			 		"  \"loanStatus\": {\r\n" + 
			 		"    \"id\": \""+loanStatus_id+"\",\r\n" + 
			 		"    \"displayName\": \"Active\",\r\n" + 
			 		"    \"value\": \"active\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"paidOffDate\": null,\r\n" + 
			 		"  \"totalOutStandingBalance\": 0,\r\n" + 
			 		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
			 		"}";
			return masterTermLoanCommit;
		 }

		 public String masterTermloanPreviewAmt(String loanType_id,String borrower_id,String name,String loanNumber,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
				
			 String checkPreview="{\r\n" + 
			 		"  \"id\": null,\r\n" + 
			 		"  \"loanType\": {\r\n" + 
			 		"    \"id\": \""+loanType_id+"\",\r\n" + 
			 		"    \"value\": \"term_loan\",\r\n" + 
			 		"    \"display\": \"Term Loan\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"borrower\": {\r\n" + 
			 		"    \"id\": \""+borrower_id+"\",\r\n" + 
			 		"    \"name\": \""+name+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"currency\": {\r\n" + 
			 		"    \"id\": 5,\r\n" + 
			 		"    \"currencyCode\": \"USD\",\r\n" + 
			 		"    \"description\": \"USD : US Doll\",\r\n" + 
			 		"    \"decimalPrecision\": 2,\r\n" + 
			 		"    \"systemDefined\": false\r\n" + 
			 		"  },\r\n" + 
			 		"  \"loanNumber\": \""+loanNumber+"\",\r\n" + 
			 		"  \"loanName\": \""+loanName+"\",\r\n" + 
			 		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
			 		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
			 		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
			 		"  \"termType\": {\r\n" + 
			 		"    \"id\": \""+termType_id+"\",\r\n" + 
			 		"    \"value\": \""+value+"\",\r\n" + 
			 		"    \"display\": \""+display+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"terms\": \""+terms+"\",\r\n" + 
			 		"  \"originationDate\": \""+originationDate+"\",\r\n" + 
			 		"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
			 		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
			 		"  \"interestRate\": "+interestRate+",\r\n" + 
			 		"  \"divisor\": "+divisor+",\r\n" + 
			 		"  \"revisedInterestRate\": null,\r\n" + 
			 		"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
			 		"  \"comments\": null,\r\n" + 
			 		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
			 		"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
			 		"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
			 		"  \"totalInterest\": null,\r\n" + 
			 		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
			 		"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
			 		"  \"editedFixedPrincipal\": null,\r\n" + 
			 		"  \"baseInterestRate\": null,\r\n" + 
			 		"  \"intRatePrecision\": 12,\r\n" + 
			 		"  \"dailyDivisor\": 360,\r\n" + 
			 		"  \"loanStatus\": {\r\n" + 
			 		"    \"id\": \""+loanStatus_id+"\",\r\n" + 
			 		"    \"displayName\": \"Active\",\r\n" + 
			 		"    \"value\": \"active\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"paidOffDate\": null,\r\n" + 
			 		"  \"totalOutStandingBalance\": 0,\r\n" + 
			 		"  \"preview\": null,\r\n" + 
			 		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
			 		"}";
			return checkPreview;
		 }
		 public String masterTermloanPreview(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
			
			 String checkPreview="{\r\n" + 
			 		"  \"id\": null,\r\n" + 
			 		"  \"loanType\": {\r\n" + 
			 		"    \"id\": \""+loanType_id+"\",\r\n" + 
			 		"    \"value\": \"term_loan\",\r\n" + 
			 		"    \"display\": \"Term Loan\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"borrower\": {\r\n" + 
			 		"    \"id\": \""+borrower_id+"\",\r\n" + 
			 		"    \"name\": \""+name+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"currency\": {\r\n" + 
			 		"    \"id\": 5,\r\n" + 
			 		"    \"currencyCode\": \"USD\",\r\n" + 
			 		"    \"description\": \"USD : US Doll\",\r\n" + 
			 		"    \"decimalPrecision\": 2,\r\n" + 
			 		"    \"systemDefined\": false\r\n" + 
			 		"  },\r\n" + 
			 		"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
			 		"  \"loanName\": \""+loanName+"\",\r\n" + 
			 		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
			 		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
			 		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
			 		"  \"termType\": {\r\n" + 
			 		"    \"id\": \""+termType_id+"\",\r\n" + 
			 		"    \"value\": \""+value+"\",\r\n" + 
			 		"    \"display\": \""+display+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"terms\": \""+terms+"\",\r\n" + 
			 		"  \"originationDate\": \""+originationDate+"\",\r\n" + 
			 		"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
			 		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
			 		"  \"interestRate\": "+interestRate+",\r\n" + 
			 		"  \"divisor\": "+divisor+",\r\n" + 
			 		"  \"revisedInterestRate\": null,\r\n" + 
			 		"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
			 		"  \"comments\": null,\r\n" + 
			 		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
			 		"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
			 		"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
			 		"  \"totalInterest\": null,\r\n" + 
			 		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
			 		"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
			 		"  \"editedFixedPrincipal\": null,\r\n" + 
			 		"  \"baseInterestRate\": null,\r\n" + 
			 		"  \"intRatePrecision\": 12,\r\n" + 
			 		"  \"dailyDivisor\": 360,\r\n" + 
			 		"  \"loanStatus\": {\r\n" + 
			 		"    \"id\": \""+loanStatus_id+"\",\r\n" + 
			 		"    \"displayName\": \"Active\",\r\n" + 
			 		"    \"value\": \"active\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"paidOffDate\": null,\r\n" + 
			 		"  \"totalOutStandingBalance\": 0,\r\n" + 
			 		"  \"preview\": null,\r\n" + 
			 		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
			 		"}";
			return checkPreview;
		 }
		 public String masterTermloanPreview1(String loanType_id,String borrower_id,String name,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String termType_id,String value,String display,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String revisedInterestRate,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String fixedPrincipal,String loanStatus_id,String disbursementAmount) {
				
			 String checkPreview="{\r\n" + 
			 		"  \"id\": null,\r\n" + 
			 		"  \"loanType\": {\r\n" + 
			 		"    \"id\": \""+loanType_id+"\",\r\n" + 
			 		"    \"value\": \"term_loan\",\r\n" + 
			 		"    \"display\": \"Term Loan\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"borrower\": {\r\n" + 
			 		"    \"id\": \""+borrower_id+"\",\r\n" + 
			 		"    \"name\": \""+name+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"currency\": {\r\n" + 
			 		"    \"id\": 5,\r\n" + 
			 		"    \"currencyCode\": \"USD\",\r\n" + 
			 		"    \"description\": \"USD : US Doll\",\r\n" + 
			 		"    \"decimalPrecision\": 2,\r\n" + 
			 		"    \"systemDefined\": false\r\n" + 
			 		"  },\r\n" + 
			 		"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
			 		"  \"loanName\": \""+loanName+"\",\r\n" + 
			 		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
			 		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
			 		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
			 		"  \"termType\": {\r\n" + 
			 		"    \"id\": \""+termType_id+"\",\r\n" + 
			 		"    \"value\": \""+value+"\",\r\n" + 
			 		"    \"display\": \""+display+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"terms\": \""+terms+"\",\r\n" + 
			 		"  \"originationDate\": \""+originationDate+"\",\r\n" + 
			 		"  \"maturityDate\": \""+maturityDate+"\",\r\n" + 
			 		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
			 		"  \"interestRate\": "+interestRate+",\r\n" + 
			 		"  \"divisor\": "+divisor+",\r\n" + 
			 		"  \"revisedInterestRate\": "+revisedInterestRate+",\r\n" + 
			 		"  \"revisedInterestRateEffectiveDate\": "+revisedInterestRateEffectiveDate+",\r\n" + 
			 		"  \"comments\": null,\r\n" + 
			 		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
			 		"  \"interestRateCode\": "+interestRateCode+",\r\n" + 
			 		"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
			 		"  \"totalInterest\": "+totalInterest+",\r\n" + 
			 		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
			 		"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
			 		"  \"editedFixedPrincipal\": null,\r\n" + 
			 		"  \"baseInterestRate\": null,\r\n" + 
			 		"  \"intRatePrecision\": 12,\r\n" + 
			 		"  \"dailyDivisor\": 360,\r\n" + 
			 		"  \"loanStatus\": {\r\n" + 
			 		"    \"id\": \""+loanStatus_id+"\",\r\n" + 
			 		"    \"displayName\": \"Active\",\r\n" + 
			 		"    \"value\": \"active\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"paidOffDate\": null,\r\n" + 
			 		"  \"totalOutStandingBalance\": 0,\r\n" + 
			 		"  \"preview\": null,\r\n" + 
			 		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
			 		"}";
			return checkPreview;
		 }
		 public String disbursementPayment(String disbursementAmount,String disbursementDate,String termLoan_id) {
			 String disbursementPayment="{\r\n" + 
			 		"  \"disbursementAmount\": \""+disbursementAmount+"\",\r\n" + 
			 		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
			 		"  \"termLoan\": {\r\n" + 
			 		"    \"id\": \""+termLoan_id+"\"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"comment\": \"hi test\"\r\n" + 
			 		"}";
			return disbursementPayment;
		 }
		 public String createInterestRateCode(String rate_code,String rate_name) {
			 String createInterestRateCode="{\r\n" + 
			 		"  \"interest_rate_code\": {\r\n" + 
			 		"    \"rate_code\": \""+rate_code+"\",\r\n" + 
			 		"    \"rate_name\": \""+rate_name+"\",\r\n" + 
			 		"    \"rate_description\": \"\",\r\n" + 
			 		"    \"rate_divisor\": \"360\",\r\n" + 
			 		"    \"rate_precision\": \"8\",\r\n" + 
			 		"    \"loan_type\": \"TermLoan\"\r\n" + 
			 		"  }\r\n" + 
			 		"}";
			return createInterestRateCode;
			 
		 }
		public String addInterestOnRateCode(String rate_date,String rate_value,String interest_rate_code_id) {
			String addInterestOnRateCode="{\r\n" + 
					"  \"interest_rate\": {\r\n" + 
					"    \"rate_date\": \""+rate_date+"\",\r\n" + 
					"    \"rate_value\": \""+rate_value+"\",\r\n" + 
					"    \"interest_rate_code_id\": \""+interest_rate_code_id+"\"\r\n" + 
					"  }\r\n" + 
					"}";
			return addInterestOnRateCode;
		}
		 public String autoNotification(String termLoanEventid,String eventName,String displayName,String notifyType,String eventAction,String eventDays,String emailTemplateid) {
			 String autoNotification="[\r\n" + 
			 		"  {\r\n" + 
			 		"    \"id\": \"\",\r\n" + 
			 		"    \"termLoanEvent\": {\r\n" + 
			 		"      \"id\": \""+termLoanEventid+"\",\r\n" + 
			 		"      \"eventName\": \""+eventName+"\",\r\n" + 
			 		"      \"displayName\": \""+displayName+"\"\r\n" + 
			 		"    },\r\n" + 
			 		"    \"notifyType\": \""+notifyType+"\",\r\n" + 
			 		"    \"eventAction\": \""+eventAction+"\",\r\n" + 
			 		"    \"eventDays\": \""+eventDays+"\",\r\n" + 
			 		"    \"emailTemplate\": {\r\n" + 
			 		"      \"id\": \""+emailTemplateid+"\"\r\n" + 
			 		"    },\r\n" + 
			 		"    \"delFlag\": false\r\n" + 
			 		"  }\r\n" + 
			 		"]";
			return autoNotification;
		 }
		 public String createBorrower(String client_name,String short_name,String client_number,String bbc_frequency_date,String manager_ids,String sales_region_id,String client_template_id) {
			 String createBorrower="{\r\n" + 
			 		"  \"borrower\": {\r\n" + 
			 		"    \"client_name\": \""+client_name+"\",\r\n" + 
			 		"    \"short_name\": \""+short_name+"\",\r\n" + 
			 		"    \"client_number\": "+client_number+",\r\n" + 
			 		"    \"bbc_frequency\": \"M\",\r\n" + 
			 		"    \"bbc_frequency_date\": \""+bbc_frequency_date+"\",\r\n" + 
			 		"    \"bbc_period\": \"\",\r\n" + 
			 		"    \"bbc_day\": \"\",\r\n" + 
			 		"    \"currency_id\": 0,\r\n" + 
			 		"    \"naics_code_id\": 0,\r\n" + 
			 		"    \"parent_client_id\": \"\",\r\n" + 
			 		"    \"email_id\": \"\",\r\n" + 
			 		"    \"description\": \"\",\r\n" + 
			 		"    \"client_url\": \"\",\r\n" + 
			 		"    \"acount_reference\": \"\",\r\n" + 
			 		"    \"processing_type\": \"\",\r\n" + 
			 		"    \"manager_ids\": [\r\n" + 
			 		"      \""+manager_ids+"\"\r\n" + 
			 		"    ],\r\n" + 
			 		"    \"original_amount\": 0,\r\n" + 
			 		"    \"current_loan_balance\": \"\",\r\n" + 
			 		"    \"limit_amount\": \"\",\r\n" + 
			 		"    \"minimum_balance_amount\": \"\",\r\n" + 
			 		"    \"cash_controls\": \"\",\r\n" + 
			 		"    \"risk_rating_code\": \"\",\r\n" + 
			 		"    \"company_type\": \"\",\r\n" + 
			 		"    \"date_established\": \"\",\r\n" + 
			 		"    \"country_id\": \"\",\r\n" + 
			 		"    \"state_province_id\": \"\",\r\n" + 
			 		"    \"tax_id\": \"\",\r\n" + 
			 		"    \"expiration_date\": \"\",\r\n" + 
			 		"    \"term\": \"\",\r\n" + 
			 		"    \"branch\": \"\",\r\n" + 
			 		"    \"sales_region_id\": [\r\n" + 
			 		"      \""+sales_region_id+"\"\r\n" + 
			 		"    ],\r\n" + 
			 		"    \"ucc_number\": \"\",\r\n" + 
			 		"    \"ucc_filling_date\": \"\",\r\n" + 
			 		"    \"active\": true,\r\n" + 
			 		"    \"client_template_id\": \""+client_template_id+"\"\r\n" + 
			 		"  }\r\n" + 
			 		"}";
			return createBorrower;
		 }
		 public String autoNotificationafterDue(String id,String termLoanEventid,String notifyType,String eventAction,String eventDays,String emailTemplateid,String emailTemplatename) {
			 String autoNotificationafterDue="[\r\n" + 
			 		"  {\r\n" + 
			 		"    \"id\": \""+id+"\",\r\n" + 
			 		"    \"termLoanEvent\": {\r\n" + 
			 		"      \"id\": \""+termLoanEventid+",\r\n" + 
			 		"      \"eventName\": \"payment-due\",\r\n" + 
			 		"      \"displayName\": \"Payment Due\"\r\n" + 
			 		"    },\r\n" + 
			 		"    \"notifyType\": \""+notifyType+"\",\r\n" + 
			 		"    \"eventAction\": \""+eventAction+"\",\r\n" + 
			 		"    \"eventDays\": "+eventDays+",\r\n" + 
			 		"    \"emailTemplate\": {\r\n" + 
			 		"      \"id\": \""+emailTemplateid+"\",\r\n" + 
			 		"      \"name\": \""+emailTemplatename+"\",\r\n" + 
			 		"      \"emailType\": \"Termloan\",\r\n" + 
			 		"      \"purpose\": \"Loan Outstanding\",\r\n" + 
			 		"      \"body\": \"Email Test body\",\r\n" + 
			 		"      \"cc\": null,\r\n" + 
			 		"      \"subject\": \"Payment Outstanding on Loan %{Loan}\",\r\n" + 
			 		"      \"defaultTemplate\": true\r\n" + 
			 		"    },\r\n" + 
			 		"    \"textTemplate\": null,\r\n" + 
			 		"    \"repeat\": false,\r\n" + 
			 		"    \"repeatDays\": 0,\r\n" + 
			 		"    \"delFlag\": true\r\n" + 
			 		"  },\r\n" + 
			 		"  {\r\n" + 
			 		"    \"id\": \"\",\r\n" + 
			 		"    \"termLoanEvent\": {\r\n" + 
			 		"      \"id\": \""+termLoanEventid+"\",\r\n" + 
			 		"      \"eventName\": \"payment-due\",\r\n" + 
			 		"      \"displayName\": \"Payment Due\"\r\n" + 
			 		"    },\r\n" + 
			 		"    \"notifyType\": \""+notifyType+"\",\r\n" + 
			 		"    \"eventAction\": \""+eventAction+"\",\r\n" + 
			 		"    \"eventDays\": \""+eventDays+"\",\r\n" + 
			 		"    \"emailTemplate\": {\r\n" + 
			 		"      \"id\": \""+emailTemplateid+"\"\r\n" + 
			 		"    },\r\n" + 
			 		"    \"repeat\": false,\r\n" + 
			 		"    \"repeatDays\": \"\",\r\n" + 
			 		"    \"delFlag\": false\r\n" + 
			 		"  }\r\n" + 
			 		"]";
			return autoNotificationafterDue;
		 }
		 public String editPaymentDuePayload(String amortizationScheduleId,String period,String interestRate,String paymentDate,String openingBalance,String regularInterest,String regularPrincipal,String regularPaymentDue,String totalPaymentDue,String endingBalance,String balanceDue,String responseOfPreview,String loanNumber,String loanName,String loanType_id,String principalAmount,String totalInterest,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String divisor,String termType_id,String value,String display,String terms,String originationDate,String disbursementDate,String maturityDate,String initialPaymentDate,String borrower_id,String name,String loanStatus_id,String soFarDisbursement,String balanceDisbursement,String disbursementAmount,String periodStartDate,String periodEndDate) {
			 
			 String editPaymentDuePayload="{\r\n" + 
			 		"  \"id\": \""+amortizationScheduleId+"\",\r\n" + 
			 		"  \"period\": "+period+",\r\n" + 
			 		"  \"interestRate\": "+interestRate+",\r\n" + 
			 		"  \"paymentDate\": \""+paymentDate+"\",\r\n" + 
			 		"  \"openingBalance\": "+openingBalance+",\r\n" + 
			 		"  \"regularInterest\": "+regularInterest+",\r\n" + 
			 		"  \"regularPrincipal\": "+regularPrincipal+",\r\n" + 
			 		"  \"regularPaymentDue\": \""+regularPaymentDue+"\",\r\n" + 
			 		"  \"fee\": 0,\r\n" + 
			 		"  \"totalPaymentDue\": "+totalPaymentDue+",\r\n" + 
			 		"  \"totalPaymentDone\": 0,\r\n" + 
			 		"  \"totalInterestPayment\": 0,\r\n" + 
			 		"  \"totalFeePayment\": 0,\r\n" + 
			 		"  \"totalPrincipalPayment\": 0,\r\n" + 
			 		"  \"extraPrincipalPayment\": 0,\r\n" + 
			 		"  \"endingBalance\": "+endingBalance+",\r\n" + 
			 		"  \"balanceDue\": "+balanceDue+",\r\n" + 
			 		"  \"termLoan\": {\r\n" + 
			 		"    \"id\": \""+responseOfPreview+"\",\r\n" + 
			 		"    \"loanNumber\": \""+loanNumber+"\",\r\n" + 
			 		"    \"loanName\": \""+loanName+"\",\r\n" + 
			 		"    \"formattedTermloanName\": null,\r\n" + 
			 		"    \"totalOutStandingBalance\": 0,\r\n" + 
			 		"    \"loanType\": {\r\n" + 
			 		"      \"id\": \""+loanType_id+"\",\r\n" + 
			 		"      \"value\": \"term_loan\",\r\n" + 
			 		"      \"display\": \"Term Loan\"\r\n" + 
			 		"    },\r\n" + 
			 		"    \"currency\": {\r\n" + 
			 		"      \"id\": 5,\r\n" + 
			 		"      \"currencyCode\": \"USD\",\r\n" + 
			 		"      \"description\": \"USD : USD : US Doll\",\r\n" + 
			 		"      \"decimalPrecision\": 2,\r\n" + 
			 		"      \"systemDefined\": false\r\n" + 
			 		"    },\r\n" + 
			 		"    \"principalAmount\": "+principalAmount+",\r\n" + 
			 		"    \"interestRate\": "+interestRate+",\r\n" + 
			 		"    \"totalInterest\": "+totalInterest+",\r\n" + 
			 		"    \"rateAdjustment\": 0,\r\n" + 
			 		"    \"revisedInterestRateEffectiveDate\": \""+revisedInterestRateEffectiveDate+"\",\r\n" + 
			 		"    \"interestRateType\": \""+interestRateType+"\",\r\n" + 
			 		"    \"interestRateCode\": "+interestRateCode+",\r\n" + 
			 		"    \"divisor\": "+divisor+",\r\n" + 
			 		"    \"termType\": {\r\n" + 
			 		"      \"id\": \""+termType_id+"\",\r\n" + 
			 		"      \"value\": \""+value+"\",\r\n" + 
			 		"      \"display\": \""+display+"\"\r\n" + 
			 		"    },\r\n" + 
			 		"    \"terms\": "+terms+",\r\n" + 
			 		"    \"originationDate\": \""+originationDate+"\",\r\n" + 
			 		"    \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
			 		"    \"maturityDate\": \""+maturityDate+"\",\r\n" + 
			 		"    \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
			 		"    \"includeLoanBalanceInReserve\": false,\r\n" + 
			 		"    \"borrower\": {\r\n" + 
			 		"      \"id\": "+borrower_id+",\r\n" + 
			 		"      \"name\": \""+name+"\",\r\n" + 
			 		"      \"clientNumber\": null,\r\n" + 
			 		"      \"active\": false,\r\n" + 
			 		"      \"emailId\": null,\r\n" + 
			 		"      \"mailAddresses\": null\r\n" + 
			 		"    },\r\n" + 
			 		"    \"comments\": null,\r\n" + 
			 		"    \"precision\": 2,\r\n" + 
			 		"    \"loanStatus\": {\r\n" + 
			 		"      \"id\": \""+loanStatus_id+"\",\r\n" + 
			 		"      \"displayName\": \"Active\",\r\n" + 
			 		"      \"value\": \"active\"\r\n" + 
			 		"    },\r\n" + 
			 		"    \"paidOffDate\": null,\r\n" + 
			 		"    \"allowNegative\": false,\r\n" + 
			 		"    \"gracePeriodDays\": 0,\r\n" + 
			 		"    \"amortizationType\": \"normal\",\r\n" + 
			 		"    \"interestRatePrecision\": 0,\r\n" + 
			 		"    \"fixedPrincipal\": 0,\r\n" + 
			 		"    \"editedFixedPrincipal\": false,\r\n" + 
			 		"    \"soFarDisbursement\": "+soFarDisbursement+",\r\n" + 
			 		"    \"balanceDisbursement\": "+balanceDisbursement+",\r\n" + 
			 		"    \"disbursementAmount\": "+disbursementAmount+"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"payments\": null,\r\n" + 
			 		"  \"periodStartDate\": \""+periodStartDate+"\",\r\n" + 
			 		"  \"periodEndDate\": \""+periodEndDate+"\",\r\n" + 
			 		"  \"graceDays\": 0,\r\n" + 
			 		"  \"graceDaysEdited\": false,\r\n" + 
			 		"  \"additionalDisbursement\": 0,\r\n" + 
			 		"  \"periodCharged\": false,\r\n" + 
			 		"  \"paymentDueEdited\": false,\r\n" + 
			 		"  \"paymentDone\": false\r\n" + 
			 		"}";
			return editPaymentDuePayload;
		 }
		 public String termLonDistrubution(String batch_date,String ref_batch_no,String total_amount,String borrower_id, String check_no, String check_amount,String loanNumber, String loanName, String loan_id
				 , String initial_payment_date, String period, String payment_due_date, String interest_due_amount, String principal_due_amount,
				 String principal_paid_amount, String term_loan_amount) {
				 String termLoan= "{\r\n" +
				 " \"batch\": {\r\n" +
				 " \"batch_date\": \""+batch_date+"\",\r\n" +
				 " \"ref_batch_no\": \""+ref_batch_no+"\",\r\n" +
				 " \"total_amount\": \""+total_amount+"\",\r\n" +
				 " \"image_split\": true\r\n" +
				 " },\r\n" +
				 " \"check_parameters\": [\r\n" +
				 " {\r\n" +
				 " \"borrower_id\": "+borrower_id+",\r\n" +
				 " \"check_no\": \""+check_no+"\",\r\n" +
				 " \"check_amount\": \""+check_amount+"\",\r\n" +
				 " \"cash_receipt_source_code_id\": 1,\r\n" +
				 " \"bank_account_no\": \"\",\r\n" +
				 " \"account_id\": \"\",\r\n" +
				 " \"bank_routing_no\": \"\",\r\n" +
				 " \"invoices\": [\r\n" +
				 " \r\n" +
				 " ],\r\n" +
				 " \"credit_memos\": {\r\n" +
				 " \r\n" +
				 " },\r\n" +
				 " \"adjustment_only\": false,\r\n" +
				 " \"term_loans\": [\r\n" +
				 " [\r\n" +
				 " {\r\n" +
				 " \"loan_number\": \""+loanNumber+"\",\r\n" +
				 " \"loan_name\": \""+loanName+"\",\r\n" +
				 " \"loan_id\": \""+loan_id+"\",\r\n" +
				 " \"precision\": 2,\r\n" +
				 " \"initial_payment_date\": \""+initial_payment_date+"\",\r\n" +
				 " \"loan_period_due\": [\r\n" +
				 " {\r\n" +
				 " \"id\": \"\",\r\n" +
				 " \"period\": "+period+",\r\n" +
				 " \"payment_due_date\": \""+payment_due_date+"\",\r\n" +
				 " \"interest_due_amount\": "+interest_due_amount+",\r\n" +
				 " \"other_fee_due_amount\": 0,\r\n" +
				 " \"principal_due_amount\": "+principal_due_amount+",\r\n" +
				 " \"interest_paid_amount\": 0,\r\n" +
				 " \"other_fee_paid_amount\": 0,\r\n" +
				 " \"principal_paid_amount\": \""+principal_paid_amount+"\",\r\n" +
				 " \"loan_number\": \""+loanNumber+"\",\r\n" +
				 " \"auto_allocated\": false,\r\n" +
				 " \"loan_index\": 0,\r\n" +
				 " \"period_index\": 0,\r\n" +
				 " \"temp_flag\": false,\r\n" +
				 " \"precision\": 2\r\n" +
				 " }\r\n" +
				 " \r\n" +
				 " ]\r\n" +
				 " }\r\n" +
				 " \r\n" +
				 " ]\r\n" +
				 " ],\r\n" +
				 " \"bulk_amount\": null,\r\n" +
				 " \"debtor_bulk_amount\": null,\r\n" +
				 " \"abl_amount\": \"0.00\",\r\n" +
				 " \"fact_amount\": \"0.00\",\r\n" +
				 " \"is_non_factored\": false,\r\n" +
				 " \"term_loan_amount\": \""+term_loan_amount+"\",\r\n" +
				 " \"abl_payment_mode\": \"\",\r\n" +
				 " \"update_bank_details\": false\r\n" +
				 " }\r\n" +
				 " ]\r\n" +
				 "}";
				 return termLoan;
				 }
		 public String termloanRepayment(String batch_date,String ref_batch_no,String total_amount,String borrower_id,String check_no,String check_amount,String loan_number,String loan_name,String loan_id,String initial_payment_date,String period,String payment_due_date,String interest_due_amount,String principal_due_amount,String term_loan_amount) {
			 String termloanRepayment="{\r\n" + 
			 		"  \"batch\": {\r\n" + 
			 		"    \"batch_date\": \""+batch_date+"\",\r\n" + 
			 		"    \"ref_batch_no\": \""+ref_batch_no+"\",\r\n" + 
			 		"    \"total_amount\": \""+total_amount+"\",\r\n" + 
			 		"    \"image_split\": false\r\n" + 
			 		"  },\r\n" + 
			 		"  \"check_parameters\": [\r\n" + 
			 		"    {\r\n" + 
			 		"      \"borrower_id\": "+borrower_id+",\r\n" + 
			 		"      \"check_no\": \""+check_no+"\",\r\n" + 
			 		"      \"check_amount\": \""+check_amount+"\",\r\n" + 
			 		"      \"cash_receipt_source_code_id\": 1,\r\n" + 
			 		"      \"bank_account_no\": \"\",\r\n" + 
			 		"      \"account_id\": \"\",\r\n" + 
			 		"      \"bank_routing_no\": \"\",\r\n" + 
			 		"      \"invoices\": [],\r\n" + 
			 		"      \"credit_memos\": {},\r\n" + 
			 		"      \"adjustment_only\": false,\r\n" + 
			 		"      \"term_loans\": [\r\n" + 
			 		"        [\r\n" + 
			 		"          {\r\n" + 
			 		"            \"loan_number\": \""+loan_number+"\",\r\n" + 
			 		"            \"loan_name\": \""+loan_name+"\",\r\n" + 
			 		"            \"loan_id\": \""+loan_id+"\",\r\n" + 
			 		"            \"precision\": 2,\r\n" + 
			 		"            \"initial_payment_date\": \""+initial_payment_date+"\",\r\n" + 
			 		"            \"loan_period_due\": [\r\n" + 
			 		"              {\r\n" + 
			 		"                \"id\": \"\",\r\n" + 
			 		"                \"period\": "+period+",\r\n" + 
			 		"                \"payment_due_date\": \""+payment_due_date+"\",\r\n" + 
			 		"                \"interest_due_amount\": "+interest_due_amount+",\r\n" + 
			 		"                \"other_fee_due_amount\": 0,\r\n" + 
			 		"                \"principal_due_amount\": "+principal_due_amount+",\r\n" + 
			 		"                \"interest_paid_amount\": 0,\r\n" + 
			 		"                \"other_fee_paid_amount\": 0,\r\n" + 
			 		"                \"principal_paid_amount\": 0,\r\n" + 
			 		"                \"loan_number\": \""+loan_number+"\",\r\n" + 
			 		"                \"auto_allocated\": false,\r\n" + 
			 		"                \"loan_index\": 0,\r\n" + 
			 		"                \"period_index\": 0,\r\n" + 
			 		"                \"temp_flag\": false,\r\n" + 
			 		"                \"precision\": 2\r\n" + 
			 		"              }\r\n" + 
			 		"            ]\r\n" + 
			 		"          }\r\n" + 
			 		"        ]\r\n" + 
			 		"      ],\r\n" + 
			 		"      \"bulk_amount\": null,\r\n" + 
			 		"      \"debtor_bulk_amount\": null,\r\n" + 
			 		"      \"abl_amount\": \"0.00\",\r\n" + 
			 		"      \"fact_amount\": \"0.00\",\r\n" + 
			 		"      \"is_non_factored\": false,\r\n" + 
			 		"      \"term_loan_amount\": \""+term_loan_amount+"\",\r\n" + 
			 		"      \"abl_payment_mode\": \"\",\r\n" + 
			 		"      \"update_bank_details\": false\r\n" + 
			 		"    }\r\n" + 
			 		"  ]\r\n" + 
			 		"}";
			return termloanRepayment;
			 
		 }
		 public String editAmtpayload(String amortizationScheduleId,String period,String interestRate,String paymentDate,String openingBalance,String regularInterest,String regularPrincipal,String regularPaymentDue,String totalPaymentDue,String endingBalance,String balanceDue,String responseOfPreview,String loanNumber,String loanName,String loanType_id,String principalAmount,String totalInterest,String rateAdjustment,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String divisor,String termType_id,String value,String display,String terms,String originationDate,String disbursementDate,String maturityDate,String initialPaymentDate,String loanStatus_id,String soFarDisbursement,String balanceDisbursement,String disbursementAmount,String periodStartDate,String periodEndDate) {
			 String editAmtpayload="{\r\n" + 
			 		"  \"id\": \""+amortizationScheduleId+"\",\r\n" + 
			 		"  \"period\": "+period+",\r\n" + 
			 		"  \"interestRate\": "+interestRate+",\r\n" + 
			 		"  \"paymentDate\": \""+paymentDate+"\",\r\n" + 
			 		"  \"openingBalance\": "+openingBalance+",\r\n" + 
			 		"  \"regularInterest\": "+regularInterest+",\r\n" + 
			 		"  \"regularPrincipal\": "+regularPrincipal+",\r\n" + 
			 		"  \"regularPaymentDue\": \""+regularPaymentDue+"\",\r\n" + 
			 		"  \"fee\": 0,\r\n" + 
			 		"  \"totalPaymentDue\": "+totalPaymentDue+",\r\n" + 
			 		"  \"totalPaymentDone\": 0,\r\n" + 
			 		"  \"totalInterestPayment\": 0,\r\n" + 
			 		"  \"totalFeePayment\": 0,\r\n" + 
			 		"  \"totalPrincipalPayment\": 0,\r\n" + 
			 		"  \"extraPrincipalPayment\": 0,\r\n" + 
			 		"  \"endingBalance\": "+endingBalance+",\r\n" + 
			 		"  \"balanceDue\": "+balanceDue+",\r\n" + 
			 		"  \"termLoan\": {\r\n" + 
			 		"    \"id\": \""+responseOfPreview+"\",\r\n" + 
			 		"    \"loanNumber\": \""+loanNumber+"\",\r\n" + 
			 		"    \"loanName\": \""+loanName+"\",\r\n" + 
			 		"    \"formattedTermloanName\": null,\r\n" + 
			 		"    \"totalOutStandingBalance\": 0,\r\n" + 
			 		"    \"loanType\": {\r\n" + 
			 		"      \"id\": \""+loanType_id+"\",\r\n" + 
			 		"      \"value\": \"term_loan\",\r\n" + 
			 		"      \"display\": \"Term Loan\"\r\n" + 
			 		"    },\r\n" + 
			 		"    \"currency\": {\r\n" + 
			 		"      \"id\": 5,\r\n" + 
			 		"      \"currencyCode\": \"USD\",\r\n" + 
			 		"      \"description\": \"USD : US Dollar\",\r\n" + 
			 		"      \"decimalPrecision\": 3,\r\n" + 
			 		"      \"systemDefined\": true\r\n" + 
			 		"    },\r\n" + 
			 		"    \"principalAmount\": "+principalAmount+",\r\n" + 
			 		"    \"interestRate\": "+interestRate+",\r\n" + 
			 		"    \"totalInterest\": "+totalInterest+",\r\n" + 
			 		"    \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
			 		"    \"revisedInterestRateEffectiveDate\": \""+revisedInterestRateEffectiveDate+"\",\r\n" + 
			 		"    \"interestRateType\": \""+interestRateType+"\",\r\n" + 
			 		"    \"interestRateCode\": "+interestRateCode+",\r\n" + 
			 		"    \"divisor\": "+divisor+",\r\n" + 
			 		"    \"termType\": {\r\n" + 
			 		"      \"id\": \""+termType_id+"\",\r\n" + 
			 		"      \"value\": \""+value+"\",\r\n" + 
			 		"      \"display\": \""+display+"\"\r\n" + 
			 		"    },\r\n" + 
			 		"    \"terms\": "+terms+",\r\n" + 
			 		"    \"originationDate\": \""+originationDate+"\",\r\n" + 
			 		"    \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
			 		"    \"maturityDate\": \""+maturityDate+"\",\r\n" + 
			 		"    \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
			 		"    \"includeLoanBalanceInReserve\": false,\r\n" + 
			 		"    \"borrower\": {\r\n" + 
			 		"      \"id\": 11622,\r\n" + 
			 		"      \"name\": \"ABH-001\",\r\n" + 
			 		"      \"clientNumber\": \"NABH6\",\r\n" + 
			 		"      \"active\": true,\r\n" + 
			 		"      \"emailId\": \"mahesh.b@idexcel.com\",\r\n" + 
			 		"      \"mailAddresses\": [\r\n" + 
			 		"        {\r\n" + 
			 		"          \"id\": 391,\r\n" + 
			 		"          \"addressCode\": \"23092020\",\r\n" + 
			 		"          \"primaryName\": \"MAHESH\",\r\n" + 
			 		"          \"alternateName\": \"\",\r\n" + 
			 		"          \"streetAddress\": \"BTM 2ND STAGE BANGALORE\",\r\n" + 
			 		"          \"city\": \"BANGALORE\",\r\n" + 
			 		"          \"stateProvince\": \"205\",\r\n" + 
			 		"          \"zipCode\": \"2002\",\r\n" + 
			 		"          \"country\": \"United States\",\r\n" + 
			 		"          \"phoneNumber\": \"+918553432171\",\r\n" + 
			 		"          \"primaryAddr\": true\r\n" + 
			 		"        }\r\n" + 
			 		"      ]\r\n" + 
			 		"    },\r\n" + 
			 		"    \"comments\": null,\r\n" + 
			 		"    \"precision\": 2,\r\n" + 
			 		"    \"loanStatus\": {\r\n" + 
			 		"      \"id\": \""+loanStatus_id+"\",\r\n" + 
			 		"      \"displayName\": \"Active\",\r\n" + 
			 		"      \"value\": \"active\"\r\n" + 
			 		"    },\r\n" + 
			 		"    \"paidOffDate\": null,\r\n" + 
			 		"    \"allowNegative\": false,\r\n" + 
			 		"    \"gracePeriodDays\": 0,\r\n" + 
			 		"    \"amortizationType\": \"normal\",\r\n" + 
			 		"    \"interestRatePrecision\": 0,\r\n" + 
			 		"    \"fixedPrincipal\": 0,\r\n" + 
			 		"    \"editedFixedPrincipal\": false,\r\n" + 
			 		"    \"soFarDisbursement\": "+soFarDisbursement+",\r\n" + 
			 		"    \"balanceDisbursement\": "+balanceDisbursement+",\r\n" + 
			 		"    \"disbursementAmount\": "+disbursementAmount+"\r\n" + 
			 		"  },\r\n" + 
			 		"  \"payments\": null,\r\n" + 
			 		"  \"periodStartDate\": \""+periodStartDate+"\",\r\n" + 
			 		"  \"periodEndDate\": \""+periodEndDate+"\",\r\n" + 
			 		"  \"graceDays\": 0,\r\n" + 
			 		"  \"graceDaysEdited\": false,\r\n" + 
			 		"  \"additionalDisbursement\": 0,\r\n" + 
			 		"  \"paymentDone\": false,\r\n" + 
			 		"  \"paymentDueEdited\": false,\r\n" + 
			 		"  \"periodCharged\": false,\r\n" + 
			 		"  \"isEditAllowed\": true\r\n" + 
			 		"}";
			return editAmtpayload;
		 }
		 
			    public static String  getChargeCode(){
	            Random t = new Random();
	            int nextInt = t.nextInt(100000000);
	            String valueOf = String.valueOf(nextInt);
	    return valueOf;
	 
	        }
	    
	    public static String  getTransactionCode(){
	        Random t = new Random();
	        int nextInt = t.nextInt(10000000);
	        String valueOf = String.valueOf(nextInt);
	     return valueOf;

	    }
	        
	    public static String  getLoanNumber(){
	        Random t = new Random();
	        int nextInt = t.nextInt(10);
	        String valueOf = String.valueOf(nextInt);
	     return valueOf;

	    }
	    
	    public static String  getLoanName(){
	    	StringBuilder sb = new StringBuilder("idexcel");
	        Random t = new Random();
	        int nextInt = t.nextInt(10);
	        String valueOf2 = String.valueOf(nextInt);
	        StringBuilder valueOf=sb.append(valueOf2);
	      
	     return  valueOf.toString();

	    }
	    public static String  getComment(){
	    	StringBuilder sb = new StringBuilder("DELETING_DATA");
	        Random t = new Random();
	        int nextInt = t.nextInt(10);
	        String valueOf2 = String.valueOf(nextInt);
	        StringBuilder valueOf=sb.append(valueOf2);
	      
	     return  valueOf.toString();

	    }
	    public static Integer  getValue(){
	        Random t = new Random();
	        int nextInt = t.nextInt(100000);
	         return nextInt;

	    }
	    public static    float getValues(){
	        Random t = new Random();
	        float nextFloat = t.nextFloat();
	         return   nextFloat;

	    }
	    public static Integer  getPercentage(){
	        Random t = new Random();
	        int nextInt = t.nextInt(99);
	         return nextInt;

	    }

	    public static Integer  getValueforFee(){
	        Random t = new Random();
	        int nextInt = t.nextInt(100000);
	         return nextInt;

	    }

	    public static Integer  getActualValue(){
	        Random t = new Random();
	        int nextInt = t.nextInt(100000);
	         return nextInt;

	    }
	    public static    float getActualValuedecimal(){
	        Random t = new Random();
	        float nextFloat = t.nextFloat();
	         return   nextFloat;

	    }
	    public static    float getinligbleValuedecimal(){
	        Random t = new Random();
	        float nextFloat = t.nextFloat();
	         return   nextFloat;

	    }
	    public static    float getAdvanceValuedecimal(){
	        Random t = new Random();
	        float nextFloat = t.nextFloat();
	         return   nextFloat;

	    }

	    public Integer  getTransactionId(){
	        Random t = new Random();
	        int nextInt = t.nextInt(100000);
	         return nextInt;

	    }
	    

	    public static Integer  getRegularPaymentdue(){
	        Random t = new Random();
	        int nextInt = t.nextInt(100);
	         return nextInt;

	    }
		
		

	}
	
	 


