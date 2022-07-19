package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.ModelService;
import services.ShopPositionService;

import javax.inject.Inject;

public class ShopPositionController extends Controller {

    private final ShopPositionService shopPositionService;

    @Inject
    public ShopPositionController(ShopPositionService shopPositionService) {
        this.shopPositionService = shopPositionService;
    }

    public Result getAllPositions() {
        return shopPositionService.getAll();
    }

    public Result getBrandPositions(Long brand_id) {
        return shopPositionService.getBrandPositions(brand_id);
    }

    public Result getPosition(Long id) {
        return shopPositionService.get(id);
    }

    public Result create(Http.Request request) {
        return  shopPositionService.create(request);
    }

    public Result update(Http.Request request, Long id) {
        return shopPositionService.update(request, id);
    }

    public Result delete(Long id) {
        return shopPositionService.delete(id);
    }

    public Result getPositionsByBrandAndModel(String brand, String model) {
        return shopPositionService.getPositionsByBrandModel(brand, model);
    }

}
