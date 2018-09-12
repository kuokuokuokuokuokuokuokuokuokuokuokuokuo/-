package com.ikats.scheduler.logic;

import com.ikats.scheduler.entity.bean.SZEmailBean;
import com.ikats.scheduler.repository.ISZEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

@Component
@Transactional
public class SZEmailLogic extends AbstractLogic {

    @Autowired
    private ISZEmailRepository repository;

    public void insert(SZEmailBean bean) {
        Long count = repository.insert(bean);
        if (count <= 0) {
            this.setSuccess(false);
            this.setMessage("没有新增");

            return;
        }
        this.setSuccess(true);
    }


    public Long selectCount(Map<String, String> express)
    {
        Long count = repository.selectCount(express);
        this.setSuccess(true);
        return count;
    }
}
