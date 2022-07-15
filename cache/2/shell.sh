#!/bin/bash
for i in {200..2000..200} 
do 
java deepDepression $i $i $i $i o >> testeO.txt
done
for i in {200..2000..200}
do
java deepDepression $i $i $i $i t >> testeT.txt
done
