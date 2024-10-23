package imb.lh.p3.clases.util;

import java.util.ArrayList;
import java.util.List;

public class DTOResponse<T> {
	
	private int status;
	private List<String> message;
	private T data;
	
	public DTOResponse(int status, List<String> message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public DTOResponse(int status, String message, T data) {
		super();
		this.status = status;
		List<String> messages = new ArrayList();
		messages.add(message);
		this.message = messages;
		this.data = data;
	}
	
	public DTOResponse() {
		
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	
	
}
