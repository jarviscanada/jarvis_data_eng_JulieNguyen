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
  * To create a container: ```./scripts/psql_docker.sh create psql_user psql_password```
  * To start the container: `./scripts/psql_docker.sh start`
  * To stop the container: `./scripts/psql_docker.sh stop`
    
`host_info.sh`:
* A bash script that will collect the hardware information of a node and insert it into the database.
  * To run: `./scripts/host_info.sh psql_host psql_port db_name psql_user psql_password`

`host_usage.sh`:
* A bash script that will collect resource usage data of a node and insert it into the database. This script runs every minute using Crontab.
  * To run: `./scripts/host_usage.sh psql_host psql_port db_name psql_user psql_password` 

`ddl.sql`:
* An SQL script that switches the user to the host_agent database and defines host_info and host_usage tables.

`queries.sql`:
* An SQL script that queries data from the host_info and host_usage tables to verify that the program is working.
  * 

## Database Modeling


# Test

# Deployment

# Improvements