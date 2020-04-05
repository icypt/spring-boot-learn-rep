package com.icypt.sboot.common.result;
/**
 * @PlatForm：冰点IT
 * @projectName: 个人博客
 * @Author：icypt
 * @createTime： 2020/1/17 22:37
 * @version：2.0
 * @description：结果工具类
 * @url: www.icypt.com
 */
public class ResultUtil {
	/**
     * 成功
	 * @return
     */
	public static Result succ() {
		return succ(null) ;
	}

	/**
	 * 成功
	 * @return
	 */
	public static Result succ(Object data) {
		return new Result(CodeMsgFactory.SUCC, data) ;
	}

    /**
     * 失败
	 * @return
     */
	public static Result fail() {
		return fail(null) ;
	}
	
	public static Result fail( Object data) {
		return new Result(CodeMsgFactory.FAIL, data) ;
	}
	
	public static Result result(CodeMsg codeMsg, Object data) {
		return new Result(codeMsg, data) ;
	}

	public static Result result(CodeMsg codeMsg) {
		return new Result(codeMsg, null) ;
	}
	
	public static Result result(String code, String msg, Object data) {
		CodeMsg codeMsg = new CodeMsg(code, msg);
		return new Result(codeMsg, data) ;
	}
}
