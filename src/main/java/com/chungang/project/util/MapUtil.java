package com.chungang.project.util;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.chungang.project.model.GeocodeRequestDTO;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;

@Service
public class MapUtil {
	@Scheduled(fixedDelay=5000)
	public Float[] geoCoding(GeocodeRequestDTO geocodeRequestdto) {
		if(geocodeRequestdto.getAddress()==null) {
			return null;
		}
		
		Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder()
				.setAddress(geocodeRequestdto.getAddress())
				.setLanguage("ko")
				.getGeocoderRequest();
		
		GeocodeResponse geocodeResponse = new GeocodeResponse();
	
		try {
			geocodeResponse = geocoder.geocode(geocoderRequest);
			System.out.println(geocodeResponse.getStatus());
			System.out.println(geocodeResponse.getResults());
			if(geocodeResponse.getStatus() == GeocoderStatus.OK & !geocodeResponse.getResults().isEmpty()) {
				GeocoderResult geocoderResult=geocodeResponse.getResults().iterator().next();
				LatLng latitudeLongitude = geocoderResult.getGeometry().getLocation();
				
				Float[] coords = new Float[2];
				coords[0] = latitudeLongitude.getLat().floatValue();
				coords[1] = latitudeLongitude.getLat().floatValue();
				
				return coords;
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}