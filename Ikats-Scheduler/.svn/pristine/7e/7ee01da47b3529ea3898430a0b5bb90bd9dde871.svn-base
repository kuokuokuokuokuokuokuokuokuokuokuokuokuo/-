package com.ikats.scheduler.ibatis.repository;

import com.ikats.scheduler.entity.bean.DmsSettlementRecordBean;
import com.ikats.scheduler.ibatis.mapper.DmsSettlementRecordMapper;
import com.ikats.scheduler.repository.IDmsSettlementRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : liu kuo
 * @Date : 2017/11/17 13:56.
 * @Description : Indulge in study , wasting away
 */

@Repository
public class DmsSettlementRecordRepository implements IDmsSettlementRecordRepository
{

    @Autowired
    private DmsSettlementRecordMapper mapper;

    @Override
    public DmsSettlementRecordBean selectByKey(Long id) {
        return mapper.selectByKey(id);
    }

    @Override
    public int insert(DmsSettlementRecordBean bean) {
        return mapper.insert(bean);
    }

    @Override
    public List<DmsSettlementRecordBean> selectAllRecord() {
        return this.mapper.selectAllRecord();
    }

    @Override
    public int insertList(List<DmsSettlementRecordBean> list) {
        return this.mapper.insertList(list);
    }
}
