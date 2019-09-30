package com.kyiminhan.spring;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

@SpringBootApplication
public class GoogleMapClientSpringApplication {

	public static void main(final String[] args) throws ApiException, InterruptedException, IOException {
		SpringApplication.run(GoogleMapClientSpringApplication.class, args);

		final GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBO6D-KZDZ5fRvj0LYgmjV2-gBYH3p8MVE")
				.build();

		final GeocodingResult[] results = GeocodingApi.geocode(context, "東京都江東区大島").await();
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();

		System.out.println();
		System.out.println(gson.toJson(results[0].formattedAddress));

		System.out.println();
		System.out.println(gson.toJson(results[0].geometry.location.lat));
		System.out.println(gson.toJson(results[0].geometry.location.lng));

		System.out.println();
		System.out.println(gson.toJson(results[0].geometry.location));

		System.out.println(gson.toJson(results[0].addressComponents));

	}

}
