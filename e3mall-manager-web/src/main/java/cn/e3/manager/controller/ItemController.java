package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemService;
import cn.e3.pojo.TbItem;
import cn.e3.utils.DatagridPagebean;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService ;
	
	@RequestMapping("item/list/{itemId}")
	@ResponseBody
	public TbItem findItemByID(@PathVariable Long itemId){
		TbItem item = itemService.findItemById(itemId);
		return  item;
	} 
	
	@RequestMapping("/item/list")
	@ResponseBody
	public DatagridPagebean findByPage(@RequestParam(defaultValue="30") Integer rows, @RequestParam(defaultValue="1")  Integer page){
		DatagridPagebean findItemBypage = itemService.findItemBypage(page, rows);
		
		return  findItemBypage;
	}
	
	
}
