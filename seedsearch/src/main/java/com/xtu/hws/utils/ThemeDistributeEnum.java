package com.xtu.hws.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 
 * @version 1.0, 2023/3/16 19:42
 * @since
 */
@RequiredArgsConstructor
public enum ThemeDistributeEnum {
    DEFAULT(0),
    BIRTH(1),
    INTERSTELLAR(2),
    RARE(3),
    ;
    @Getter
    private final int value;

    private static final Map<Integer, ThemeDistributeEnum> VALUE_MAP = Arrays.stream(values()).collect(
        Collectors.toMap(ThemeDistributeEnum::getValue, Function.identity()));

    public ThemeDistributeEnum from(Integer value) {
        return value == null ? null : VALUE_MAP.get(value);
    }
}
