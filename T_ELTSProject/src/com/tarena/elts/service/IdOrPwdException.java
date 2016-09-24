package com.tarena.elts.service;

public class IdOrPwdException extends Exception {
	private static final long 
	serialVersionUID = 2778336549007960935L;
    //序列化端口号，便于序列化和反序列化；
	
	public IdOrPwdException() {
	}

	public IdOrPwdException(String message) {
		super(message);
	}

	public IdOrPwdException(Throwable cause) {
		super(cause);
	}

	public IdOrPwdException(String message, Throwable cause) {
		super(message, cause);
	}

}
