create table TESTERSJOURNAL_DEVICE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DEVICE_OS_ID varchar(36) not null,
    SCREEN_RESOLUTION_ID varchar(36),
    DESCRIPTION varchar(255),
    --
    primary key (ID)
);
