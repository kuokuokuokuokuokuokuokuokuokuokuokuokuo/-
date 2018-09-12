package com.ikats.scheduler.ibatis.repository;

import com.ikats.scheduler.entity.bean.ClientBean;
import com.ikats.scheduler.ibatis.mapper.ClientMapper;
import com.ikats.scheduler.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * Repository
 * 
 * 管易取消订单数据操作
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-18 09:53:44
 */
@Repository
public class ClientRepository implements IClientRepository{

	@Autowired
	private ClientMapper mapper;

	@Override
	public List<ClientBean> selectEffectiveClient() {
		return this.mapper.selectEffectiveClient();
	}
}
