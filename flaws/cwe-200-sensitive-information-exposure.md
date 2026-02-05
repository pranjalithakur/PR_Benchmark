Reviewdemo Top25: CWE-200 Sensitive Information Exposure
========================================================

Sensitive data (credentials, passwords, system properties) is returned to
clients or embedded in responses.

Exploit - View sensitive data
-----------------------------
1. Browse to `/profile` or `/admin/env`.
2. Observe passwords or environment/system properties exposed.

Mitigate
--------
Never expose secrets; redact sensitive fields in responses.

Remediate
---------
Remove hardcoded secrets and filter sensitive properties from output.

Resources
---------
* [CWE 200](https://cwe.mitre.org/data/definitions/200.html)
