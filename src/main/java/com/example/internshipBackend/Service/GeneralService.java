package com.example.internshipBackend.Service;

import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class GeneralService {
    public void updateEntity(Map<String, Object> entityDTO, Object entityToUpdate, Class entityToUpdateClass) {
// Map key is field name, v is value
        entityDTO.forEach((k, v) -> {
// use reflection to get field k on entityToUpdate and setit to value k
            Field field =
                    ReflectionUtils.findRequiredField(entityToUpdateClass, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, entityToUpdate, v);
        });
    }
}
