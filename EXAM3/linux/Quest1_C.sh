#!/bin/bash

# Search for files larger than 1KB in the current directory
echo "Files larger than 1KB:"
find . -maxdepth 1 -type f -size +1k
