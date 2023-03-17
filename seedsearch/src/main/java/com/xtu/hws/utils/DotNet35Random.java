package com.xtu.hws.utils;

/**
 * @author 
 * @version 1.0, 2023/3/16 20:58
 * @since
 */
public final class DotNet35Random {
    /** 黄金分割数 */
    public static final int PHI = 161803398;
    /** 梅森素数 */
    public static final int MASON_PRIME = (1 << 31) - 1;
    private final int[] seedArray = new int[56];
    private int inext = 0;
    private int inextp = 31;

    public DotNet35Random(int seed) {
        int num = PHI - Math.abs(seed);
        seedArray[55] = num;
        int num2 = 1;
        for (int i = 1; i < 55; i++) {
            int num3 = 21 * i % 55;
            seedArray[num3] = num2;
            num2 = num - num2;
            if (num2 < 0) {
                num2 += MASON_PRIME;
            }
            num = seedArray[num3];
        }
        for (int j = 1; j < 5; j++) {
            for (int k = 1; k < 56; k++) {
                seedArray[k] -= seedArray[1 + (k + 30) % 55];
                if (seedArray[k] < 0) {
                    seedArray[k] += MASON_PRIME;
                }
            }
        }
    }

    private double sample() {
        if (++inext >= 56)
            inext = 1;
        if (++inextp >= 56)
            inextp = 1;
        int num = seedArray[inext] - seedArray[inextp];
        if (num < 0)
            num += 2147483647;
        seedArray[inext] = num;
        return num * 4.6566128752457969E-10;
    }

    public int nextInt() {
        return (int) (sample() * 2147483647.0);
    }

    public long nextInt(int minValue, int maxValue) {
        long num = (long) maxValue - (long) minValue;
        if (num <= 1) {
            return minValue;
        }
        return (long) (sample() * num + minValue);
    }

    public double nextDouble() {
        return sample();
    }
}
