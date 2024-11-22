#!/bin/bash

# Compiles src into bin and runs the application
if javac -d ./bin/ src/*.java; then
    java -cp ./bin/ Main
else
    echo "Did not compile"
fi