package mappers;

import entity.ModelEntity;
import entity.ShopPositionEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ModelMapper {
    @Select("select * from model")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="title", column="title"),
            @Result(property="productionStarted", column="production_start"),
            @Result(property="productionFinished", column="production_finish"),
    })
    List<ModelEntity> findAll();

    @Select("select * from model where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "productionStarted", column = "production_start"),
            @Result(property = "productionFinished", column = "production_finish")})
    ModelEntity findById(@Param("id") Long id);

    @Select("select * from model where title = #{title}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "productionStarted", column = "production_start"),
            @Result(property = "productionFinished", column = "production_finish")})
    ModelEntity findByTitle(@Param("title") String title);

    @Insert("insert into model (title, production_start, production_finish) " +
            "VALUES(#{title}, #{productionStarted}, #{productionFinished})")
    void save(ModelEntity brand);

    @Update("UPDATE model SET title = #{title}, production_start = #{productionStarted}, " +
            "production_finish = #{productionFinished} WHERE id = #{id}")
    void update(ModelEntity brand);

    @Delete("delete from model where id=#{id} ")
    boolean deleteById(@Param("id") Long id);
}
