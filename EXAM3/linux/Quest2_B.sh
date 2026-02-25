#!/bin/bash

# Check if 2 arguments are provided
if [ $# -ne 2 ]; then
    echo "Usage: $0 <tag> <html_file>"
    echo "Example: $0 title index.html"
    exit 1
fi

tag=$1
file=$2

echo "Extracting text between <$tag>...</$tag> from $file"

# Use grep with regex to extract tag content
grep -oP "(?<=<$tag>).*?(?=</$tag>)" "$file"
