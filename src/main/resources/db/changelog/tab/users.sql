-- liquibase formatted sql
/*
 Описание:                Пользователи
 Первичные ключи:         inline
 Уникальные ключи:        pk_user_id
*/
-- changeset ${user.name}:create_users_tab.sql logicalFilePath:db/changelog/tab/users.sql runOnChange:true splitStatements:true
create table if not exists users
(
    id          bigserial
    constraint pk_user_id primary key,
    role_id     bigint      not null,
    name  varchar(50) not null,
    password varchar(250) not null,
    phone       varchar(50) not null,
    email       varchar(50),

    CONSTRAINT name_unique UNIQUE (name)
   );


-- changeset ${user.name}:comment_on_columns_users.sql logicalFilePath:db/changelog/tab/users.sql runOnChange:true splitStatements:true
comment on column users.role_id is 'Роль пользователя';
comment on column users.name is 'Имя';
comment on column users.phone is 'Номер телефона';
comment on column users.email is 'Почта';
