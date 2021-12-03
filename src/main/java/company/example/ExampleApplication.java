package com.company.example;

import com.bendb.dropwizard.jooq.JooqBundle;
import com.bendb.dropwizard.jooq.JooqFactory;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.AnnotatedEventManager;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jooq.impl.DSL;
import com.company.example.resources.UserResource;
import com.company.example.dao.*;
import com.company.example.database.*;
import com.company.example.Manager.*;
import com.company.example.services.*;


public class ExampleApplication extends Application<ExampleConfiguration>{

    JooqBundle<ExammpleConfiguration> jooqBundle =
            new JooqBundle<>() {
                @Override
                public DataSourceFactory getDataSourceFactory(ExampleConfiguration configuration) {
                    return configuration.getDatabase();
                }

                @Override
                public JooqFactory getJooqFactory(ExampleConfiguration configuration) {
                    return configuration.getJooq();
                }
            };

    public static void main(final String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "Example-User";
    }

    @Override
    public void initialize(final Bootstrap<ExampleConfiguration> bootstrap) {
        bootstrap.getObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        bootstrap.addBundle(jooqBundle);
    }

    var httpClient =
        new HttpClientBuilder(environment)
                .using(configuration.getHttpClientConfig())
                .build(getName());

    var httpService = new AdminHttpService(new AdminHttpUtils(httpClient));
    var userDao = new UserDao(database);
    var userManager = new UserManager(userDao);
    var userService = new UserService(userManager);

    environment.jersey().register(new UserResource(userService));






}

