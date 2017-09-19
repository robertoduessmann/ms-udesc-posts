package org.udesc.client;

import org.udesc.dto.PostDTO;

import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public interface TwitterPostClient {

	@RequestLine("POST /users/{userId}/posts")
	@Headers({ "Content-Type: application/json", "X-Auth: ${token}" })
	public void create(@Param("userId") String userId, @Param("token") String token, PostDTO postDTO);

	public static TwitterPostClient connect(String url) {
		return Feign.builder()
				.encoder( new GsonEncoder() )
				.decoder( new GsonDecoder() )
				.target( TwitterPostClient.class, url );
	}
}
