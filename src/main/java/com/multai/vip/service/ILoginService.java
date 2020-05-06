package com.multai.vip.service;

import com.multai.vip.bean.Person;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ILoginService {
	Person getUserById(int paramInt);

	int saveUser(Person paramPerson);

	List<Person> getAllUsers();

	void setTemporaryPassword(String email,String password);

	void updateUser(Person person);

	void deleteByUserId(int userId);
}
