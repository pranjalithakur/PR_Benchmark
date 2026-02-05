Reviewdemo Top25: CWE-284 Improper Access Control
=================================================

Sensitive actions rely on client-controlled headers to indicate roles instead of enforcing
server-side access controls.

Exploit - Access admin pages by setting a role header
-----------------------------------------------------
1. Send a request to `/admin` with `X-Role: admin`.
2. Observe admin functionality without a validated role.

Mitigate
--------
Use server-side session roles and enforce access checks on every request.

Remediate
---------
Remove trust in client-supplied role headers and implement consistent authorization.

Resources
---------
* [CWE 284](https://cwe.mitre.org/data/definitions/284.html)
