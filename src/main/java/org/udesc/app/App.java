package org.udesc.app;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum App {
	FACEBOOK( "facebook" ), GOOGLE( "google" );

	private String description;
}