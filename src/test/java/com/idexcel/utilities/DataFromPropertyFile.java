package com.idexcel.utilities;

/**
 * @author Shivaraj.Budeppa
 *
 */
public class DataFromPropertyFile {
	
	
	PropertyFileReader propReader = new PropertyFileReader();

	//public String getKey = "Staging.properties";
	public String getKey = System.getProperty("user.dir")+
			"/envinput/Staging.properties";

	private String  TermloanRequest =propReader.getDataprovider(getKey,
			"TermloanRequest");
    
	private String  TermloanAPI =propReader.getDataprovider(getKey,
			"TermloanAPI");
	private String  baseURL =propReader.getDataprovider(getKey,
			"baseURL");
	private String  RequestToCreateTermloan =propReader.getDataprovider(getKey,
			"RequestToCreateTermloan");

	private String  UserInformation =propReader.getDataprovider(getKey,
			"UserInformation");

	private String  TermloanChargeCodeAPI =propReader.getDataprovider(getKey,
			"TermloanChargeCodeAPI");

	private String  LatefeeURI =propReader.getDataprovider(getKey,
			"LatefeeURI");

	private String  LatefeePut =propReader.getDataprovider(getKey,
			"LatefeePut");
	

	private String  ChargetypesAPI =propReader.getDataprovider(getKey,
			"ChargetypesAPI");

	private String  frequenciesAPI =propReader.getDataprovider(getKey,
			"frequenciesAPI");


	private String  natSignAPI =propReader.getDataprovider(getKey,
			"natSignAPI");

	private String  PostingTypesapi =propReader.getDataprovider(getKey,
			"PostingTypesapi");

	private String  RequestToUpdateTermloan =propReader.getDataprovider(getKey,
			"RequestToUpdateTermloan");

	private String  UpdateResponseapi =propReader.getDataprovider(getKey,
			"UpdateResponseapi");

	private String  maturitydateapi =propReader.getDataprovider(getKey,
			"maturitydateapi");

	private String  CurrenciesApi =propReader.getDataprovider(getKey,
			"CurrenciesApi");

	private String  credentials =propReader.getDataprovider(getKey,
			"credentials");

	private String  RequestToCreateChargeCode =propReader.getDataprovider(getKey,
			"RequestToCreateChargeCode");
	
	private String  RequestToUpdateFinancialAnalyzer =propReader.getDataprovider(getKey,
			"RequestToUpdateFinancialAnalyzer");
	
	private String  uploadfile =propReader.getDataprovider(getKey,
			"uploadfile");
	private String  emoapi =propReader.getDataprovider(getKey,
			"emoapi");
	
	private String  Requestbodyfortermloan =propReader.getDataprovider(getKey,
			"Requestbodyfortermloan");
	private String  RequestAmortization =propReader.getDataprovider(getKey,
			"RequestAmortization");
	private String  SelectLoan =propReader.getDataprovider(getKey,
			"SelectLoan");
	private String  TermloanId =propReader.getDataprovider(getKey,
			"TermloanId");

	private String  chargecode =propReader.getDataprovider(getKey,
			"chargecode");
	private String  ChargeCodeBody =propReader.getDataprovider(getKey,
			"ChargeCodeBody");
	
	private String  chargecodeApi =propReader.getDataprovider(getKey,
			"chargecodeApi");
	
	private String  getChargeCodes =propReader.getDataprovider(getKey,
			"getChargeCodes");
	
	private String  CurrencyAPI =propReader.getDataprovider(getKey,
			"CurrencyAPI");
	
	private String  LoantypeAPI =propReader.getDataprovider(getKey,
			"LoantypeAPI");
	
	private String  getTermtypeAPI =propReader.getDataprovider(getKey,
			"getTermtypeAPI");
	private String  BaseURI =propReader.getDataprovider(getKey,
			"BaseURI");
	
	private String  LenderID =propReader.getDataprovider(getKey,
			"LenderID");
	
	private String  TermloanURI =propReader.getDataprovider(getKey,
			"TermloanURI");
	
	private String  chrgAndPaymentURI =propReader.getDataprovider(getKey,
			"chrgAndPaymentURI");

