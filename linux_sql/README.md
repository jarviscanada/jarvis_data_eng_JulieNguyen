# Linux Cluster Monitoring Agent
This project is under development. Since this project follows the GitFlow, the final work will be merged to the master branch after Team Code Team.

# Introduction
The Linux Cluster Monitoring Agent (LCMA) is a cluster monitoring system that records the hardware and resource usage of each host in a system. This script is used by the Jarvis Linux Cluster Administration (LCA) team to manage a Linux cluster running on CentOS 7. Variables collected include the host's CPU number, total memory, memory free, disk I/O, CPU MHz and more, which is recorded to a PostgresSQL Docker RDBMS database every minute using Crontab. SQL queries were written to show this data over different time intervals and to detect failure in the host/server. Bash script is used to create, start and stop the PSQL Docker container, collect information from the host and run SQL statements to insert the data into the database.

# Quick Start


# Implementation

## Architecture
![Architecture](./assets/linux_sql_architecture_resize.png)

## Scripts
`psql_docker.sh`
`host_info.sh`
`host_usage.sh`

## Database Modeling

# Test

# Deployment

# Improvements