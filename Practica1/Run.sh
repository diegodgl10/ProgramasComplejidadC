#!/bin/bash

if [ -d target/ ];
then
	rm -r target/
fi

mkdir -p target/classes/

javac src/*.java -d target/classes/

cd target/classes/

#java Programa1

#for i in $(seq 1 20);
#do
	java Programa1 -t
#    echo 
#done