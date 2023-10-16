package com.resellerapp.service;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.entity.enums.ConditionNameEnum;

public interface ConditionService {
    void initConditions();

    ConditionEntity findByConditionNameEnum(ConditionNameEnum conditionNameEnum);
}
