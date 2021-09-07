#!/bin/bash

#three command line arguments: cmd, db_username, db_password
cmd=$1
db_username=$2
db_password=$3

#variable checking if docker container exists
container_wc=$(docker container ls -a -f name=jrvs-psql | wc -l)

#check if docker is running, if true, start docker.
sudo systemctl status docker >/dev/null 2>/dev/null || systemctl start docker

#if command is "create", create a docker container
if [ "${cmd}" == "create" ]; then
    if [ $"$container_wc" == 2 ]; then
      echo "Error: Docker container \"jrvs-psql\" already exists."
      exit 1
    #if username or password is not in the command line (command line does not have 3 arguments), error
    elif [ "$#" != 3 ]; then
      echo "Error: Missing username or password."
      exit 1
    fi

    #create docker volume & docker container "jrvs-psql"
    docker volume create pgdata
    docker run --name jrvs-psql -e POSTGRES_PASSWORD="${db_password}" -e POSTGRES_USER="${db_username}" -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres
    exit $?
fi

#if docker container has not been created, error
if [ "$container_wc" != 2 ]; then
  echo "Error: Docker container \"jrvs-psql\" does not exist."
  exit 1
fi

#if command is start/stop, then start/stop docker container
case "${cmd}" in
  "start")
    docker container start jrvs-psql
    exit $?
  ;;
  "stop")
    docker container stop jrvs-psql
    exit $?
  ;;
esac

#if command does not exist
echo "Error: Invalid command."
exit 1