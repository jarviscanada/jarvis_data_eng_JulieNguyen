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

hostname=$(hostname -f)

#save statistics to a variable
mem_out=`cat /proc/meminfo`
cpustat_out=`vmstat -t`
diskstat_out=`vmstat -d`
disk_out=`df -BM /`

#usage
timestamp=$(date +"%Y-%m-%d %T") #current timestamp in `2019-11-26 14:40:19` format
memory_free=$(echo "$mem_out" | grep 'MemFree:' | awk '{print $2}'| xargs)
cpu_idle=$(echo "$cpustat_out" | tail -1 | awk '{print $15}' | xargs) #id is cpu idle percentage. temp solution
cpu_kernel=$(echo "$cpustat_out" | tail -1 | awk '{print $14}' | xargs) #sy is cpu kernel percentage
disk_io=$(echo "$diskstat_out" | tail -1 | awk '{print $10}' | xargs)
disk_available=$(echo "$disk_out" | tail -1 | awk '{print substr($4, 1, length($4)-1)}' | xargs)

#subquery to get host_id from host_info
host_id="SELECT id FROM host_info WHERE hostname='$hostname'"

#insert usage information into SQL database
insert_stmt="INSERT INTO host_usage (timestamp, host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available)
  VALUES ('$timestamp', ($host_id), $memory_free, $cpu_idle, $cpu_kernel, $disk_io, $disk_available)"

#insert SQL statement into PSQL database
psql -h "$psql_host" -p "$psql_port" -d "$db_name" -U "$psql_user" -c "$insert_stmt"
exit $?