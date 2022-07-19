package services;

import entity.ModelEntity;
import mappers.ModelMapper;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Optional;

import static play.mvc.Results.*;

public class ModelService {

    private final ModelMapper modelMapper;

    @Inject
    public ModelService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Result getAll() {
        return ok(Json.toJson(modelMapper.findAll()));
    }

    public Result get(Long id) {

        ModelEntity model = modelMapper.findById(id);

        return (model == null) ? notFound() : ok(Json.toJson(model));
    }

    public Result create(Http.Request request) {
        Optional<ModelEntity> modelEntity = request.body().parseJson(ModelEntity.class);

        if (modelEntity.isEmpty()) {
            return badRequest("Expecting Json data");
        }

        final ModelEntity model = modelEntity.get();

        ModelEntity existingModel = modelMapper.findByTitle(model.getTitle());

        if (existingModel != null) {
            return badRequest("This model already exists");
        } else {
            modelMapper.save(model);
        }

        return ok();
    }

    public Result update(Http.Request request, Long id) {
        Optional<ModelEntity> modelEntity = request.body().parseJson(ModelEntity.class);

        if (modelEntity.isEmpty()) {
            return badRequest("Expecting Json data");
        }

        final ModelEntity model = modelEntity.get();
        model.setId(id);

        ModelEntity existingModel = modelMapper.findById(id);

        if (existingModel != null) {
            modelMapper.update(model);
        } else {
            return notFound();
        }

        return ok();
    }

    public Result delete(Long id) {
        try {
            ModelEntity model = modelMapper.findById(id);

            if (model == null) {
                return notFound();
            }

            modelMapper.deleteById(id);
            return ok();
        } catch (Exception e) {
            return internalServerError(e.getMessage());
        }
    }
}
