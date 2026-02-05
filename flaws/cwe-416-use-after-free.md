Reviewdemo Top25: CWE-416 Use After Free
========================================

The diagnostics memory workflow frees a native buffer and continues to read from it.
This can cause unexpected data reads or crashes.

Exploit - Read after free
-------------------------
1. Submit a diagnostics memory request.
2. Observe that the response reads from the buffer after it has been freed.

Mitigate
--------
Ensure buffers are not accessed after being freed.
Invalidate references and short-circuit code paths post-free.

Remediate
---------
Move all reads before freeing memory.
Guard access with a freed flag and throw on access.

Resources
---------
* [CWE 416](https://cwe.mitre.org/data/definitions/416.html)
