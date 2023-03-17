package com.xtu.hws.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 
 * @version 1.0, 2023/3/16 14:18
 * @since
 */
@RequiredArgsConstructor
public enum StartTypeEnum {
    MAIN_SEQ_STAR(0, "主序星"),
    GIANT_STAR(1, "巨星"),
    WHITE_DWARF_STAR(2, "白矮星"),
    NEUTRON_STAR(3, "中子星"),
    BLACK_HOLE(4, "黑洞"),
    ;
    @Getter
    private final int value;
    @Getter
    private final String name;

    private static final Map<Integer, StartTypeEnum> VALUE_MAP = Arrays.stream(values()).collect(
        Collectors.toMap(StartTypeEnum::getValue, Function.identity()));

    public StartTypeEnum from(Integer value) {
        return value == null ? null : VALUE_MAP.get(value);
    }
}
