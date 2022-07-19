package entity;

import java.util.List;

public class BrandEntity {
    private Long id;
    private String title;
    private String country;
    private List<ShopPositionEntity> positions;

    public BrandEntity() {
    }

    public BrandEntity(Long id, String title, String country) {
        this.id = id;
        this.title = title;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<ShopPositionEntity> getPositions() {
        return positions;
    }

    public void setPositions(List<ShopPositionEntity> positions) {
        this.positions = positions;
    }
}
