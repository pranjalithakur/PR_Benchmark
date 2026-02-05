Reviewdemo Top25: CWE-770 Allocation of Resources Without Limits or Throttling
==============================================================================

Resource allocation endpoints allow users to request large amounts of memory without limits.
This can exhaust server resources and impact availability.

Exploit - Allocate excessive resources
--------------------------------------
1. Open `/tools` and submit a very large count in the allocation form.
2. Observe memory exhaustion or degraded performance.

Mitigate
--------
Enforce rate limits and quotas for resource-intensive operations.

Remediate
---------
Add input limits and server-side guards on allocation size.

Resources
---------
* [CWE 770](https://cwe.mitre.org/data/definitions/770.html)
