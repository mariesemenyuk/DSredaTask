-- !Ups
CREATE TABLE brand (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    title varchar(255) NOT NULL UNIQUE,
    country varchar(255) NOT NULL,
    PRIMARY KEY (id));

CREATE TABLE model (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    title varchar(255) NOT NULL UNIQUE,
    production_start integer NOT NULL,
    production_finish integer NOT NULL,
    PRIMARY KEY (id));

CREATE TABLE shop_position (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    brand_id  bigint  NOT NULL,
    model_id  bigint  NOT NULL,
    year_prod integer NOT NULL,
    mileage   integer NOT NULL,
    price     integer NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_BRAND_ID FOREIGN KEY(brand_id) REFERENCES brand(id),
    CONSTRAINT FK_MODEL_ID FOREIGN KEY(model_id) REFERENCES model(id));

-- !Downs
DROP TABLE if exists brand;
DROP TABLE if exists model;