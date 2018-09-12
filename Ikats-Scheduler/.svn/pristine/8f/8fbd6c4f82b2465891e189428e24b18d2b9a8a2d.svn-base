package com.ikats.scheduler.ibatis.repository;


import com.ikats.scheduler.entity.bean.SZEmailBean;
import com.ikats.scheduler.ibatis.mapper.SZEmailMapper;
import com.ikats.scheduler.repository.ISZEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public class SZEmailRepository implements ISZEmailRepository{

	@Autowired
	private SZEmailMapper mapper;

    @Override
    public Long insert(SZEmailBean record)
	{
		return mapper.insert(record);
	}


    @Override
    public Long selectCount(Map<String, String> express)
	{
		return mapper.selectCount(express);
	}
}
