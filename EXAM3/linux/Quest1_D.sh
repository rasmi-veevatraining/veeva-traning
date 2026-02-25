#!/bin/bash

# Check if user provided an extension
if [ -z "$1" ]; then
    echo "Usage: $0 <extension>"
    echo "Example: $0 txt"
    exit 1
fi

# Store the extension
ext=$1

echo "Files with extension .$ext in the current directory:"
find . -maxdepth 1 -type f -name "*.$ext"
