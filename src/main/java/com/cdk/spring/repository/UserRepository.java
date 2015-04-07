package com.cdk.spring.repository;

import com.cdk.spring.entity.User;
import com.cdk.spring.entity.UserPrimaryKey;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by khana on 3/13/2015.
 */
public interface UserRepository extends CrudRepository<User, UserPrimaryKey> {

}
