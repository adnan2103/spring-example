package com.cdk.spring.config;


import com.zaxxer.hikari.HikariDataSource;
import org.h2.jdbcx.JdbcDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Spring configuration for database data source.
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(DataSourceConfig.class);

    /**
     * This method populates the listed db schemas
     * 
     * @param schemas
     *            schema holder
     * @return DatabasePopulator 
     *          populates the database
     */
    @Bean
    public DatabasePopulator databasePopulator(
            @Qualifier("databaseSchemaHolder") final SchemaResourceHolder schemas) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.setContinueOnError(true);
        for (Resource schema : schemas.getSchemas()) {
            populator.addScript(schema);
        }
        return populator;
    }

    /**
     * Provides a list of {@link Resource Resources} that are used to initialize
     * the data store. The default bean will return an empty list. It should be
     * overridden if database initialization is desired.
     *
     * @return An empty list.
     */
    @Bean(name = "databaseSchemaHolder")
    public SchemaResourceHolder databaseSchemaHolder() {
        return new SchemaResourceHolder();
    }

    /**
     * Provides a {@link DataSourceInitializer} object that Spring will use to
     * load zero or more initializing scripts.
     *
     * @param dataSource
     *            The dataSource representing the database into which the
     *            scripts should be loaded
     * @param databasePopulator
     *            The database populator
     * @return DataSourceInitializer returns the Initialized DataSource
     */
    @Bean
    public DataSourceInitializer dataSourceInitializer(
            final DataSource dataSource,
            final DatabasePopulator databasePopulator) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator);
        return initializer;
    }

    /**
     * Data source configuration for a Postgresql database
     */
    @Configuration
    @Profile("postgres")
    public static class PostgresDataSourceConfiguration {

        @Value("${jdbc.databaseName}")
        private String databaseName;

        @Value("${jdbc.datasourceClassName}")
        private String datasourceClass;

        @Value("${jdbc.password}")
        private String jdbcPassword;

        @Value("${jdbc.user}")
        private String jdbcUser;

        @Value("${jdbc.maxPoolSize}")
        private Integer maxPoolSize;

        @Value("${jdbc.serverName}")
        private String serverName;

        /**
         * This provides the Hikari data source for Postgresql
         *
         * @return DataSource Postgresql DataSource
         */
        @Bean
        public DataSource cmpDataSource() {
            LOGGER.info("Creating Postgres DataSource with {} for user {}",
                    serverName, jdbcUser);
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.addDataSourceProperty("databaseName", databaseName);
            dataSource.addDataSourceProperty("serverName", serverName);
            dataSource.setMaximumPoolSize(maxPoolSize);
            dataSource.setDataSourceClassName(datasourceClass);
            dataSource.addDataSourceProperty("user", jdbcUser);
            dataSource.addDataSourceProperty("password", jdbcPassword);
            return dataSource;
        }

        /**
         * This method provides the required transaction manager for the test
         * classes
         *
         * @param dataSource
         *          Postgresql DataSource
         * @return PlatformTransactionManager
         *          spring PlatformTransactionManager
         */
        @Bean
        public PlatformTransactionManager transactionManager(
                final DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

    }

}
