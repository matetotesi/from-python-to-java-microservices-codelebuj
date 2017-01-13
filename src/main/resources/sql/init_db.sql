drop table if exists paid_products;
drop table if exists client;


create table client
(
client_id SERIAL PRIMARY KEY ,
client_identifier varchar UNIQUE ,
client_name VARCHAR
);

create table paid_products
(
product_id int,
quantity int,
purchase_time date,
client_id INTEGER REFERENCES client(client_id) on delete cascade on update cascade
);
