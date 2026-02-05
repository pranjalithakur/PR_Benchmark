Reviewdemo Top25: CWE-502 Deserialization of Untrusted Data
===========================================================

User input is deserialized using `ObjectInputStream.readObject()` without
validation, enabling gadget-based attacks.

Exploit - Malicious serialized payload
--------------------------------------
1. POST to `/admin/import` with a crafted serialized object payload.
2. Observe unexpected behavior during deserialization.

Mitigate
--------
Avoid Java native deserialization for untrusted data.

Remediate
---------
Use safe formats (JSON) and allowlist types if deserialization is required.

Resources
---------
* [CWE 502](https://cwe.mitre.org/data/definitions/502.html)
