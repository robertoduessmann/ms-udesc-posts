package org.udesc.post;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.udesc.app.App;
import org.udesc.app.AppService;
import org.udesc.auth.AuthService;
import org.udesc.dto.AuthDTO;
import org.udesc.dto.PostDTO;

public class PostMediatorTest {

	@Mock
	private Map<App, PostService> postService;
	@Mock
	private FacebookPostService facebookPostService;
	@Mock
	private GooglePostService googlePostService;
	@Mock
	private AuthService authService;
	@Mock
	private AppService appService;
	@InjectMocks
	private PostMediator mediator;

	@Before
	public void init() {
		initMocks( this );
	}

	@Test
	public void createTest() {
		PostDTO mockPost = mockPost();
		AuthDTO mockAuth = mockAuth();
		when( appService.getRandom() ).thenReturn( App.FACEBOOK );
		when( authService.get( App.FACEBOOK ) ).thenReturn( mockAuth );

		mediator.create( mockPost );

		verify( authService ).get( App.FACEBOOK );
		verify( facebookPostService ).create( mockAuth, mockPost );
	}

	private PostDTO mockPost() {
		return new PostDTO( "Random Post" );
	}

	private AuthDTO mockAuth() {
		return new AuthDTO( "asdasdas7-das9-dasm0-7d7asda" );
	}
}
