#!/bin/bash

#check number of arguments in CLI
if [ $# != 5 ]; then
    echo "Error: Invalid number of arguments."
    exit 1
fi

#assign CLI to variables
psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
export PGPASSWORD=$5

#save number of CPU to a variable
lscpu_out=`lscpu`
mem_out=`cat /proc/meminfo`

#hardware
hostname=$(hostname -f)
cpu_number=$(echo "$lscpu_out"  | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out" | grep 'Architecture:' | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out" | grep 'Model name:' | awk '{$1="";$2=""; print $0}' | xargs)
cpu_mhz=$(echo "$lscpu_out" | grep 'CPU MHz:' | awk '{print $3}' | xargs)
l2_cache=$(echo "$lscpu_out" | grep 'L2 cache:' | awk '{print $3}' | xargs | sed 's/.$//')
total_mem=$(echo "$mem_out" | grep 'MemTotal:' | awk '{print $2}' | xargs)
timestamp=$(date +"%Y-%m-%d %T") #current timestamp in `2019-11-26 14:40:19` format

#insert hardware information into SQL database
insert_stmt="INSERT INTO host_info (hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, L2_cache, total_mem, timestamp)
  VALUES ('$hostname', $cpu_number, '$cpu_architecture', '$cpu_model', $cpu_mhz, $l2_cache, $total_mem, '$timestamp')"

#insert SQL statement into PSQL database
psql -h "$psql_host" -p "$psql_port" -d "$db_name" -U "$psql_user" -c "$insert_stmt"
exit $?