	private String  Calculatefee =propReader.getDataprovider(getKey,
			"Calculatefee");
	
	private String  Manualfee =propReader.getDataprovider(getKey,
			"Manualfee");
	
	
	private String  AmortizationApis =propReader.getDataprovider(getKey,
			"AmortizationApis");
	private String  latefeedelete =propReader.getDataprovider(getKey,
			"latefeedelete");
	
	private String  AmortizationSchedule =propReader.getDataprovider(getKey,
			"AmortizationSchedule");
	private String  Collateralget =propReader.getDataprovider(getKey,
			"Collateralget");
	private String  AmortizationSchedulePost =propReader.getDataprovider(getKey,
			"AmortizationSchedulePost");
	
	private String  termloansApi =propReader.getDataprovider(getKey,
			"termloansApi");
	
	private String  chargetemplates =propReader.getDataprovider(getKey,
			"chargetemplates");
	
	private String  chargetemp =propReader.getDataprovider(getKey,
			"chargetemp");
	private String  TermLoancharge =propReader.getDataprovider(getKey,
			"TermLoancharge");
	
	private String  ChargeDetails =propReader.getDataprovider(getKey,
			"ChargeDetails");
	
	private String  AmortizationscheduleAPI =propReader.getDataprovider(getKey,
			"AmortizationscheduleAPI");
	
	private String  regulardue =propReader.getDataprovider(getKey,
			"regulardue");
	
	private String  RecalculateForPreview =propReader.getDataprovider(getKey,
			"RecalculateForPreview");
	private String  Preview =propReader.getDataprovider(getKey,
			"Preview");
	
	private String  chargecodes =propReader.getDataprovider(getKey,
			"chargecodes");
	private String  getpreviewURI =propReader.getDataprovider(getKey,
			"getpreviewURI");
	
	private String  getTermloanID =propReader.getDataprovider(getKey,
			"getTermloanID");
	private String  getCommitURI =propReader.getDataprovider(getKey,
			"getCommitURI");

	private String  getPutURI =propReader.getDataprovider(getKey,
			"getPutURI");
	
	private String  CreatebatchURI =propReader.getDataprovider(getKey,
			"CreatebatchURI");
	private String  RepaymentURI =propReader.getDataprovider(getKey,
			"RepaymentURI");
	private String  	ProcessBactchURI =propReader.getDataprovider(getKey,
			"	ProcessBactchURI");
	private String  	GetbatchDetailURI =propReader.getDataprovider(getKey,
			"	GetbatchDetailURI");
	
	private String  	NewInterestURI =propReader.getDataprovider(getKey,
			"	NewInterestURI");
	private String  	getBaseCodeURI =propReader.getDataprovider(getKey,
			"	getBaseCodeURI");
	private String  	getOutstandingBalanceURI =propReader.getDataprovider(getKey,
			"	getOutstandingBalanceURI");

	

	private String  	UpdateRegularDue =propReader.getDataprovider(getKey,
			"	UpdateRegularDue");
	
	
	private String  	getGracedays =propReader.getDataprovider(getKey,
			"	getGracedays");
	private String  	graceURI =propReader.getDataprovider(getKey,
			"	graceURI");
	
	private String  	getPeriodRevisionPutAPi =propReader.getDataprovider(getKey,
			"	getPeriodRevisionPutAPi");
	private String  getDocumentList =propReader.getDataprovider(getKey,
			"getDocumentList");
	private String downloadDocument = propReader.getDataprovider(getKey, 
			   "downloadDocument");
	private String uploadFile = propReader.getDataprovider(getKey, "uploadFile");
	
    private String termloanId = propReader.getDataprovider(getKey, "termloanId");
    private String clientId = propReader.getDataprovider(getKey, "clientId");
    
    private String documentName=propReader.getDataprovider(getKey, "documentName");
    private String purpose=propReader.getDataprovider(getKey, "purpose");
    private String file=propReader.getDataprovider(getKey, "file");
    private String fileType=propReader.getDataprovider(getKey, "fileType");
    private String uploadedFileList=propReader.getDataprovider(getKey,"uploadedFileList");
    private String documentDelete=propReader.getDataprovider(getKey, "documentDelete");
    private String listOutDeletedDocuments=propReader.getDataprovider(getKey,"listOutDeletedDocuments");
    
