package com.cdacproject.dao;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdacproject.model.Fd;
import com.cdacproject.model.User;

@Repository
public interface XRepository extends JpaRepository<User, Integer>{

	@Query(nativeQuery=true ,value="SELECT * FROM User u where u.user_id= :userId and u.password= :password")
	User loginUser(@Param("userId") String userId, @Param("password") String password);

	@Query(nativeQuery=true ,value="SELECT * FROM User u where u.user_id= :userId")
	User getUserById(@Param("userId") String userId);

}
