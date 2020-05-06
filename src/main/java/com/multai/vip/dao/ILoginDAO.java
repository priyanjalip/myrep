package com.multai.vip.dao;

import com.multai.vip.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ILoginDAO extends JpaRepository<Person, Integer> {
	Person findByUserId(int paramInt);

	Person findByEmail(String email);
}
