Reviewdemo Top25: CWE-121 Stack-based Buffer Overflow
=====================================================

The diagnostics memory handler writes user-controlled data into a fixed-size local buffer.
Oversized input can overflow the buffer and trigger runtime errors.

Exploit - Overflow a local buffer
---------------------------------
1. Submit a diagnostics request with a large length value.
2. Observe exceptions when writing beyond the local buffer size.

Mitigate
--------
Validate lengths against the fixed buffer size.

Remediate
---------
Replace fixed-size buffers with bounded, validated structures.

Resources
---------
* [CWE 121](https://cwe.mitre.org/data/definitions/121.html)
