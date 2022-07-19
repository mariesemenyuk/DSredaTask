package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.ModelService;

import javax.inject.Inject;

public class ModelController extends Controller {

    private final ModelService modelService;

    @Inject
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    public Result getAllModels() {
        return modelService.getAll();
    }

    public Result getModel(Long id) {
        return modelService.get(id);
    }

    public Result create(Http.Request request) {
        return  modelService.create(request);
    }

    public Result update(Http.Request request, Long id) {
        return modelService.update(request, id);
    }

    public Result delete(Long id) {
        return modelService.delete(id);
    }
}
