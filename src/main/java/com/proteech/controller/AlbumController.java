package com.proteech.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.proteech.modal.Album;
@CrossOrigin
@RestController
@RequestMapping("/albums")
public class AlbumController {
	private static final Logger log=LoggerFactory.getLogger(AlbumController.class);
	
	@GetMapping("/{id}")
	public List<Album>getAlbumById(@PathVariable int id){
	 String uri="https://jsonplaceholder.typicode.com/albums";
	 
	 RestTemplate template= new RestTemplate();
			 List<Album>albums=Arrays.stream(template.getForObject(uri+"/"+id+"/photos", Album[].class)).collect(Collectors.toList());
			 return albums;
	 
	}

}
