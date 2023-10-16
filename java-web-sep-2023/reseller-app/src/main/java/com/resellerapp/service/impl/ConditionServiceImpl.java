package com.resellerapp.service.impl;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.entity.enums.ConditionNameEnum;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.service.ConditionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.resellerapp.model.entity.enums.ConditionNameEnum.EXCELLENT;
@Service
public class ConditionServiceImpl implements ConditionService {


    private static final String EXCELLENT_CONDITION = "In perfect condition";
    private static final String GOOD_CONDITION = "Some signs of wear and tear or minor defects";
    private static final String ACCEPTABLE_CONDITION = "The item is fairly worn but continues to function properly";
    private final ConditionRepository conditionRepository;

    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void initConditions() {

        if (conditionRepository.count() != 0) {
            return;
        }

        Arrays.stream(ConditionNameEnum.values())
                .forEach(conditionNameEnum -> {
                    ConditionEntity condition = new ConditionEntity();
                    condition.setConditionNameEnum(conditionNameEnum);
                    switch (conditionNameEnum) {
                        case EXCELLENT:
                            condition.setDescription(EXCELLENT_CONDITION);
                            break;
                        case GOOD:
                            condition.setDescription(GOOD_CONDITION);
                            break;
                        case ACCEPTABLE:
                            condition.setDescription(ACCEPTABLE_CONDITION);
                            break;
                    }

                    conditionRepository.save(condition);
                });

    }

    @Override
    public ConditionEntity findByConditionNameEnum(ConditionNameEnum conditionNameEnum) {
        return conditionRepository
                .findByConditionNameEnum(conditionNameEnum)
                .orElse(null);
    }
}
