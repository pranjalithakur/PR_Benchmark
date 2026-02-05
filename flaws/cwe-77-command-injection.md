Reviewdemo Top25: CWE-77 Improper Neutralization of Special Elements used in a Command ('Command Injection')
============================================================================================================

The scan utility appends user input to a system command without proper neutralization.
Attackers can inject additional shell arguments or commands.

Exploit - Inject shell arguments in scan
---------------------------------------
1. Open `/tools` and submit a host with extra arguments (e.g., `127.0.0.1; whoami`).
2. Observe that the injected command executes.

Mitigate
--------
Avoid shell invocation when possible. Use safe APIs with argument lists.

Remediate
---------
Validate and escape user input, and use `ProcessBuilder` with fixed arguments.

Resources
---------
* [CWE 77](https://cwe.mitre.org/data/definitions/77.html)
