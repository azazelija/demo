-- liquibase formatted sql
/*
     Главный пользователь с ролью ADMIN
*/
-- changeset ${user.name}:insert_admin_user.sql logicalFilePath:db/changelog/data/user-data.sql runOnChange:true splitStatements:true endDelimiter:/

do
$$
declare role_id int;
declare name varchar := 'Администратор';
declare phone varchar := '000' ;
declare email varchar := 'admin@admin.ru';

begin
    select roles.id into STRICT role_id
            from roles where roles.name = 'ADMIN';
    if role_id is not null then
        insert into users (role_id, name, phone, email) values (role_id, name, phone, email);
        raise notice 'Admin user has been added';
    else
        raise notice 'Failed to add Admin user';
    end if;
end
$$ /

-- changeset ${user.name}:insert_default_user.sql logicalFilePath:db/changelog/data/user-data.sql runOnChange:true splitStatements:true endDelimiter:/

do
$$
declare role_id int;
declare name varchar := 'Пользователь';
declare phone varchar := '111' ;
declare email varchar := 'user@user.ru';

begin
    select roles.id into STRICT role_id
            from roles where roles.name = 'USER';
    if role_id is not null then
        insert into users (role_id, name, phone, email) values (role_id, name, phone, email);
        raise notice 'Default user has been added';
    else
        raise notice 'Failed to add Default user';
    end if;
end
$$ /
