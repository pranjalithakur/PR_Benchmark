Reviewdemo Top25: CWE-78 OS Command Injection
=============================================

User-controlled input is passed to OS command execution without validation,
allowing arbitrary command execution.

Exploit - Execute arbitrary command
----------------------------------
1. POST to `/tools/exec` with `command=whoami`.
2. Observe command output returned by the server.

Mitigate
--------
Avoid shell execution; use safe APIs and allowlists for arguments.

Remediate
---------
Disallow arbitrary commands and remove direct use of `Runtime.exec`.

Resources
---------
* [CWE 78](https://cwe.mitre.org/data/definitions/78.html)
