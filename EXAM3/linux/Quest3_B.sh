#!/bin/bash

# Intentionally generate an error and send it to error.log
ls nonexistentfile 2>> error.log

echo "Error logged to error.log"
