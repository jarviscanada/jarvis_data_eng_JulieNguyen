-- switch to host_agent database
\c host_agent;

-- create host_info table
CREATE TABLE PUBLIC.host_info
(
    id SERIAL NOT NULL PRIMARY KEY,
    hostname VARCHAR NOT NULL UNIQUE,
    cpu_number INT NOT NULL,
    cpu_architecture VARCHAR NOT NULL,
    cpu_model VARCHAR NOT NULL,
    cpu_mhz FLOAT NOT NULL,
    L2_cache INT NOT NULL,
    total_mem INT NOT NULL,
    "timestamp" TIMESTAMP NOT NULL
);

-- create host_usage table
CREATE TABLE PUBLIC.host_usage
(
    "timestamp" TIMESTAMP NOT NULL PRIMARY KEY,
    host_id INT NOT NULL REFERENCES host_info(id),
    memory_free INT NOT NULL,
    cpu_idle INT NOT NULL,
    cpu_kernel INT NOT NULL,
    disk_io INT NOT NULL,
    disk_available INT NOT NULL
);