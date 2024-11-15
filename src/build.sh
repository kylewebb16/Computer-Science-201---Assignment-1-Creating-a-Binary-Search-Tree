#!/bin/bash
if javac -d ../bin/ *.java; then
    java -cp ../bin/ Main
else
    echo "Did not compile"
fi