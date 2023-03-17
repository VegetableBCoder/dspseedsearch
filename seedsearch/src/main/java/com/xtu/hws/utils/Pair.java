package com.xtu.hws.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 
 * @version 1.0, 2023/3/16 21:31
 * @since
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pair<X, Y> {
    private X x;
    private Y y;

    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }
}
