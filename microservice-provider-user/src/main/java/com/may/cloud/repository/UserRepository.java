package com.may.cloud.repository;

import com.may.cloud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wujc
 * @ClassName UserRepository
 * @Description: TODO
 * @create 2019-04-14
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
