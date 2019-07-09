package cn.test.spring.response;

public class CommonException extends RuntimeException {

	private static final long serialVersionUID = 5330899151866165507L;

	public CommonException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommonException(String message) {
		super(message);
	}
}
