package com.idexcel.utilities;

import java.util.Random;

public class PayloadProd extends Payloads{
	//PayloadProd payloads = new PayloadProd();
	 public static String getPayload(String getnatSignId, String getfrequencyId, String getchargeTypeId, String getpostingTypeId) {
	        String requestBodyForChargeCode="{\r\n  \"id\": \"\",\r\n  \"chargeCode\":"
	                + " \""+Payloads.getChargeCode()+"\",\r\n  \"transactionCode\": \""+Payloads.getTransactionCode()+"\",\r\n "
	                        + " \"natSign\": {\r\n    \"id\": \""+getnatSignId+"\",\r\n    \"value\": \"+\",\r\n    \"displayName\": \"Plus\"\r\n  },\r\n  "
	                                + "\"frequency\": {\r\n    \"id\": \""+getfrequencyId+"\",\r\n    \"value\": \"manual\",\r\n    \"displayName\": \"Manual\"\r\n  },\r\n  "
	                                        + "\"chargeType\": {\r\n    \"id\": \""+getchargeTypeId+"\",\r\n    \"value\": \"original_loan_amount\",\r\n    \"displayName\": \"On Original Loan Amount\",\r\n    \"calculationType\": \"percentage\"\r\n  },\r\n "
	                                                + " \"postingType\": {\r\n    \"id\": \""+getpostingTypeId+"\",\r\n    \"value\": \"in_bal\",\r\n    \"displayName\": \"In Balance\"\r\n  },\r\n  \"value\": \"4\",\r\n  \"autoNewClient\": false\r\n}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	 public String payloadforDeleteLoan(String termLoanId) {
		 String requestBody="[\r\n" + 
		 		"  \""+termLoanId+"\"\r\n" + 
		 		"]";
		return requestBody;
	 }
	    
	    
	    public static String getPayloadforTermloan(String getLoanId, String loanTypeID, String currencyID, String loanNumber) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \""+getLoanId+"\",\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \""+loanTypeID+"\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"8401\",\r\n" + 
	        		"    \"name\": \"LOAN-401\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"currency\": {\r\n" + 
	        		"    \"id\": "+currencyID+",\r\n" + 
	        		"    \"currencyCode\": \"USD\",\r\n" + 
	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	        		"    \"decimalPrecision\": 6,\r\n" + 
	        		"    \"systemDefined\": false\r\n" + 
	        		"  },\r\n" + 
	        		"  \"loanNumber\": \""+getLoanNumber()+"\",\r\n" + 
	        		"  \"loanName\": \"Loan\",\r\n" + 
	        		"  \"principalAmount\": \"5000\",\r\n" + 
	        		"  \"disbursementDate\": null,\r\n" + 
	        		"  \"initialPaymentDate\": null,\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"eb8af499-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"months\",\r\n" + 
	        		"    \"display\": \"Months\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \"12\",\r\n" + 
	        		"  \"originationDate\": \"09/05/2019\",\r\n" + 
	        		"  \"maturityDate\": \"09/05/2020\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": 2,\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"comments\": null\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	    
	    
	    public  String getPayloadforPreviewToCheckLoanNumberPositive(String LoanNumber) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": null,\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"5160\",\r\n" + 
	        		"    \"name\": \"MAHESHQA\"\r\n" + 
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
	        		"    \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
	        		"    \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863a\",\r\n" + 
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
	    
