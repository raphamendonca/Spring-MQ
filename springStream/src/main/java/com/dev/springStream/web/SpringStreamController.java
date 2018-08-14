/**
 * 
 */
package com.dev.springStream.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RequestMapping("/stream")
@RestController
public class SpringStreamController {

	@Autowired
	Source mysource;
	
	@PostMapping
	public String stream(@RequestParam String nome) {
		System.out.println(nome);
		
		mysource.output().send(MessageBuilder.withPayload(nome).build());
		
		return "Sucesso";
	}
	
}
