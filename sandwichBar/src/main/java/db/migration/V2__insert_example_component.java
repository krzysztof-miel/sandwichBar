package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class V2__insert_example_component extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("insert into components (name, price) values ('Bread', 4.0)");

        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("insert into components (name, price) values ('Cheese', 2.0)");

        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("insert into components (name, price) values ('Ham', 2.0)");

        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("insert into components (name, price) values ('Bacon', 1.5)");

        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("insert into components (name, price) values ('Egg', 1.8)");

        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("insert into components (name, price) values ('Lettuce', 1.0)");

        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("insert into components (name, price) values ('Cucumber', 1.5)");

        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("insert into components (name, price) values ('Pepper', 1.5)");

        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("insert into components (name, price) values ('Hummus', 2.2)");

    }
}
