package org.udesc.client;

import org.udesc.dto.AuthDTO;

import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public interface AuthClient {

	@RequestLine("GET /token/{app}/random")
	@Headers({ "Content-Type: application/json" })
	public AuthDTO get(@Param("app") String app);

	public static AuthClient connect(String url) {
		return Feign.builder()
				.encoder( new GsonEncoder() )
				.decoder( new GsonDecoder() )
				.target( AuthClient.class, url );
	}
}
