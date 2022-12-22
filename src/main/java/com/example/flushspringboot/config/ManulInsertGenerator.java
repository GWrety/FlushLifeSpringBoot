package com.example.flushspringboot.config;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

public class ManulInsertGenerator extends IdentityGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) throws HibernateException {
        Serializable id = (Serializable) s.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, s);
        //本质上就是判断对象有没有可用的id   有就返回 没有就新增   之后是insert还是update交给下一步
        if (id != null && Integer.valueOf(id.toString()) > 0) {
            return id;
        } else {
            return (Serializable) super.generate(s, obj);
        }
    }
}
