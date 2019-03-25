#!/bin/bash

#取当前目录
BASE_PATH=`cd "$(dirname "$0")"; pwd`

#设置java运行参数
DEFAULT_JAVA_OPTS=" -server -Xmx512m -Xms512m -Xmn256m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128M -Xss256k"

#定义变量:
JAVA_OPTS=${JAVA_OPTS:-$DEFAULT_JAVA_OPTS}
JAR_NAME=${JAR_NAME:-"account.jar"}
PROFILE=$2

exist(){
            if test $( lsof $JAR_NAME |grep $JAR_NAME | head -n 1 | cut -d" " -f5 | wc -l ) -eq 0
            then
                return 1
            else
                return 0
            fi
}

start(){
        if [ ! -n $PROFILE  ] ;then
            $PROFILE="dev"
        fi
        if exist; then
                echo "$JAR_NAME is already running."
                exit 1
        else
##                ulimit -SHn 65535;
                cd $BASE_PATH
                nohup java $JAVA_OPTS  -jar -Dspring.profiles.active=$PROFILE $JAR_NAME 2> /dev/null &
                echo "$JAR_NAME is started."
                exit 0
        fi
}

stop(){
    runningPID=`lsof $JAR_NAME |grep $JAR_NAME |  head -n 1 | cut -d" " -f5`
    if [ "$runningPID" ]; then
                echo "$JAR_NAME pid: $runningPID"
            count=0
        kwait=5
        echo "$JAR_NAME is stopping, please wait..."
        kill -15 $runningPID
                    until [ `ps --pid $runningPID 2> /dev/null | grep -c $runningPID 2> /dev/null` -eq '0' ] || [ $count -gt $kwait ]
                do
                    sleep 1
                    let count=$count+1;
                done

            if [ $count -gt $kwait ]; then
                kill -9 $runningPID
            fi
        clear
        echo "$JAR_NAME is stopped."
    else
            echo "$JAR_NAME has not been started."
    fi
}

check(){
   if exist; then
        echo "$JAR_NAME is alive."
        exit 0
   else
        echo "$JAR_NAME is dead."
        exit -1
   fi
}

restart(){
        stop
        start
}

case "$1" in

start)
        start
;;
stop)
        stop
;;
restart)
        restart
;;
check)
        check
;;
*)
        echo "available operations: [start|stop|restart|check]"
        exit 1
;;
esac
