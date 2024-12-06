drop table if exists tb_member cascade;
create table tb_member (
    seq bigint generated by default as identity,
    login_id varchar(50) not null unique,
    password varchar(100) not null,
    name varchar(50) not null,
    status varchar(255) not null check (status in ('ACTIVE','INACTIVE')),
    created_at timestamp(6),
    updated_at timestamp(6),
    primary key (seq)
);

drop table if exists board cascade;
create table board (
    seq bigint generated by default as identity,
    created_by bigint not null,
    updated_by bigint,
    content varchar(255) not null,
    title varchar(255) not null,
    updated_at timestamp(6),
    created_at timestamp(6),
    primary key (seq)
);