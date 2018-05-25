create table TESTERSJOURNAL_TESTING (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36) not null,
    START_TIME timestamp not null,
    END_TIME timestamp,
    DEVICE_ID varchar(36) not null,
    --
    primary key (ID)
);
