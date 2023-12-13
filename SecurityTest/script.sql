-- SecurityTest > script.sql

drop table tblRent;
drop table tblMember;

-- 회원 테이블
-- 암호 > 암호화 인코딩
create table tblMember (
    userid varchar2(50) not null primary key,
    userpw varchar2(100) not null, -- 최소 100바이트 이상
    username varchar2(100) not null,
    regdate date default sysdate not null,
    enabled char(1) default '1'
);

-- 권한(자격) 테이블 > ROLE_MEMBER, ROLE_ADMIN..
create table tblAuth (
    userid varchar2(50) not null,
    auth varchar2(50) not null,
    constraint fk_member_auth foreign key(userid) references tblMember(userid)
);

select * from tblMember;
select * from tblAuth;

insert into tblAuth (userid, auth) values ('lion', 'ROLE_MEMBER'); 

commit;

select m.userid, m.userpw, m.username, m.enabled, m.regdate, a.auth
from tblMember m 
    left outer join tblAuth a
    on m.userid = a.userid
where m.userid = 'lion';