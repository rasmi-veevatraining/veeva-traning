#!/bin/bash

# Search for files modified in the last 3 days in the current directory
echo "Files modified in the last 3 days:"
find . -maxdepth 1 -type f -mtime -3
