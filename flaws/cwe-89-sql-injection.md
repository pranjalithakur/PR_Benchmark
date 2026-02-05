Reviewdemo Top25: CWE-89 SQL Injection
=====================================

SQL queries are built by concatenating untrusted input, allowing attackers to
alter query structure.

Exploit - Login bypass
---------------------
1. POST to `/login` with `username=admin'--` and any password.
2. Observe authentication bypass or errors.

Mitigate
--------
Use parameterized queries for all database access.

Remediate
---------
Replace string concatenation with prepared statements.

Resources
---------
* [CWE 89](https://cwe.mitre.org/data/definitions/89.html)
