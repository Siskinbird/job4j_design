package io;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
        assertThat(config.value("name1"),
                is("Dmitry Chizhov"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenException() {
        String path = "./data/illegaltest.properties";
        Config config = new Config(path);
        config.load();
        config.value("normalKey");
    }

    @Test
    public void newProperties() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect")
        );
        assertThat(
                config.value("hibernate.connection.url"),
                is("jdbc:postgresql://127.0.0.1:5432/trackstudio")
        );
        assertThat(
                config.value("hibernate.connection.driver_class"),
                is("org.postgresql.Driver")
        );
        assertThat(
                config.value("hibernate.connection.username"),
                is("postgres")
        );
        assertThat(
                config.value("hibernate.connection.password"),
                is("password")
        );
    }
}