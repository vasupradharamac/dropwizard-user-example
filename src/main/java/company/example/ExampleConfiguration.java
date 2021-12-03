package com.company.example;


import com.bendb.dropwizard.jooq.JooqFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.HttpClientConfiguration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.validation.OneOf;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;


@Getter
public class ExampleConfiguration extends Configuration {

    @Valid @NotNull private DataSourceFactory database;

    @Valid @NotNull private JooqFactory jooq;

    @JsonProperty("httpClient")
    @Valid
    @NotNull
    private HttpClientConfiguration httpClientConfig;


}

