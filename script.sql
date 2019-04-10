create database test;

create table test.user
(
    id   bigint auto_increment,
    name character varying(128) not null unique,
    role character varying(64)  not null,
    primary key (id)
);

create table test.request
(
    id       bigint auto_increment,
    request  character varying(256) not null,
    bid      numeric                not null,
    due_date date                   not null,
    status   character varying(128) not null,
    id_user  bigint,
    primary key (id),
    foreign key (id_user) references test.user (id)
);

insert into test.user(name, role)
values ('client1', 'CLIENT'),
       ('client2', 'CLIENT'),
       ('admin', 'ADMIN');

insert into test.request(request, bid, due_date, status, id_user)
VALUES ('Помыть слона', 100.0, now(), 'WAIT', 1),
       ('Помыть тюленя', 90.0, now(), 'WAIT', 2);

