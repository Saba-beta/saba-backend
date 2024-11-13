package saba.example.domain.spot.model;

import lombok.Builder;
import lombok.Getter;
import org.locationtech.jts.geom.Point;
import saba.example.common.annotation.Aggregate;
import saba.example.domain.spot.model.emun.Category;

@Aggregate
@Getter
@Builder(toBuilder = true)
public class Spot {
    private Long id;
    private String name;
    private Category category;
    private Point point;
    /*
    저장하는 식
    Point point = (Point) new WKTReader().read(String.format("POINT(%s %s)", latitude, longitude));
    */
}
