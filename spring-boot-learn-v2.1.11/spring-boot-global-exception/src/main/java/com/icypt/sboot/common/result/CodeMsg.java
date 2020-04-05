package com.icypt.sboot.common.result;

/**
 * @PlatForm： 冰点IT
 * @projectName: 个人博客
 * @Author：icypt
 * @createTime：
 * @version：2.0
 * @description：
 * @url: www.icypt.com
 */
public class CodeMsg {
	
	private String code;
	private String msg;
	
	public CodeMsg(String code, String msg) {
		this.code = code;
		this.msg = msg;
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