    private String uploadFileThroughClient=propReader.getDataprovider(getKey, "uploadFileThroughClient");
    private String getAttentionRequiredCount=propReader.getDataprovider(getKey,"getAttentionRequiredCount");
    private String getFollowUpRequiredCount=propReader.getDataprovider(getKey,"getFollowUpRequiredCount");
    private String getFollowUpLoans=propReader.getDataprovider(getKey,"getFollowUpLoans");
    private String getTermLoanNotes=propReader.getDataprovider(getKey, "getTermLoanNotes");
    private String getListOfNotification=propReader.getDataprovider(getKey, "getListOfNotification");
    private String getListOfNotiFicationType = propReader.getDataprovider(getKey, "getListOfNotiFicationType");
    private String getFollowUpPeriods=propReader.getDataprovider(getKey, "getFollowUpPeriods");
    
    private String createNotify=propReader.getDataprovider(getKey,"createNotify");
    
    private String createNote=propReader.getDataprovider(getKey, "createNote");
    
    private String createNoteloanlevel=propReader.getDataprovider(getKey, "createNoteloanlevel");
    
    private String createNoteForFollowOverDueOrFollowPeriod = propReader.getDataprovider(getKey, "createNoteForFollowOverDueOrFollowPeriod");
    
    private String emailNotificationTemplate=propReader.getDataprovider(getKey, "emailNotificationTemplate");
    
    private String textTemplate=propReader.getDataprovider(getKey, "textTemplate");
    
    private String periodRevision=propReader.getDataprovider(getKey, "periodRevision");
    private String getPaymentrecevied=propReader.getDataprovider(getKey, "getPaymentrecevied");
    private String periodRevisionCommit=propReader.getDataprovider(getKey, "periodRevisionCommit");
    
    private String cronurl=propReader.getDataprovider(getKey, "cronurl");
    
    private String cronurl1=propReader.getDataprovider(getKey, "cronurl1");
    
    public String getCronurl() {
    	
		return cronurl;
    	
    }
public String getCronurl1() {
    	
		return cronurl1;
    	
    }
    public String getPaymentrecevied() {
    	
    	return getPaymentrecevied;
    }
    public String periodRevision() {
    	
    	return periodRevision;
    }
    
    public String textTemplate() {
    	
		return textTemplate;
    	
    }
    
    public String emailNotificationTemplate() {
    	
		return emailNotificationTemplate;
    	
    }
    public String periodRevisionCommit() {
    	
    	return periodRevisionCommit;
    	
    }
    public String createNoteloanlevel() {
    	
		return createNoteloanlevel;
    	
    }
    
    public String createNote() {
    	
		return createNote;
    	
    }
    public String createNotify() {
    	
		return createNotify;
    	
    }
    public String getAttentionRequiredCount() {
    	
    	return getAttentionRequiredCount;
    }
	public String getPutURI() {
		// TODO Auto-generated method stub
		return getPutURI;
	}
	public String getTermloanRequest() {
		// TODO Auto-generated method stub
		return TermloanRequest;
	}

	public String getTermloanAPI() {
		// TODO Auto-generated method stub
		return TermloanAPI;
	}

	public String getRequestToCreateTermloan() {
		// TODO Auto-generated method stub
		return RequestToCreateTermloan;
	}

	public String getUserInformationAPI() {
		// TODO Auto-generated method stub
		return UserInformation;
	}

	public String getTermloanChargeCodeAPI() {
		// TODO Auto-generated method stub
		return TermloanChargeCodeAPI;
	}

	public String getChargetypesAPI() {
		// TODO Auto-generated method stub
		return ChargetypesAPI;
	}

	public String getfrequenciesAPI() {
		// TODO Auto-generated method stub
		return frequenciesAPI;
	}

	public String getNatSignAPI() {
		// TODO Auto-generated method stub
		return natSignAPI;
	}

	public String getPostingTypesAPI() {
		// TODO Auto-generated method stub
		return 	"PostingTypesAPI";
	}

