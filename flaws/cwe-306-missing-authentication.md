Reviewdemo Top25: CWE-306 Missing Authentication for Critical Function
=======================================================================

Critical functions are exposed without verifying that the caller is authenticated.
This allows unauthenticated users to access sensitive utilities.

Exploit - Use tools without authentication
------------------------------------------
1. Open `/tools` without logging in.
2. Execute a command or allocation task.

Mitigate
--------
Require authentication for all sensitive endpoints.

Remediate
---------
Add an authentication filter and enforce session checks in controllers.

Resources
---------
* [CWE 306](https://cwe.mitre.org/data/definitions/306.html)
