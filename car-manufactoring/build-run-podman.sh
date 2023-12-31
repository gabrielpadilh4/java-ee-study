#!/bin/bash
set -eu

mvn clean package

chmod 777 $(pwd)/target/car-manufactoring.war

podman run --rm --privileged \
    -p 8080:8080 \
    -v $(pwd)/target/car-manufactoring.war:/opt/jboss/wildfly/standalone/deployments/car-manufactoring.war \
    jboss/wildfly:25.0.0.Final


# curl -s localhost:8080/car-manufactoring/resources/cars | jq
# curl localhost:8080/car-manufactoring/resources/cars -XPOST -H 'content-type: application/json' -d '{"color":"RED", "engineType":"DIESEL"}'
