package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springboot.cruddemo.entity.User;


@Service
public class UserServiceImpl implements UserService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public UserServiceImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<User> findAll() {
//		logger.info("in getUsers(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<User>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<User>>() {});

		// get the list of users from response
		List<User> users = responseEntity.getBody();

		logger.info("in findAll(): users" + users);
		
		return users;
	}

	@Override
	public User findById(int theId) {

//		logger.info("in getUser(): Calling REST API " + crmRestUrl);

		// make REST call
		User theEmployee = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						User.class);

		logger.info("in findById(): theEmployee=" + theEmployee);
		
		return theEmployee;
	}

	@Override
	public void save(User theEmployee) {
//		logger.info("in saveUser(): Calling REST API " + crmRestUrl);
		
		int userId = theEmployee.getId();

		// make REST call
		if (userId == 0) {
			// add user
			restTemplate.postForEntity(crmRestUrl, theEmployee, String.class);			
		
		} else {
			// update user
			restTemplate.put(crmRestUrl, theEmployee);
		}

		logger.info("in Employee save(): success");	
		
	}

	@Override
	public void deleteById(int theId) {
		
//		logger.info("in deleteById(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteById(): deleted user theId=" + theId);
		
	}

	

	
	
}






