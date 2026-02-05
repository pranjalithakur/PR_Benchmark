Reviewdemo Top25: CWE-862 Missing Authorization
==============================================

Administrative actions are exposed without verifying that the caller is authorized to perform them.
This allows any authenticated user (or sometimes even anonymous users) to access sensitive functions.

Exploit - Access admin actions without authorization
---------------------------------------------------
1. Browse to `/admin` without any admin role.
2. Submit the promotion form to update another user's role.

Mitigate
--------
Enforce role-based access checks on every sensitive action.
Centralize authorization in a shared filter or interceptor.

Remediate
---------
Require admin authorization for all admin endpoints.
Return a 403 response when authorization is missing or invalid.

Resources
---------
* [CWE 862](https://cwe.mitre.org/data/definitions/862.html)
