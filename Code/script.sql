create table tblCode(
    seq number primary key,
    subject varchar2(1000) not null,
    code varchar2(2000) not null,
    regdate date default sysdate not null,
    language varchar2(100) not null
);

create sequence seqCode;

select * from tblCode;