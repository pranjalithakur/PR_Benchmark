Reviewdemo Top25: CWE-120 Buffer Copy without Checking Size of Input ('Classic Buffer Overflow')
================================================================================================

The diagnostics endpoint copies user data into a fixed-size buffer without verifying the length.
Excess input causes buffer overwrites or exceptions.

Exploit - Oversized payload into fixed buffer
---------------------------------------------
1. Open `/diagnostics` and submit a large `length` value.
2. Observe errors when the copy exceeds the fixed-size buffer.

Mitigate
--------
Validate input size before copying.
Use safe copy operations with explicit bounds.

Remediate
---------
Add maximum size limits and reject oversized requests.

Resources
---------
* [CWE 120](https://cwe.mitre.org/data/definitions/120.html)
