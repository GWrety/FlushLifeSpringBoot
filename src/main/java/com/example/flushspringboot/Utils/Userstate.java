package com.example.flushspringboot.Utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity(name = "userstate")
public class Userstate {

    //这里主要是用了 usage的id 充当userstate的id 由于save无法保存已经有id的数据 所以需要淡出处理一下
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "myid")
    @GenericGenerator(name = "myid", strategy = "com.example.flushspringboot.config.ManulInsertGenerator")
    private Integer id;


    //这里用sqldate
    private Date enrolltime;
    private Integer feeltimes;
    private Integer breathetimes;


}

/**
 *  自定义的主键生成策略，如果填写了主键id，如果数据库中没有这条记录，则新增指定id的记录；否则更新记录
 *
 *  如果不填写主键id，则利用数据库本身的自增策略指定id
 *
 * Created by @author yihui in 20:51 19/11/13.
 */
