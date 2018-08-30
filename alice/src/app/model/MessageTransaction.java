package app.model;

public class MessageTransaction {
	
	private int ErrorNumber;
	private String Message;
	private int idResult;
	
	public int getErrorNumber() {
		return ErrorNumber;
	}
	public void setErrorNumber(int errorNumber) {
		ErrorNumber = errorNumber;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public int getIdResult() {
		return idResult;
	}
	public void setIdResult(int idResult) {
		this.idResult = idResult;
	}
	
	@Override
	public String toString() {
		return "MessageTransaction [ErrorNumber=" + ErrorNumber + ", Message=" + Message + ", idResult=" + idResult
				+ "]";
	}
	
}
