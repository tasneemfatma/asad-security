package com.rating2.rating.service2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rating_microservice")
public class Rating {


    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private String ratings;
    private String comments;




}
