--liquibase formatted sql

--changeset m.tebaldi:1
CREATE TABLE usersmgr.users
(
    id               serial NOT NULL,
    username              varchar(64),
    password_hash           varchar(64),
    password_hash_alg           varchar(64),
    last_name           varchar(64),
    first_name           varchar(64),
    email           varchar(256),
    company_id           int,
    enabled     smallint,
    create_timestamp timestamp,
    create_user_id   int,
    create_user      VARCHAR(50),
    update_timestamp timestamp,
    update_user_id   int,
    update_user      VARCHAR(50),
    CONSTRAINT connector_parameters_pk PRIMARY KEY (id)
);

CREATE TABLE usersmgr.companies
(
    id               serial NOT NULL,
    code              varchar(64),
    name           varchar(256),
    vat_number           varchar(64),
    vat_country_code           varchar(10),
    enabled     smallint,
    create_timestamp timestamp,
    create_user_id   int,
    create_user      VARCHAR(50),
    update_timestamp timestamp,
    update_user_id   int,
    update_user      VARCHAR(50),
    CONSTRAINT companies_pk PRIMARY KEY (id)
);

CREATE TABLE usersmgr.groups
(
    id               serial NOT NULL,
    code             varchar(64),
    description      varchar(256),
    create_timestamp timestamp,
    create_user_id   int,
    create_user      VARCHAR(50),
    update_timestamp timestamp,
    update_user_id   int,
    update_user      VARCHAR(50),
    CONSTRAINT groups_pk PRIMARY KEY (id)
);

CREATE TABLE usersmgr.roles
(
    id               serial NOT NULL,
    code             varchar(64),
    description      varchar(256),
    create_timestamp timestamp,
    create_user_id   int,
    create_user      VARCHAR(50),
    update_timestamp timestamp,
    update_user_id   int,
    update_user      VARCHAR(50),
    CONSTRAINT roles_pk PRIMARY KEY (id)
);

CREATE TABLE usersmgr.users_groups
(
    id               serial NOT NULL,
    user_id             int,
    group_id      int,
    create_timestamp timestamp,
    create_user_id   int,
    create_user      VARCHAR(50),
    update_timestamp timestamp,
    update_user_id   int,
    update_user      VARCHAR(50),
    CONSTRAINT users_groups_pk PRIMARY KEY (id)
);

CREATE TABLE usersmgr.companies_roles
(
    id               serial NOT NULL,
    company_id             int,
    role_id      int,
    create_timestamp timestamp,
    create_user_id   int,
    create_user      VARCHAR(50),
    update_timestamp timestamp,
    update_user_id   int,
    update_user      VARCHAR(50),
    CONSTRAINT companies_roles_pk PRIMARY KEY (id)
);