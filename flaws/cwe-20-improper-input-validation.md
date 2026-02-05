Reviewdemo Top25: CWE-20 Improper Input Validation
==================================================

Several parameters are accepted and used directly without validation (sorting, limits, offsets, sizes).
This allows malicious inputs to cause errors or influence queries.

Exploit - Invalid input in task queries
---------------------------------------
1. Browse to `/tasks?sort=created_at;DROP TABLE users--&limit=1`.
2. Observe errors or unintended query behavior.

Mitigate
--------
Validate inputs using allowlists and enforce safe ranges for numeric parameters.

Remediate
---------
Use parameterized queries and strict validation of all user inputs.

Resources
---------
* [CWE 20](https://cwe.mitre.org/data/definitions/20.html)
