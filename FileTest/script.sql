-- FileTest > script.sql

-- 장소 등록
create table tblPlace (
    seq number primary key,
    subject varchar2(500) not null,
    content varchar2(1000) not null,
    regdate date default sysdate not null
);
create SEQUENCE seqPlace;

-- 사진
create table tblPic (
    seq number primary key,
    filename varchar2(300) not null,
    pseq number references tblPlace(seq) not null
);
create SEQUENCE seqPic;

select * from tblPlace;
select * from tblPic;


select a.*, () as picCount from tblPlace order by seq desc;



