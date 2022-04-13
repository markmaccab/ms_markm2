package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.Userpre;
//used for data persistence
public interface UserPreRepository extends JpaRepository<Userpre, Integer>  {

}

/*
package com.example.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springboot.entity.Userpre;
//used for data persistence
public interface UserPreRepository extends JpaRepository<Userpre, Integer>  {
	   @Query(value = "SELECT e from Userpre e where e.name =:John ", nativeQuery = true) //   @ using @query with native
	    List<Userpre> findByNameNative(@Param("John") String name);
}
*/