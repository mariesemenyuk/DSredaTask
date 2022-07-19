package entity;

public class ModelEntity {
    private Long id;
    private String title;
    private int productionStarted;
    private int productionFinished;

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

    public int getProductionStarted() {
        return productionStarted;
    }

    public void setProductionStarted(int productionStarted) {
        this.productionStarted = productionStarted;
    }

    public int getProductionFinished() {
        return productionFinished;
    }

    public void setProductionFinished(int productionFinished) {
        this.productionFinished = productionFinished;
    }
}
