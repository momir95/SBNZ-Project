package com.example.drools.repository;

import com.example.drools.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Momir on 10.06.2018.
 */
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
