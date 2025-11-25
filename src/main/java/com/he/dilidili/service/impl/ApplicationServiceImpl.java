package com.he.dilidili.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.config.OssConfig;
import com.he.dilidili.common.result.PageResult;
import com.he.dilidili.convert.ApplicationConvert;
import com.he.dilidili.mapper.ApplicationMapper;
import com.he.dilidili.model.dto.ApplicationDTO;
import com.he.dilidili.model.entity.Application;
import com.he.dilidili.model.query.Query;
import com.he.dilidili.model.vo.ApplicationVO;
import com.he.dilidili.service.ApplicationService;
import com.he.dilidili.utils.UpLoadUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {
    UpLoadUtils uploadUtils;
    @Override
    public PageResult<ApplicationVO> getPage(Query query) {
        Page<ApplicationVO> page = new Page<>(query.getPage(), query.getLimit());

        return null;
    }

    @Override
    public void update(ApplicationDTO applicationDTO) {

    }

    @Override
    public void insert(ApplicationDTO applicationDTO) {
        Application application = ApplicationConvert.INSTANCE.convert(applicationDTO);
        application.setCertificate(uploadUtils.uploadFile(applicationDTO.getImg()));
        application.setApplicant(RequestContext.getUserId());
        application.setCreateTime(LocalDateTime.now());
        baseMapper.insert(application);
    }

}
