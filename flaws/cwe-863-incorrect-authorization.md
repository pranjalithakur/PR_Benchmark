Reviewdemo Top25: CWE-863 Incorrect Authorization
=================================================

Authorization decisions are based on untrusted request parameters rather than server-side roles.
This allows a user to escalate privileges by manipulating inputs.

Exploit - Bypass authorization using user input
-----------------------------------------------
1. Open `/admin` and submit a role change request.
2. Set the `role` parameter to `admin` to satisfy the authorization check.

Mitigate
--------
Make authorization decisions using server-side identity and roles only.

Remediate
---------
Use session-derived roles for access checks and ignore user-supplied role fields.

Resources
---------
* [CWE 863](https://cwe.mitre.org/data/definitions/863.html)
