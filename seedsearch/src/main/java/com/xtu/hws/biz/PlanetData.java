package com.xtu.hws.biz;

import com.xtu.hws.utils.PlanetSingularityTypeEnum;
import com.xtu.hws.utils.PlanetTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 
 * @version 1.0, 2023/3/16 19:16
 * @since
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors
public class PlanetData {
    private Integer id;
    private Integer index;
    private Integer seed;
    private Integer infoSeed;
    private Integer orbitAround;
    private String name;
    private String overrideName;
    private Float orbitRadius = 1F;
    private Float orbitInclination;
    private Float orbitLongitude;
    private Double orbitalPeriod = 3600D;
    private Float orbitPhase;
    private Float obliquity;
    private Double rotationPeriod = 480D;
    private Float rotationPhase;
    private Float radius = 200.0F;
    private Float scale = 1.0F;
    private Float sunDistance;
    private Float habitableBias;
    private Float temperatureBias;
    private Float ionHeight;
    private Float windStrength;
    private Float luminosity;
    private Float landPercent;
    private Double modX;
    private Double modY;
    private Float waterHeight;
    private Integer waterItemId;
    private Boolean levelized;
    private Integer iceFlag;
    private PlanetTypeEnum type;
    private Integer singularity;
    private Integer theme;
    private Integer algoId;
    private Integer style;
    private List<PlanetData> orbitAroundPlanet;
    private List<Integer> gasItems;
    private List<Float> gasSpeeds;

    public float realRadius() {
        return radius * scale;
    }

    public String GetPlanetSingularityString() {
        StringBuilder result = new StringBuilder();
        if (orbitAround > 0) {
            result.append(" 卫星");
        }
        PlanetSingularityTypeEnum.getSingularity(singularity).
            stream()
            .map(PlanetSingularityTypeEnum::getName)
            .forEach(singularityName -> result.append(" ").append(singularityName));
        return result.toString();
    }
}