	    public  String latefee() {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": null,\r\n" + 
	        		"  \"lateFeePercentage\": 10,\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \"45ae28b9-4859-46df-ae94-5fd0a9c7582e\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"pastDueDays\": 10,\r\n" + 
	        		"  \"feeBasedOn\": {\r\n" + 
	        		"    \"id\": \"3b7a98bc-c623-11e9-8128-0efdfcf6f638\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"lateFeeValue\": 500\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public String latefeePUt() {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \"a51f74cd-9220-4d11-8c32-66a1cb374d10\",\r\n" + 
	        		"  \"lateFeePercentage\": 0,\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \"45ae28b9-4859-46df-ae94-5fd0a9c7582e\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"pastDueDays\": 5,\r\n" + 
	        		"  \"feeBasedOn\": {\r\n" + 
	        		"    \"id\": \"3b7a98bc-c623-11e9-8128-0efdfcf6f638\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"lateFeeValue\": 5000\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	    
	    
	    public  static String commnet() {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"comment\": \"loan\",\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \"56ddeadb-198c-4db2-9c81-020aa9ecb2d3\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"visibility\": \"public\"\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public static String getPayloadforPreviewForQuaterly() {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": null,\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \"eb8f9164-c363-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"8837\",\r\n" + 
	        		"    \"name\": \"LOAN-1014\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"currency\": {\r\n" + 
	        		"    \"id\": 5,\r\n" + 
	        		"    \"currencyCode\": \"USD\",\r\n" + 
	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	        		"    \"decimalPrecision\": 6,\r\n" + 
	        		"    \"systemDefined\": false\r\n" + 
	        		"  },\r\n" + 
	        		"  \"loanNumber\": \""+RandomGenerator.random(5, PermittedCharacters.ALPHANUMERIC)+"\",\r\n" + 
	        		"  \"loanName\": \"Loan\",\r\n" + 
	        		"  \"principalAmount\": \"6000\",\r\n" + 
	        		"  \"disbursementDate\": null,\r\n" + 
	        		"  \"initialPaymentDate\": null,\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"b0e0f611-ea8e-11e9-9d62-12e987db82ac\",\r\n" + 
	        		"    \"value\": \"quarterly\",\r\n" + 
	        		"    \"display\": \"Quarterly\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \"12\",\r\n" + 
	        		"  \"originationDate\": \"10/14/2019\",\r\n" + 
	        		"  \"maturityDate\": \"10/14/2022\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": 2,\r\n" + 
	        		"  \"divisor\": 4,\r\n" + 
	        		"  \"comments\": null\r\n" + 
	        		"}";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	    public String getLoanDetails(String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String	Intrest,String Originationdate,String InitialPaymentdate,String	Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": null,\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"5160\",\r\n" + 
	        		"    \"name\": \"MAHESHQA\"\r\n" + 
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
	        		"    \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
	        		"    \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
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
	    public String getLoanDetailsForFixedAmortization(String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String	Intrest,String Originationdate,String InitialPaymentdate,String	Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate,String disbursementAmount,String fixedPrincipal) {
	    	String getLoanDetailsForFixedAmortization="{\r\n" + 
	    			"  \"id\": null,\r\n" + 
	    			"  \"loanType\": {\r\n" + 
	    			"    \"id\": \"6b322770-c3e2-11e9-9c39-0ed26729ed2e\",\r\n" + 
	    			"    \"value\": \"term_loan\",\r\n" + 
	    			"    \"display\": \"Term Loan\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"borrower\": {\r\n" + 
	    			"    \"id\": \"5130\",\r\n" + 
	    			"    \"name\": \"QAMAHESH\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"currency\": {\r\n" + 
	    			"    \"id\": 5,\r\n" + 
	    			"    \"currencyCode\": \"USD\",\r\n" + 
	    			"    \"description\": \"USD : US Doll\",\r\n" + 
	    			"    \"decimalPrecision\": 2,\r\n" + 
	    			"    \"systemDefined\": false\r\n" + 
	    			"  },\r\n" + 
	    			"  \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
	    			"  \"loanName\": \""+LoanName+"\",\r\n" + 
	    			"  \"principalAmount\": \""+PrincipalAmount+"\",\r\n" + 
	    			"  \"disbursementDate\":\""+Disburnsmentdate+" ,\r\n" + 
	    			"  \"initialPaymentDate\": \""+InitialPaymentdate+",\r\n" + 
	    			"  \"termType\": {\r\n" + 
	    			"    \"id\": \"6b2db216-c3e2-11e9-9c39-0ed26729ed2e\",\r\n" + 
	    			"    \"value\": \""+Termtype+"\",\r\n" + 
	    			"    \"display\": \""+Termtype+"\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"terms\": \""+Term+"\",\r\n" + 
	    			"  \"originationDate\": \""+Originationdate+"\",\r\n" + 
	    			"  \"maturityDate\": \""+MaturityDate+"\",\r\n" + 
	    			"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	    			"  \"interestRate\":"+Intrest+",\r\n" + 
	    			"  \"divisor\": 12,\r\n" + 
	    			"  \"revisedInterestRate\": null,\r\n" + 
	    			"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	    			"  \"comments\": null,\r\n" + 
	    			"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	    			"  \"interestRateCode\": null,\r\n" + 
	    			"  \"rateAdjustment\": "+rateAdjustment+",\r\n" + 
	    			"  \"totalInterest\": null,\r\n" + 
	    			"  \"amortizationType\": \"interestonly\",\r\n" + 
	    			"  \"fixedPrincipal\": "+fixedPrincipal+",\r\n" + 
	    			"  \"editedFixedPrincipal\": false,\r\n" + 
	    			"  \"baseInterestRate\": null,\r\n" + 
	    			"  \"intRatePrecision\": 12,\r\n" + 
	    			"  \"dailyDivisor\": 360,\r\n" + 
	    			"  \"loanStatus\": {\r\n" + 
	    			"    \"id\": \"385f91a5-f411-11e9-9c39-0ed26729ed2e\",\r\n" + 
	    			"    \"displayName\": \"Active\",\r\n" + 
	    			"    \"value\": \"active\"\r\n" + 
	    			"  },\r\n" + 
	    			"  \"paidOffDate\": null,\r\n" + 
	    			"  \"totalOutStandingBalance\": 0,\r\n" + 
	    			"  \"preview\": null,\r\n" + 
	    			"  \"disbursementAmount\": \""+disbursementAmount+"\"\r\n" + 
	    			"}";
	    	return getLoanDetailsForFixedAmortization;
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
   
	    public String floating(String LoanNumber,String LoanName,String PrincipalAmount,String Term,String	Intrest,String	Orignaldate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate)			
{
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": null,\r\n" + 
	        		"  \"loanType\": {\r\n" + 
	        		"    \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"5160\",\r\n" + 
	        		"    \"name\": \"MAHESHQA\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"currency\": {\r\n" + 
	        		"    \"id\": 5,\r\n" + 
	        		"    \"currencyCode\": \"USD\",\r\n" + 
	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	        		"    \"decimalPrecision\": 2,\r\n" + 
	        		"    \"systemDefined\": false\r\n" + 
	        		"  },\r\n" + 
	        		"  \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
	        		"  \"loanName\": \""+LoanName+"\",\r\n" + 
	        		"  \"principalAmount\": \""+PrincipalAmount+"\",\r\n" + 
	        		"  \"disbursementDate\": null,\r\n" + 
	        		"  \"initialPaymentDate\": null,\r\n" + 
	        		"  \"termType\": {\r\n" + 
	        		"    \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"    \"value\": \"months\",\r\n" + 
	        		"    \"display\": \"Months\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"terms\": \""+Term+"\",\r\n" + 
	        		"  \"originationDate\": \""+Orignaldate+"\",\r\n" + 
	        		"  \"maturityDate\": \""+MaturityDate+"\",\r\n" + 
	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	        		"  \"interestRate\": null,\r\n" + 
	        		"  \"divisor\": 12,\r\n" + 
	        		"  \"revisedInterestRate\": null,\r\n" + 
	        		"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	        		"  \"comments\": null,\r\n" + 
	        		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	        		"  \"interestRateCode\": 245,\r\n" + 
	        		"  \"rateAdjustment\": \""+rateAdjustment+"\",\r\n" + 
	        		"  \"totalInterest\": null,\r\n" + 
	        		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	        		"  \"loanStatus\": {\r\n" + 
	        		"    \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
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
	    public String floatingcommit(String responseOfPreview,String LoanNumber,String LoanName,String PrincipalAmount,String Term,String	Intrest,String	Orignaldate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate)			
	    {
	    	        String requestBodyForChargeCode="{\r\n" + 
	    	        		"  \"id\": \""+responseOfPreview+"\",\r\n" + 
	    	        		"  \"loanType\": {\r\n" + 
	    	        		"    \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	    	        		"    \"value\": \"term_loan\",\r\n" + 
	    	        		"    \"display\": \"Term Loan\"\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"borrower\": {\r\n" + 
	    	        		"    \"id\": \"5160\",\r\n" + 
	    	        		"    \"name\": \"MAHESHQA\"\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"currency\": {\r\n" + 
	    	        		"    \"id\": 5,\r\n" + 
	    	        		"    \"currencyCode\": \"USD\",\r\n" + 
	    	        		"    \"description\": \"USD : US Dollar\",\r\n" + 
	    	        		"    \"decimalPrecision\": 2,\r\n" + 
	    	        		"    \"systemDefined\": false\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"loanNumber\": \""+LoanNumber+"\",\r\n" + 
	    	        		"  \"loanName\": \""+LoanName+"\",\r\n" + 
	    	        		"  \"principalAmount\": \""+PrincipalAmount+"\",\r\n" + 
	    	        		"  \"disbursementDate\": null,\r\n" + 
	    	        		"  \"initialPaymentDate\": null,\r\n" + 
	    	        		"  \"termType\": {\r\n" + 
	    	        		"    \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	    	        		"    \"value\": \"months\",\r\n" + 
	    	        		"    \"display\": \"Months\"\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"terms\": \""+Term+"\",\r\n" + 
	    	        		"  \"originationDate\": \""+Orignaldate+"\",\r\n" + 
	    	        		"  \"maturityDate\": \"09/05/2020\",\r\n" + 
	    	        		"  \"includeLoanBalanceInReserve\": null,\r\n" + 
	    	        		"  \"interestRate\": null,\r\n" + 
	    	        		"  \"divisor\": 12,\r\n" + 
	    	        		"  \"revisedInterestRate\": null,\r\n" + 
	    	        		"  \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	    	        		"  \"comments\": null,\r\n" + 
	    	        		"  \"interestRateType\": \""+interestRateType+"\",\r\n" + 
	    	        		"  \"interestRateCode\": 294,\r\n" + 
	    	        		"  \"rateAdjustment\": \""+rateAdjustment+"\",\r\n" + 
	    	        		"  \"totalInterest\": null,\r\n" + 
	    	        		"  \"amortizationType\": \""+amortizationType+"\",\r\n" + 
	    	        		"  \"loanStatus\": {\r\n" + 
	    	        		"    \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
	    	        		"    \"displayName\": \"Active\",\r\n" + 
	    	        		"    \"value\": \"active\"\r\n" + 
	    	        		"  },\r\n" + 
	    	        		"  \"paidOffDate\": null,\r\n" + 
	    	        		"  \"totalOutStandingBalance\": 0\r\n" + 
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
	    
	    
	    public static String getPayloadforPreviewToCheckLoanNumberNegative(String LoanNumber) {
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
	        		"    \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"    \"value\": \"term_loan\",\r\n" + 
	        		"    \"display\": \"Term Loan\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"borrower\": {\r\n" + 
	        		"    \"id\": \"5160\",\r\n" + 
	        		"    \"name\": \"MAHESHQA\"\r\n" + 
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
	        		"    \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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

	    public  static String getPayloadforPreviewToCheckEditOperationforNegativeInactive(String PaidOffDate,String LaonName,String loanID) {
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
	        		"   {\r\n" + 
	        		"      \"termLoan\":{\r\n" + 
	        		"         \"id\":\""+termLoan+"\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"chargeCode\":{\r\n" + 
	        		"         \"id\":\"1c6f46c9-c41e-4944-bb0b-e44841f1f616\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"natSign\":\"+\",\r\n" + 
	        		"      \"frequency\":\"manual\",\r\n" + 
	        		"      \"chargeType\":{\r\n" + 
	        		"         \"id\":\"3b7a970f-c623-11e9-8128-0efdfcf6f638\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"value\":10\r\n" + 
	        		"   }\r\n" + 
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
	        		"         \"id\":\"QATEST\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"natSign\":\"+\",\r\n" + 
	        		"      \"frequency\":\"manual\",\r\n" + 
	        		"      \"chargeType\":{\r\n" + 
	        		"         \"id\":\"3b7a970f-c623-11e9-8128-0efdfcf6f638\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"value\":\"15\",\r\n" + 
	        		"      \"id\":\"3aec33a1-6e51-4e89-8735-a12463df2035\"\r\n" + 
	        		"   }\r\n" + 
	        		"]";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    public String getPayloadforChargeTemplatePUTFloat(String termLoan ) {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \""+termLoan+"\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeCode\": {\r\n" + 
	        		"      \"id\": \"QATEST\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"natSign\": \"+\",\r\n" + 
	        		"    \"frequency\": \"manual\",\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"value\": \""+ getValues()+"\",\r\n" + 
	        		"    \"id\": \"3aec33a1-6e51-4e89-8735-a12463df2035\"\r\n" + 
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
	        		"    \"id\": \"3b71f6c0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"    \"value\": \"+\",\r\n" + 
	        		"    \"displayName\": \"Plus\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"frequency\": {\r\n" + 
	        		"    \"id\": \"3b6e3803-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"    \"value\": \"manual\",\r\n" + 
	        		"    \"displayName\": \"Manual\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"chargeType\": {\r\n" + 
	        		"    \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"    \"value\": \"original_loan_amount\",\r\n" + 
	        		"    \"displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"    \"calculationType\": \"percentage\"\r\n" + 
	        		"  },\r\n" + 
	        		"  \"postingType\": {\r\n" + 
	        		"    \"id\": \"3b76178b-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
	        		"    \"activityDate\": \"09/28/2019\",\r\n" + 
	        		"    \"selectedCharge\": true,\r\n" + 
	        		"    \"chargedAmount\": 300\r\n" + 
	        		"  }\r\n" + 
	        		"]\r\n" + 
	        		"";
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    
	    public String getPayloadforManualFeePostValue() {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"id\": \"870facb6-dfe7-48d8-baf2-6d9910f45402\",\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \"43b58465-b282-40ed-9205-ed98ef6192d6\",\r\n" + 
	        		"      \"loanNumber\": \"THRE11\",\r\n" + 
	        		"      \"loanName\": \"THRE11 : THRE\",\r\n" + 
	        		"      \"formattedTermloanName\": null,\r\n" + 
	        		"      \"totalOutStandingBalance\": 0,\r\n" + 
	        		"      \"loanType\": {\r\n" + 
	        		"        \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
	        		"      \"principalAmount\": 6000,\r\n" + 
	        		"      \"interestRate\": 5,\r\n" + 
	        		"      \"totalInterest\": 5,\r\n" + 
	        		"      \"rateAdjustment\": 0,\r\n" + 
	        		"      \"revisedInterestRateEffectiveDate\": \"07/30/2020\",\r\n" + 
	        		"      \"interestRateType\": \"fixed\",\r\n" + 
	        		"      \"interestRateCode\": 0,\r\n" + 
	        		"      \"divisor\": 12,\r\n" + 
	        		"      \"termType\": {\r\n" + 
	        		"        \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"        \"value\": \"months\",\r\n" + 
	        		"        \"display\": \"Months\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"terms\": 12,\r\n" + 
	        		"      \"originationDate\": \"07/30/2020\",\r\n" + 
	        		"      \"disbursementDate\": \"09/30/2020\",\r\n" + 
	        		"      \"maturityDate\": \"07/30/2021\",\r\n" + 
	        		"      \"initialPaymentDate\": \"08/30/2020\",\r\n" + 
	        		"      \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"      \"borrower\": {\r\n" + 
	        		"        \"id\": 5160,\r\n" + 
	        		"        \"name\": \"MAHESHQA\",\r\n" + 
	        		"        \"clientNumber\": \"381\",\r\n" + 
	        		"        \"active\": true,\r\n" + 
	        		"        \"emailId\": \"\",\r\n" + 
	        		"        \"mailAddresses\": []\r\n" + 
	        		"      },\r\n" + 
	        		"      \"comments\": null,\r\n" + 
	        		"      \"precision\": 2,\r\n" + 
	        		"      \"loanStatus\": {\r\n" + 
	        		"        \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
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
	        		"      \"id\": \"f36d35e7-3666-49c7-bec0-df4487d4b3fa\",\r\n" + 
	        		"      \"chargeCode\": \"MAHESHQA\",\r\n" + 
	        		"      \"transactionCode\": 34711,\r\n" + 
	        		"      \"sequence\": 1,\r\n" + 
	        		"      \"natSign\": {\r\n" + 
	        		"        \"id\": \"3b71f6c0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"        \"value\": \"+\",\r\n" + 
	        		"        \"displayName\": \"Plus\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"frequency\": {\r\n" + 
	        		"        \"id\": \"3b6e3803-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"        \"value\": \"manual\",\r\n" + 
	        		"        \"displayName\": \"Manual\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"chargeType\": {\r\n" + 
	        		"        \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"        \"value\": \"original_loan_amount\",\r\n" + 
	        		"        \"displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"        \"calculationType\": \"percentage\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"postingType\": {\r\n" + 
	        		"        \"id\": \"3b76178b-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"        \"value\": \"in_bal\",\r\n" + 
	        		"        \"displayName\": \"In Balance\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"value\": 5,\r\n" + 
	        		"      \"autoNewClient\": true\r\n" + 
	        		"    },\r\n" + 
	        		"    \"natSign\": \"+\",\r\n" + 
	        		"    \"sequence\": 1,\r\n" + 
	        		"    \"frequency\": \"manual\",\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"      \"value\": \"original_loan_amount\",\r\n" + 
	        		"      \"displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"      \"calculationType\": \"percentage\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"value\": null,\r\n" + 
	        		"    \"inBalance\": false,\r\n" + 
	        		"    \"accruedToLoan\": false,\r\n" + 
	        		"    \"percentage\": \""+ getPercentage()+"\",\r\n" + 
	        		"    \"chargeType.displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"    \"selectedCharge\": true,\r\n" + 
	        		"    \"chargedAmount\": \"\",\r\n" + 
	        		"    \"chargeTemplate\": {\r\n" + 
	        		"      \"id\": \"870facb6-dfe7-48d8-baf2-6d9910f45402\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"activityDate\": \"07/30/2020\"\r\n" + 
	        		"  }\r\n" + 
	        		"]";
	        		
	        
//	        System.out.println("requestBodyForChargeCode "+requestBodyForChargeCode);
	        
	     return requestBodyForChargeCode;
	        
	    }
	    

		public String getPayloadsforManualNegativePercentage(String data) {
			String rqst="[\r\n" + 
					"  {\r\n" + 
					"    \"id\": \"acabd10f-f75f-4802-90db-a257eb3224a0\",\r\n" + 
					"    \"termLoan\": {\r\n" + 
					"      \"id\": \"43b58465-b282-40ed-9205-ed98ef6192d6\",\r\n" + 
					"      \"loanNumber\": \"THRE11\",\r\n" + 
					"      \"loanName\": \"THRE11 : THRE\",\r\n" + 
					"      \"formattedTermloanName\": null,\r\n" + 
					"      \"totalOutStandingBalance\": 0,\r\n" + 
					"      \"loanType\": {\r\n" + 
					"        \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
					"      \"principalAmount\": 6000,\r\n" + 
					"      \"interestRate\": 5,\r\n" + 
					"      \"totalInterest\": 5,\r\n" + 
					"      \"rateAdjustment\": 0,\r\n" + 
					"      \"revisedInterestRateEffectiveDate\": \"07/30/2020\",\r\n" + 
					"      \"interestRateType\": \"fixed\",\r\n" + 
					"      \"interestRateCode\": 0,\r\n" + 
					"      \"divisor\": 12,\r\n" + 
					"      \"termType\": {\r\n" + 
					"        \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"months\",\r\n" + 
					"        \"display\": \"Months\"\r\n" + 
					"      },\r\n" + 
					"      \"terms\": 12,\r\n" + 
					"      \"originationDate\": \"07/30/2020\",\r\n" + 
					"      \"disbursementDate\": \"09/30/2020\",\r\n" + 
					"      \"maturityDate\": \"07/30/2021\",\r\n" + 
					"      \"initialPaymentDate\": \"08/30/2020\",\r\n" + 
					"      \"includeLoanBalanceInReserve\": false,\r\n" + 
					"      \"borrower\": {\r\n" + 
					"        \"id\": 5160,\r\n" + 
					"        \"name\": \"MAHESHQA\",\r\n" + 
					"        \"clientNumber\": \"381\",\r\n" + 
					"        \"active\": true,\r\n" + 
					"        \"emailId\": \"\",\r\n" + 
					"        \"mailAddresses\": []\r\n" + 
					"      },\r\n" + 
					"      \"comments\": null,\r\n" + 
					"      \"precision\": 2,\r\n" + 
					"      \"loanStatus\": {\r\n" + 
					"        \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
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
					"      \"id\": \"ed6834e9-3b11-46dc-bb84-7fb8c230a2b1\",\r\n" + 
					"      \"chargeCode\": \"Loan 123\",\r\n" + 
					"      \"transactionCode\": 366,\r\n" + 
					"      \"sequence\": 1,\r\n" + 
					"      \"natSign\": {\r\n" + 
					"        \"id\": \"3b71f83d-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"-\",\r\n" + 
					"        \"displayName\": \"Minus\"\r\n" + 
					"      },\r\n" + 
					"      \"frequency\": {\r\n" + 
					"        \"id\": \"3b6e3803-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"manual\",\r\n" + 
					"        \"displayName\": \"Manual\"\r\n" + 
					"      },\r\n" + 
					"      \"chargeType\": {\r\n" + 
					"        \"id\": \"3b7a9a4a-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"payment_balance_due\",\r\n" + 
					"        \"displayName\": \"On Balance Due\",\r\n" + 
					"        \"calculationType\": \"percentage\"\r\n" + 
					"      },\r\n" + 
					"      \"postingType\": {\r\n" + 
					"        \"id\": \"3b76178b-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"in_bal\",\r\n" + 
					"        \"displayName\": \"In Balance\"\r\n" + 
					"      },\r\n" + 
					"      \"value\": 60,\r\n" + 
					"      \"autoNewClient\": true\r\n" + 
					"    },\r\n" + 
					"    \"natSign\": \"-\",\r\n" + 
					"    \"sequence\": 1,\r\n" + 
					"    \"frequency\": \"manual\",\r\n" + 
					"    \"chargeType\": {\r\n" + 
					"      \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"      \"value\": \"original_loan_amount\",\r\n" + 
					"      \"displayName\": \"On Original Loan Amount\",\r\n" + 
					"      \"calculationType\": \"percentage\"\r\n" + 
					"    },\r\n" + 
					"    \"value\": null,\r\n" + 
					"    \"inBalance\": false,\r\n" + 
					"    \"accruedToLoan\": false,\r\n" + 
					"    \"percentage\":\"" +data+"\"\r\n" + 
					"    \"chargeType.displayName\": \"On Original Loan Amount\",\r\n" + 
					"    \"selectedCharge\": true,\r\n" + 
					"    \"chargeTemplate\": {\r\n" + 
					"      \"id\": \"acabd10f-f75f-4802-90db-a257eb3224a0\"\r\n" + 
					"    },\r\n" + 
					"    \"activityDate\": \"07/30/2020\"\r\n" + 
					"  }\r\n" + 
					"]";
			return rqst;
		}
	    

		public String getPayloadforManualFeePostValue(String data) {
			String rqst="[\r\n" + 
					"  {\r\n" + 
					"    \"id\": \"870facb6-dfe7-48d8-baf2-6d9910f45402\",\r\n" + 
					"    \"termLoan\": {\r\n" + 
					"      \"id\": \"43b58465-b282-40ed-9205-ed98ef6192d6\",\r\n" + 
					"      \"loanNumber\": \"THRE11\",\r\n" + 
					"      \"loanName\": \"THRE11 : THRE\",\r\n" + 
					"      \"formattedTermloanName\": null,\r\n" + 
					"      \"totalOutStandingBalance\": 0,\r\n" + 
					"      \"loanType\": {\r\n" + 
					"        \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
					"      \"principalAmount\": 6000,\r\n" + 
					"      \"interestRate\": 5,\r\n" + 
					"      \"totalInterest\": 5,\r\n" + 
					"      \"rateAdjustment\": 0,\r\n" + 
					"      \"revisedInterestRateEffectiveDate\": \"07/30/2020\",\r\n" + 
					"      \"interestRateType\": \"fixed\",\r\n" + 
					"      \"interestRateCode\": 0,\r\n" + 
					"      \"divisor\": 12,\r\n" + 
					"      \"termType\": {\r\n" + 
					"        \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"months\",\r\n" + 
					"        \"display\": \"Months\"\r\n" + 
					"      },\r\n" + 
					"      \"terms\": 12,\r\n" + 
					"      \"originationDate\": \"07/30/2020\",\r\n" + 
					"      \"disbursementDate\": \"09/30/2020\",\r\n" + 
					"      \"maturityDate\": \"07/30/2021\",\r\n" + 
					"      \"initialPaymentDate\": \"08/30/2020\",\r\n" + 
					"      \"includeLoanBalanceInReserve\": false,\r\n" + 
					"      \"borrower\": {\r\n" + 
					"        \"id\": 5160,\r\n" + 
					"        \"name\": \"MAHESHQA\",\r\n" + 
					"        \"clientNumber\": \"381\",\r\n" + 
					"        \"active\": true,\r\n" + 
					"        \"emailId\": \"\",\r\n" + 
					"        \"mailAddresses\": []\r\n" + 
					"      },\r\n" + 
					"      \"comments\": null,\r\n" + 
					"      \"precision\": 2,\r\n" + 
					"      \"loanStatus\": {\r\n" + 
					"        \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
					"        \"displayName\": \"Active\",\r\n" + 
					"        \"value\": \"active\"\r\n" + 
					"      },\r\n" + 
					"      \"paidOffDate\": \"07/30/2020\",\r\n" + 
					"      \"allowNegative\": false,\r\n" + 
					"      \"gracePeriodDays\": 0,\r\n" + 
					"      \"amortizationType\": \"normal\",\r\n" + 
					"      \"interestRatePrecision\": 0\r\n" + 
					"    },\r\n" + 
					"    \"chargeCode\": {\r\n" + 
					"      \"id\": \"f36d35e7-3666-49c7-bec0-df4487d4b3fa\",\r\n" + 
					"      \"chargeCode\": \"MAHESHQA\",\r\n" + 
					"      \"transactionCode\": 34711,\r\n" + 
					"      \"sequence\": 1,\r\n" + 
					"      \"natSign\": {\r\n" + 
					"        \"id\": \"3b71f6c0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"+\",\r\n" + 
					"        \"displayName\": \"Plus\"\r\n" + 
					"      },\r\n" + 
					"      \"frequency\": {\r\n" + 
					"        \"id\": \"3b6e3803-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"manual\",\r\n" + 
					"        \"displayName\": \"Manual\"\r\n" + 
					"      },\r\n" + 
					"      \"chargeType\": {\r\n" + 
					"        \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"original_loan_amount\",\r\n" + 
					"        \"displayName\": \"On Original Loan Amount\",\r\n" + 
					"        \"calculationType\": \"percentage\"\r\n" + 
					"      },\r\n" + 
					"      \"postingType\": {\r\n" + 
					"        \"id\": \"3b76178b-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"in_bal\",\r\n" + 
					"        \"displayName\": \"In Balance\"\r\n" + 
					"      },\r\n" + 
					"      \"value\": 5,\r\n" + 
					"      \"autoNewClient\": true\r\n" + 
					"    },\r\n" + 
					"    \"natSign\": \"+\",\r\n" + 
					"    \"sequence\": 1,\r\n" + 
					"    \"frequency\": \"manual\",\r\n" + 
					"    \"chargeType\": {\r\n" + 
					"      \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"      \"value\": \"original_loan_amount\",\r\n" + 
					"      \"displayName\": \"On Original Loan Amount\",\r\n" + 
					"      \"calculationType\": \"percentage\"\r\n" + 
					"    },\r\n" + 
					"    \"value\": null,\r\n" + 
					"    \"inBalance\": false,\r\n" + 
					"    \"accruedToLoan\": false,\r\n" + 
					"    \"percentage\": 5,\r\n" + 
					"    \"chargeType.displayName\": \"On Original Loan Amount\",\r\n" + 
					"    \"selectedCharge\": true,\r\n" + 
					"    \"chargeTemplate\": {\r\n" + 
					"      \"id\": \"870facb6-dfe7-48d8-baf2-6d9910f45402\"\r\n" + 
					"    },\r\n" + 
					"    \"activityDate\": \"07/30/2020\"\r\n" + 
					"  }\r\n" + 
					"]";
			return rqst;
		}
	    
		

		public String getPayloadforManualValueNegative(String Data) {
			String rqst="[\r\n" + 
					"  {\r\n" + 
					"    \"id\": \"54482133-2d42-4fb6-b862-538dae8c6df6\",\r\n" + 
					"    \"termLoan\": {\r\n" + 
					"      \"id\": \"43b58465-b282-40ed-9205-ed98ef6192d6\",\r\n" + 
					"      \"loanNumber\": \"THRE11\",\r\n" + 
					"      \"loanName\": \"THRE11 : THRE\",\r\n" + 
					"      \"formattedTermloanName\": null,\r\n" + 
					"      \"totalOutStandingBalance\": 0,\r\n" + 
					"      \"loanType\": {\r\n" + 
					"        \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
					"      \"principalAmount\": 6000,\r\n" + 
					"      \"interestRate\": 5,\r\n" + 
					"      \"totalInterest\": 5,\r\n" + 
					"      \"rateAdjustment\": 0,\r\n" + 
					"      \"revisedInterestRateEffectiveDate\": \"07/30/2020\",\r\n" + 
					"      \"interestRateType\": \"fixed\",\r\n" + 
					"      \"interestRateCode\": 0,\r\n" + 
					"      \"divisor\": 12,\r\n" + 
					"      \"termType\": {\r\n" + 
					"        \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"months\",\r\n" + 
					"        \"display\": \"Months\"\r\n" + 
					"      },\r\n" + 
					"      \"terms\": 12,\r\n" + 
					"      \"originationDate\": \"07/30/2020\",\r\n" + 
					"      \"disbursementDate\": \"09/30/2020\",\r\n" + 
					"      \"maturityDate\": \"07/30/2021\",\r\n" + 
					"      \"initialPaymentDate\": \"08/30/2020\",\r\n" + 
					"      \"includeLoanBalanceInReserve\": false,\r\n" + 
					"      \"borrower\": {\r\n" + 
					"        \"id\": 5160,\r\n" + 
					"        \"name\": \"MAHESHQA\",\r\n" + 
					"        \"clientNumber\": \"381\",\r\n" + 
					"        \"active\": true,\r\n" + 
					"        \"emailId\": \"\",\r\n" + 
					"        \"mailAddresses\": []\r\n" + 
					"      },\r\n" + 
					"      \"comments\": null,\r\n" + 
					"      \"precision\": 2,\r\n" + 
					"      \"loanStatus\": {\r\n" + 
					"        \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
					"        \"displayName\": \"Active\",\r\n" + 
					"        \"value\": \"active\"\r\n" + 
					"      },\r\n" + 
					"      \"paidOffDate\": \"07/30/2020\",\r\n" + 
					"      \"allowNegative\": false,\r\n" + 
					"      \"gracePeriodDays\": 0,\r\n" + 
					"      \"amortizationType\": \"normal\",\r\n" + 
					"      \"interestRatePrecision\": 0\r\n" + 
					"    },\r\n" + 
					"    \"chargeCode\": {\r\n" + 
					"      \"id\": \"49bed712-f2f9-4a2a-8fdd-d895477057d7\",\r\n" + 
					"      \"chargeCode\": \"hhf\",\r\n" + 
					"      \"transactionCode\": 875461,\r\n" + 
					"      \"sequence\": 1,\r\n" + 
					"      \"natSign\": {\r\n" + 
					"        \"id\": \"3b71f83d-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"-\",\r\n" + 
					"        \"displayName\": \"Minus\"\r\n" + 
					"      },\r\n" + 
					"      \"frequency\": {\r\n" + 
					"        \"id\": \"3b6e3803-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"manual\",\r\n" + 
					"        \"displayName\": \"Manual\"\r\n" + 
					"      },\r\n" + 
					"      \"chargeType\": {\r\n" + 
					"        \"id\": \"3b7a99bf-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"total_payment_due\",\r\n" + 
					"        \"displayName\": \"On Total Payment Due\",\r\n" + 
					"        \"calculationType\": \"percentage\"\r\n" + 
					"      },\r\n" + 
					"      \"postingType\": {\r\n" + 
					"        \"id\": \"3b76178b-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"        \"value\": \"in_bal\",\r\n" + 
					"        \"displayName\": \"In Balance\"\r\n" + 
					"      },\r\n" + 
					"      \"value\": 12,\r\n" + 
					"      \"autoNewClient\": true\r\n" + 
					"    },\r\n" + 
					"    \"natSign\": \"-\",\r\n" + 
					"    \"sequence\": 1,\r\n" + 
					"    \"frequency\": \"manual\",\r\n" + 
					"    \"chargeType\": {\r\n" + 
					"      \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"      \"value\": \"original_loan_amount\",\r\n" + 
					"      \"displayName\": \"On Original Loan Amount\",\r\n" + 
					"      \"calculationType\": \"percentage\"\r\n" + 
					"    },\r\n" + 
					"    \"value\":\""+Data+"\",\r\n" + 
					"    \"inBalance\": false,\r\n" + 
					"    \"accruedToLoan\": false,\r\n" + 
					"    \"percentage\": 12,\r\n" + 
					"    \"chargeType.displayName\": \"On Total Payment Due\",\r\n" + 
					"    \"selectedCharge\": true,\r\n" + 
					"    \"chargeTemplate\": {\r\n" + 
					"      \"id\": \"54482133-2d42-4fb6-b862-538dae8c6df6\"\r\n" + 
					"    },\r\n" + 
					"    \"activityDate\": \"07/30/2020\"\r\n" + 
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
	        		"      \"id\": \"ada0fa6c-501f-4a6d-8148-a4e92b995bb5\",\r\n" + 
	        		"      \"termLoan\": {\r\n" + 
	        		"        \"id\": \"43b58465-b282-40ed-9205-ed98ef6192d6\",\r\n" + 
	        		"        \"loanNumber\": \"THRE11\",\r\n" + 
	        		"        \"loanName\": \"THRE11 : THRE\",\r\n" + 
	        		"        \"formattedTermloanName\": null,\r\n" + 
	        		"        \"totalOutStandingBalance\": 0,\r\n" + 
	        		"        \"loanType\": {\r\n" + 
	        		"          \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"          \"value\": \"term_loan\",\r\n" + 
	        		"          \"display\": \"Term Loan\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"currency\": {\r\n" + 
	        		"          \"id\": 5,\r\n" + 
	        		"          \"currencyCode\": \"USD\",\r\n" + 
	        		"          \"description\": \"USD : US Dollar\",\r\n" + 
	        		"          \"decimalPrecision\": 3,\r\n" + 
	        		"          \"systemDefined\": true\r\n" + 
	        		"        },\r\n" + 
	        		"        \"principalAmount\": 6000,\r\n" + 
	        		"        \"interestRate\": 5,\r\n" + 
	        		"        \"totalInterest\": 5,\r\n" + 
	        		"        \"rateAdjustment\": 0,\r\n" + 
	        		"        \"revisedInterestRateEffectiveDate\": \"07/30/2020\",\r\n" + 
	        		"        \"interestRateType\": \"fixed\",\r\n" + 
	        		"        \"interestRateCode\": 0,\r\n" + 
	        		"        \"divisor\": 12,\r\n" + 
	        		"        \"termType\": {\r\n" + 
	        		"          \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"          \"value\": \"months\",\r\n" + 
	        		"          \"display\": \"Months\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"terms\": 12,\r\n" + 
	        		"        \"originationDate\": \"07/30/2020\",\r\n" + 
	        		"        \"disbursementDate\": \"09/30/2020\",\r\n" + 
	        		"        \"maturityDate\": \"07/30/2021\",\r\n" + 
	        		"        \"initialPaymentDate\": \"08/30/2020\",\r\n" + 
	        		"        \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"        \"borrower\": {\r\n" + 
	        		"          \"id\": 5160,\r\n" + 
	        		"          \"name\": \"MAHESHQA\",\r\n" + 
	        		"          \"clientNumber\": \"381\",\r\n" + 
	        		"          \"active\": true,\r\n" + 
	        		"          \"emailId\": \"\",\r\n" + 
	        		"          \"mailAddresses\": []\r\n" + 
	        		"        },\r\n" + 
	        		"        \"comments\": null,\r\n" + 
	        		"        \"precision\": 2,\r\n" + 
	        		"        \"loanStatus\": {\r\n" + 
	        		"          \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
	        		"          \"displayName\": \"Active\",\r\n" + 
	        		"          \"value\": \"active\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"paidOffDate\": \"07/30/2020\",\r\n" + 
	        		"        \"allowNegative\": false,\r\n" + 
	        		"        \"gracePeriodDays\": 0,\r\n" + 
	        		"        \"amortizationType\": \"normal\",\r\n" + 
	        		"        \"interestRatePrecision\": 0\r\n" + 
	        		"      },\r\n" + 
	        		"      \"chargeCode\": {\r\n" + 
	        		"        \"id\": \"95695bf7-2ada-11ea-a6f1-0683e4e863aa\",\r\n" + 
	        		"        \"chargeCode\": \"Late Fee Penalty\",\r\n" + 
	        		"        \"transactionCode\": 0,\r\n" + 
	        		"        \"sequence\": 1,\r\n" + 
	        		"        \"natSign\": {\r\n" + 
	        		"          \"id\": \"3b71f6c0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"          \"value\": \"+\",\r\n" + 
	        		"          \"displayName\": \"Plus\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"frequency\": {\r\n" + 
	        		"          \"id\": \"3b6e3803-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"          \"value\": \"manual\",\r\n" + 
	        		"          \"displayName\": \"Manual\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"chargeType\": {\r\n" + 
	        		"          \"id\": \"95683d98-2ada-11ea-a6f1-0683e4e863aa\",\r\n" + 
	        		"          \"value\": \"principal_balance\",\r\n" + 
	        		"          \"displayName\": \"On Payment Due of All Principal Balance Periods\",\r\n" + 
	        		"          \"calculationType\": \"percentage\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"postingType\": {\r\n" + 
	        		"          \"id\": \"3b76178b-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
	        		"        \"id\": \"95683d98-2ada-11ea-a6f1-0683e4e863aa\",\r\n" + 
	        		"        \"value\": \"principal_balance\",\r\n" + 
	        		"        \"displayName\": \"On Payment Due of All Principal Balance Periods\",\r\n" + 
	        		"        \"calculationType\": \"percentage\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"value\": 0,\r\n" + 
	        		"      \"inBalance\": false,\r\n" + 
	        		"      \"accruedToLoan\": false\r\n" + 
	        		"    },\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \"43b58465-b282-40ed-9205-ed98ef6192d6\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"      \"value\": \"original_loan_amount\",\r\n" + 
	        		"      \"displayName\": \"On Original Loan Amount\",\r\n" + 
	        		"      \"calculationType\": \"percentage\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"activityDate\": \"07/30/2020\",\r\n" + 
	        		"    \"percentage\": "+percentage+",\r\n" + 
	        		"    \"value\": 0,\r\n" + 
	        		"    \"chargedAmount\": 0,\r\n" + 
	        		"    \"principalAmount\": null,\r\n" + 
	        		"    \"outstandingPrincipal\": null,\r\n" + 
	        		"    \"totalPaymentDue\": null,\r\n" + 
	        		"    \"balanceDue\": null,\r\n" + 
	        		"    \"principalBalance\": null,\r\n" + 
	        		"    \"pastDueDays\": 4\r\n" + 
	        		"  }\r\n" + 
	        		"]";
	        
	        return requestBodyForChargeCode;}
	    
	    
	    public String getpenaltyRequestbodyForvalue(String value) {
	        String requestBodyForChargeCode="[\r\n" + 
	        		"  {\r\n" + 
	        		"    \"chargeTemplate\": {\r\n" + 
	        		"      \"id\": \"ada0fa6c-501f-4a6d-8148-a4e92b995bb5\",\r\n" + 
	        		"      \"termLoan\": {\r\n" + 
	        		"        \"id\": \"43b58465-b282-40ed-9205-ed98ef6192d6\",\r\n" + 
	        		"        \"loanNumber\": \"THRE11\",\r\n" + 
	        		"        \"loanName\": \"THRE11 : THRE\",\r\n" + 
	        		"        \"formattedTermloanName\": null,\r\n" + 
	        		"        \"totalOutStandingBalance\": 0,\r\n" + 
	        		"        \"loanType\": {\r\n" + 
	        		"          \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"          \"value\": \"term_loan\",\r\n" + 
	        		"          \"display\": \"Term Loan\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"currency\": {\r\n" + 
	        		"          \"id\": 5,\r\n" + 
	        		"          \"currencyCode\": \"USD\",\r\n" + 
	        		"          \"description\": \"USD : US Dollar\",\r\n" + 
	        		"          \"decimalPrecision\": 3,\r\n" + 
	        		"          \"systemDefined\": true\r\n" + 
	        		"        },\r\n" + 
	        		"        \"principalAmount\": 6000,\r\n" + 
	        		"        \"interestRate\": 5,\r\n" + 
	        		"        \"totalInterest\": 5,\r\n" + 
	        		"        \"rateAdjustment\": 0,\r\n" + 
	        		"        \"revisedInterestRateEffectiveDate\": \"07/30/2020\",\r\n" + 
	        		"        \"interestRateType\": \"fixed\",\r\n" + 
	        		"        \"interestRateCode\": 0,\r\n" + 
	        		"        \"divisor\": 12,\r\n" + 
	        		"        \"termType\": {\r\n" + 
	        		"          \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"          \"value\": \"months\",\r\n" + 
	        		"          \"display\": \"Months\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"terms\": 12,\r\n" + 
	        		"        \"originationDate\": \"07/30/2020\",\r\n" + 
	        		"        \"disbursementDate\": \"09/30/2020\",\r\n" + 
	        		"        \"maturityDate\": \"07/30/2021\",\r\n" + 
	        		"        \"initialPaymentDate\": \"08/30/2020\",\r\n" + 
	        		"        \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"        \"borrower\": {\r\n" + 
	        		"          \"id\": 5160,\r\n" + 
	        		"          \"name\": \"MAHESHQA\",\r\n" + 
	        		"          \"clientNumber\": \"381\",\r\n" + 
	        		"          \"active\": true,\r\n" + 
	        		"          \"emailId\": \"\",\r\n" + 
	        		"          \"mailAddresses\": []\r\n" + 
	        		"        },\r\n" + 
	        		"        \"comments\": null,\r\n" + 
	        		"        \"precision\": 2,\r\n" + 
	        		"        \"loanStatus\": {\r\n" + 
	        		"          \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
	        		"          \"displayName\": \"Active\",\r\n" + 
	        		"          \"value\": \"active\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"paidOffDate\": \"07/30/2020\",\r\n" + 
	        		"        \"allowNegative\": false,\r\n" + 
	        		"        \"gracePeriodDays\": 0,\r\n" + 
	        		"        \"amortizationType\": \"normal\",\r\n" + 
	        		"        \"interestRatePrecision\": 0\r\n" + 
	        		"      },\r\n" + 
	        		"      \"chargeCode\": {\r\n" + 
	        		"        \"id\": \"95695bf7-2ada-11ea-a6f1-0683e4e863aa\",\r\n" + 
	        		"        \"chargeCode\": \"Late Fee Penalty\",\r\n" + 
	        		"        \"transactionCode\": 0,\r\n" + 
	        		"        \"sequence\": 1,\r\n" + 
	        		"        \"natSign\": {\r\n" + 
	        		"          \"id\": \"3b71f6c0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"          \"value\": \"+\",\r\n" + 
	        		"          \"displayName\": \"Plus\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"frequency\": {\r\n" + 
	        		"          \"id\": \"3b6e3803-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"          \"value\": \"manual\",\r\n" + 
	        		"          \"displayName\": \"Manual\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"chargeType\": {\r\n" + 
	        		"          \"id\": \"95683d98-2ada-11ea-a6f1-0683e4e863aa\",\r\n" + 
	        		"          \"value\": \"principal_balance\",\r\n" + 
	        		"          \"displayName\": \"On Payment Due of All Principal Balance Periods\",\r\n" + 
	        		"          \"calculationType\": \"percentage\"\r\n" + 
	        		"        },\r\n" + 
	        		"        \"postingType\": {\r\n" + 
	        		"          \"id\": \"3b76178b-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
	        		"        \"id\": \"95683d98-2ada-11ea-a6f1-0683e4e863aa\",\r\n" + 
	        		"        \"value\": \"principal_balance\",\r\n" + 
	        		"        \"displayName\": \"On Payment Due of All Principal Balance Periods\",\r\n" + 
	        		"        \"calculationType\": \"percentage\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"value\": 0,\r\n" + 
	        		"      \"inBalance\": false,\r\n" + 
	        		"      \"accruedToLoan\": false\r\n" + 
	        		"    },\r\n" + 
	        		"    \"termLoan\": {\r\n" + 
	        		"      \"id\": \"43b58465-b282-40ed-9205-ed98ef6192d6\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"chargeType\": {\r\n" + 
	        		"      \"id\": \"3b7a9ac4-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"      \"value\": \"value\",\r\n" + 
	        		"      \"displayName\": \"Value\",\r\n" + 
	        		"      \"calculationType\": \"absolute\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"activityDate\": \"07/30/2020\",\r\n" + 
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
	    
	    
	    public String getPayloadforAmortizationUPdateRegularDate(String ResponseID) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \""+ResponseID+"\",\r\n" + 
	        		"  \"period\": 1,\r\n" + 
	        		"  \"interestRate\": 10,\r\n" + 
	        		"  \"paymentDate\": \"08/27/2020\",\r\n" + 
	        		"  \"openingBalance\": 1000000,\r\n" + 
	        		"  \"regularInterest\": 8333.33,\r\n" + 
	        		"  \"regularPrincipal\": 163228.06,\r\n" + 
	        		"  \"regularPaymentDue\": \""+getRegularPaymentdue()+"\",\r\n" + 
	        		"  \"fee\": 0,\r\n" + 
	        		"  \"totalPaymentDue\": 171561.39,\r\n" + 
	        		"  \"totalPaymentDone\": 0,\r\n" + 
	        		"  \"totalInterestPayment\": 0,\r\n" + 
	        		"  \"totalFeePayment\": 0,\r\n" + 
	        		"  \"totalPrincipalPayment\": 0,\r\n" + 
	        		"  \"extraPrincipalPayment\": 0,\r\n" + 
	        		"  \"endingBalance\": 836771.94,\r\n" + 
	        		"  \"balanceDue\": 171561.39,\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \"cd56f426-bf1b-4239-b53e-0fb124663440\",\r\n" + 
	        		"    \"loanNumber\": \"QAW11\",\r\n" + 
	        		"    \"loanName\": \"QAW\",\r\n" + 
	        		"    \"loanType\": {\r\n" + 
	        		"      \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"      \"value\": \"term_loan\",\r\n" + 
	        		"      \"display\": \"Term Loan\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"currency\": {\r\n" + 
	        		"      \"id\": 5,\r\n" + 
	        		"      \"currencyCode\": \"USD\",\r\n" + 
	        		"      \"description\": \"USD : US Dollar\",\r\n" + 
	        		"      \"decimalPrecision\": 6,\r\n" + 
	        		"      \"systemDefined\": false\r\n" + 
	        		"    },\r\n" + 
	        		"    \"principalAmount\": 1000000,\r\n" + 
	        		"    \"interestRate\": 2,\r\n" + 
	        		"    \"divisor\": 12,\r\n" + 
	        		"    \"interestStartDate\": null,\r\n" + 
	        		"    \"termType\": {\r\n" + 
	        		"      \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"      \"value\": \"months\",\r\n" + 
	        		"      \"display\": \"Months\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"terms\": 6,\r\n" + 
	        		"    \"originationDate\": \"08/27/2020\",\r\n" + 
	        		"    \"disbursementDate\": \"09/27/2020\",\r\n" + 
	        		"    \"maturityDate\": \"01/27/2021\",\r\n" + 
	        		"    \"initialPaymentDate\": \"08/27/2020\",\r\n" + 
	        		"    \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"    \"borrower\": {\r\n" + 
	        		"      \"id\": 5160,\r\n" + 
	        		"      \"name\": \"MAHESHQA\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"interestRevised\": false,\r\n" + 
	        		"    \"revisedInterestRate\": 0,\r\n" + 
	        		"    \"revisedInterestDateEffectiveDate\": null,\r\n" + 
	        		"    \"comments\": null,\r\n" + 
	        		"    \"precision\": 3\r\n" + 
	        		"  },\r\n" + 
	        		"  \"payments\": null,\r\n" + 
	        		"  \"paymentDueEdited\": false,\r\n" + 
	        		"  \"periodCharged\": false,\r\n" + 
	        		"  \"paymentDone\": false,\r\n" + 
	        		"  \"isEditAllowed\": true\r\n" + 
	        		"}";
	        
	        return requestBodyForChargeCode;}
	    
	    public String getPayloadforAmortizationRecalculateForPreview(String ResponseID,String RegularPaymentDue) {
	        String requestBodyForChargeCode="{\r\n" + 
	        		"  \"id\": \""+ResponseID+"\",\r\n" + 
	        		"  \"period\": 1,\r\n" + 
	        		"  \"interestRate\": 10,\r\n" + 
	        		"  \"paymentDate\": \"08/27/2020\",\r\n" + 
	        		"  \"openingBalance\": 1000000,\r\n" + 
	        		"  \"regularInterest\": 8333.33,\r\n" + 
	        		"  \"regularPrincipal\": 163228.06,\r\n" + 
	        		"  \"regularPaymentDue\": \""+RegularPaymentDue+"\",\r\n" + 
	        		"  \"fee\": 0,\r\n" + 
	        		"  \"totalPaymentDue\": 171561.39,\r\n" + 
	        		"  \"totalPaymentDone\": 0,\r\n" + 
	        		"  \"totalInterestPayment\": 0,\r\n" + 
	        		"  \"totalFeePayment\": 0,\r\n" + 
	        		"  \"totalPrincipalPayment\": 0,\r\n" + 
	        		"  \"extraPrincipalPayment\": 0,\r\n" + 
	        		"  \"endingBalance\": 836771.94,\r\n" + 
	        		"  \"balanceDue\": 171561.39,\r\n" + 
	        		"  \"termLoan\": {\r\n" + 
	        		"    \"id\": \"12d1558a-831a-4cbe-9cf7-8881568406c9\",\r\n" + 
	        		"    \"loanNumber\": \"QAW11\",\r\n" + 
	        		"    \"loanName\": \"QAW11 : QAW\",\r\n" + 
	        		"    \"formattedTermloanName\": null,\r\n" + 
	        		"    \"totalOutStandingBalance\": 0,\r\n" + 
	        		"    \"loanType\": {\r\n" + 
	        		"      \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
	        		"    \"principalAmount\": 1000000,\r\n" + 
	        		"    \"interestRate\": 4,\r\n" + 
	        		"    \"divisor\": 12,\r\n" + 
	        		"    \"interestStartDate\": \"07/27/2020\",\r\n" + 
	        		"    \"termType\": {\r\n" + 
	        		"      \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
	        		"      \"value\": \"months\",\r\n" + 
	        		"      \"display\": \"Months\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"terms\": 5,\r\n" + 
	        		"    \"originationDate\": \"07/27/2020\",\r\n" + 
	        		"    \"disbursementDate\": null,\r\n" + 
	        		"    \"maturityDate\": \"01/27/2021\",\r\n" + 
	        		"    \"initialPaymentDate\": \"08/27/2020\",\r\n" + 
	        		"    \"includeLoanBalanceInReserve\": false,\r\n" + 
	        		"    \"borrower\": {\r\n" + 
	        		"      \"id\": 5160,\r\n" + 
	        		"      \"name\": \"MAHESHQA\"\r\n" + 
	        		"    },\r\n" + 
	        		"    \"interestRevised\": false,\r\n" + 
	        		"    \"revisedInterestRate\": 0,\r\n" + 
	        		"    \"revisedInterestRateEffectiveDate\": null,\r\n" + 
	        		"    \"comments\": null,\r\n" + 
	        		"    \"precision\": 4,\r\n" + 
	        		"    \"loanStatus\": {\r\n" + 
	        		"      \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
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
					"    \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"    \"value\": \"term_loan\",\r\n" + 
					"    \"display\": \"Term Loan\"\r\n" + 
					"  },\r\n" + 
					"  \"borrower\": {\r\n" + 
					"    \"id\": \"5160\",\r\n" + 
					"    \"name\": \"MAHESHQA\"\r\n" + 
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
					"    \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
					"    \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
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

		public String getCommitRequestBodyOfLoan(String responseOfPreview,String LoanNumber,String LoanName,String PrincipalAmount,String Term,String Termtype,String	Intrest,String Originationdate,String InitialPaymentdate,String Disburnsmentdate,String	interestRateType,String	rateAdjustment,String amortizationType,String	MaturityDate)			
	     {
			String rqst ="{\r\n" + 
					"  \"id\": \""+responseOfPreview+"\",\r\n" + 
					"  \"loanType\": {\r\n" + 
					"    \"id\": \"3b6a411e-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"    \"value\": \"term_loan\",\r\n" + 
					"    \"display\": \"Term Loan\"\r\n" + 
					"  },\r\n" + 
					"  \"borrower\": {\r\n" + 
					"    \"id\": \"5160\",\r\n" + 
					"    \"name\": \"MAHESHQA\"\r\n" + 
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
					"    \"id\": \"3b663bc0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
					"    \"id\": \"b5c14ca1-fa31-11e9-a6f1-0683e4e863aa\",\r\n" + 
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



		public String getChargecodeRequestBodyForNEgativeScenario(String chargeCode) {
			String Request="{\r\n" + 
					"  \"id\": \"\",\r\n" + 
					"  \"chargeCode\": \""+chargeCode+"\",\r\n" + 
					"  \"transactionCode\": \"200406\",\r\n" + 
					"  \"natSign\": {\r\n" + 
					"    \"id\": \"3b71f6c0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"    \"value\": \"+\",\r\n" + 
					"    \"displayName\": \"Plus\"\r\n" + 
					"  },\r\n" + 
					"  \"frequency\": {\r\n" + 
					"    \"id\": \"3b6e3803-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"    \"value\": \"manual\",\r\n" + 
					"    \"displayName\": \"Manual\"\r\n" + 
					"  },\r\n" + 
					"  \"chargeType\": {\r\n" + 
					"    \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"    \"value\": \"original_loan_amount\",\r\n" + 
					"    \"displayName\": \"On Original Loan Amount\",\r\n" + 
					"    \"calculationType\": \"percentage\"\r\n" + 
					"  },\r\n" + 
					"  \"postingType\": {\r\n" + 
					"    \"id\": \"3b76178b-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
					"    \"id\": \"3b71f6c0-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"    \"value\": \"+\",\r\n" + 
					"    \"displayName\": \"Plus\"\r\n" + 
					"  },\r\n" + 
					"  \"frequency\": {\r\n" + 
					"    \"id\": \"3b6e3803-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"    \"value\": \"manual\",\r\n" + 
					"    \"displayName\": \"Manual\"\r\n" + 
					"  },\r\n" + 
					"  \"chargeType\": {\r\n" + 
					"    \"id\": \"3b7a970f-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
					"    \"value\": \""+chargeType+"\",\r\n" + 
					"    \"displayName\": \""+chargeType+"\",\r\n" + 
					"    \"calculationType\": \"percentage\"\r\n" + 
					"  },\r\n" + 
					"  \"postingType\": {\r\n" + 
					"    \"id\": \"3b76178b-c623-11e9-8128-0efdfcf6f638\",\r\n" + 
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
		 
		 
		 public String getRequestedNotifyDetails() {
			 String getRequestedNotifyDetails ="[\r\n" + 
			 		"   {\r\n" + 
			 		"      \"period\":0,\r\n" + 
			 		"      \"termLoanId\":\"f1af7f16-83fd-483f-a213-c62df9b79472\"\r\n" + 
			 		"   }\r\n" + 
			 		"]";
			return getRequestedNotifyDetails;
			 
		 }
		 public String requestNotesDetailsDtos() {
			 String getRequestedNotifyDetails ="[\r\n" + 
			 		"   {\r\n" + 
			 		"      \"period\":0,\r\n" + 
			 		"      \"termLoanId\":\"f1af7f16-83fd-483f-a213-c62df9b79472\"\r\n" + 
			 		"   }\r\n" + 
			 		"]";
			return getRequestedNotifyDetails;
			 
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
		        		"      \"borrower_id\": 5160,\n" + 
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
		        		"            \"loan_number\": \"QAW11\",\n" + 
		        		"            \"loan_name\": \"QAW\",\n" + 
		        		"            \"precision\": 4,\n" + 
		        		"            \"initial_payment_date\": \"08/27/2020\",\n" + 
		        		"            \"loan_period_due\": [\n" + 
		        		"              {\n" + 
		        		"                \"id\": \"\",\n" + 
		        		"                \"period\": 1,\n" + 
		        		"                \"payment_due_date\": \"08/27/2020\",\n" + 
		        		"                \"interest_due_amount\": 8333.33,\n" + 
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
		 public String createNotify() {
			 String createNotify ="{\r\n" + 
			 		"   \"templateId\":\"a8352d16-dc85-11ea-9a17-12e987db82ac\",\r\n" + 
			 		"   \"notificationType\":\"email\",\r\n" + 
			 		"   \"notifyDetails\":[\r\n" + 
			 		"      {\r\n" + 
			 		"         \"termLoanId\":\"31724c55-3bc7-4f82-aa6b-f9cfa1c31e79\",\r\n" + 
			 		"         \"period\":\"1\"\r\n" + 
			 		"      }\r\n" + 
			 		"   ]\r\n" + 
			 		"}";
			return createNotify;
		 }
		 
		 public String createNote() {
			 String createNote = "{\r\n" + 
			 		"   \"notes\":\"Hi this mahesh for testing team\",\r\n" + 
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
			 		"   \"notes\":\"Hi this test for test QA\",\r\n" + 
			 		"   \"termLoanIds\":[\r\n" + 
			 		"      \"31724c55-3bc7-4f82-aa6b-f9cfa1c31e79\"\r\n" + 
			 		"   ]\r\n" + 
			 		"}";
			return createNoteloanlevel;
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
         public String createNoteForFollowOverDueOrFollowPeriod() {
			 String createNoteForFollowOverDueOrFollowPeriod ="{\r\n" + 
			 		"   \"notes\":\"We are from QA team we are doing testing only \",\r\n" + 
			 		"   \"periodDetails\":[\r\n" + 
			 		"      {\r\n" + 
			 		"         \"period\":1,\r\n" + 
			 		"         \"termLoanId\":\"764972ee-be45-432c-ad34-bb5265bee86d\"\r\n" + 
			 		"      }\r\n" + 
			 		"   ]\r\n" + 
			 		"}";
			return createNoteForFollowOverDueOrFollowPeriod;
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
