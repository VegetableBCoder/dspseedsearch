package com.xtu.hws.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 
 * @version 1.0, 2023/3/16 19:38
 * @since
 */
@RequiredArgsConstructor
public enum PlanetTypeEnum {
    NONE(0, ""),
    VOLCANO(1, "火山灰"),
    OCEAN(2, "水世界"),
    DESERT(3, "沙漠?"),
    ICE(4, "冰巨星"),
    GAS(5, "气态巨星"),
    ;
    @Getter
    private final int value;
    @Getter
    private final String name;

    private static final Map<Integer, PlanetTypeEnum> VALUE_MAP = Arrays.stream(values()).collect(
        Collectors.toMap(PlanetTypeEnum::getValue, Function.identity()));

    public PlanetTypeEnum from(Integer value) {
        return value == null ? null : VALUE_MAP.get(value);
    }
}
