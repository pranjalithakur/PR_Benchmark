Reviewdemo Top25: CWE-94 Improper Control of Generation of Code ('Code Injection')
==================================================================================

The report runner executes user-provided expressions directly in a scripting engine.
This allows arbitrary code execution in the script context.

Exploit - Script injection via reports
--------------------------------------
1. Open `/reports` and submit an expression such as `java.lang.Runtime.getRuntime().exec("id")`.
2. Observe that the engine evaluates the expression.

Mitigate
--------
Avoid dynamic evaluation of untrusted expressions.
If expression support is required, implement a strict allowlist and sandbox.

Remediate
---------
Remove script execution from the request path or use a safe, restricted DSL.

Resources
---------
* [CWE 94](https://cwe.mitre.org/data/definitions/94.html)
