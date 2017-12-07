package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3.manager.service.ItemService;

@Controller
public class PageContrl {
  @Autowired
private ItemService itemService ;
  
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		
		
		return page;
	}
	
}
