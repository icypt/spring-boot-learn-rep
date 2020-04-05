package com.icypt.sboot.common.result;

public class Result {
	private String code;
	private String msg;
	private Object data;
	
	public Result(CodeMsg codeMsg, Object data) {
		this.code  = codeMsg.getCode();
		this.msg = codeMsg.getMsg();
		this.data = data;
	}
	
	public Result(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
