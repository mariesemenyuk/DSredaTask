package mappers;

import entity.BrandEntity;
import entity.ShopPositionEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BrandMapper {
    @Select("select * from brand")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="title", column="title"),
            @Result(property="country", column="country"),
            @Result(property="positions", column = "id", javaType=List.class,
                    many=@Many(select="getPositions"))
    })
    List<BrandEntity> findAll();

    @Select("select * from brand where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "country", column = "country"),
            @Result(property="positions", column = "id", javaType=List.class,
                    many=@Many(select="getPositions"))})
    public BrandEntity findById(@Param("id") Long id);

    @Select("select * from brand where title = #{title}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="title", column="title"),
            @Result(property="country", column="country"),
            @Result(property="positions", column = "id", javaType=List.class,
                    many=@Many(select="getPositions"))
    })
    BrandEntity findByTitle(@Param("title") String title);

    @Insert("insert into brand (title, country) VALUES(#{title}, #{country})")
    void save(BrandEntity brand);

    @Update("UPDATE brand SET title = #{title}, country = #{country} WHERE id = #{id}")
    void update(BrandEntity brand);

    @Delete("delete from brand where id=#{id} ")
    public boolean deleteById(@Param("id") Long id);

    @Select("SELECT * FROM shop_position WHERE shop_position.brand_id = #{id}")
    List<ShopPositionEntity> getPositions(Long id);
}
