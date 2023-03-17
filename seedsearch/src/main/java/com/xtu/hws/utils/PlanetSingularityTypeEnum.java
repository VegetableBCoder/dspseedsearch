package com.xtu.hws.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 
 * @version 1.0, 2023/3/16 14:22
 * @since 1.0.0
 */
@RequiredArgsConstructor
public enum PlanetSingularityTypeEnum {
    NONE(0, ""),
    TIDAL_LOCKED(1, "潮汐锁定,永昼永夜"),
    TIDAL_LOCKED2(2, "轨道共振1:2"),
    TIDAL_LOCKED4(4, "轨道共振1:4"),
    LAY_SIDE(8, "横躺自转"),
    CLOCK_WISE_ROTATE(0x10, "反向自转"),
    MULTIPLE_SATELLITES(0x20, "多卫星"),
    ;
    @Getter
    private final int value;
    @Getter
    private final String name;

    private static final Map<Integer, PlanetSingularityTypeEnum> VALUE_MAP = Arrays.stream(values()).collect(
        Collectors.toMap(PlanetSingularityTypeEnum::getValue, Function.identity()));

    public PlanetSingularityTypeEnum from(Integer value) {
        return value == null ? null : VALUE_MAP.get(value);
    }

    public static List<PlanetSingularityTypeEnum> getSingularity(Integer value) {
        List<PlanetSingularityTypeEnum> result = new ArrayList<>();
        for (PlanetSingularityTypeEnum type : values()) {
            if (type.getValue() != 0 && (value & type.getValue()) == type.getValue()) {
                result.add(type);
            }
        }
        if (result.isEmpty()) {
            return Collections.singletonList(NONE);
        }
        return result;
    }
}
