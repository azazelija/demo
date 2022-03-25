-- liquibase formatted sql
/*
    Случайные сообщения
*/
-- changeset ${user.name}:insert_data_in_messages_table.sql logicalFilePath:db/changelog/data/messages-data.sql runOnChange:true splitStatements:true endDelimiter:/

insert into messages (text, message_time) values ('First_text', TIMESTAMP '2011-05-16 15:36:38');
