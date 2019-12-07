package com.dj.sample.health;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthChecker implements HealthIndicator {

	@Override
	public Health health() {

		return checkInternet() == true ? Health.up().withDetail("Success", "Active Internet Connection").build()
				: Health.down().withDetail("No Internet", "In Active Internet Connection").build();
	}

	private boolean checkInternet() {

		boolean flag = false;
		try {
			URL url = new URL("https://www.google.com");
			URLConnection urlConnection = url.openConnection();
			urlConnection.connect();
			flag = true;
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return flag;
	}

}
