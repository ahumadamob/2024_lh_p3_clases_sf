package imb.lh.p3.clases.util;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse<T> {
	
	private int status;
	private List<String> error;
	private T data;
	
	public ApiResponse(int status, List<String> error, T data) {
		super();
		this.status = status;
		this.error = error;
		this.data = data;
	}
	
	public ApiResponse(int status, String error, T data) {
		super();
		this.status = status;
		List<String> errores = new ArrayList();
		errores.add(error);
		this.error = errores;
		this.data = data;
	}
	
	public ApiResponse() {
		
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<String> getError() {
		return error;
	}
	public void setError(List<String> error) {
		this.error = error;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	
	
}
