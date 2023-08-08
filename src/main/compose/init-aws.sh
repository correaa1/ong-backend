#!/usr/bin/env bash

awslocal dynamodb create-table --table-name Users --attribute-definitions AttributeName=id,AttributeType=S --key-schema AttributeName=id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5
awslocal dynamodb create-table --table-name Delivery --attribute-definitions AttributeName=idDelivery,AttributeType=S --key-schema AttributeName=idDelivery,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5
