package com.rating2.rating.service2.controller;


import com.rating2.rating.service2.entity.Rating;
import com.rating2.rating.service2.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {


    @Autowired
    private RatingService ratingService;


    @PostMapping("/")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
        return new ResponseEntity<>(ratingService.saveRating(rating), HttpStatus.CREATED)  ;
    }

    @GetMapping("/")
    public ResponseEntity<List<Rating>> allRating(){
        return new ResponseEntity<List<Rating>>(ratingService.allRating(), HttpStatus.OK)  ;
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable("ratingId") String ratingId){
        return new ResponseEntity<>(ratingService.getRating(ratingId), HttpStatus.OK)  ;
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("hotelId") String hotelId){
        return new ResponseEntity<>(ratingService.getRatingByHotelId(hotelId), HttpStatus.OK)  ;
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") String userId){
        return new ResponseEntity<>(ratingService.getRatingByUserId(userId), HttpStatus.OK)  ;
    }

}
