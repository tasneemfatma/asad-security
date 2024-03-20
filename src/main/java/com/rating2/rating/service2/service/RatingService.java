package com.rating2.rating.service2.service;

import com.rating2.rating.service2.entity.Rating;
import com.rating2.rating.service2.exception.ResourceNotFoundException;
import com.rating2.rating.service2.repo.RatingRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingService {

    @Autowired
    private RatingRepo repo;
    Logger logger= LoggerFactory.getLogger(RatingService.class);



    public Rating saveRating(Rating rating){
        String randomNumber = UUID.randomUUID().toString();
        rating.setRatingId(randomNumber);
        return repo.save(rating);
    }

    public Rating getRating(String id){
        return repo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("rating not found in server with id " + id)
        );
    }

    public List<Rating> allRating(){
        return repo.findAll();
    }
    public List<Rating> getRatingByUserId(String id){
        List<Rating> ratings = repo.findRatingByUserId(id);
        if(ratings == null){
            throw new ResourceNotFoundException("Rating of user not found with id: " + id) ;
        }
        else{
            return ratings;
        }

    }

    public List<Rating> getRatingByHotelId(String id){
        List<Rating> ratings = repo.findRatingByHotelId(id);
        if(ratings == null){
           throw new ResourceNotFoundException("Rating of hotel not found with id: " + id) ;
        }
        else{
            return ratings;
        }
    }






}
