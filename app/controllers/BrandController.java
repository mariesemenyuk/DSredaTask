package controllers;

import javax.inject.Inject;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.BrandService;

public class BrandController extends Controller {

    private final BrandService brandService;

    @Inject
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    public Result getAllBrands() {
        return brandService.getAll();
    }

    public Result getBrand(Long id) {
        return brandService.get(id);
    }

    public Result create(Http.Request request) {
        return  brandService.create(request);
    }

    public Result update(Http.Request request, Long id) {
        return brandService.update(request, id);
    }

    public Result delete(Long id) {
        return brandService.delete(id);
    }
}
