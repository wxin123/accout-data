echo "start mvn"
mvn clean
mvn package -Dmaven.test.skip=true