Reviewdemo Top25: CWE-918 Server-Side Request Forgery (SSRF)
===========================================================

The report fetch feature accepts arbitrary URLs and makes server-side HTTP requests.
Attackers can use this to access internal services or metadata endpoints.

Exploit - Fetch internal resources
----------------------------------
1. Open `/reports` and submit a URL such as `http://127.0.0.1:8080/admin`.
2. Observe the response body returned by the server.

Mitigate
--------
Restrict outbound requests to an allowlist of known safe hosts.
Block access to internal IP ranges and metadata endpoints.

Remediate
---------
Add URL validation and DNS/IP checks before outbound requests.

Resources
---------
* [CWE 918](https://cwe.mitre.org/data/definitions/918.html)
