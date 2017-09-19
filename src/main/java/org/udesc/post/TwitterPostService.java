package org.udesc.post;

import org.springframework.stereotype.Service;
import org.udesc.client.TwitterPostClient;
import org.udesc.dto.AuthDTO;
import org.udesc.dto.PostDTO;

@Service
public class TwitterPostService implements PostService {

	@Override
	public void create(AuthDTO authDTO, PostDTO postDTO) {
		TwitterPostClient
				.connect( "http://localhost:8084" )
				.create( authDTO.getUserId(), authDTO.getToken(), postDTO );
	}
}
