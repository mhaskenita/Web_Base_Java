package com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tour.entity.Tour;



public interface TourRepository extends JpaRepository<Tour,Integer>{

}
