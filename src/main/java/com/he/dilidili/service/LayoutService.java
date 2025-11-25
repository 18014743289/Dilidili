package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.model.dto.LayoutDTO;
import com.he.dilidili.model.entity.Layout;
import com.he.dilidili.model.vo.LayoutVO;

public interface LayoutService extends IService<Layout> {

//    获取个人布局
    LayoutVO getLayout(Integer id);

//    修改个人布局
    void updateLayout(LayoutDTO layoutDTO);

//    添加个人布局
    void addLayout(LayoutDTO layoutDTO);

//    删除个人布局
    void deleteLayout(Integer id);
}
