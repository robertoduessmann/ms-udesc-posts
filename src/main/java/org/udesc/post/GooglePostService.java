package org.udesc.post;

import org.springframework.stereotype.Service;
import org.udesc.client.GooglePostClient;
import org.udesc.dto.AuthDTO;
import org.udesc.dto.PostDTO;

@Service
public class GooglePostService implements PostService {

	@Override
	public void create(AuthDTO authDTO, PostDTO postDTO) {
		GooglePostClient
				.connect( "http://localhost:8082" )
				.create( authDTO.getUserId(), authDTO.getToken(), postDTO );
	}
}
