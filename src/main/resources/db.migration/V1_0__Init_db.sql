create sequence seq_participant start 1 increment 1;

create table participant (
    id int8 not null,
    birthday date not null,
    last_name varchar(255) not null,
    name varchar(255) not null,
    subscription_from date not null,
    subscription_to date not null,
    role_id int8 not null,
    primary key (id));

create table participant_role (
    id int8 not null,
    role_value varchar(255) not null unique,
    primary key (id));

alter table if exists participant
    add constraint participant_participant_role_fk foreign key (role_id) references participant_role;