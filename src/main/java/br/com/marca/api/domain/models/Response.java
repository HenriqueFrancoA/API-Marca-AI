package br.com.marca.api.domain.models;


public class Response<T> {

	private Long statusCode;
	private T data;
	private String timeStamp;
	
	public Response() {
		
	}
	
	public Response(Long statusCode, T data, String timeStamp) {
		super();
		this.statusCode = statusCode;
		this.data = data;
		this.timeStamp = timeStamp;
	}
	
	public Long getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Long statusCode) {
		this.statusCode = statusCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
