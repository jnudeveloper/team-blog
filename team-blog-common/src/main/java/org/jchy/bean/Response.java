package org.jchy.bean;

/**
 * ͳһ�����ظ�View���JSON
 * 
 * @author Jeremy
 * @date 2018��4��3��
 *
 */
public class Response {

	private static final int STATE_OK = 200;
	
	private static final int STATE_UNAUTHORIZED = 401;
	
	private static final int STATE_ERROR = 500;
	
	private int code;

	/** ������Ϣ */
	private String message;

	/** ���ط�װ���� */
	private Object data;
	
	public Response ok(Object data) {
		this.code = STATE_OK;
		this.data = data;
		return this;
	}
	
	public Response ok(Object data, String message) {
		this.message = message;
		this.ok(data);
		return this;
	}
	
	public Response unauthorized() {
		this.code = STATE_UNAUTHORIZED;
		return this;
	}
	
	public Response failure(Exception ex) {
		if (ex instanceof RuntimeException) { // TODO�������쳣��ϵ
			this.message = ex.getMessage();
		} else {
			this.code = STATE_ERROR;
			this.message = "��������æ�����Ժ�����";
		}
		return this;
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
