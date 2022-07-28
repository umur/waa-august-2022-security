package com.miu.Lab3.utils;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class MappingUtils {
    public static ModelMapper getMapper(){
        return  new ModelMapper();
    }
    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> getMapper().map(element, targetClass))
                .collect(Collectors.toList());
    }
}
