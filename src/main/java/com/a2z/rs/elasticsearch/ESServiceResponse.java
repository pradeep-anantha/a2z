package com.a2z.rs.elasticsearch;

import com.a2z.core.vo.ServiceResponse;

public class ESServiceResponse extends ServiceResponse {

	public ESServiceResponse(int code, String msg) {
		statusCode = code;
		message = msg;
	}

}
