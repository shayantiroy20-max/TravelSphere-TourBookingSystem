package com.tourapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tourapp.model.TourPackage;
public interface PackageRepository 
        extends JpaRepository<TourPackage, Integer> {
}