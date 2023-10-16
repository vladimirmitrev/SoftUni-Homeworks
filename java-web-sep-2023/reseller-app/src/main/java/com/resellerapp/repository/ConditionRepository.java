package com.resellerapp.repository;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.entity.enums.ConditionNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConditionRepository extends JpaRepository<ConditionEntity, Long> {
    Optional<ConditionEntity> findByConditionNameEnum(ConditionNameEnum conditionNameEnum);
}
