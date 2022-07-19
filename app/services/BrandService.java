package services;

import entity.BrandEntity;
import mappers.BrandMapper;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static play.mvc.Results.*;

public class BrandService {

    private final BrandMapper brandMapper;

    @Inject
    public BrandService(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    public Result getAll() {
        return ok(Json.toJson(brandMapper.findAll()));
    }

    public Result get(Long id) {

        BrandEntity brand = brandMapper.findById(id);

        return (brand == null) ? notFound() : ok(Json.toJson(brand));
    }

    public Result create(Http.Request request) {
        Optional<BrandEntity> brandEntity = request.body().parseJson(BrandEntity.class);

        if (brandEntity.isEmpty()) {
            return badRequest("Expecting Json data");
        }

        final BrandEntity brand = brandEntity.get();

        BrandEntity existingBrand = brandMapper.findByTitle(brand.getTitle());

        if (existingBrand != null) {
            return badRequest("This brand already exists");
        } else {
            brandMapper.save(brand);
        }

        return ok();
    }

    public Result update(Http.Request request, Long id) {
        Optional<BrandEntity> brandEntity = request.body().parseJson(BrandEntity.class);

        if (brandEntity.isEmpty()) {
            return badRequest("Expecting Json data");
        }

        final BrandEntity brand = brandEntity.get();
        brand.setId(id);

        BrandEntity existingBrand = brandMapper.findById(id);

        if (existingBrand != null) {
            brandMapper.update(brand);
        } else {
            return notFound();
        }

        return ok();
    }

    public Result delete(Long id) {
        try {
            BrandEntity brand = brandMapper.findById(id);

            if (brand == null) {
                return notFound();
            }

            brandMapper.deleteById(id);
            return ok();
        } catch (Exception e) {
            return internalServerError(e.getMessage());
        }
    }
}
