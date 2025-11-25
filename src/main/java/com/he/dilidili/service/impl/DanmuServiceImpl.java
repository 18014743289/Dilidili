package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.mapper.DanmuMapper;
import com.he.dilidili.model.dto.DanmuDTO;
import com.he.dilidili.model.entity.Danmu;
import com.he.dilidili.model.vo.DanmuVO;
import com.he.dilidili.service.DanmuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class DanmuServiceImpl extends ServiceImpl<DanmuMapper, Danmu> implements DanmuService {
    @Override
    public List<DanmuVO> getDanmuByVideoId(Integer video) {
        return List.of();
    }

    @Override
    public void addDanmu(DanmuDTO danmuDTO) {

    }

    @Override
    public void deleteDanmu(Integer id) {

    }
}
