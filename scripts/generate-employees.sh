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
    h) url="$OPTARG/api/employees";;
    ?)
      echo "Error: Invalid option was specified -$OPTARG" >&2
      exit 1
      ;;
  esac
done

jsonData=(
  '{
    "firstName": "Tietiana",
    "lastName": "Tarasenko",
    "contractId": "CV12345678",
    "department": "Logistics",
    "street": "Gorgondona 12",
    "postCode": "86-300",
    "city": "Kraków"
  }'
  '{
    "firstName": "Mateo",
    "lastName": "Gała",
    "contractId": "CV12345699",
    "department": "Logistics",
    "street": "Pogromcy Smoków i Dziewic 13/a",
    "postCode": "86-300",
    "city": "Kraków"
  }'
  '{
    "firstName": "Mafetke",
    "lastName": "Zateus",
    "contractId": "CV12345669",
    "department": "IT",
    "street": "Wojska Polskiego 12/9",
    "postCode": "86-300",
    "city": "Kraków"
  }'
  '{
    "firstName": "Wojtek",
    "lastName": "Dsw",
    "contractId": "CV22345699",
    "department": "IT",
    "street": "Święty Wojciech 77",
    "postCode": "86-300",
    "city": "Głogów"
  }'
  '{
    "firstName": "Jacobi",
    "lastName": "Wilku",
    "contractId": "CV23345699",
    "department": "IT",
    "street": "Mazura i Pazura 43/222a",
    "postCode": "86-300",
    "city": "Głogów"
  }'
  '{
    "firstName": "Valdena",
    "lastName": "Yalanska",
    "contractId": "CV22345654",
    "department": "Product Verification",
    "street": "Szona Kisielińska 18/300",
    "postCode": "12-304",
    "city": "Świebodzin"
  }'
  '{
    "firstName": "Olena",
    "lastName": "Yanushkiewic",
    "contractId": "CV22345254",
    "department": "Product Verification",
    "street": "Szona Kisielińska 18/301",
    "postCode": "12-304",
    "city": "Świebodzin"
  }'
  '{
    "firstName": "Oleksander",
    "lastName": "Baranowsky",
    "contractId": "CV22312345",
    "department": "Product Verification",
    "street": "Szona Kisielińska 18/302",
    "postCode": "12-304",
    "city": "Świebodzin"
  }'
  '{
    "firstName": "Oleksander",
    "lastName": "Omelchenko",
    "contractId": "CV22312344",
    "department": "Product Verification",
    "street": "Szona Kisielińska 18/303",
    "postCode": "12-304",
    "city": "Świebodzin"
  }'
  '{
    "firstName": "Anna",
    "lastName": "Kowalska",
    "contractId": "CV98765432",
    "department": "Product Verification",
    "street": "Zbrodniarza Radzieckiego 44a/12",
    "postCode": "76-660",
    "city": "Zielona Góra"
  }'
  '{
    "firstName": "Błonisław",
    "lastName": "Kowalski",
    "contractId": "CV98765433",
    "department": "Product Verification",
    "street": "Zbłodniarza Ładzieckiego 44a/12",
    "postCode": "76-660",
    "city": "Zielona Góra"
  }'
  '{
    "firstName": "Monka",
    "lastName": "Sumna",
    "contractId": "CV98765669",
    "department": "IT",
    "street": "Skargi 12",
    "postCode": "76-661",
    "city": "Zielona Góra"
  }'
)

for body in "${jsonData[@]}";
do
  curl -X POST -u "$user" -H "Content-Type: application/json;charset=UTF-8" -d "$body" "$url"
  sleep 0.5;
done
