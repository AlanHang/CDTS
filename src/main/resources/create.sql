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
 job_queue VARCHAR(50)
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
(job_history_id VARCHAR(20) PRIMARY KEY,
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