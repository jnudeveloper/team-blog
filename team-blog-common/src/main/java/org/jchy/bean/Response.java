package org.jchy.bean;

/**
 * 统一处理返回给View层的JSON
 * 
 * @author Jeremy
 * @date 2018年4月3日
 *
 */
public class Response {

	private static final int STATE_OK = 200;
	
	private static final int STATE_UNAUTHORIZED = 401;
	
	private static final int STATE_ERROR = 500;
	
	private int code;

	/** 返回信息 */
	private String message;

	/** 返回封装对象 */
	private Object data;
	
	public void ok(Object data) {
		this.code = STATE_OK;
		this.data = data;
	}
	
	public void ok(Object data, String message) {
		this.message = message;
		this.ok(data);
	}
	
	public void unauthorized() {
		this.code = STATE_UNAUTHORIZED;
	}
	
	public void failure(Exception ex) {
		if (ex instanceof RuntimeException) { // TODO：定义异常体系
			this.message = ex.getMessage();
		} else {
			this.code = STATE_ERROR;
			this.message = "服务器繁忙，请稍后再试";
		}
	}
	
	public Response ok() {
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
