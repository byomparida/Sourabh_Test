package com.booking.recruitment.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.booking.recruitment.hotel.model.City;
import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.service.CityService;
import com.booking.recruitment.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	private final HotelService hotelService;
	private final CityService cityService;

	@Autowired
	public HotelController(HotelService hotelService, CityService cityService) {
		this.cityService = cityService;
		this.hotelService = hotelService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Hotel> getAllHotels() {
		return hotelService.getAllHotels();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return hotelService.createNewHotel(hotel);
	}

	@GetMapping("/{hotelId}")
	public Optional<Hotel> getHotelById(@PathVariable(value = "hotelId") Long hotelId) {
		return hotelService.getHotelById(hotelId);
	}

	@DeleteMapping("/{hotelId}")
	public void deleteHotelById(@PathVariable Long hotelId) {
		Hotel hotel = getHotelById(hotelId).get();
		if (hotel != null) {
			hotel.setDeleted(true);
			hotelService.removeHotel(hotel);
		}
	}

	@GetMapping("/search/{cityId}")
	public List<Hotel> findHotelsClosestToCity(@PathVariable(value = "cityId") Long cityId,
			@RequestParam("sortBy") Long distance) {

		City city = cityService.getCityById(cityId);
		final int R = 6371; // Radious of the earth
		Double lat1 = Double.parseDouble(city.getCityCentreLatitude();
		Double lon1 = Double.parseDouble(city.getCityCentreLongitude());
		Double latDistance = hotelService.toRad(lat2 - lat1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(hotelService.toRad(lat1)) * Math.cos(hotelService.toRad(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		Double distance1 = R * c;
	}

	

}
