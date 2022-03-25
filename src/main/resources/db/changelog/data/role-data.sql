-- liquibase formatted sql
/*
     Основные роли: ADMIN - администратор
                    USER - пользователь
*/
-- changeset ${user.name}:insert_default_data_roles.sql logicalFilePath:db/changelog/data/role-data.sql runOnChange:true splitStatements:true endDelimiter:/

insert into roles (name) values ('ADMIN');
insert into roles (name) values ('USER');
