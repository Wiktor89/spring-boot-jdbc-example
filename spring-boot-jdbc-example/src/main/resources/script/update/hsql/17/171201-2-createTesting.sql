alter table TESTERSJOURNAL_TESTING add constraint FK_TESTERSJOURNAL_TESTING_USER foreign key (USER_ID) references SEC_USER(ID);
alter table TESTERSJOURNAL_TESTING add constraint FK_TESTERSJOURNAL_TESTING_DEVICE foreign key (DEVICE_ID) references TESTERSJOURNAL_DEVICE(ID);
create index IDX_TESTERSJOURNAL_TESTING_USER on TESTERSJOURNAL_TESTING (USER_ID);
create index IDX_TESTERSJOURNAL_TESTING_DEVICE on TESTERSJOURNAL_TESTING (DEVICE_ID);
