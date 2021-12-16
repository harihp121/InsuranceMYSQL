package com.insurance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Renewal;
import com.insurance.repository.RenewalRepository;

@RestController
@RequestMapping(value="api/vehicleinsurance")
public class RenewalController {
@Autowired
RenewalRepository renewalrepo;

@PostMapping("/renewal")
public Renewal addUser(@RequestBody Renewal renewal)
{
	renewalrepo.save(renewal);
	return renewal;
}

@GetMapping("/renewal")
public List<Renewal> getUser()
{
	return renewalrepo.findAll();
}

@RequestMapping("/renewal/{emailID}")
public Optional<Renewal> getUser(@PathVariable("emailID") String emailID )
{
	return renewalrepo.findById(emailID);
}


}
