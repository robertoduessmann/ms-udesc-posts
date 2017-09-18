package org.udesc.app;

import org.springframework.stereotype.Service;

@Service
public class AppService {

	public App getRandom() {
		return App.FACEBOOK;
	}

}
