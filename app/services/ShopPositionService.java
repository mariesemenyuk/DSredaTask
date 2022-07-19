package services;

import entity.BrandEntity;
import entity.ModelEntity;
import entity.ShopPositionEntity;
import mappers.BrandMapper;
import mappers.ModelMapper;
import mappers.ShopPositionMapper;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static play.mvc.Results.*;

public class ShopPositionService {

    private final ShopPositionMapper shopPositionMapper;
    private final BrandMapper brandMapper;
    private final ModelMapper modelMapper;

    @Inject
    public ShopPositionService(ShopPositionMapper shopPositionMapper, BrandMapper brandMapper, ModelMapper modelMapper) {
        this.shopPositionMapper = shopPositionMapper;
        this.brandMapper = brandMapper;
        this.modelMapper = modelMapper;
    }

    public Result getAll() {
        return ok(Json.toJson(shopPositionMapper.findAll()));
    }

    public Result getPositionsByBrandModel(String brandTitle, String modelTitle) {
        BrandEntity brand = brandMapper.findByTitle(brandTitle);
        ModelEntity model = modelMapper.findByTitle(modelTitle);
        List<ShopPositionEntity> shopPositionEntities = shopPositionMapper.selectShopPositions(brand.getId());
        List<ShopPositionEntity> resultList = new ArrayList<>();
        for (ShopPositionEntity position: shopPositionEntities) {
            if(position.getModel_id() == model.getId()) {
                resultList.add(position);
            }
        }
        return ok(Json.toJson(resultList));
    }

    public Result getBrandPositions(Long brand_id) {
        return ok(Json.toJson(shopPositionMapper.selectShopPositions(brand_id)));
    }

    public Result get(Long id) {

        ShopPositionEntity shopPosition = shopPositionMapper.findById(id);

        return (shopPosition == null) ? notFound() : ok(Json.toJson(shopPosition));
    }

    public Result create(Http.Request request) {
        Optional<ShopPositionEntity> shopPositionEntity = request.body().parseJson(ShopPositionEntity.class);

        if (shopPositionEntity.isEmpty()) {
            return badRequest("Expecting Json data");
        }

        final ShopPositionEntity shopPosition = shopPositionEntity.get();
        shopPositionMapper.save(shopPosition);

        return ok();
    }

    public Result update(Http.Request request, Long id) {
        Optional<ShopPositionEntity> shopPositionEntity = request.body().parseJson(ShopPositionEntity.class);

        if (shopPositionEntity.isEmpty()) {
            return badRequest("Expecting Json data");
        }

        final ShopPositionEntity shopPosition = shopPositionEntity.get();
        shopPosition.setId(id);

        ShopPositionEntity existingPosition = shopPositionMapper.findById(id);

        if (existingPosition != null) {
            shopPositionMapper.update(shopPosition);
        } else {
            return notFound();
        }

        return ok();
    }

    public Result delete(Long id) {
        try {
            ShopPositionEntity shopPosition = shopPositionMapper.findById(id);

            if (shopPosition == null) {
                return notFound();
            }

            shopPositionMapper.deleteById(id);
            return ok();
        } catch (Exception e) {
            return internalServerError(e.getMessage());
        }
    }
}
