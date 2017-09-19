package org.udesc.client;

import org.udesc.dto.PostDTO;

import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public interface FacebookPostClient {

	@RequestLine("POST /users/{userId}/posts")
	@Headers({ "Content-Type: application/json", "X-Auth: ${token}" })
	public void create(@Param("userId") String userId, @Param("token") String token, PostDTO postDTO);

	public static FacebookPostClient connect(String url) {
		return Feign.builder()
				.encoder( new GsonEncoder() )
				.decoder( new GsonDecoder() )
				.target( FacebookPostClient.class, url );
	}
}
