#!/bin/bash
# Generates new libs and copies them in the destination dir (first arg)
# if optional 2nd arg present, commits the project with message 2nd arg

test -z "$1" && { echo "Give the destination dir"; exit 1; }

# if subdir "lib" does not exist, we must be in subdir "utils"
# therefore go up in parent dir
test -d lib || cd ..

OLD_DATE=`ls lib/famix*.jar | awk -F[-.] '{print $2}'`

#if ant jar files, stop all
ant jar || { echo "ant jar failed"; exit 1; }

NEW_DATE=`date '+%Y%m%d_%H%M'`

# did we generate new libs correctly?
NEW_FAMIX="lib/famix-${NEW_DATE}.jar"
test -f ${NEW_FAMIX} || { echo "${NEW_FAMIX} not found"; exit 1; }

rm -f lib/*-${OLD_DATE}.jar

# If there is a commit message then commit
test -z "$2" || svn commit -m "$2"

DEST=$1
rm -f ${DEST}/lib/*-${OLD_DATE}.jar
cp lib/*-${NEW_DATE}.jar ${DEST}/lib
