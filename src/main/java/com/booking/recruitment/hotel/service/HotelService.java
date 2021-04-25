package com.booking.recruitment.hotel.service;

import java.util.List;
import java.util.Optional;

import com.booking.recruitment.hotel.model.Hotel;

public interface HotelService {
  List<Hotel> getAllHotels();

  List<Hotel> getHotelsByCity(Long cityId);

  Hotel createNewHotel(Hotel hotel);
  
  Optional<Hotel> getHotelById(Long hotelId);
  
  void removeHotel(Hotel hotel);
  
  Double toRad(Double value);
}
