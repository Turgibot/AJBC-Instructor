package ajbc.examples.custom.unchecked;

public class BusinessLogicException extends RuntimeException {
	private final ErrorCode code;

	public BusinessLogicException(ErrorCode code) {
		super();
		this.code = code;
	}

	public BusinessLogicException(String message, Throwable cause, ErrorCode code) {
		super(message, cause);
		this.code = code;
	}

	public BusinessLogicException(String message, ErrorCode code) {
		super(message);
		this.code = code;
	}

	public BusinessLogicException(Throwable cause, ErrorCode code) {
		super(cause);
		this.code = code;
	}

	public ErrorCode getErrorCode() {
		return this.code;
	}

	public static enum ErrorCode {
		MISSING_INFO(100), ILLEGAL_NAME(101), ILLEGAL_AGE(102), INVALID_ID(103);

		int codeNum;

		ErrorCode(int codeNum) {
			this.codeNum = codeNum;
		}
	}

}
