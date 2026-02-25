#!/bin/bash

# Check if 2 arguments are given
if [ $# -ne 2 ]; then
    echo "Usage: $0 <string> <filename>"
    echo "Example: $0 hello sample.txt"
    exit 1
fi

# Store arguments
string=$1
file=$2

# Search the string in the file
echo "Searching for '$string' in $file ..."
grep "$string" "$file"
