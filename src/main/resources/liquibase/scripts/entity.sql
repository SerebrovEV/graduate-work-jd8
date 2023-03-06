-- liquibase formatted sql

--changeset sev:1
create table "user" (
    id         serial primary key,
    first_name text,
    last_name  text,
    email      text,
    phone      text,
    reg_date   date,
    admin_role boolean
);

--changeset sev:2
create table comment (
    id   serial primary key,
    text text,
    date timestamp
);
--changeset sev:3
create table ads
(
    id          serial primary key,
    title       text,
    description text,
    price       int
);