package com.rating2.rating.service2.repo;

import com.rating2.rating.service2.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,String> {

    List<Rating> findRatingByUserId(String userId);

    List<Rating> findRatingByHotelId(String hotelId);
}
