package com.ikats.scheduler.logic;

import com.ikats.scheduler.entity.bean.ClientBean;
import com.ikats.scheduler.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Component
@Transactional
public class ClientLogic extends AbstractLogic {

    @Autowired
    private IClientRepository repository;

    public List<ClientBean> selectEffectiveClient()
    {
        List<ClientBean> clients = repository.selectEffectiveClient();
        this.setSuccess(true);
        return clients;
    }
}
