CREATE TABLE  IF NOT EXISTS PLAN_INFO(
plan_id INT PRIMARY KEY COMMENT '任务的唯一标识',
plan_name varchar(50) COMMENT '任务名称',
plan_is_del INT COMMENT '0:可用 1:删除',
create_time DATETIME COMMENT '迁移任务创建的时间',
migrate_types INT COMMENT '以个位，十位，百位是否为1代表是否包含结构迁移、全量迁移和增量迁移。',
source_cea_id  varchar(10) COMMENT '源集群的cea标识',
source_cluster_id varchar(10) COMMENT '源集群cea下的行云集群id',
source_cluster_type varchar(20) COMMENT '源集群的数据库类型',
source_cluster_version varchar(20) COMMENT '源集群的数据库版本',
source_hadoop_add varchar(20) COMMENT '源集群hadoop-namenode',
source_core_site varchar(500) COMMENT '源集群sore-site.xml路径',
source_hdfs_site varchar(500) COMMENT '源集群hdfs-site.xml路径',
source_ker_bool INT COMMENT '源集群是否是kerberos环境：0 不是 1：是',
source_ip varchar(20) COMMENT '源集群IP地址',
source_username varchar(100) COMMENT '源集群用户名' ,
source_password varchar(100) COMMENT '源集群密码' ,
target_cea_id  varchar(10) COMMENT '目标集群的cea标识',
target_cluster_id varchar(10) COMMENT '目标集群cea下的行云集群id',
target_cluster_type varchar(20) COMMENT '目标集群的数据库类型',
target_cluster_version varchar(20) COMMENT '目标集群的数据库版本',
target_hadoop_add varchar(20) COMMENT '目标集群hadoop-namenode',
target_core_site varchar(500) COMMENT '目标集群sore-site.xml路径',
target_hdfs_site varchar(500) COMMENT '目标集群hdfs-site.xml路径',
target_ker_bool INT COMMENT '目标集群是否是kerberos环境：0 不是 1：是',
target_ip varchar(20) COMMENT '目标集群IP地址',
target_username varchar(100) COMMENT '目标集群用户名' ,
target_password varchar(100) COMMENT '目标集群密码'
);

CREATE TABLE IF NOT EXISTS PLAN_OBJECT_INFO(
plan_id INT,
db_id INT,
object_text text
);


CREATE TABLE  IF NOT EXISTS PLAN_HISTORY(
job_his_id varchar(20),
plan_his_id INT,
plan_id 	INT,
plan_name varchar(50),
plan_order int,
start_time datetime,
end_time datetime,
complete_detial varchar(6000),
run_status int
);

CREATE TABLE IF NOT EXISTS CEA_INFO
(cea_id INT PRIMARY KEY auto_increment,
 cea_name VARCHAR(50),
 cea_ip VARCHAR(20),
 cea_create_time DATETIME,
 cea_remark VARCHAR(200),
 cea_status INT
);

CREATE TABLE IF NOT EXISTS CEA_CLUSTER_STATUS
(cea_id INT,
 cluster_id VARCHAR(20),
 cluster_status INT,
 PRIMARY KEY(cea_id,cluster_id)
);

CREATE TABLE IF NOT EXISTS CEA_CLUSTER_INFO
(cea_id INT,
 cluster_id VARCHAR(20),
 cluster_key VARCHAR(50),
 cluster_value VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS JOB_INFO
(job_id INT PRIMARY KEY auto_increment,
 job_name VARCHAR(50),
 job_remark VARCHAR(200),
 job_is_del INT,
 job_create_time DATETIME,
 job_type INT,
 job_status INT,
 job_queue_name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS JOB_STRATEGY_INFO
(job_id INT,
 job_strategy_key VARCHAR(30),
 job_strategy_value VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS JOB_PLAN_INFO
(job_id INT,
 plan_id INT,
 plan_order INT
);

CREATE TABLE IF NOT EXISTS JOB_HISTORY
(job_his_id VARCHAR(20) PRIMARY KEY,
 job_id INT,
 start_time DATETIME,
 end_time DATETIME,
 complete_detail VARCHAR(6000),
 run_status INT,
 host_ip VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS TASK_HISTORY
(plan_his_id INT,
 application_id VARCHAR(20),
 start_time DATETIME,
 end_time DATETIME,
 complete_detail VARCHAR(6000),
 run_status INT,
 log TEXT,
 speed VARCHAR(100)
);
