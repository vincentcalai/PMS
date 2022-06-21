package com.pms.pmsapp.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.common.data.Message;
import com.pms.pmsapp.common.service.MessageService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	private static final Logger log = LoggerFactory.getLogger(MessageController.class);
	
	@RequestMapping(value="/msg/retrieve", method=RequestMethod.POST)
	public List<Message> retrieveMsg(@RequestBody String loginUser) {
		return messageService.retrieveMsg(loginUser);
	}
	
	@RequestMapping(value="/msg/retrievecnt", method=RequestMethod.POST)
	public int retrieveMsgCnt(@RequestBody String loginUser) {
		return messageService.retrieveMsgCnt(loginUser);
	}
	
	@RequestMapping(value="/msg/softDelReadMsg", method=RequestMethod.POST)
	public void softDelReadMsg(@RequestBody String loginUser) {
		messageService.softDelReadMsg(loginUser);
	}
	
	@RequestMapping(value="/msg/deleteAllMsg", method=RequestMethod.POST)
	public void deleteAllMsg(@RequestBody String loginUser) {
		messageService.deleteAllMsg(loginUser);
	}
}
