package com.icypt.sboot.common.result;

public class CodeMsgFactory {
	/**
	 * 系统通用结果码
	 */
	public static final CodeMsg SUCC = new CodeMsg("000000", "成功");
	public static final CodeMsg FAIL = new CodeMsg("FFFFFF", "系统异常");

	/**
	 * 请求参数错误
	 */
	public static final CodeMsg REQ_PARAM_ERROR = new CodeMsg("REQ_PARAM_ERROR", "请求参数错误");

	/**
	 * 请求异常
	 */
	public static final CodeMsg REQ_EXCEPTION = new CodeMsg("REQ_EXCEPTION", "请求异常");
}
