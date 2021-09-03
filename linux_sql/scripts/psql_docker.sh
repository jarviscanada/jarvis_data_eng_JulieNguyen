#!/bin/bash

#three command line arguments: cmd, db_username, db_password
cmd=$1
db_username=$2
db_password=$3

#check if docker is running, if true, start docker.
#systemctl status docker command output is sent to a null device to not output to the shell.
if (! sudo systemctl status docker >/dev/null 2>/dev/null); then
  sudo systemctl start docker
fi

#if command is "create", create a docker container
if [ "${cmd}" == "create" ]; then
  #if docker container already exists, error
  if [ "$(docker container ls -a -f name=jrvs-psql | wc -l)" == 2 ]; then
    echo "Error: Docker container \"jrvs-psql\" already exists."
    exit 1
  fi

  #if username or password is not in the command line (command line does not have 3 arguments), error
  if [ "$#" != 3 ]; then
    echo "Error: Missing username or password."
    exit 1
  fi

  #create docker volume & docker container "jrvs-psql"
  docker volume create pgdata
  docker run --name jrvs-psql -e POSTGRES_PASSWORD="${db_password}" -e POSTGRES_USER="${db_username}" -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres
  exit $?
fi

#if docker container has not been created, error
if [ "$(docker container ls -a -f name=jrvs-psql | wc -l)" != 2 ]; then
  echo "Error: Docker container \"jrvs-psql\" does not exist."
  exit 1
fi

#if command is start, then start docker container
if [ "${cmd}" == "start" ]; then
  #start container
  docker container start jrvs-psql
  exit $?
fi

#if command is stop, then stop docker container
if [ "${cmd}" == "stop" ]; then
  #stop container
  docker container stop jrvs-psql
  exit $?
fi

#if command does not exist
echo "Error: Invalid command."

exit 0