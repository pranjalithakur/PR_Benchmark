Reviewdemo Top25: CWE-434 Unrestricted Upload of File with Dangerous Type
=========================================================================

The upload endpoint stores files using their original names and does not validate file type.
Attackers can upload executable or server-side files that may be invoked later.

Exploit - Upload a dangerous file type
--------------------------------------
1. Open `/upload` and submit a file with a server-executable extension (e.g., `.jsp`).
2. Observe that the file is stored in the target directory without validation.

Mitigate
--------
Restrict allowed content types and file extensions.
Store uploads outside the web root and use generated file names.

Remediate
---------
Implement a strict allowlist for file types and scan uploads.
Ensure files are never executed by the server.

Resources
---------
* [CWE 434](https://cwe.mitre.org/data/definitions/434.html)