	public String gePostingTypesapi() {
		// TODO Auto-generated method stub
		return PostingTypesapi;
	}

	public String getRequestToUpdateTermloan() {
		// TODO Auto-generated method stub
		return RequestToUpdateTermloan;
	}

	public String getUpdateResponseapi() {
		// TODO Auto-generated method stub
		return UpdateResponseapi;
	}

	public String getmaturitydateapi() {
		// TODO Auto-generated method stub
		return maturitydateapi;
	}

	public String getCurrenciesApi() {
		// TODO Auto-generated method stub
		return CurrenciesApi;
	}

	public String getcredentials() {
		// TODO Auto-generated method stub
		return credentials;
	}

	public String getRequestToCreateChargeCode() {
		// TODO Auto-generated method stub
		return RequestToCreateChargeCode;
	}

	public String getRequestToUpdateFinancialAnalyzer() {
		// TODO Auto-generated method stub
		return RequestToUpdateFinancialAnalyzer;
	}

	public String getuploadfile() {
		// TODO Auto-generated method stub
		return uploadfile;
	}

	public String getemtot() {
		// TODO Auto-generated method stub
		return emoapi;
	}

	public String getRequestbodyfortermloan() {
		// TODO Auto-generated method stub
		return Requestbodyfortermloan;
	}

	public String getAmortizationApi() {
		// TODO Auto-generated method stub
		return RequestAmortization;
	}

	public String getSelectLoan() {
		// TODO Auto-generated method stub
		return SelectLoan ;
	}

	public String getTermloanId() {
		// TODO Auto-generated method stub
		return TermloanId;
	}

	public String getchargecode() {
		// TODO Auto-generated method stub
		return chargecode;
	}

	public String getChargeCodeBody() {
		// TODO Auto-generated method stub
		return ChargeCodeBody;
	}

	public String getchargecodeApi() {
		// TODO Auto-generated method stub
		return chargecodeApi;
	}

	public String natSignAPI() {
		// TODO Auto-generated method stub
		return natSignAPI;
	}

	public String getFrequenciesAPI() {
		// TODO Auto-generated method stub
		return frequenciesAPI ;
	}

	public String getChargeCodes() {
		// TODO Auto-generated method stub
		return getChargeCodes;
	}

	public String getCurrencyAPI() {
		// TODO Auto-generated method stub
		return CurrencyAPI;
	}

	public String getLoantypeAPI() {
		// TODO Auto-generated method stub
		return LoantypeAPI;
	}

	public String getTermtypeAPI() {
		// TODO Auto-generated method stub
		return getTermtypeAPI;
	}

	public String getBaseURI() {
		// TODO Auto-generated method stub
		return BaseURI;
	}

	public String getLenderID() {
		// TODO Auto-generated method stub
		return LenderID;
	}

	public String getTermloanURI() {
		// TODO Auto-generated method stub
		return TermloanURI;
	}

	public String chargesAndPaymentURI() {
		// TODO Auto-generated method stub
		return chrgAndPaymentURI;
	}
	
	public String getCalculatefee() {
		// TODO Auto-generated method stub
		return Calculatefee;
	}

	public String getManualfeePost() {
		// TODO Auto-generated method stub
		return Manualfee;
	}

	public String getAmortizationApis() {
		// TODO Auto-generated method stub
		return AmortizationApis;
	}

	public String getAmortizationSchedule() {
		// TODO Auto-generated method stub
		return AmortizationSchedule;
	}

	public String getCollateralget() {
		// TODO Auto-generated method stub
		return Collateralget;
	}

	public String getAmortizationSchedulePost() {
		// TODO Auto-generated method stub
		return AmortizationSchedulePost;
	}

	public String gettermloansApi() {
		// TODO Auto-generated method stub
		return termloansApi;
	}

	public String getchargetemplates() {
		// TODO Auto-generated method stub
		return chargetemplates;
	}

	public String getchargetemp() {
		// TODO Auto-generated method stub
		return chargetemp;
	}

	public String getTermLoancharge() {
		// TODO Auto-generated method stub
		return TermLoancharge;
	}

