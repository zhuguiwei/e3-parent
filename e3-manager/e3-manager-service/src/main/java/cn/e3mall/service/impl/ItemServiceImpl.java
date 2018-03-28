package cn.e3mall.service.impl;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
private TbItemMapper itemMapper;
    @Override
    public TbItem getItemById(long itemId) {
        //根据主键查询
       // TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
       //设置查询条件
        TbItemExample example = new TbItemExample();
      TbItemExample.Criteria criteria=   example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list=itemMapper.selectByExample(example);
        if(list !=null&&list.size()>0){
            return list.get(0);
        }
      return  null;
    }
}
