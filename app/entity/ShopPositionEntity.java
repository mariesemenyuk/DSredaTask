package entity;

public class ShopPositionEntity {
    private Long id;
    private int brand_id;
    private int model_id;
    private int year_prod;
    private int mileage;
    private long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public int getYear_prod() {
        return year_prod;
    }

    public void setYear_prod(int year_prod) {
        this.year_prod = year_prod;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
