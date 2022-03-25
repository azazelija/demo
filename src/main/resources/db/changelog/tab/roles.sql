-- liquibase formatted sql
/*
 Описание:                Роли
 Первичные ключи:         inline
 Уникальные ключи:        pk_role_id
*/
-- changeset ${user.name}:create_roles_tab.sql logicalFilePath:db/changelog/tab/roles.sql runOnChange:true splitStatements:true
create table if not exists roles
(
    id   bigserial
    constraint pk_role_id primary key,
    name varchar(200) not null
    );


-- changeset ${user.name}:comment_on_columns_roles.sql logicalFilePath:db/changelog/tab/roles.sql runOnChange:true splitStatements:true
comment on column roles.name is 'Роль пользователя';
