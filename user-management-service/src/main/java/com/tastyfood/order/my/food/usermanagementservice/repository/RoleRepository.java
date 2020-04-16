package com.tastyfood.order.my.food.usermanagementservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tastyfood.order.my.food.usermanagementservice.model.Role;
import com.tastyfood.order.my.food.usermanagementservice.model.RoleName;
 

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}