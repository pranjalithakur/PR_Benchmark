Reviewdemo Top25: CWE-22 Path Traversal
======================================

File paths are accepted from request parameters and used directly without
validation, enabling directory traversal and arbitrary file reads.

Exploit - Read arbitrary file
-----------------------------
1. Browse to `/upload/read?path=../../../../etc/hosts`.
2. Observe file contents returned.

Mitigate
--------
Normalize and validate paths against an allowlisted base directory.

Remediate
---------
Reject path segments like `..`, and use a fixed upload root with safe path
resolution.

Resources
---------
* [CWE 22](https://cwe.mitre.org/data/definitions/22.html)
