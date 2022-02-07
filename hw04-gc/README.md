#App run statistic table

| -Xmx and -Xms size | Spend time before refactoring, ms | Spend time after refactoring, ms |
|--------------------|-----------------------------------|----------------------------------|
| 256m               | OutOfMemoryError                  | 921                              |
| 512m               | 17119                             | 963                              |
| 1g                 | 14294                             | 946                              |
| 2g                 | 13352                             | 971                              |
| 3g                 | 13316                             | 1010                             |
| 4g                 | 13604                             | 979                              |

Before refactoring we haven't spent time changes from 2g option.