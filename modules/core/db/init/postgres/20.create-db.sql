-- begin ELEVATOR_VEHICLE
alter table ELEVATOR_VEHICLE add constraint FK_ELEVATOR_VEHICLE_ON_MODEL foreign key (MODEL_ID) references ELEVATOR_MODEL(ID)^
alter table ELEVATOR_VEHICLE add constraint FK_ELEVATOR_VEHICLE_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
alter table ELEVATOR_VEHICLE add constraint FK_ELEVATOR_VEHICLE_ON_ORGANIZATION foreign key (ORGANIZATION_ID) references ELEVATOR_ORGANIZATION(ID)^
create index IDX_ELEVATOR_VEHICLE_ON_MODEL on ELEVATOR_VEHICLE (MODEL_ID)^
create index IDX_ELEVATOR_VEHICLE_ON_USER on ELEVATOR_VEHICLE (USER_ID)^
create index IDX_ELEVATOR_VEHICLE_ON_ORGANIZATION on ELEVATOR_VEHICLE (ORGANIZATION_ID)^
-- end ELEVATOR_VEHICLE
-- begin ELEVATOR_MEDICAL_EXAMINATION
alter table ELEVATOR_MEDICAL_EXAMINATION add constraint FK_ELEVATOR_MEDICAL_EXAMINATION_ON_MEDICAL_USER foreign key (MEDICAL_USER_ID) references SEC_USER(ID)^
create index IDX_ELEVATOR_MEDICAL_EXAMINATION_ON_MEDICAL_USER on ELEVATOR_MEDICAL_EXAMINATION (MEDICAL_USER_ID)^
-- end ELEVATOR_MEDICAL_EXAMINATION
-- begin ELEVATOR_CONSIGNMENT_NOTE
alter table ELEVATOR_CONSIGNMENT_NOTE add constraint FK_ELEVATOR_CONSIGNMENT_NOTE_ON_BARN foreign key (BARN_ID) references ELEVATOR_BARN(ID)^
alter table ELEVATOR_CONSIGNMENT_NOTE add constraint FK_ELEVATOR_CONSIGNMENT_NOTE_ON_VEHICLE foreign key (VEHICLE_ID) references ELEVATOR_VEHICLE(ID)^
alter table ELEVATOR_CONSIGNMENT_NOTE add constraint FK_ELEVATOR_CONSIGNMENT_NOTE_ON_ORGANIZATION foreign key (ORGANIZATION_ID) references ELEVATOR_ORGANIZATION(ID)^
alter table ELEVATOR_CONSIGNMENT_NOTE add constraint FK_ELEVATOR_CONSIGNMENT_NOTE_ON_MEDICAL_EXAMINATION foreign key (MEDICAL_EXAMINATION_ID) references ELEVATOR_MEDICAL_EXAMINATION(ID)^
create unique index IDX_ELEVATOR_CONSIGNMENT_NOTE_UK_NUMBER_ on ELEVATOR_CONSIGNMENT_NOTE (NUMBER_) where DELETE_TS is null ^
create index IDX_ELEVATOR_CONSIGNMENT_NOTE_ON_BARN on ELEVATOR_CONSIGNMENT_NOTE (BARN_ID)^
create index IDX_ELEVATOR_CONSIGNMENT_NOTE_ON_VEHICLE on ELEVATOR_CONSIGNMENT_NOTE (VEHICLE_ID)^
create index IDX_ELEVATOR_CONSIGNMENT_NOTE_ON_ORGANIZATION on ELEVATOR_CONSIGNMENT_NOTE (ORGANIZATION_ID)^
create index IDX_ELEVATOR_CONSIGNMENT_NOTE_ON_MEDICAL_EXAMINATION on ELEVATOR_CONSIGNMENT_NOTE (MEDICAL_EXAMINATION_ID)^
-- end ELEVATOR_CONSIGNMENT_NOTE
-- begin ELEVATOR_CONSIGNMENT_NOTE_RECEIPT
alter table ELEVATOR_CONSIGNMENT_NOTE_RECEIPT add constraint FK_ELEVATOR_CONSIGNMENT_NOTE_RECEIPT_ON_ID foreign key (ID) references ELEVATOR_CONSIGNMENT_NOTE(ID) on delete CASCADE^
-- end ELEVATOR_CONSIGNMENT_NOTE_RECEIPT
-- begin ELEVATOR_CONSIGNMENT_NOTE_CONSIGNMENT
alter table ELEVATOR_CONSIGNMENT_NOTE_CONSIGNMENT add constraint FK_ELEVATOR_CONSIGNMENT_NOTE_CONSIGNMENT_ON_ID foreign key (ID) references ELEVATOR_CONSIGNMENT_NOTE(ID) on delete CASCADE^
-- end ELEVATOR_CONSIGNMENT_NOTE_CONSIGNMENT