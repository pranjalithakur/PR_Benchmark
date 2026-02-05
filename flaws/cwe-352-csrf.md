Reviewdemo Top25: CWE-352 Cross-Site Request Forgery
===================================================

State-changing POST endpoints lack CSRF protections, allowing attackers to
trick authenticated users into unwanted actions.

Exploit - CSRF on profile update
--------------------------------
1. Host a page that auto-submits a POST to `/profile/update`.
2. Visit it while logged in and observe profile changes.

Mitigate
--------
Require CSRF tokens for state-changing requests.

Remediate
---------
Implement server-side CSRF validation and include tokens in forms.

Resources
---------
* [CWE 352](https://cwe.mitre.org/data/definitions/352.html)
