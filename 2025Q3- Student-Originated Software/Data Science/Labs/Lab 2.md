Alexis Baker


Data Science


Lab 2 (Zylab 3.10)


`main.py`

```python
import statsmodels.stats as st
from statsmodels.stats.proportion import proportions_ztest
import pandas as pd

# Read in gpa.csv
gpa = pd.read_csv("gpa.csv")

# Get the value of the proportion for the null hypothesis
value = float(input())
# Get the gpa cutoff
cutoff = float(input())

# Determine the number of students with a gpa higher than cutoff
counts = (gpa['gpa']>cutoff).sum()

# Determine the total number of students
nobs = len(gpa)

# Perform z-test for counts, nobs, and value
# Modify prop_var parameter
ztest = (proportions_ztest(counts,nobs,value,prop_var=value))
print("(", end="")
print(round(ztest[0],3), ", ", end="")
print(round(ztest[1],3), ")")


if ztest[1] < 0.01:
    print("The two-tailed p-value, ", end="")
    print(round(ztest[1],3), ", is less than \u03B1. Thus, sufficient evidence exists to support the hypothesis that the proportion is different from", value)
else:
    print("The two-tailed p-value, ", end="")
    print(round(ztest[1],3), ", is greater than \u03B1. Thus, insufficient evidence exists to support the hypothesis that the proportion is different from", value)
```
