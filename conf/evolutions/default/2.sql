# --- dataset

# --- !Ups

insert into brand (title,country) values ('Honda','Japan');
insert into brand (title,country) values ('Ford','USA');
insert into brand (title,country) values ('Kia','Korea');
insert into brand (title,country) values ('Toyota','Japan');
insert into brand (title,country) values ('Renault','France');

insert into model (title, production_start, production_finish) values ('Civic', 1972, 2022);
insert into model (title, production_start, production_finish) values ('Accord', 1976, 2022);
insert into model (title, production_start, production_finish) values ('CR-V', 1995, 2022);

insert into model (title, production_start, production_finish) values ('Focus', 1998, 2022);
insert into model (title, production_start, production_finish) values ('Mondeo', 1992, 2022);
insert into model (title, production_start, production_finish) values ('Fiesta', 1976, 2022);

insert into model (title, production_start, production_finish) values ('Picanto', 2004, 2022);
insert into model (title, production_start, production_finish) values ('Ceed', 2006, 2022);
insert into model (title, production_start, production_finish) values ('Rio', 1999, 2022);

insert into model (title, production_start, production_finish) values ('Corolla', 1966, 2022);
insert into model (title, production_start, production_finish) values ('Prius', 1997, 2022);
insert into model (title, production_start, production_finish) values ('Avensis', 1997, 2018);

insert into model (title, production_start, production_finish) values ('Megane', 1995, 2022);
insert into model (title, production_start, production_finish) values ('Scenic', 1996, 2022);
insert into model (title, production_start, production_finish) values ('Koleos', 2006, 2022);


insert into shop_position (brand_id, model_id, year_prod, mileage, price) values (1, 1, 2006, 180000, 500000);
insert into shop_position (brand_id, model_id, year_prod, mileage, price) values (1, 1, 2011, 140000, 600000);
insert into shop_position (brand_id, model_id, year_prod, mileage, price) values (1, 2, 2005, 220000, 350000);
insert into shop_position (brand_id, model_id, year_prod, mileage, price) values (1, 2, 2015, 80000, 800000);
insert into shop_position (brand_id, model_id, year_prod, mileage, price) values (1, 3, 2009, 195000, 750000);

insert into shop_position (brand_id, model_id, year_prod, mileage, price) values (2, 4, 2010, 210000, 550000);
insert into shop_position (brand_id, model_id, year_prod, mileage, price) values (2, 4, 2013, 160000, 700000);
insert into shop_position (brand_id, model_id, year_prod, mileage, price) values (2, 5, 2006, 250000, 500000);
insert into shop_position (brand_id, model_id, year_prod, mileage, price) values (2, 6, 2012, 180000, 500000);
insert into shop_position (brand_id, model_id, year_prod, mileage, price) values (2, 6, 2009, 200000, 400000);

# --- !Downs

delete from brand;
delete from model;
delete from brand;