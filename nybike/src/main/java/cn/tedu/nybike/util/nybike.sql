
-- ������
create database nybikedb;

-- ʹ�����ݿ�
use nybikedb;

-- ����tb_status��
create table tb_status(
sid int,
nba int,
nda int,
abi double
);

-- ����tb_status_915
create table tb_status_915(
data_timestamp bigint,
station_id int,
num_bikes_available int,
num_bikes_disabled int,
num_docks_available int,
num_docks_disabled int,
is_installed int,
is_renting int,
is_returning int,
last_reported bigint
);

-- ��csv�ļ�����tb_status_915
load data infile 'D:/status_915.csv'  -- �ļ�·��
into table tb_status_915  -- ����
fields terminated by ','   -- �ļ����ֶηָ���
optionally enclosed by '"'  -- ȥ�ֶ���β˫����
lines terminated by '\r\n'  -- ���з�
ignore 1 lines; -- ������һ��

-- ������hive�е����
-- ����һ�����ݿ�nybikedb
create database nybikedb;

-- ʹ��nybikedb���ݿ�
use nybikedb;

-- ����tb_trip_0601
create table tb_trip_0601(
tripduration int,
starttime string,
stoptime string,
start_station_id int,
start_station_name string,
start_station_latitude double,
start_station_longitude double,
end_station_id int,
end_station_name string,
end_station_latitude double,
end_station_longitude double,
bikeid int,
usertype string,
birth_year int,
gender int
)row format delimited
fields terminated by ',';


load data inpath 'hdfs://master:8020/20190601.csv' into table tb_trip_0601;

-- ͳ��6��1��
select hour(starttime),count(*) 
from tb_trip_0601 
group by hour(starttime);

drop table tb_trip_0601;

create table tb_hc_0601(
hour int,
c_count int
)row format delimited
fields terminated by ',';




