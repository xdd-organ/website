#!/bin/sh

#--------------------------------------------
# 功能：停止项目 website.jar
#--------------------------------------------

PROJECT_NAME="website.jar"

#------------------关闭服务--------------------------#
#stop server
PIDS=(`ps -ef|grep ${PROJECT_NAME}|grep -v grep|awk {'print $2'}`)
if [[ ${PIDS} ]] ;then
   for s in ${PIDS[@]}
   do
      kill -9 $s
   done
else
   echo "${PROJECT_NAME} does not start"
fi


