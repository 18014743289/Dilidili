package com.he.dilidili.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.he.dilidili.model.dto.DanmuDTO;
import com.he.dilidili.model.entity.Danmu;
import com.he.dilidili.model.vo.DanmuVO;

import java.util.List;

public interface DanmuService extends IService<Danmu> {

//    获取视频弹幕
    List<DanmuVO> getDanmuByVideoId(Integer video);

//    添加弹幕
    void addDanmu(DanmuDTO danmuDTO);

//    删除弹幕
    void deleteDanmu(Integer id);

}
