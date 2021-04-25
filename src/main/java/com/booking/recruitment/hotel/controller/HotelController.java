package com.booking.recruitment.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	private final HotelService hotelService;

	@Autowired
	public HotelController(HotelService hotelService) {
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

	@GetMapping("/hotel/{hotelId}")
	public Optional<Hotel> getHotelById(@PathVariable(value = "hotelId") Long hotelId) {
		return hotelService.getHotelById(hotelId);
	}

}
