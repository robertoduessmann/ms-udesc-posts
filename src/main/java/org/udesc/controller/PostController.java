package org.udesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.udesc.dto.PostDTO;
import org.udesc.post.PostMediator;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	private PostMediator mediator;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody PostDTO postDTO) {
		mediator.create( postDTO );
	}
}
