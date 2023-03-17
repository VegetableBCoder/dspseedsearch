package com.xtu.hws.biz;

import com.xtu.hws.utils.SpectrumTypeEnum;
import com.xtu.hws.utils.StartTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * @author 
 * @version 1.0, 2023/3/16 19:47
 * @since
 */
@Data
public class StarData {
    private Integer seed;
    private Integer index;
    private Integer id;
    private String name;
    private String overrideName;
    private VectorLF3 position;
    private VectorLF3 uPosition;
    private Float mass = 1.0f;
    private Float lifetime = 50.0f;
    private Float age;
    private StartTypeEnum type;
    private Float temperature = 8500.0f;
    private SpectrumTypeEnum spectr;
    private Float classFactor;
    private Float color;
    private Float luminosity = 1.0f;
    private Float radius = 1.0f;
    private Float acdiskRadius;
    private Float habitableRadius = 1.0f;
    private Float lightBalanceRadius = 1.0f;
    private Float dysonRadius = 10.0f;
    private Float orbitScaler = 1.0f;
    private Float asterBelt1OrbitIndex;
    private Float asterBelt2OrbitIndex;
    private Float asterBelt1Radius;
    private Float asterBelt2Radius;
    private Integer planetCount;
    private Float level;
    private Float resourceCoef = 1.0f;

    List<PlanetData> planets;

    public float physicsRadius() {
        return radius * 1200;
    }

    public float dysonLuminosity() {
        return Math.round((float) Math.pow(luminosity, 0.33000001311302185) * 1000.0f) / 1000.0f;
    }

    public String getStartTypeName() {
        switch (type) {
            case GIANT_STAR:
                return this.spectr.getGiantName();
            case WHITE_DWARF_STAR, NEUTRON_STAR, BLACK_HOLE:
                return this.type.getName();
            default:
        }
        return this.spectr.getName();
    }
}
