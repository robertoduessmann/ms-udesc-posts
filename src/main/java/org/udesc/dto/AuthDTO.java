package org.udesc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDTO {
	private String userId;
	private String token;
	private String consumerKey;
	private String consumerSecret;
	private String accessToken;
	private String accessTokenSecret;
}
