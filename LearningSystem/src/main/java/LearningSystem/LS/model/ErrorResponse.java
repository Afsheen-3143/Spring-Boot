package LearningSystem.LS.model;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private LocalDateTime timestamp;
	private String errormessage;
	private String errordetails;
	private String errorcode;
	public ErrorResponse(LocalDateTime timestamp, String errormessage, String errordetails, String errorcode) {
		super();
		this.timestamp = timestamp;
		this.errormessage = errormessage;
		this.errordetails = errordetails;
		this.errorcode = errorcode;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public String getErrordetails() {
		return errordetails;
	}
	public void setErrordetails(String errordetails) {
		this.errordetails = errordetails;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	
	

}
