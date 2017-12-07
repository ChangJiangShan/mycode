package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.utils.DatagridPagebean;

public interface ItemService {

	public TbItem findItemById(Long id);
	
	public DatagridPagebean  findItemBypage(Integer page,Integer rows);
}
