package com.ikats.scheduler.ibatis.repository;

import com.ikats.scheduler.entity.bean.JSTAllocateBean;
import com.ikats.scheduler.ibatis.mapper.JSTAllocateMapper;
import com.ikats.scheduler.repository.IJSTAllocateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao Jianzhen
 * @Date: Created in 10:30 2018/1/4
 * @Description:
 */
@Repository
public class JSTAllocateRepository implements IJSTAllocateRepository {

    @Autowired
    private JSTAllocateMapper mapper;

    /** 添加单条记录 */
    @Override
    public int insert(JSTAllocateBean record)
    {
        return mapper.insert(record);
    }

    /** 添加一批记录 */
    @Override
    public int insertList(List<JSTAllocateBean> records)
    {
        return mapper.insertList(records);
    }

    /** 删除记录 - 根据主键 */
    @Override
    public int delete(Long id)
    {
        return mapper.delete(id);
    }

    /** 更新记录 - 根据主键 */
    @Override
    public int update(JSTAllocateBean record)
    {
        return mapper.update(record);
    }

    /** 查询记录 - 根据主键 */
    @Override
    public JSTAllocateBean selectByKey(Long id)
    {
        return mapper.selectByKey(id);
    }

    /** 所有记录计数 */
    @Override
    public Long selectCount(Map<String, String> express)
    {
        return mapper.selectCount(express);
    }

    /** 筛选记录 */
    @Override
    public List<JSTAllocateBean> selectByQuery(Map<String, String> express)
    {
        return mapper.selectByQuery(express);
    }

    /** 分页查询 */
    @Override
    public List<JSTAllocateBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express)
    {
        pageNum = pageSize * (pageNum - 1);
        return mapper.pageByQuery(pageNum,pageSize,express);
    }

    @Override
    public void updateByoutboundId(JSTAllocateBean bean)
    {
        this.mapper.updateByoutboundId(bean);
    }

    @Override
    public List<JSTAllocateBean> selectByNo(String orderNo) {
        return this.mapper.selectByNo(orderNo);
    }

    @Override
    public List<JSTAllocateBean> getAllocateSendJob() {
        return this.mapper.getAllocateSendJob();
    }
}
