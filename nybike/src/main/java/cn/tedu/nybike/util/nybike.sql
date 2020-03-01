
-- 创建库
create database nybikedb;

-- 使用数据库
use nybikedb;

-- 创建tb_status表
create table tb_status(
sid int,
nba int,
nda int,
abi double
);

-- 创建tb_status_915
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

-- 将csv文件导入tb_status_915
load data infile 'D:/status_915.csv'  -- 文件路径
into table tb_status_915  -- 表名
fields terminated by ','   -- 文件中字段分隔符
optionally enclosed by '"'  -- 去字段首尾双引号
lines terminated by '\r\n'  -- 换行符
ignore 1 lines; -- 跳过第一行

-- 以下是hive中的语句
-- 创建一个数据库nybikedb
create database nybikedb;

-- 使用nybikedb数据库
use nybikedb;

-- 创建tb_trip_0601
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

-- 统计6月1日
select hour(starttime),count(*) 
from tb_trip_0601 
group by hour(starttime);

drop table tb_trip_0601;

create table tb_hc_0601(
hour int,
c_count int
)row format delimited
fields terminated by ',';




