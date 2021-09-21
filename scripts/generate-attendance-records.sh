#!/bin/bash

if [ $# -ne 4 ]; then
  echo "Error: Wrong script usage" >&2
  echo "Usage:   $0 -u <username>:<password> -h <host_addr>" >&2
  echo "Example: $0 -u admin:admin -h localhost:8080" >&2
  exit 1
fi

while getopts ":u:h:" flag
do
  case "$flag" in
    u) user="$OPTARG";;
    h)
      employeesEndpoint="$OPTARG/api/employees"
      attendanceEndpoint="$OPTARG/api/attendance"
      ;;
    ?)
      echo "Error: Invalid option was specified -$OPTARG" >&2
      exit 1
      ;;
  esac
done

employeeIds=$(curl -s -X GET -u "$user" -H "Content-Type: application/json;charset=UTF-8" "$employeesEndpoint" | jq '.[].id')

for id in $employeeIds;
do
  format='%Y-%m-%d %H:%M:%S'
  entryTimeVariance=$(seq $((-10*60)) $((5*60)) | shuf -n 1) # between -10 and 5 minutes
  exitTimeVariance=$(seq $((8*60*60)) $((9*60*60)) | shuf -n 1) # between 8 and 9 hours
  enteredAt=$(date -d "$entryTimeVariance seconds" +"$format")
  leftAt=$(date -d "$exitTimeVariance seconds" +"$format")
  body="{\"employeeId\": \"$id\", \"enteredAt\":\"$enteredAt\", \"leftAt\":\"$leftAt\"}"
  curl -X POST -u "$user" -H "Content-Type: application/json;charset=UTF-8" -d "$body" "$attendanceEndpoint"
  sleep 0.5;
done
