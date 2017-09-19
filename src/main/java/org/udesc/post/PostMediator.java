package org.udesc.post;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Service;
import org.udesc.app.App;
import org.udesc.app.AppService;
import org.udesc.auth.AuthService;
import org.udesc.dto.PostDTO;

@Service
@Log4j
public class PostMediator {

	private Map<App, PostService> postService;
	private FacebookPostService facebookPostService;
	private GooglePostService googlePostService;
	private AuthService authService;
	private AppService appService;

	public PostMediator(FacebookPostService facebookPostService, GooglePostService googlePostService,
			AuthService authService, AppService appService) {
		this.authService = authService;
		this.appService = appService;
		postService = new HashMap<>();
		postService.put( App.FACEBOOK, facebookPostService );
		postService.put( App.GOOGLE, googlePostService );
	}

	public void create(PostDTO postDTO) {
		App app = appService.getRandom();
		log.info( "[PostMediator] Creating post in..." + app.getDescription() );
		postService.get( app ).create( authService.get( app ), postDTO );
	}
}
