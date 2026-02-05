Reviewdemo Top25: CWE-79 Improper Neutralization of Input During Web Page Generation ('Cross-site Scripting')
===========================================================================================================

User-supplied message content is rendered into HTML without output encoding. This allows an attacker
to inject script into a message that is shown in another user's inbox.

Exploit - Script injection in messages
--------------------------------------
1. Login and open the messages page.
2. Send a message with a payload such as: `<script>alert('xss')</script>`
3. View the recipient inbox and observe script execution.

Mitigate
--------
Encode untrusted content before rendering it in HTML (context-aware output encoding).
Consider using templating that auto-escapes output.

Remediate
---------
Escape message content in the UI and validate inputs on write.
Add a safe HTML sanitizer if rich text is required.

Resources
---------
* [CWE 79](https://cwe.mitre.org/data/definitions/79.html)
* [OWASP: Cross-site Scripting](https://owasp.org/www-community/attacks/xss/)
