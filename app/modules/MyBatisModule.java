package modules;

import com.google.inject.Provider;
import com.google.inject.name.Names;
import mappers.BrandMapper;
import mappers.ModelMapper;
import mappers.ShopPositionMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import play.db.Database;

import javax.inject.Inject;
import javax.sql.DataSource;

public class MyBatisModule extends org.mybatis.guice.MyBatisModule {

    @Override
    protected void initialize() {
        environmentId("development");
        bindConstant().annotatedWith(
                            Names.named("mybatis.configuration.failFast")).
                    to(true);
        bindDataSourceProviderType(PlayDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);

        addMapperClass(BrandMapper.class);
        addMapperClass(ModelMapper.class);
        addMapperClass(ShopPositionMapper.class);
    }


    static class PlayDataSourceProvider implements Provider<DataSource> {

        final Database db;

        @Inject
        public PlayDataSourceProvider(final Database db) {
            this.db = db;
        }

        @Override
        public DataSource get() {
            return db.getDataSource();
        }

    }
}
