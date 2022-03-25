-- liquibase formatted sql
/*
 Описание:                Сообщения
 Первичные ключи:         inline
 Уникальные ключи:        pk_message_id
*/
-- changeset ${user.name}:create_messages_tab.sql logicalFilePath:db/changelog/tab/messages.sql runOnChange:true splitStatements:true
create table if not exists messages
(
    id   bigserial
    constraint pk_message_id primary key,
    text         varchar(100)      not null,
    message_time timestamp with time zone not null
);


-- changeset ${user.name}:comment_on_columns_messages.sql logicalFilePath:db/changelog/tab/messages.sql runOnChange:true splitStatements:true
comment on column messages.text is 'Текст сообщения';
comment on column messages.message_time is 'Дата/Время';
