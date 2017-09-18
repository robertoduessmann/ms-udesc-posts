package org.udesc.post;

import org.springframework.stereotype.Service;
import org.udesc.client.FacebookPostClient;
import org.udesc.dto.AuthDTO;
import org.udesc.dto.PostDTO;

@Service
public class FacebookPostService implements PostService {

	@Override
	public void create(AuthDTO authDTO, PostDTO postDTO) {
		FacebookPostClient
				.connect( "http://localhost:8083" )
				.create( authDTO.getToken(), postDTO );
	}
}
