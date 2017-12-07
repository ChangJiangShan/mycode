package cn.e3.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.DatagridPagebean;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper ibItemMapper ;
	
	@Override
	public TbItem findItemById(Long id) {
		TbItem ibitem = ibItemMapper.selectByPrimaryKey(id);
		return ibitem;
	}

	@Override
	public DatagridPagebean findItemBypage(Integer page, Integer rows) {
		TbItemExample example = new TbItemExample();
	 
	     PageHelper.startPage(page,rows);
		List<TbItem> list = ibItemMapper.selectByExample(example);
		//创创建一个获取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		//获取总记录数
		long total = pageInfo.getTotal();
		//创建一个返回值对象
		DatagridPagebean pageBean = new DatagridPagebean();
		//设置查询分页记录
		pageBean.setRows(list);
		pageBean.setTotal(total);
		return pageBean;
	}

}
