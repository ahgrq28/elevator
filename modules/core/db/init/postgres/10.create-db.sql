-- begin ELEVATOR_ORGANIZATION
create table ELEVATOR_ORGANIZATION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    INN varchar(255),
    KPP varchar(255),
    SHORT_NAME varchar(255),
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end ELEVATOR_ORGANIZATION
-- begin ELEVATOR_VEHICLE
create table ELEVATOR_VEHICLE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GOVERNMENT_NUMBER varchar(255),
    MODEL_ID uuid,
    USER_ID uuid,
    ORGANIZATION_ID uuid,
    --
    primary key (ID)
)^
-- end ELEVATOR_VEHICLE
-- begin ELEVATOR_BARN
create table ELEVATOR_BARN (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255),
    DESCRIPTION text,
    CAPACITY double precision,
    --
    primary key (ID)
)^
-- end ELEVATOR_BARN
-- begin ELEVATOR_MEDICAL_EXAMINATION
create table ELEVATOR_MEDICAL_EXAMINATION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STATUS varchar(50) not null,
    MEDICAL_USER_ID uuid,
    --
    primary key (ID)
)^
-- end ELEVATOR_MEDICAL_EXAMINATION
-- begin ELEVATOR_MODEL
create table ELEVATOR_MODEL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(1000),
    DESCRIPTION text,
    --
    primary key (ID)
)^
-- end ELEVATOR_MODEL
-- begin ELEVATOR_CONSIGNMENT_NOTE
create table ELEVATOR_CONSIGNMENT_NOTE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(60),
    --
    NUMBER_ integer not null,
    DATE_ timestamp not null,
    GRADE integer not null,
    BARN_ID uuid,
    VEHICLE_ID uuid,
    ORGANIZATION_ID uuid,
    MEDICAL_EXAMINATION_ID uuid,
    --
    primary key (ID)
)^
-- end ELEVATOR_CONSIGNMENT_NOTE
-- begin ELEVATOR_CONSIGNMENT_NOTE_RECEIPT
create table ELEVATOR_CONSIGNMENT_NOTE_RECEIPT (
    ID uuid,
    --
    COMING double precision not null,
    WEEDINESS double precision,
    HUMIDITY double precision,
    --
    primary key (ID)
)^
-- end ELEVATOR_CONSIGNMENT_NOTE_RECEIPT
-- begin ELEVATOR_CONSIGNMENT_NOTE_CONSIGNMENT
create table ELEVATOR_CONSIGNMENT_NOTE_CONSIGNMENT (
    ID uuid,
    --
    LEFT_ double precision,
    --
    primary key (ID)
)^
-- end ELEVATOR_CONSIGNMENT_NOTE_CONSIGNMENT
