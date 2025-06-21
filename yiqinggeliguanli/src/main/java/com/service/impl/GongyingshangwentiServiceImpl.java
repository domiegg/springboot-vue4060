package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.GongyingshangwentiDao;
import com.entity.GongyingshangwentiEntity;
import com.entity.view.GongyingshangwentiView;
import com.service.GongyingshangwentiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 供应商问题 服务实现类
 */
@Service("gongyingshangwentiService")
@Transactional
public class GongyingshangwentiServiceImpl extends ServiceImpl<GongyingshangwentiDao, GongyingshangwentiEntity> implements GongyingshangwentiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<GongyingshangwentiView> page =new Query<GongyingshangwentiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
