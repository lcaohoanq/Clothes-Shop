#!/bin/bash
# Wait for SQL Server to start
echo "Waiting for SQL Server to start..."
sleep 30s

# Run the initialization script
echo "Initializing database..."
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P $MSSQL_SA_PASSWORD -i /usr/src/app/init.sql
echo "Database initialized"