# Linux Cluster Monitoring Agent
This project is under development. Since this project follows the GitFlow, the final work will be merged to the master branch after Team Code Team.

# Introduction
The Linux Cluster Monitoring Agent (LCMA) is a cluster monitoring system that records the hardware and resource usage of each host in a system. This script is used by the Jarvis Linux Cluster Administration (LCA) team to manage a Linux cluster running on CentOS 7. Variables collected include the host's CPU number, total memory, memory free, disk I/O, CPU MHz and more, which are recorded to a PostgresSQL Docker RDBMS database every minute using Crontab. The LCMA uses the following technologies:
* PostgresSQL
* SQL
* Google Cloud Platform
* Docker
* Bash
* Git
* CentOS 7

# Quick Start


# Implementation

## Architecture
![Architecture](./assets/linux_sql_architecture_resize.png)

## Scripts
`psql_docker.sh`:
* A bash script that can create, start or stop a container.
  * To create a container: `./scripts/psql_docker.sh create psql_user psql_password`
  * To start the container: `./scripts/psql_docker.sh start`
  * To stop the container: `./scripts/psql_docker.sh stop`
    
`host_info.sh`:
* A bash script that will collect the hardware information of a node and insert it into the database.
  * To run: `./scripts/host_info.sh psql_host psql_port db_name psql_user psql_password`

`host_usage.sh`:
* A bash script that will collect resource usage data of a node and insert it into the database. This script runs every minute using Crontab.
  * To run: `./scripts/host_usage.sh psql_host psql_port db_name psql_user psql_password` 

`crontab`
* Crontab script is used to automate `host_usage.sh` every minute.
  * To edit file: `crontab -e`
  * Add to file: `* * * * * ./<PATH>/host_usage.sh psql_host psql_port db_name psql_user psql_password > /tmp/host_usage.log`

`ddl.sql`:
* An SQL script that switches the user to the `host_agent` database and defines `host_info` and `host_usage` tables.
  * To run: `psql -h psql_host -U psql_user -d host_agent -f sql/ddl.sql` 

`queries.sql`:
* An SQL script that queries data from the `host_info` and `host_usage` tables to verify that the program is working. 
  * Test cases include:
    * Grouping hosts by CPU number and sorting them by their total memory in descending order.
    * Finding the average memory used in percentage over a five-minute interval.
    * Detecting server failure by checking if less than three data points are inserted within a five-minute interval.
  * To run: `psql -h psql_host -U psql_user -d host_agent -f sql/queries.sql`

## Database Modeling
`host_info`:

Attribute  | Data Type | Description
----------|-----------|------------
id|serial| unique ID
hostname | varchar | name of the host
cpu_number|int|cpu number
cpu_architecture|varchar| xyz
cpu_model|varchar|xyz
cpu_mhz|float|xyz
L2_cache|int|xyz
total_mem|int|xyz
timestamp|timestamp|xyz

`host_usage`

Attribute  | Data Type | Description
----------|-----------|------------
timestamp|timestamp|xyz
host_id|serial|xyz
memory_free|int|xyz
cpu_idle|int|xyz
cpu_kernel|int|xyz
disk_io|int|xyz
disk_available|int|xyz

# Test

# Deployment

# Improvements