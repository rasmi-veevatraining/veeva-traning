#!/bin/bash

# Ask for filename
echo "Enter filename to search:"
read filename

echo "----- Checking in current directory -----"
# Check file in current directory
if [ -e "$filename" ]; then
    echo "File '$filename' exists in current directory."
else
    echo "File '$filename' does NOT exist in current directory."
fi

echo "----- Searching entire system -----"
# Search file entire system
location=$(find / -name "$filename" 2>/dev/null)

if [ -n "$location" ]; then
    echo "File found at:"
    echo "$location"
else
    echo "File NOT found anywhere in system."
fi
