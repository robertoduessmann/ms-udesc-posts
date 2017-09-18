package org.udesc.post;

import org.udesc.dto.AuthDTO;
import org.udesc.dto.PostDTO;

public interface PostService {

	void create(AuthDTO authDTO, PostDTO postDTO);
}
