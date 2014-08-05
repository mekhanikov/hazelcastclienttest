# Bug description.
Reproduced in 3.2.4 and 3.3-RC2 versions.

Expected result:
in console:
- 200 messages "BEFORE"
- 200 messages "AFTER"
- message "EXIT".

Actual result:
in console:
0
BEFORE
1
BEFORE
2
BEFORE
3
BEFORE


Maybe the reason because thread pool has no more free threads to normal work. 
