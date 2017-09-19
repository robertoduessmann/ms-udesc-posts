package org.udesc.client;

import org.udesc.dto.PostDTO;

import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public interface TwitterPostClient {

	@RequestLine("POST /posts")
	@Headers({ "Content-Type: application/json", "X-ConsumerKey: ${consumerKey}", "X-ConsumerSecret: ${consumerSecret}",
			"X-AccessToken: ${accessToken}", "X-AccessTokenSecret: ${accessTokenSecret}" })
	public void create(@Param("consumerKey") String consumerKey, @Param("consumerSecret") String consumerSecret,
			@Param("accessToken") String accessToken, @Param("accessTokenSecret") String accessTokenSecret,
			PostDTO postDTO);

	public static TwitterPostClient connect(String url) {
		return Feign.builder()
				.encoder( new GsonEncoder() )
				.decoder( new GsonDecoder() )
				.target( TwitterPostClient.class, url );
	}
}
