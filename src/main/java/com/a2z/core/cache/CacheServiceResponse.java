package com.a2z.core.cache;

import com.a2z.core.vo.ServiceResponse;

public class CacheServiceResponse extends ServiceResponse {
	
	public CacheServiceResponse(int code, String msg) {
		statusCode = code;
		message = msg;
	}

}
