package com.example.gamestore.util;

import jakarta.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

    <E> boolean isValid(E entity);
    <E> Set<ConstraintViolation<E>> getViolations(E entity);
}
