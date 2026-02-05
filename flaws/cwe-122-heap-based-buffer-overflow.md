Reviewdemo Top25: CWE-122 Heap-based Buffer Overflow
====================================================

Native memory buffers are allocated on the heap and written using user-provided lengths.
Large writes can overflow the allocated heap region.

Exploit - Overflow a heap buffer
--------------------------------
1. Submit a diagnostics request with a small size and large length.
2. Observe errors or instability from heap overflow.

Mitigate
--------
Validate write sizes and offsets before interacting with heap buffers.

Remediate
---------
Remove unsafe heap memory operations from request paths.
Use safe bounded buffers instead.

Resources
---------
* [CWE 122](https://cwe.mitre.org/data/definitions/122.html)
