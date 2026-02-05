Reviewdemo Top25: CWE-787 Out-of-bounds Write
============================================

The diagnostics endpoint writes data into a native buffer using user-supplied offsets and lengths.
Without bounds checks, writes can occur beyond the allocated memory region.

Exploit - Write beyond buffer size
----------------------------------
1. Open `/diagnostics` and submit a memory request with a small size (e.g., 8).
2. Provide a large offset (e.g., 1024) or a large length.
3. Observe errors or instability as memory is written past the buffer.

Mitigate
--------
Validate offsets and lengths against the allocated buffer size.
Avoid unsafe memory operations when possible.

Remediate
---------
Use bounds-checked buffers and throw explicit validation errors.
Remove unsafe memory utilities from the request path.

Resources
---------
* [CWE 787](https://cwe.mitre.org/data/definitions/787.html)
