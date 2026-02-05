Reviewdemo Top25: CWE-639 Authorization Bypass Through User-Controlled Key
==========================================================================

User identifiers are accepted from the request and used to access data without verifying ownership.
This enables direct access to other users' tasks, messages, or profile data.

Exploit - Access another user's data
-----------------------------------
1. Open `/messages?userId=otheruser` or `/tasks?owner=otheruser`.
2. Observe that another user's records are displayed.

Mitigate
--------
Always derive object ownership from the authenticated session, not from request parameters.

Remediate
---------
Filter queries by the session user and enforce per-user access control.

Resources
---------
* [CWE 639](https://cwe.mitre.org/data/definitions/639.html)
