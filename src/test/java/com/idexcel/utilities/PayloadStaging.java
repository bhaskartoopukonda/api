package com.idexcel.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;


public class PayloadStaging extends Payloads{
	//PayloadStaging payloads= new PayloadStaging();
	   
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
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
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

	    public String getLoanDetails(String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String Intrest,String Originationdate,String InitialPaymentdate,String	Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate) {
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
	        		"  \"disbursementDate\": null,\r\n" + 
	        		"  \"initialPaymentDate\": null,\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"months\",\r\n" + 
	        		"    \"display\": \"Months\"\r\n" + 
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
	        		"  \"rateAdjustment\": null,\r\n" + 
	        		"  \"totalInterest\": null,\r\n" + 
	        		"  \"amortizationType\": \"normal\",\r\n" + 
	        		"  \"fixedPrincipal\": null,\r\n" + 
	        		"  \"editedFixedPrincipal\": null,\r\n" + 
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
	        		"  \"preview\": null,\r\n" + 
	        		"  \"disbursementAmount\": \"5000\"\r\n" + 
	        		"}";
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
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

	    public String termloanFloatingPreview(String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String id,String value,String display,String terms,String originationDate,String maturityDate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String disbursementAmount) {
	    	
	    	
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
	    			"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
	    			"  \"loanName\": \""+loanName+"\",\r\n" + 
	    			"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
	    			"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	    			"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	    			"  \"termType\": {\r\n" + 
	    			"    \"id\": \""+id+"\",\r\n" + 
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
	    			"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
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
	    public String getLoanCommitsWithTermType(String responseOfPreview,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String id,String months,String Months,String terms,String originationDate,String maturityDate,String interestRate,String divisor,String interestRateType,String interestRateCode,String amortizationType,String rateAdjustment,String disbursementAmount) {
		       
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
	        		"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
	        		"  \"loanName\": \""+loanName+"\",\r\n" + 
	        		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
	        		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	        		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \""+id+"\",\r\n" + 
	        		"    \"value\": \""+months+"\",\r\n" + 
	        		"    \"display\": \""+Months+"\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \"12\",\r\n" + 
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
	        		"  \"rateAdjustment\": null,\r\n" + 
	        		"  \"totalInterest\": 10,\r\n" + 
	        		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	        		"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
	        		"  \"editedFixedPrincipal\": false,\r\n" + 
	        		"  \"baseInterestRate\": 10,\r\n" + 
	        		"  \"intRatePrecision\": 12,\r\n" + 
	        		"  \"dailyDivisor\": 360,\r\n" + 
	        		"  \"loanStatus\": {\r\n" + 
	        		"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"displayName\": \"Active\",\r\n" + 
	        		"    \"value\": \"active\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"paidOffDate\": null,\r\n" + 
	        		"  \"totalOutStandingBalance\": 0,\r\n" + 
	        		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
	        		"}";
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public String getFloatingFixedCommit(String responseOfPreview,String loanNumber,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String id ,String value,String display,String terms,String originationDate,String maturityDate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String disbursementAmount) {
	    	   
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
	    	   		"  \"loanNumber\": \""+loanNumber+"\",\r\n" + 
	    	   		"  \"loanName\": \""+loanName+"\",\r\n" + 
	    	   		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
	    	   		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	    	   		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	    	   		"  \"termType\": {\r\n" + 
	    	   		"    \"id\": \""+id+"\",\r\n" + 
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
	    	   		"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	    	   		"    \"displayName\": \"Active\",\r\n" + 
	    	   		"    \"value\": \"active\"\r\n" + 
	    	   		"  },\r\n" + 
	    	   		"  \"paidOffDate\": null,\r\n" + 
	    	   		"  \"totalOutStandingBalance\": 0,\r\n" + 
	    	   		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
	    	   		"}";
			return getFloatingFixedCommit;
	       }
	    public String payloadforDeleteLoan(String termLoanId) {
			 String requestBody="[\r\n" + 
			 		"  \""+termLoanId+"\"\r\n" + 
			 		"]";
			return requestBody;
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
	        		"    \"id\": \"11536\",\r\n" + 
	        		"    \"name\": \"MAHESH_TEST\"\r\n" + 
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
	    
	    public String floating(String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String id,String value,String display,String terms,String originationDate,String maturityDate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String disbursementAmount)			
	    {
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
	    	        		"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
	    	        		"  \"loanName\": \""+loanName+"\",\r\n" + 
	    	        		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
	    	        		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	    	        		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	    	        		"  \"termType\": {\r\n" + 
	    	        		"    \"id\": \""+id+"\",\r\n" + 
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
	    	        		"  \"fixedPrincipal\": null,\r\n" + 
	    	        		"  \"editedFixedPrincipal\": null,\r\n" + 
	    	        		"  \"baseInterestRate\": null,\r\n" + 
	    	        		"  \"intRatePrecision\": 8,\r\n" + 
	    	        		"  \"dailyDivisor\": 360,\r\n" + 
	    	        		"  \"loanStatus\": {\r\n" + 
	    	        		"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	    	        		"    \"displayName\": \"Active\",\r\n" + 
	    	        		"    \"value\": \"active\"\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"paidOffDate\": null,\r\n" + 
	    	        		"  \"totalOutStandingBalance\": 0,\r\n" + 
	    	        		"  \"preview\": null,\r\n" + 
	    	        		"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
	    	        		"}";
//	    	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	    	        
	    	     return requestBodyForChargeCode;
	    	        
	    	    }
	    public String floatingcommit(String responseOfPreview,String loanNumber,String loanName,String principalAmount,String disbursementDate,String initialPaymentDate,String id,String value,String display,String terms,String originationDate,String maturityDate,String divisor,String interestRateType,String interestRateCode,String rateAdjustment,String totalInterest,String amortizationType,String disbursementAmount)			
	    {
	    	        String requestBodyForChargeCode="{\r\n" + 
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
	    	        		"    \"decimalPrecision\": 3,\r\n" + 
	    	        		"    \"systemDefined\": true\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"loanNumber\": \""+loanNumber+"\",\r\n" + 
	    	        		"  \"loanName\": \""+loanName+"\",\r\n" + 
	    	        		"  \"principalAmount\": \""+principalAmount+"\",\r\n" + 
	    	        		"  \"disbursementDate\": \""+disbursementDate+"\",\r\n" + 
	    	        		"  \"initialPaymentDate\": \""+initialPaymentDate+"\",\r\n" + 
	    	        		"  \"termType\": {\r\n" + 
	    	        		"    \"id\": \""+id+"\",\r\n" + 
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
	    	        		"  \"fixedPrincipal\": null,\r\n" + 
	    	        		"  \"editedFixedPrincipal\": null,\r\n" + 
	    	        		"  \"baseInterestRate\": 10,\r\n" + 
	    	        		"  \"intRatePrecision\": 8,\r\n" + 
	    	        		"  \"dailyDivisor\": 360,\r\n" + 
	    	        		"  \"loanStatus\": {\r\n" + 
	    	        		"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
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
	    
	    public static String getPayloadforPreviewToCheckOriginalDate() {
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
	        		"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
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
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	    
	    public static String getPayloadforPreviewToCheckLoanName(String Id) {
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
	        		"  \"loanName\": \""+getLoanName()+"\",\r\n" + 
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
	    
	    
	    public String getPayloadforPreviewToCheckLoanNameNegative(String Id,String Loanname) {
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
	    

	    public static String getPayloadforPreviewToCheckOrignalDateNegative(String Id,String Orignaldate ) {
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
	        		"  \"loanName\": \""+getLoanName()+"\",\r\n" + 
	        		"  \"principalAmount\": \"3600\",\r\n" + 
	        		"  \"disbursementDate\": null,\r\n" + 
	        		"  \"initialPaymentDate\": null,\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"months\",\r\n" + 
	        		"    \"display\": \"Months\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \"7\",\r\n" + 
	        		"  \"originationDate\": \""+Orignaldate+"\",\r\n" + 
	        		"  \"maturityDate\": \"04/12/2020\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": 2,\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"comments\": \"HI\"\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    

	    public static String getPayloadforPreviewToCheckDateNegative(String Id,String Initialdate ) {
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
	        		"  \"loanName\": \""+getLoanName()+"\",\r\n" + 
	        		"  \"principalAmount\": \"3600\",\r\n" + 
	        		"  \"disbursementDate\": null,\r\n" + 
	        		"  \"initialPaymentDate\": \""+Initialdate+",\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"months\",\r\n" + 
	        		"    \"display\": \"Months\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \"7\",\r\n" + 
	        		"  \"originationDate\": \"09/17/2019\",\r\n" + 
	        		"  \"maturityDate\": \"04/12/2020\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": 2,\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"comments\": \"HI\"\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public static String getPayloadforPreviewToCheckDisburnsmentNegative(String Id,String Disburnsmentdate ) {
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
	        		"  \"loanName\": \""+getLoanName()+"\",\r\n" + 
	        		"  \"principalAmount\": \"3600\",\r\n" + 
	        		"  \"disbursementDate\":  \""+Disburnsmentdate+"\",\r\n" + 
	        		"  \"initialPaymentDate\": null,\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"months\",\r\n" + 
	        		"    \"display\": \"Months\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \"7\",\r\n" + 
	        		"  \"originationDate\": \"09/17/2019\",\r\n" + 
	        		"  \"maturityDate\": \"04/12/2020\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": 2,\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"comments\": \"HI\"\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	  /*  public  String   getPayloadforPreviewToCheckEditOperation(String Id) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \""+Id+",\r\n" + 
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
	        		"  \"loanNumber\": 10\",\r\n" + 
	        		"  \"loanName\": \""+getLoanName()+"\",\r\n" + 
	        		"  \"principalAmount\": \"3600\",\r\n" + 
	        		"  \"disbursementDate\":  null,\r\n" + 
	        		"  \"initialPaymentDate\": null,\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"months\",\r\n" + 
	        		"    \"display\": \"Months\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \"7\",\r\n" + 
	        		"  \"originationDate\": \"09/17/2019\",\r\n" + 
	        		"  \"maturityDate\": \"04/12/2020\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": 2,\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"comments\": \""+getComment()+"\"\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }*/
	    
	    public static String getPayloadforPreviewToCheckEditOperation(String Id) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \""+Id+"\",\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"8992\",\r\n" + 
	        		"    \"name\": \"LOAN-1031\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"currency\": {\r\n" + 
	        		"    \"id\": 5,\r\n" + 
	        		"    \"currencyCode\": \"USD\",\r\n" + 
	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	        		"    \"decimalPrecision\": 6,\r\n" + 
	        		"    \"systemDefined\": false\r\n" + 
	        		"  },\r\n" + 
	        		"  \"loanNumber\": \"1035\",\r\n" + 
	        		"  \"loanName\": \""+getLoanName()+"\",\r\n" + 
	        		"  \"principalAmount\": 60,\r\n" + 
	        		"  \"disbursementDate\": null,\r\n" + 
	        		"  \"initialPaymentDate\": \"08/01/2019\",\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"months\",\r\n" + 
	        		"    \"display\": \"Months\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": 12,\r\n" + 
	        		"  \"originationDate\": \"07/01/2019\",\r\n" + 
	        		"  \"maturityDate\": \"07/01/2020\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"  \"interestRate\": 2,\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"comments\": "+getComment()+",\r\n" + 
	        		"  \"loanStatus\": {\r\n" + 
	        		"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"displayName\": \"Active\",\r\n" + 
	        		"    \"value\": \"active\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"paidOffDate\": \"08/01/2019\",\r\n" + 
	        		"  \"clientId\": \"8992\",\r\n" + 
	        		"  \"clientName\": \"LOAN-1031\"\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public static String autoAllocate(String batchDate, String clientId,String loanNumber,String allocationAmount) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"batchDate\": \""+batchDate+"\",\r\n" + 
	        		"  \"clientId\": \"10984\",\r\n" + 
	        		"  \"loanNumber\": \""+loanNumber+",\r\n" + 
	        		"  \"allocationAmount\": "+allocationAmount+"\r\n" + 
	        		"	\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }

	    public String getPayloadforPreviewToCheckEditOperationforNegative(String PaidOffDate,String LoanName,String loanID) {
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

	    public static String getPayloadforPreviewToCheckEditOperationforNegativeInactive(String PaidOffDate,String LaonName,String loanID) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \""+loanID+"\",\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"8992\",\r\n" + 
	        		"    \"name\": \"LOAN-1031\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"currency\": {\r\n" + 
	        		"    \"id\": 5,\r\n" + 
	        		"    \"currencyCode\": \"USD\",\r\n" + 
	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	        		"    \"decimalPrecision\": 6,\r\n" + 
	        		"    \"systemDefined\": false\r\n" + 
	        		"  },\r\n" + 
	        		"  \"loanNumber\": \"1035\",\r\n" + 
	        		"  \"loanName\": \""+LaonName+"\",\r\n" + 
	        		"  \"principalAmount\": 60,\r\n" + 
	        		"  \"disbursementDate\": null,\r\n" + 
	        		"  \"initialPaymentDate\": \"08/01/2019\",\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"months\",\r\n" + 
	        		"    \"display\": \"Months\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": 12,\r\n" + 
	        		"  \"originationDate\": \"07/01/2019\",\r\n" + 
	        		"  \"maturityDate\": \"07/01/2020\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"  \"interestRate\": 2,\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"comments\": "+getComment()+",\r\n" + 
	        		"  \"loanStatus\": {\r\n" + 
	        		"    \"id\": \"71ebd31b-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"displayName\": \"InActive\",\r\n" + 
	        		"    \"value\": \"inactive\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"paidOffDate\": "+PaidOffDate+",\r\n" + 
	        		"  \"clientId\": \"8992\",\r\n" + 
	        		"  \"clientName\": \"LOAN-1031\"\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }

	    public String getPayloadforChargeTemplatePost(String termLoan) {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \""+termLoan+"\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeCode\": {\r\n" + 
	        		"      \"id\": \"ebd8eea6-98c5-49a0-8b83-c1903206d317\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"natSign\": \"+\",\r\n" + 
	        		"    \"frequency\": \"manual\",\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"value\": 5\r\n" + 
	        		"  }\r\n" + 
	        		"]";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	   
	    public String getPayloadforChargeTemplatePut(String termLoan) {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"   {\r\n" + 
	        		"      \"termLoan\":{\r\n" + 
	        		"         \"id\":\""+termLoan+"\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"chargeCode\":{\r\n" + 
	        		"         \"id\":\"15142020\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"natSign\":\"+\",\r\n" + 
	        		"      \"frequency\":\"manual\",\r\n" + 
	        		"      \"chargeType\":{\r\n" + 
	        		"         \"id\":\"eba0a1ae-c363-11e9-9d62-12e987db82ac\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"value\":\""+getValue()+"\",\r\n" + 
	        		"      \"id\":\"add0101b-3443-4d77-b47f-4b8262b025f4\"\r\n" + 
	        		"   }\r\n" + 
	        		"]\r\n" + 
	        		"";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public String getPayloadforChargeTemplatePUTFloat(String termLoan) {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \""+termLoan+"\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeCode\": {\r\n" + 
	        		"      \"id\": \"15142020\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"natSign\": \"+\",\r\n" + 
	        		"    \"frequency\": \"manual\",\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"eba0a1ae-c363-11e9-9d62-12e987db82ac\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"value\": \""+ getValues()+"\",\r\n" + 
	        		"    \"id\": \"add0101b-3443-4d77-b47f-4b8262b025f4\"\r\n" + 
	        		"  }\r\n" + 
	        		"]";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	    
	    public static String getPayloadforchargecode(String getnatSignId, String getfrequencyId, String getchargeTypeId, String getpostingTypeId) {
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
	        		"  \"autoNewClient\": false\r\n" + 
	        		"}";
	        
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
	    
	    public static String getPayloadforchargecode(String ChargeCode) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \"\",\r\n" + 
	        		"  \"chargeCode\": \""+ChargeCode+"\",\r\n" + 
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
	    public String getPayloadforManualFeePost() {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"id\": \"01f2710d-1c3c-49ea-9565-d45c3c2d2bfb\",\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \"5299916c-d1d0-4a8b-917e-e1c35b250e57\",\r\n" + 
	        		"      \"loanNumber\": \"hjhhqa12\",\r\n" + 
	        		"      \"loanName\": \"hjhhqa12 : UNDOLOAN21\",\r\n" + 
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
	        		"      \"principalAmount\": 5000,\r\n" + 
	        		"      \"interestRate\": 2,\r\n" + 
	        		"      \"totalInterest\": 2,\r\n" + 
	        		"      \"rateAdjustment\": 2,\r\n" + 
	        		"      \"revisedInterestRateEffectiveDate\": \"03/23/2020\",\r\n" + 
	        		"      \"interestRateType\": \"fixed\",\r\n" + 
	        		"      \"interestRateCode\": 0,\r\n" + 
	        		"      \"divisor\": 12,\r\n" + 
	        		"      \"termType\": {\r\n" + 
	        		"        \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"months\",\r\n" + 
	        		"        \"display\": \"Months\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"terms\": 12,\r\n" + 
	        		"      \"originationDate\": \"03/23/2020\",\r\n" + 
	        		"      \"disbursementDate\": \"03/30/2020\",\r\n" + 
	        		"      \"maturityDate\": \"03/23/2021\",\r\n" + 
	        		"      \"initialPaymentDate\": \"04/23/2020\",\r\n" + 
	        		"      \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"      \"borrower\": {\r\n" + 
	        		"        \"id\": 11622,\r\n" + 
	        		"        \"name\": \"ABH-001\",\r\n" + 
	        		"        \"clientNumber\": \"NABH6\",\r\n" + 
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
	        		"      \"paidOffDate\": \"08/09/2020\",\r\n" + 
	        		"      \"allowNegative\": false,\r\n" + 
	        		"      \"gracePeriodDays\": 4,\r\n" + 
	        		"      \"amortizationType\": \"normal\",\r\n" + 
	        		"      \"interestRatePrecision\": 0\r\n" + 
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
	        		"      \"value\": 20,\r\n" + 
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
	        		"    \"percentage\":\"" +getPercentage()+"\",\r\n" + 
	        		"    \"chargeType.displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"    \"selectedCharge\": true,\r\n" + 
	        		"    \"chargeTemplate\": {\r\n" + 
	        		"      \"id\": \"01f2710d-1c3c-49ea-9565-d45c3c2d2bfb\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"activityDate\": \"09/04/2020\",\r\n" + 
	        		"    \"chargedAmount\": 1000\r\n" + 
	        		"  }\r\n" + 
	        		"]";
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	    public String getPayloadforManualFeePostWithArgument(String LoanNumber,String LoanName,String PrincipalAmount,String Intrest,String Originationdate,String Disburnsmentdate,String MaturityDate,String InitialPaymentdate,String responseOfPreview) {
			
	    	String requestBodyForChargeCode="[\r\n" + 
	    			"  {\r\n" + 
	    			"    \"id\": \"0107b426-7a75-432f-aef2-fd0f29eda527\",\r\n" + 
	    			"    \"termLoan\": {\r\n" + 
	    			"      \"id\": \""+responseOfPreview+"\",\r\n" + 
	    			"      \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
	    			"      \"loanName\": \""+LoanName+"\",\r\n" + 
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
	    			"      \"principalAmount\""+PrincipalAmount+",\r\n" + 
	    			"      \"interestRate\""+Intrest+",\r\n" + 
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
	    			"      \"originationDate\": \""+Originationdate+"\",\r\n" + 
	    			"      \"disbursementDate\": \""+Disburnsmentdate+"\",\r\n" + 
	    			"      \"maturityDate\": \""+MaturityDate+"\",\r\n" + 
	    			"      \"initialPaymentDate\": \""+InitialPaymentdate+"\",\r\n" + 
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
	    			"      \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
	    			"      \"loanName\": \""+LoanName+"\",\r\n" + 
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
	    			"      \"principalAmount\""+PrincipalAmount+",\r\n" + 
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
	    			"      \"originationDate\": \""+Originationdate+"\",\r\n" + 
	    			"      \"disbursementDate\": \""+Disburnsmentdate+"\",\r\n" + 
	    			"      \"maturityDate\": \""+MaturityDate+"\",\r\n" + 
	    			"      \"initialPaymentDate\": \""+InitialPaymentdate+"\",\r\n" + 
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
	    			"    \"activityDate\": \"09/24/2020\",\r\n" + 
	    			"    \"chargedAmount\": 3600\r\n" + 
	    			"  }\r\n" + 
	    			"]";
	    	return requestBodyForChargeCode;
	    	
	    }
	    public String getPayloadforManualFeePostWithArg(String id,String termLoan_id,String loanNumber,String loanName,String loanType_id,String principalAmount,String interestRate,String totalInterest,String revisedInterestRateEffectiveDate,String interestRateType,String interestRateCode,String divisor,String termType_id,String terms,String originationDate,String disbursementDate,String maturityDate,String initialPaymentDate,String loanStatus_id,String gracePeriodDays,String amortizationType,String soFarDisbursement,String balanceDisbursement,String disbursementAmount,String chargeCode_id,String chargeCode,String transactionCode,String natSign_id,String frequency_id,String chargeType_id,String chargeType_value,String displayName,String calculationType,String postingType_id,String postingType_value,String displayName_postingType,String chargeType_displayName,String chargeType_calculationType,String chargeType_DisplayName,String activityDate) {
	    	
	    	String getPayloadforManualFeePostWithArg="";
			return getPayloadforManualFeePostWithArg;
	    }
	    
	    public String getPayloadforManualFeePostValue() {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"id\": \"6325bdd4-00fb-4f43-a05b-07444954d638\",\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \"5299916c-d1d0-4a8b-917e-e1c35b250e57\",\r\n" + 
	        		"      \"loanNumber\": \"hjhhqa12\",\r\n" + 
	        		"      \"loanName\": \"hjhhqa12 : UNDOLOAN21\",\r\n" + 
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
	        		"      \"principalAmount\": 5000,\r\n" + 
	        		"      \"interestRate\": 2,\r\n" + 
	        		"      \"totalInterest\": 2,\r\n" + 
	        		"      \"rateAdjustment\": 2,\r\n" + 
	        		"      \"revisedInterestRateEffectiveDate\": \"03/23/2020\",\r\n" + 
	        		"      \"interestRateType\": \"fixed\",\r\n" + 
	        		"      \"interestRateCode\": 0,\r\n" + 
	        		"      \"divisor\": 12,\r\n" + 
	        		"      \"termType\": {\r\n" + 
	        		"        \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"        \"value\": \"months\",\r\n" + 
	        		"        \"display\": \"Months\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"terms\": 12,\r\n" + 
	        		"      \"originationDate\": \"03/23/2020\",\r\n" + 
	        		"      \"disbursementDate\": \"03/30/2020\",\r\n" + 
	        		"      \"maturityDate\": \"03/23/2021\",\r\n" + 
	        		"      \"initialPaymentDate\": \"04/23/2020\",\r\n" + 
	        		"      \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"      \"borrower\": {\r\n" + 
	        		"        \"id\": 11622,\r\n" + 
	        		"        \"name\": \"ABH-001\",\r\n" + 
	        		"        \"clientNumber\": \"NABH6\",\r\n" + 
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
	        		"      \"paidOffDate\": \"08/09/2020\",\r\n" + 
	        		"      \"allowNegative\": false,\r\n" + 
	        		"      \"gracePeriodDays\": 4,\r\n" + 
	        		"      \"amortizationType\": \"normal\",\r\n" + 
	        		"      \"interestRatePrecision\": 0\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeCode\": {\r\n" + 
	        		"      \"id\": \"5f414999-ff4e-4e59-8b89-2e6fa144e82f\",\r\n" + 
	        		"      \"chargeCode\": \"4092020\",\r\n" + 
	        		"      \"transactionCode\": 120504,\r\n" + 
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
	        		"      \"value\": 10,\r\n" + 
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
	        		"    \"percentage\": \"20\",\r\n" + 
	        		"    \"chargeType.displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"    \"selectedCharge\": true,\r\n" + 
	        		"    \"chargeTemplate\": {\r\n" + 
	        		"      \"id\": \"6325bdd4-00fb-4f43-a05b-07444954d638\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"activityDate\": \"09/04/2020\",\r\n" + 
	        		"    \"chargedAmount\": 1000\r\n" + 
	        		"  }\r\n" + 
	        		"]";
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    

		public  String getPayloadsforManualNegativePercentage(String data) {
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
		

	    public static String getPayloadforCollateralSetupDecimal(String loanID) {
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
	    
	    

	    public String getPayloadforCollateralSetup(String loanID) {
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
	    
	    
	    
	    
	    
	    
	    
	    
	    public String getpenaltyRequestbody(String percentage) {
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
	    
	    public static String getPayloadforCollateralSetupdecimal(String loanID,String collateralLoanId) {
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
	        
	        return requestBodyForAutoAllocationPerion;}
	    
	    
	    
	    public String getPayloadforAmortizationPost() {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"clientPayments\": [\r\n" + 
	        		"    {\r\n" + 
	        		"      \"clientName\": \"Demo Testing\",\r\n" + 
	        		"      \"clientId\": 4479,\r\n" + 
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
	    
	    
	    public String getPayloadforAmortizationUPdateRegularDate(String ResponseID) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \""+ResponseID+"\",\r\n" + 
	        		"  \"period\": 1,\r\n" + 
	        		"  \"interestRate\": 2,\r\n" + 
	        		"  \"paymentDate\": \"02/01/2020\",\r\n" + 
	        		"  \"openingBalance\": 50000,\r\n" + 
	        		"  \"regularInterest\": 83.33,\r\n" + 
	        		"  \"regularPrincipal\": 4128.61,\r\n" + 
	        		"  \"regularPaymentDue\": \""+getRegularPaymentdue()+"\",\r\n" + 
	        		"  \"fee\": 0,\r\n" + 
	        		"  \"totalPaymentDue\": 4211.94,\r\n" + 
	        		"  \"totalPaymentDone\": 0,\r\n" + 
	        		"  \"totalInterestPayment\": 0,\r\n" + 
	        		"  \"totalFeePayment\": 0,\r\n" + 
	        		"  \"totalPrincipalPayment\": 0,\r\n" + 
	        		"  \"extraPrincipalPayment\": 0,\r\n" + 
	        		"  \"endingBalance\": 45871.39,\r\n" + 
	        		"  \"balanceDue\": 4211.94,\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \"f161b826-2d55-4c82-b603-492d3e11949f\",\r\n" + 
	        		"    \"loanNumber\": \"sgiuy7\",\r\n" + 
	        		"    \"loanName\": \"sgiuy7 : period\",\r\n" + 
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
	        		"      \"decimalPrecision\": 3,\r\n" + 
	        		"      \"systemDefined\": true\r\n" + 
	        		"    },\r\n" + 
	        		"    \"principalAmount\": 50000,\r\n" + 
	        		"    \"interestRate\": 2,\r\n" + 
	        		"    \"totalInterest\": 2,\r\n" + 
	        		"    \"rateAdjustment\": 2,\r\n" + 
	        		"    \"revisedInterestRateEffectiveDate\": \"01/01/2020\",\r\n" + 
	        		"    \"interestRateType\": \"fixed\",\r\n" + 
	        		"    \"interestRateCode\": 0,\r\n" + 
	        		"    \"divisor\": 12,\r\n" + 
	        		"    \"termType\": {\r\n" + 
	        		"      \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"      \"value\": \"months\",\r\n" + 
	        		"      \"display\": \"Months\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"terms\": 12,\r\n" + 
	        		"    \"originationDate\": \"01/01/2020\",\r\n" + 
	        		"    \"disbursementDate\": \"02/01/2020\",\r\n" + 
	        		"    \"maturityDate\": \"01/01/2021\",\r\n" + 
	        		"    \"initialPaymentDate\": \"02/01/2020\",\r\n" + 
	        		"    \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"    \"borrower\": {\r\n" + 
	        		"      \"id\": 11622,\r\n" + 
	        		"      \"name\": \"ABH-001\",\r\n" + 
	        		"      \"clientNumber\": \"NABH6\",\r\n" + 
	        		"      \"active\": true,\r\n" + 
	        		"      \"emailId\": \"\",\r\n" + 
	        		"      \"mailAddresses\": [\r\n" + 
	        		"        \r\n" + 
	        		"      ]\r\n" + 
	        		"    },\r\n" + 
	        		"    \"comments\": null,\r\n" + 
	        		"    \"precision\": 2,\r\n" + 
	        		"    \"loanStatus\": {\r\n" + 
	        		"      \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"      \"displayName\": \"Active\",\r\n" + 
	        		"      \"value\": \"active\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"paidOffDate\": null,\r\n" + 
	        		"    \"allowNegative\": false,\r\n" + 
	        		"    \"gracePeriodDays\": 0,\r\n" + 
	        		"    \"amortizationType\": \"normal\",\r\n" + 
	        		"    \"interestRatePrecision\": 0\r\n" + 
	        		"  },\r\n" + 
	        		"  \"payments\": null,\r\n" + 
	        		"  \"periodStartDate\": \"01/02/2020\",\r\n" + 
	        		"  \"periodEndDate\": \"02/01/2020\",\r\n" + 
	        		"  \"graceDays\": 0,\r\n" + 
	        		"  \"graceDaysEdited\": false,\r\n" + 
	        		"  \"paymentDone\": false,\r\n" + 
	        		"  \"paymentDueEdited\": false,\r\n" + 
	        		"  \"periodCharged\": false,\r\n" + 
	        		"  \"isEditAllowed\": true\r\n" + 
	        		"}";
	        
	        return requestBodyForChargeCode;}
	    
	    public String getPayloadforAmortizationRecalculateForPreview(String ResponseID,String RegularPaymentDue) {
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


		
		public  static String requestBodyForMaturitydate(String Orignaldate,String  Maturitydate) {
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
		public static String getCommitRequestBodyForQuaterly(String previewTermLoanID, String disburementDate) {
			String rqst ="{\r\n" + 
					"  \"id\": \""+previewTermLoanID+"\",\r\n" + 
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
					"  \"loanName\": \"Loan\",\r\n" + 
					"  \"principalAmount\": \"500\",\r\n" + 
					"  \"disbursementDate\": \"12/12/2019\",\r\n" + 
					"  \"initialPaymentDate\": null,\r\n" + 
					"  \"termType\": {\r\n" + 
					"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"months\",\r\n" + 
					"    \"display\": \"Months\"\r\n" + 
					"  },\r\n" + 
					"  \"terms\": \"10\",\r\n" + 
					"  \"originationDate\": \"09/27/2019\",\r\n" + 
					"  \"maturityDate\": \"07/27/2020\",\r\n" + 
					"  \"includeLoanBalanceInReserve\": null,\r\n" + 
					"  \"interestRate\": 2,\r\n" + 
					"  \"divisor\": 12,\r\n" + 
					"  \"comments\": null\r\n" + 
					"}";
			return rqst;
		}

		public String getCommitRequestforPeriodRevision(String responseOfPreview,String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String	Intrest,String Originationdate,String InitialPaymentdate,String Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate)			
	     {
			String rqst ="{\r\n" + 
					"  \"id\": \""+responseOfPreview+"\",\r\n" + 
					"  \"loanType\": {\r\n" + 
					"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"term_loan\",\r\n" + 
					"    \"display\": \"Term Loan\"\r\n" + 
					"  },\r\n" + 
					"  \"borrower\": {\r\n" + 
					"    \"id\": \"11536\",\r\n" + 
					"    \"name\": \"MAHESH_TEST\"\r\n" + 
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

		public static String getPreviewtermloanID() {
			String rqst ="{\r\n" + 
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
					"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
					"  \"loanName\": \"Loan\",\r\n" + 
					"  \"principalAmount\": \"500\",\r\n" + 
					"  \"disbursementDate\": null,\r\n" + 
					"  \"initialPaymentDate\": null,\r\n" + 
					"  \"termType\": {\r\n" + 
					"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"months\",\r\n" + 
					"    \"display\": \"Months\"\r\n" + 
					"  },\r\n" + 
					"  \"terms\": \"2\",\r\n" + 
					"  \"originationDate\": \"09/05/2019\",\r\n" + 
					"  \"maturityDate\": \"01/21/0003\",\r\n" + 
					"  \"includeLoanBalanceInReserve\": null,\r\n" + 
					"  \"interestRate\": 2,\r\n" + 
					"  \"divisor\": 12,\r\n" + 
					"  \"comments\": null\r\n" + 
					"}";
			return rqst;
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
//		 	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
		 	        
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
		    	        
//		    	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
		    	        
		    	     return requestBodyForChargeCode;
		    	        
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
		 public String followupMaturingLoan(String termLoanId,String period) {
			 String maturingloan="[\r\n" + 
			 		"  {\r\n" + 
			 		"    \"termLoanId\": \""+termLoanId+"\",\r\n" + 
			 		"    \"period\": \""+period+"\"\r\n" + 
			 		"  }\r\n" + 
			 		"]";
			return maturingloan;
		 }
		 
		 public String getRequestedNotifyDetails(String termLoanId) {
			 String getRequestedNotifyDetails ="[\r\n" + 
			 		"   {\r\n" + 
			 		"      \"period\":1,\r\n" + 
			 		"      \"termLoanId\":\""+termLoanId+"\"\r\n" + 
			 		"   }\r\n" + 
			 		"]";
			return getRequestedNotifyDetails;
			 
		 }
		 public String requestNotesDetailsDtos() {
			 String getrequestNotesDetailsDtos ="[\r\n" + 
			 		"   {\r\n" + 
			 		"      \"period\":2,\r\n" + 
			 		"      \"termLoanId\":\"f1af7f16-83fd-483f-a213-c62df9b79472\"\r\n" + 
			 		"   }\r\n" + 
			 		"]";
			return getrequestNotesDetailsDtos;
			 
		 }
		 public String smsNotificationPayload(String termLoanId,String templateId) {
			 String smsNotificationPayload="{\r\n" + 
			 		"  \"templateId\": \""+templateId+"\",\r\n" + 
			 		"  \"notificationType\": \"text\",\r\n" + 
			 		"  \"notifyDetails\": [\r\n" + 
			 		"    {\r\n" + 
			 		"      \"termLoanId\": \""+termLoanId+"\",\r\n" + 
			 		"      \"period\": \"1\"\r\n" + 
			 		"    }\r\n" + 
			 		"  ]\r\n" + 
			 		"}";
			 return smsNotificationPayload;
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
		 public String createNoteForFollowOverDueOrFollowPeriod() {
			 String createNoteForFollowOverDueOrFollowPeriod = "{\r\n" + 
			 		"   \"notes\":\"hi we are testing QA test\",\r\n" + 
			 		"   \"periodDetails\":[\r\n" + 
			 		"      {\r\n" + 
			 		"         \"termLoanId\":\"44893af6-1f21-47b2-8aa7-a0c7ec8b65be\",\r\n" + 
			 		"         \"period\":\"9\"\r\n" + 
			 		"      }\r\n" + 
			 		"   ]\r\n" + 
			 		"}";
			return createNoteForFollowOverDueOrFollowPeriod;
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


		public static String getTransactionRequestBodyForNEgativeScenario(String transaction) {
			String Request="{\r\n" + 
					"  \"id\": \"\",\r\n" + 
					"  \"chargeCode\": \"ab4c\",\r\n" + 
					"  \"transactionCode\": \""+transaction+"\",\r\n" + 
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
					"  \"value\": \"2\",\r\n" + 
					"  \"autoNewClient\": true\r\n" + 
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
		
		public static String getRequestBodyForEdit(String previewLoanID) {
			String Request="{\r\n" + 
					"  \"id\": \""+previewLoanID+"\",\r\n" + 
					"  \"loanType\": {\r\n" + 
					"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"term_loan\",\r\n" + 
					"    \"display\": \"Term Loan\"\r\n" + 
					"  },\r\n" + 
					"  \"borrower\": {\r\n" + 
					"    \"id\": \"8979\",\r\n" + 
					"    \"name\": \"LOAN-1029\"\r\n" + 
					"  },\r\n" + 
					"  \"currency\": {\r\n" + 
					"    \"id\": 5,\r\n" + 
					"    \"currencyCode\": \"USD\",\r\n" + 
					"    \"description\": \"USD : US Dollar\",\r\n" + 
					"    \"decimalPrecision\": 6,\r\n" + 
					"    \"systemDefined\": false\r\n" + 
					"  },\r\n" + 
					"  \"loanNumber\": \"9600\",\r\n" + 
					"  \"loanName\": \"Loan\",\r\n" + 
					"  \"principalAmount\": 8,\r\n" + 
					"  \"disbursementDate\": null,\r\n" + 
					"  \"initialPaymentDate\": \"11/29/2019\",\r\n" + 
					"  \"termType\": {\r\n" + 
					"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"value\": \"months\",\r\n" + 
					"    \"display\": \"Months\"\r\n" + 
					"  },\r\n" + 
					"  \"terms\": 12,\r\n" + 
					"  \"originationDate\": \"10/29/2019\",\r\n" + 
					"  \"maturityDate\": \"10/29/2020\",\r\n" + 
					"  \"includeLoanBalanceInReserve\": false,\r\n" + 
					"  \"interestRate\": 2,\r\n" + 
					"  \"divisor\": 12,\r\n" + 
					"  \"comments\": null,\r\n" + 
					"  \"loanStatus\": {\r\n" + 
					"    \"id\": \"71eb5fb7-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
					"    \"displayName\": \"Active\",\r\n" + 
					"    \"value\": \"active\"\r\n" + 
					"  },\r\n" + 
					"  \"paidOffDate\": \"12/29/2019\",\r\n" + 
					"  \"clientId\": \"8979\",\r\n" + 
					"  \"clientName\": \"LOAN-1029\"\r\n" + 
					"}";
			return Request;
		}
		
		
		 public static String payloadsForNewInterestRate(String LoanNumber,String LoanName ,String InitialPaymentdate,String Orignaldate,String  Termtype,String MaturityDate,String Intrest, String PrincipalAmount,String loanID,String revisedInterestRate,String revisedInterestRateEffectiveDate, String LoanStatus) {
		        String requestBodyForChargeCode="{\r\n" + 
		        		"  \"id\": \""+loanID+"\",\r\n" + 
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
		        		"    \"decimalPrecision\": 4,\r\n" + 
		        		"    \"systemDefined\": false\r\n" + 
		        		"  },\r\n" + 
		        		"  \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
		        		"  \"loanName\": \""+LoanName+"\",\r\n" + 
		        		"  \"principalAmount\": \""+PrincipalAmount+"\",\r\n" + 
		        		"  \"disbursementDate\": \"02/04/2020\",\r\n" + 
		        		"  \"initialPaymentDate\": \""+InitialPaymentdate+"\",\r\n" + 
		        		"  \"termType\": {\r\n" + 
		        		"    \"id\": \"b0e0f611-ea8e-11e9-9d62-12e987db82ac\",\r\n" + 
		        		"    \"value\": \""+Termtype+"\",\r\n" + 
		        		"    \"display\": \""+Termtype+"\"\r\n" + 
		        		"  },\r\n" + 
		        		"  \"terms\": 10,\r\n" + 
		        		"  \"originationDate\": \""+Orignaldate+"\",\r\n" + 
		        		"  \"maturityDate\": \""+MaturityDate+"\",\r\n" + 
		        		"  \"includeLoanBalanceInReserve\": false,\r\n" + 
		        		"  \"interestRate\": "+Intrest+",\r\n" + 
		        		"  \"divisor\": 4,\r\n" + 
		        		"  \"revisedInterestRate\": \""+revisedInterestRate+"\",\r\n" + 
		        		"  \"revisedInterestRateEffectiveDate\": \""+revisedInterestRateEffectiveDate+"\",\r\n" + 
		        		"  \"comments\": null,\r\n" + 
		        		"  \"loanStatus\": {\r\n" + 
		        		"    \"id\": \"71ebd31b-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
		        		"    \"displayName\": \""+LoanStatus+"\",\r\n" + 
		        		"    \"value\": \""+LoanStatus+"\"\r\n" + 
		        		"  },\r\n" + 
		        		"  \"paidOffDate\": null,\r\n" + 
		        		"  \"totalOutStandingBalance\": null\r\n" + 
		        		"}";
		        
//		        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
		        
		     return requestBodyForChargeCode;
		        
		    }

		 public static String payloadsForNewInterestRateAfterRepayment(String LoanNumber,String LoanName ,String InitialPaymentdate,String Orignaldate,String  Termtype,String MaturityDate,String Intrest, String PrincipalAmount,String responseOfPreview,String revisedInterestRate,String revisedInterestRateEffectiveDate, String LoanStatus) {
		        String requestBodyForChargeCode="{\r\n" + 
		        		"  \"id\": \""+responseOfPreview+"\",\r\n" + 
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
		        		"    \"decimalPrecision\": 4,\r\n" + 
		        		"    \"systemDefined\": false\r\n" + 
		        		"  },\r\n" + 
		        		"  \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
		        		"  \"loanName\": \""+LoanName+"\",\r\n" + 
		        		"  \"principalAmount\": \""+PrincipalAmount+"\",\r\n" + 
		        		"  \"disbursementDate\": \"02/04/2020\",\r\n" + 
		        		"  \"initialPaymentDate\": \""+InitialPaymentdate+"\",\r\n" + 
		        		"  \"termType\": {\r\n" + 
		        		"    \"id\": \"b0e0f611-ea8e-11e9-9d62-12e987db82ac\",\r\n" + 
		        		"    \"value\": \""+Termtype+"\",\r\n" + 
		        		"    \"display\": \""+Termtype+"\"\r\n" + 
		        		"  },\r\n" + 
		        		"  \"terms\": 10,\r\n" + 
		        		"  \"originationDate\": \""+Orignaldate+"\",\r\n" + 
		        		"  \"maturityDate\": \""+MaturityDate+"\",\r\n" + 
		        		"  \"includeLoanBalanceInReserve\": false,\r\n" + 
		        		"  \"interestRate\": "+Intrest+",\r\n" + 
		        		"  \"divisor\": 4,\r\n" + 
		        		"  \"revisedInterestRate\": \""+revisedInterestRate+"\",\r\n" + 
		        		"  \"revisedInterestRateEffectiveDate\": \""+revisedInterestRateEffectiveDate+"\",\r\n" + 
		        		"  \"comments\": null,\r\n" + 
		        		"  \"loanStatus\": {\r\n" + 
		        		"    \"id\": \"71ebd31b-f58e-11e9-9d62-12e987db82ac\",\r\n" + 
		        		"    \"displayName\": \""+LoanStatus+"\",\r\n" + 
		        		"    \"value\": \""+LoanStatus+"\"\r\n" + 
		        		"  },\r\n" + 
		        		"  \"paidOffDate\": null,\r\n" + 
		        		"  \"totalOutStandingBalance\": null\r\n" + 
		        		"}";
		        
//		        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
		        
		     return requestBodyForChargeCode;
		        
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
		 
		 public String repayment(String Batchdate,String TotalAmount,String principal_paid_amount) {
		        String requestBodyForChargeCode="{\n" + 
		        		"  \"batch\": {\n" + 
		        		"    \"batch_date\": \""+Batchdate+"\",\n" + 
		        		"    \"ref_batch_no\": \"2\",\n" + 
		        		"    \"total_amount\": \"500.00\",\n" + 
		        		"    \"image_split\": true\n" + 
		        		"  },\n" + 
		        		"  \"check_parameters\": [\n" + 
		        		"    {\n" + 
		        		"      \"borrower_id\": 10093,\n" + 
		        		"      \"check_no\": \"2\",\n" + 
		        		"      \"check_amount\": \""+TotalAmount+"\",\n" + 
		        		"      \"cash_receipt_source_code_id\": 1,\n" + 
		        		"      \"bank_account_no\": \"\",\n" + 
		        		"      \"account_id\": \"\",\n" + 
		        		"      \"bank_routing_no\": \"\",\n" + 
		        		"      \"invoices\": [\n" + 
		        		"        \n" + 
		        		"      ],\n" + 
		        		"      \"credit_memos\": {\n" + 
		        		"        \n" + 
		        		"      },\n" + 
		        		"      \"adjustment_only\": false,\n" + 
		        		"      \"term_loans\": [\n" + 
		        		"        [\n" + 
		        		"          {\n" + 
		        		"            \"loan_number\": \"01\",\n" + 
		        		"            \"loan_name\": \"01:Loan\",\n" + 
		        		"            \"precision\": 4,\n" + 
		        		"            \"initial_payment_date\": \"01/01/2020\",\n" + 
		        		"            \"loan_period_due\": [\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 1,\n" + 
		        		"                \"payment_due_date\": \"01/01/2020\",\n" + 
		        		"                \"interest_due_amount\": 8.3333,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 412.861,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 2,\n" + 
		        		"                \"payment_due_date\": \"02/01/2020\",\n" + 
		        		"                \"interest_due_amount\": 7.6452,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 313.5491,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": \""+principal_paid_amount+"\",\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              }\n" + 
		        		"            ]\n" + 
		        		"          },\n" + 
		        		"          {\n" + 
		        		"            \"loan_number\": \"02\",\n" + 
		        		"            \"loan_name\": \"02:Loan\",\n" + 
		        		"            \"precision\": 4,\n" + 
		        		"            \"initial_payment_date\": \"02/20/2020\",\n" + 
		        		"            \"loan_period_due\": [\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 1,\n" + 
		        		"                \"payment_due_date\": \"02/20/2020\",\n" + 
		        		"                \"interest_due_amount\": 10,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 495.4332,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              }\n" + 
		        		"            ]\n" + 
		        		"          },\n" + 
		        		"          {\n" + 
		        		"            \"loan_number\": \"04\",\n" + 
		        		"            \"loan_name\": \"04:Loan\",\n" + 
		        		"            \"precision\": 4,\n" + 
		        		"            \"initial_payment_date\": \"02/20/2020\",\n" + 
		        		"            \"loan_period_due\": [\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 1,\n" + 
		        		"                \"payment_due_date\": \"02/20/2020\",\n" + 
		        		"                \"interest_due_amount\": 10,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 5800,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              }\n" + 
		        		"            ]\n" + 
		        		"          },\n" + 
		        		"          {\n" + 
		        		"            \"loan_number\": \"5\",\n" + 
		        		"            \"loan_name\": \"5:Loan\",\n" + 
		        		"            \"precision\": 4,\n" + 
		        		"            \"initial_payment_date\": \"01/02/2020\",\n" + 
		        		"            \"loan_period_due\": [\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 1,\n" + 
		        		"                \"payment_due_date\": \"01/02/2020\",\n" + 
		        		"                \"interest_due_amount\": 10,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 495.4332,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 2,\n" + 
		        		"                \"payment_due_date\": \"02/02/2020\",\n" + 
		        		"                \"interest_due_amount\": 9.1743,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 496.2589,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              }\n" + 
		        		"            ]\n" + 
		        		"          },\n" + 
		        		"          {\n" + 
		        		"            \"loan_number\": \"6\",\n" + 
		        		"            \"loan_name\": \"6:Loan\",\n" + 
		        		"            \"precision\": 4,\n" + 
		        		"            \"initial_payment_date\": \"02/01/2016\",\n" + 
		        		"            \"loan_period_due\": [\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 1,\n" + 
		        		"                \"payment_due_date\": \"02/01/2016\",\n" + 
		        		"                \"interest_due_amount\": 25.0005,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 88.1051,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 2,\n" + 
		        		"                \"payment_due_date\": \"03/01/2016\",\n" + 
		        		"                \"interest_due_amount\": 24.8537,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 88.2519,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 3,\n" + 
		        		"                \"payment_due_date\": \"04/01/2016\",\n" + 
		        		"                \"interest_due_amount\": 24.7066,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 88.399,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 4,\n" + 
		        		"                \"payment_due_date\": \"05/01/2016\",\n" + 
		        		"                \"interest_due_amount\": 24.5593,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 88.5463,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 5,\n" + 
		        		"                \"payment_due_date\": \"06/01/2016\",\n" + 
		        		"                \"interest_due_amount\": 24.4117,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 88.6939,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 6,\n" + 
		        		"                \"payment_due_date\": \"07/01/2016\",\n" + 
		        		"                \"interest_due_amount\": 24.2639,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 88.8417,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 7,\n" + 
		        		"                \"payment_due_date\": \"08/01/2016\",\n" + 
		        		"                \"interest_due_amount\": 24.1158,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 88.9898,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 8,\n" + 
		        		"                \"payment_due_date\": \"09/01/2016\",\n" + 
		        		"                \"interest_due_amount\": 23.9675,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 89.1381,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 9,\n" + 
		        		"                \"payment_due_date\": \"10/01/2016\",\n" + 
		        		"                \"interest_due_amount\": 23.8189,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 89.2867,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 10,\n" + 
		        		"                \"payment_due_date\": \"11/01/2016\",\n" + 
		        		"                \"interest_due_amount\": 23.6701,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 89.4355,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 11,\n" + 
		        		"                \"payment_due_date\": \"12/01/2016\",\n" + 
		        		"                \"interest_due_amount\": 23.5211,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 89.5845,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 12,\n" + 
		        		"                \"payment_due_date\": \"01/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 23.3717,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 89.7339,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 13,\n" + 
		        		"                \"payment_due_date\": \"02/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 23.2222,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 89.8834,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 14,\n" + 
		        		"                \"payment_due_date\": \"03/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 23.0724,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 90.0332,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 15,\n" + 
		        		"                \"payment_due_date\": \"04/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 22.9223,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 90.1833,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 16,\n" + 
		        		"                \"payment_due_date\": \"05/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 22.772,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 90.3336,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 17,\n" + 
		        		"                \"payment_due_date\": \"06/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 22.6215,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 90.4841,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 18,\n" + 
		        		"                \"payment_due_date\": \"07/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 22.4707,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 90.6349,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 19,\n" + 
		        		"                \"payment_due_date\": \"08/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 22.3196,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 90.786,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 20,\n" + 
		        		"                \"payment_due_date\": \"09/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 22.1683,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 90.9373,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 21,\n" + 
		        		"                \"payment_due_date\": \"10/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 22.0167,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 91.0889,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 22,\n" + 
		        		"                \"payment_due_date\": \"11/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 21.8649,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 91.2407,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 23,\n" + 
		        		"                \"payment_due_date\": \"12/01/2017\",\n" + 
		        		"                \"interest_due_amount\": 21.7128,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 91.3928,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 24,\n" + 
		        		"                \"payment_due_date\": \"01/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 21.5605,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 91.5451,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 25,\n" + 
		        		"                \"payment_due_date\": \"02/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 21.408,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 91.6976,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 26,\n" + 
		        		"                \"payment_due_date\": \"03/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 21.2551,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 91.8505,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 27,\n" + 
		        		"                \"payment_due_date\": \"04/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 21.102,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 92.0036,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 28,\n" + 
		        		"                \"payment_due_date\": \"05/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 20.9487,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 92.1569,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 29,\n" + 
		        		"                \"payment_due_date\": \"06/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 20.7951,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 92.3105,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 30,\n" + 
		        		"                \"payment_due_date\": \"07/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 20.6413,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 92.4643,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 31,\n" + 
		        		"                \"payment_due_date\": \"08/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 20.4871,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 92.6185,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 32,\n" + 
		        		"                \"payment_due_date\": \"09/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 20.3328,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 92.7728,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 33,\n" + 
		        		"                \"payment_due_date\": \"10/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 20.1782,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 92.9274,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 34,\n" + 
		        		"                \"payment_due_date\": \"11/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 20.0233,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 93.0823,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 35,\n" + 
		        		"                \"payment_due_date\": \"12/01/2018\",\n" + 
		        		"                \"interest_due_amount\": 19.8681,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 93.2375,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 36,\n" + 
		        		"                \"payment_due_date\": \"01/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 19.7127,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 93.3929,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 37,\n" + 
		        		"                \"payment_due_date\": \"02/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 19.5571,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 93.5485,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 38,\n" + 
		        		"                \"payment_due_date\": \"03/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 19.4012,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 93.7044,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 39,\n" + 
		        		"                \"payment_due_date\": \"04/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 19.245,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 93.8606,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 40,\n" + 
		        		"                \"payment_due_date\": \"05/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 19.0886,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 94.017,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 41,\n" + 
		        		"                \"payment_due_date\": \"06/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 18.9319,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 94.1737,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 42,\n" + 
		        		"                \"payment_due_date\": \"07/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 18.7749,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 94.3307,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 43,\n" + 
		        		"                \"payment_due_date\": \"08/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 18.6177,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 94.4879,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 44,\n" + 
		        		"                \"payment_due_date\": \"09/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 18.4602,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 94.6454,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 45,\n" + 
		        		"                \"payment_due_date\": \"10/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 18.3025,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 94.8031,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 46,\n" + 
		        		"                \"payment_due_date\": \"11/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 18.1445,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 94.9611,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 47,\n" + 
		        		"                \"payment_due_date\": \"12/01/2019\",\n" + 
		        		"                \"interest_due_amount\": 17.9862,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 95.1194,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 48,\n" + 
		        		"                \"payment_due_date\": \"01/01/2020\",\n" + 
		        		"                \"interest_due_amount\": 17.8277,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 95.2779,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              },\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 49,\n" + 
		        		"                \"payment_due_date\": \"02/01/2020\",\n" + 
		        		"                \"interest_due_amount\": 17.6689,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 95.4367,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              }\n" + 
		        		"            ]\n" + 
		        		"          },\n" + 
		        		"          {\n" + 
		        		"            \"loan_number\": \"7\",\n" + 
		        		"            \"loan_name\": \"7:Loan\",\n" + 
		        		"            \"precision\": 4,\n" + 
		        		"            \"initial_payment_date\": \"02/20/2020\",\n" + 
		        		"            \"loan_period_due\": [\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 1,\n" + 
		        		"                \"payment_due_date\": \"02/20/2020\",\n" + 
		        		"                \"interest_due_amount\": 0.0033,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 0,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              }\n" + 
		        		"            ]\n" + 
		        		"          },\n" + 
		        		"          {\n" + 
		        		"            \"loan_number\": \"8\",\n" + 
		        		"            \"loan_name\": \"8:Loan\",\n" + 
		        		"            \"precision\": 4,\n" + 
		        		"            \"initial_payment_date\": \"02/20/2020\",\n" + 
		        		"            \"loan_period_due\": [\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 1,\n" + 
		        		"                \"payment_due_date\": \"02/20/2020\",\n" + 
		        		"                \"interest_due_amount\": 15,\n" + 
		        		"                \"other_fee_due_amount\": 0,\n" + 
		        		"                \"principal_due_amount\": 1794.01,\n" + 
		        		"                \"interest_paid_amount\": 0,\n" + 
		        		"                \"other_fee_paid_amount\": 0,\n" + 
		        		"                \"principal_paid_amount\": 0,\n" + 
		        		"                \"precision\": 4\n" + 
		        		"              }\n" + 
		        		"            ]\n" + 
		        		"          }\n" + 
		        		"        ]\n" + 
		        		"      ],\n" + 
		        		"      \"bulk_amount\": null,\n" + 
		        		"      \"debtor_bulk_amount\": null,\n" + 
		        		"      \"abl_amount\": \"0.00\",\n" + 
		        		"      \"fact_amount\": \"0.00\",\n" + 
		        		"      \"is_non_factored\": false,\n" + 
		        		"      \"term_loan_amount\": \"500.00\",\n" + 
		        		"      \"abl_payment_mode\": \"\",\n" + 
		        		"      \"update_bank_details\": false\n" + 
		        		"    }\n" + 
		        		"  ]\n" + 
		        		"}";
		        
//		        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
		        
		     return requestBodyForChargeCode;
		        
		    }
		 public String createNote() {
			 String createNote = "{\r\n" + 
			 		"   \"notes\":\"My testing test data is for API\",\r\n" + 
			 		"   \"periodDetails\":[\r\n" + 
			 		"      {\r\n" + 
			 		"         \"termLoanId\":\"31724c55-3bc7-4f82-aa6b-f9cfa1c31e79\",\r\n" + 
			 		"         \"period\":\"1\"\r\n" + 
			 		"      }\r\n" + 
			 		"   ]\r\n" + 
			 		"}";
			return createNote;
		 }
		 
       public String createNoteloanlevel() {
			 
			 String createNoteloanlevel="{\r\n" + 
			 		"   \"notes\":\"hi test qa test\",\r\n" + 
			 		"   \"termLoanIds\":[\r\n" + 
			 		"      \"44893af6-1f21-47b2-8aa7-a0c7ec8b65be\"\r\n" + 
			 		"   ]\r\n" + 
			 		"}";
			return createNoteloanlevel;
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
		 //Using this
		    public String notelevelEqualstoPeriod(String termLoanId,String period) {
		    	String notelevelEqualstoPeriod="[\r\n" + 
		    			"  {\r\n" + 
		    			"    \"termLoanId\": \""+termLoanId+"\",\r\n" + 
		    			"    \"period\": \""+period+"\"\r\n" + 
		    			"  }\r\n" + 
		    			"]";
				return notelevelEqualstoPeriod;
		    }
		    //using this 
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

		 
	    public static String getChargeCode(){
	            Random t = new Random();
	            int nextInt = t.nextInt(100000000);
	            String valueOf = String.valueOf(nextInt);
	    return valueOf;
	 
	        }
	    
	    public static String getTransactionCode(){
	        Random t = new Random();
	        int nextInt = t.nextInt(10000000);
	        String valueOf = String.valueOf(nextInt);
	     return valueOf;

	    }
	        
	    public static String getLoanNumber(){
	        Random t = new Random();
	        int nextInt = t.nextInt(10);
	        String valueOf = String.valueOf(nextInt);
	     return valueOf;

	    }
	    
	    public static String getLoanName(){
	    	StringBuilder sb = new StringBuilder("idexcel");
	        Random t = new Random();
	        int nextInt = t.nextInt(10);
	        String valueOf2 = String.valueOf(nextInt);
	        StringBuilder valueOf=sb.append(valueOf2);
	      
	     return  valueOf.toString();

	    }
	    public static String getComment(){
	    	StringBuilder sb = new StringBuilder("DELETING_DATA");
	        Random t = new Random();
	        int nextInt = t.nextInt(10);
	        String valueOf2 = String.valueOf(nextInt);
	        StringBuilder valueOf=sb.append(valueOf2);
	      
	     return  valueOf.toString();

	    }
	    public static Integer getValue(){
	        Random t = new Random();
	        int nextInt = t.nextInt(100000);
	         return nextInt;

	    }
	    public static float getValues(){
	        Random t = new Random();
	        float nextFloat = t.nextFloat();
	         return   nextFloat;

	    }
	    public static Integer getPercentage(){
	        Random t = new Random();
	        int nextInt = t.nextInt(99);
	         return nextInt;

	    }

	    public static Integer getValueforFee(){
	        Random t = new Random();
	        int nextInt = t.nextInt(100000);
	         return nextInt;

	    }

	    public static Integer getActualValue(){
	        Random t = new Random();
	        int nextInt = t.nextInt(100000);
	         return nextInt;

	    }
	    public static float getActualValuedecimal(){
	        Random t = new Random();
	        float nextFloat = t.nextFloat();
	         return   nextFloat;

	    }
	    public static float getinligbleValuedecimal(){
	        Random t = new Random();
	        float nextFloat = t.nextFloat();
	         return   nextFloat;

	    }
	    public static float getAdvanceValuedecimal(){
	        Random t = new Random();
	        float nextFloat = t.nextFloat();
	         return   nextFloat;

	    }

	    public Integer getTransactionId(){
	        Random t = new Random();
	        int nextInt = t.nextInt(100000);
	         return nextInt;

	    }
	    

	    public static Integer getRegularPaymentdue(){
	        Random t = new Random();
	        int nextInt = t.nextInt(100);
	         return nextInt;

	    }

}
