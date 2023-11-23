-- MyBatisTest > script.sql

create table tblMyBatis (
    seq number primary key,
    name varchar2(50) not null,
    age number not null,
    address varchar2(100) not null,
    gender char(1) not null
);

create SEQUENCE seqMyBatis;

insert into tblMyBatis (seq, name, age, address, gender) values (seqMyBatis.nextVal, '홍길동', 20, '서울시 강남구 역삼동', 'm');