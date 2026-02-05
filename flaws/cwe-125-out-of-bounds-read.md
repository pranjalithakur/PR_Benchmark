Reviewdemo Top25: CWE-125 Out-of-bounds Read
===========================================

The diagnostics endpoint reads from a native buffer using user-provided offsets and lengths.
If these exceed the buffer size, data is read outside of the allocated region.

Exploit - Read beyond buffer size
---------------------------------
1. Submit a diagnostics memory request with a small size.
2. Provide a large offset or length.
3. Observe errors or unexpected data.

Mitigate
--------
Validate offsets and lengths against the buffer size before reading.

Remediate
---------
Use safe buffer abstractions with bounds checks.
Reject out-of-range requests with a 400 response.

Resources
---------
* [CWE 125](https://cwe.mitre.org/data/definitions/125.html)
