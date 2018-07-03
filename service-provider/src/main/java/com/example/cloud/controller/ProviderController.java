package com.example.cloud.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.domain.Person;

@RestController
public class ProviderController {

	@RequestMapping(value = "/call/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPerson(@PathVariable String id) {
		Person person = new Person(id, "小明");
		return person;
	}

}
