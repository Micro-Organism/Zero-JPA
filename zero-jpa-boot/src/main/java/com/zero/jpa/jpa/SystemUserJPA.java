package com.zero.jpa.jpa;

import com.zero.jpa.domain.entity.SystemUserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.io.Serializable;
import java.util.List;

/**
 * JPA 提供了许多接口不用自己再去写底层封装了
 * 按照命名规则来定义方法，即可以操作数据库了，如查询：findBy + 实体属性名, get + 实体类名 + By + 实体属性名,...
 * 还可以使用@Query注解，直接语句查询...
 * 按照Spring Data JPA 定义的规则为：findBy + 实体属性名, get + 实体类名 + By + 实体属性名,...条件属性首字母需大写。
 */
public interface SystemUserJPA extends JpaRepository<SystemUserEntity, Long>, JpaSpecificationExecutor<SystemUserEntity>, Serializable {

    //按名称查找所有用户
    List<SystemUserEntity> findByName(String userName);

    //按姓名查找单个用户
    SystemUserEntity getUserEntityByName(String userName);

    //按姓名查找单个用户 使用Query注解方式，默认是jpql语句对应实体类操作，如有需要加上nativeQuery=true来声明这是一个本地查询（sql查询）
    @Query("select u from SystemUserEntity u where u.username = ?1")
    SystemUserEntity findUserEntityByName(String userName);

//    //按姓名查找单个用户 使用原生SQL语句查询方式
//    @Query(value = "select * from t_user where t_name = ?1", nativeQuery = true)
//    SystemUserEntity findUserEntityByName(String userName);

    //根据名称删除用户
    @Transactional
    void deleteByName(String userName);

}