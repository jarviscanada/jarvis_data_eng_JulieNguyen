#!/bin/bash

cmd=$1
db_username=$2
db_password=$3

#check if docker is running
if (! docker stats --no-stream ); then
  sudo systemctl status docker || systemctl start docker
fi

if [ "${cmd}" == "create" ]; then
  if [ "$(docker container ls -a -f name=jrvs-psql | wc -l)" == 2 ]; then
    echo "Error: Docker container \"jrvs-psql\" already exists."
    exit 1
  fi

  if [ "$#" != 3 ]; then
    echo "Error: Missing username or password."
    exit 1
  fi

  docker volume create pgdata
  docker run --name jrvs-psql -e POSTGRES_PASSWORD="${db_password}" -e POSTGRES_USER="${db_username}" -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres
  exit $?
fi

if [ "$(docker container ls -a -f name=jrvs-psql | wc -l)" != 2 ]; then
  echo "Error: Docker container \"jrvs-psql\" does not exist."
  exit 1
fi

if [ "${cmd}" == "start" ]; then
  #start container
  docker container start jrvs-psql
  exit $?
fi

if [ "${cmd}" == "stop" ]; then
  #stop container
  docker container stop jrvs-psql
  exit $?
fi

echo "Error: Invalid command."

exit 0