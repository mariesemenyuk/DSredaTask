package mappers;

import entity.BrandEntity;
import entity.ModelEntity;
import entity.ShopPositionEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopPositionMapper {

    @Select("select * from shop_position")
    List<ShopPositionEntity> findAll();

    @Select("select * from shop_position where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "brand_id", column = "brand_id"),
            @Result(property = "model_id", column = "model_id"),
            @Result(property = "year_prod", column = "year_prod"),
            @Result(property = "mileage", column = "mileage"),
            @Result(property = "price", column = "price")})
    ShopPositionEntity findById(@Param("id") Long id);

    @Insert("insert into shop_position (brand_id, model_id, year_prod, mileage, price) " +
            "VALUES(#{brand_id}, #{model_id}, #{year_prod}, #{mileage}, #{price})")
    void save(ShopPositionEntity brand);

    @Update("UPDATE shop_position SET brand_id = #{brand_id}, model_id = #{model_id}, " +
            "year_prod = #{year_prod}, mileage = #{mileage}, price = #{price} WHERE id = #{id}")
    void update(ShopPositionEntity shopPosition);

    @Delete("delete from shop_position where id=#{id} ")
    public boolean deleteById(@Param("id") Long id);

    // Many To One

    @Select("SELECT * FROM shop_position WHERE brand_id = #{brandId}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "brand_id", column = "brand_id"),
            @Result(property = "model_id", column = "model_id"),
            @Result(property = "year_prod", column = "year_prod"),
            @Result(property = "mileage", column = "mileage"),
            @Result(property = "price", column = "price")
    })
    List<ShopPositionEntity> selectShopPositions(Long brandId);

    @Select("SELECT * FROM brand")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "country", column = "country"),
            @Result(property = "positions", column = "id", javaType = List.class,
                    many=@Many(select = "selectShopPositions"))
    })
    public List<BrandEntity> getAllBrands();
}
