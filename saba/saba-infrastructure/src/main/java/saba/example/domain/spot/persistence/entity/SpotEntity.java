package saba.example.domain.spot.persistence.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import saba.example.domain.spot.model.emun.Category;

@Table(name = "tbl_spot")
@Entity
@NoArgsConstructor
public class SpotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Category category;
    private Point point;

}