	public String getChargeDetails() {
		// TODO Auto-generated method stub
		return ChargeDetails;
	}

	public String getAmortizationscheduleAPI() {
		// TODO Auto-generated method stub
		return AmortizationscheduleAPI;
	}

	public String getregulardue() {
		// TODO Auto-generated method stub
		return regulardue;
	}

	public String getRecalculateForPreview() {
		// TODO Auto-generated method stub
		return RecalculateForPreview;
	}

	public String getPreview() {
		// TODO Auto-generated method stub
		return Preview;
	}

	public String getchargecodeURI() {
		// TODO Auto-generated method stub
		return chargecodes;
	}
	
	public String getpreviewURI() {
		// TODO Auto-generated method stub
		return getpreviewURI;
	}
	
	public String getTermloanID() {
		// TODO Auto-generated method stub
		return getTermloanID;
	}
	
	public String getCommitURI() {
		// TODO Auto-generated method stub
		return getCommitURI;
	}
	public String CreatebatchURI() {
		// TODO Auto-generated method stub
		return CreatebatchURI;
	}
	public String RepaymentURI() {
		// TODO Auto-generated method stub
		return RepaymentURI;
	}
	public String ProcessBactchURI() {
		// TODO Auto-generated method stub
		return ProcessBactchURI;
	}
	
	public String GetbatchDetailURI() {
		// TODO Auto-generated method stub
		return GetbatchDetailURI;
	}
	public String NewInterestURI() {
		// TODO Auto-generated method stub
		return NewInterestURI;
	}
		
		public String UpdateRegularDue() {
			// TODO Auto-generated method stub
			return UpdateRegularDue;
			
		
	}

		public String getGracedays() {
			// TODO Auto-generated method stub
			return getGracedays;
		}
		public String LatefeePut() {
			// TODO Auto-generated method stub
			return LatefeePut;
			
		}
		
		
		public String latefeedelete() {
			// TODO Auto-generated method stub
			return latefeedelete;
			
		
			
		}
		
		
		public String graceURI() {
			// TODO Auto-generated method stub
			return graceURI;
		}
		
		public String getBaseCodeURI() {
			// TODO Auto-generated method stub
			return getBaseCodeURI;
		}
	


		public String LatefeeURI() {
			// TODO Auto-generated method stub
			return LatefeeURI;
		}
		
		public String getPeriodRevisionPutAPi() {
			// TODO Auto-generated method stub
			return getPeriodRevisionPutAPi;
		}
		public String getDocumentList() {
			// TODO Auto-generated method stub
			return getDocumentList;
		}
	public String downloadDocument() {
		
		return downloadDocument;
		
	}
	public String uploadFile() {
		return uploadFile;
		
	}
	public String termloanId() {
		return termloanId;
	}
	public String clientId() {
		return clientId;
		
	}
	public String documentName() {
		
		return documentName;
		
	}
	public String purpose() {
		return purpose;
		
	}
	public String file() {
		return file;
		
	}
	public String fileType() {
		return fileType;
		
	}
	public String uploadedFileList() {
		//propReader.setData(documentId, fileName,Key,);
		return uploadedFileList;
		
	}
	public String documentDelete() {
		
		return documentDelete;
		
	}
	public String listOutDeletedDocuments() {
		
		return listOutDeletedDocuments;
		
	}
	public String uploadFileThroughClient() {
		
		return uploadFileThroughClient;
		
	}
	public String baseURL() {
		return BaseURI;
		
	}
	public String getFollowUpRequiredCount() {
		
		return getFollowUpRequiredCount;
	}
	public String getFollowUpLoans() {
		
		return getFollowUpLoans;
		
	}
	public String getTermLoanNotes() {
		
		return getTermLoanNotes;
		
	}
	public String getListOfNotification() {
		
		return getListOfNotification;
		
	}
	public String getListOfNotiFicationType() {
		
		return getListOfNotiFicationType;
		
	}
	public String getFollowUpPeriods() {
		
		return getFollowUpPeriods;
		
	}
	public String createNoteForFollowOverDueOrFollowPeriod() {
		
		return createNoteForFollowOverDueOrFollowPeriod;
		
	}
}
