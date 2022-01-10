package com.cg.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.webapp.beans.Package;

public interface PackageRepository extends JpaRepository<Package, Integer>{

	

}
