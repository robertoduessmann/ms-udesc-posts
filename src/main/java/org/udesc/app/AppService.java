package org.udesc.app;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class AppService {

	public App getRandom() {
		if (LocalDateTime.now().getSecond() % 2 == 0)
			return App.FACEBOOK;
		return App.GOOGLE;
	}

}
