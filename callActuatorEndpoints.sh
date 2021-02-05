#!/bin/bash

for ENDPOINT in `echo health auditevents beans caches conditions configprops env flyway httptrace info integrationgraph loggers liquibase metrics mappings scheduledtasks sessions shutdown startup threaddump`
do
  echo -e "=" $ENDPOINT "===========================================================================\n"
  curl localhost:9001/actuator/${ENDPOINT}
  printf "\n\n"
done

