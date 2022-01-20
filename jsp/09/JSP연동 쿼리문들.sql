# 만약에 testdb가 있다면, 삭제를 하라.
# 실행 단축키는 해당영역 ctrl + shift + enter
drop database if exists testdb;
create database testdb;
# testdb를 사용하겠다.
use testdb;

# members테이블을 생성하는 쿼리문
drop table if exists members;
create table members(
	id varchar(20) primary key,
    pw varchar(20) not null,
    username varchar(20) not null,
    phone varchar(20)
);

# members테이블에서 모든 열의 데이터를 전부다 가져와 달라.
select * from members;

# 테이블에 데이터를 삽입하는 쿼리문
insert into members values("abcde", '1234', '홍길동', null);
insert into members values("lee", '1234', '이승기', '01077778888');
insert into members values("kang", '1234', '강호동', '01055556666'),
						  ("kim", '1234', '김연아', null);
                          
# 테이블에 데이터를 수정하는 쿼리문
update members
	set pw = '7890'
    where id = 'lee'; 
    
# 테이블에 있는 데이터를 삭제하는 쿼리문
delete from members
	where id = "abcde";
    
# 테이블 정보를 보는 쿼리문
describe members;
desc members;

# 테이블의 수정을 하는 쿼리문
# addr이라는 컬럼을 추가하고 있느 쿼리문이다.
alter table members
	add column addr varchar(50);

# 테이블을 삭제하는 쿼리문
drop table members;
# 데이터베이스를 삭제하는 쿼리문
drop database testdb;