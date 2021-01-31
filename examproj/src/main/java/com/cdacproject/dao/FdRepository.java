package com.cdacproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdacproject.model.Fd;
import com.cdacproject.model.User;

public interface FdRepository extends JpaRepository<Fd, Integer> {

	@Query(nativeQuery=true ,value="SELECT * FROM Fd f where f.user_id= :userId ")
	List<Fd> fdStatement(@Param("userId") String userId);

	@Query(nativeQuery=true ,value="SELECT * FROM Fd f where f.user_id= :userId and f.date_of_maturity= :maturityDate ")
	Fd getFdByUidAndMaturutyDate(@Param("userId") String userId, @Param("maturityDate") String maturityDate);
	
	

}
