package com.xtu.hws.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 光谱类型
 *
 * @version 1.0, 2023/3/16 14:08
 * @since
 */
@RequiredArgsConstructor
public enum SpectrumTypeEnum {
    M(0, "M型恒星", "红巨星:M"),
    K(1, "K型恒星", "红巨星:K"),
    G(2, "G型恒星", "黄巨星:G"),
    F(3, "F型恒星", "黄巨星:F"),
    A(4, "A型恒星", "白巨星:A"),
    B(5, "B型恒星", "蓝巨星:B"),
    O(6, "O型恒星", "蓝巨星:O"),
    X(7, "无光谱", "未知巨星"),
    ;
    @Getter
    private final int value;
    @Getter
    private final String name;
    @Getter
    private final String giantName;

    private static final Map<Integer, SpectrumTypeEnum> VALUE_MAP = Arrays.stream(values()).collect(
        Collectors.toMap(SpectrumTypeEnum::getValue, Function.identity()));

    public SpectrumTypeEnum from(Integer value) {
        return value == null ? null : VALUE_MAP.get(value);
    }
}

