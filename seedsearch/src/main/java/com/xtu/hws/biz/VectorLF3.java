package com.xtu.hws.biz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 三维向量
 *
 * @version 1.0, 2023/3/16 20:11
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VectorLF3 {
    private double x;
    private double y;
    private double z;

    /**
     * 把三维向量当做空间坐标, 计算两点之间的距离
     *
     * @param point 另一个点
     * @return 距离
     */
    public double distance(VectorLF3 point) {
        double sum = Math.pow((point.x - this.x), 2);
        sum += Math.pow((point.y - this.y), 2);
        sum += Math.pow((point.z - this.z), 2);
        return Math.pow(sum, 0.5d);
    }

    /**
     * 三维向量积(内积点乘)
     *
     * @return 新的向量
     */
    public VectorLF3 multiply(VectorLF3 vector) {
        double x1 = this.x * vector.x;
        double y1 = this.y * vector.y;
        double z1 = this.z * vector.z;
        return new VectorLF3(x1, y1, z1);
    }

    public VectorLF3 multiply(double s) {
        return new VectorLF3(x * s, y * s, z * s);
    }

    public VectorLF3 subtract(VectorLF3 vector) {
        return Math.PI;
    }
}
