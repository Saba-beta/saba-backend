package saba.example.domain.spot.spi;

import saba.example.domain.spot.model.Spot;

public interface SpotQueryPort {
    Spot save(Spot spot);
}
