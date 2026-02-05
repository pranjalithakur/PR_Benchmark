Reviewdemo Top25: CWE-476 NULL Pointer Dereference
==================================================

Some request flows dereference optional parameters without checking for null.
This causes runtime errors and can be used to disrupt service.

Exploit - Trigger null dereference
----------------------------------
1. Visit `/dashboard` without a `theme` parameter.
2. Observe a server error caused by a null value being accessed.

Mitigate
--------
Validate optional inputs and use safe defaults.

Remediate
---------
Add null checks around parameter access and return a proper error response.

Resources
---------
* [CWE 476](https://cwe.mitre.org/data/definitions/476.html)
