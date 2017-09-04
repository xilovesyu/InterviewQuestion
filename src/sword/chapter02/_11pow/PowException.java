package sword.chapter02._11pow;

public class PowException extends RuntimeException {
	
	/**
	 *12L 
	 */
	private static final long serialVersionUID = 12L;
	private String message;
	public PowException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
