package com.curso.crudUser.service;

import java.util.List;

import com.curso.crudUser.entity.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theEmployee);
	
	public void deleteById(int theId);
}
