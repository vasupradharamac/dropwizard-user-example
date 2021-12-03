package com.company.example.dao;

import com.company.example.database.*;
import org.jooq.DSLContext;
import java.math.BigDecimal;
import java.util.Optional;
import org.jooq.DSLContext;

public class userDao {

    public final DSLContext database;

    public Optional<User> findById(int id) {

        return database
                .selectFrom(Tables.USER)
                .where(Tables.USER.ID.eq(id))
                .fetchOptionalInto(User.class);
    }

    public Optional<User> findByFirstname(String firstname) {
        return database
                .selectFrom(Tables.USERS)
                .where(Tables.USERS.FIRSTNAME.eq(firstname))
                .fetchOptionalInto(User.class);
    }

    public Optional<User> findByLastname(String lastname) {
        return database
                .selectFrom(Tables.USERS)
                .where(Tables.USERS.LASTNAME.eq(lastname))
                .fetchOptionalInto(User.class);
    }



}