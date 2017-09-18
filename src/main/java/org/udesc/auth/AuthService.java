package org.udesc.auth;

import org.springframework.stereotype.Service;
import org.udesc.app.App;
import org.udesc.client.AuthClient;
import org.udesc.dto.AuthDTO;

@Service
public class AuthService {

	public AuthDTO get(App app) {
		return AuthClient
				.connect( "http://localhost:8081" )
				.get( app.getDescription() );
	}
}
