Alexis Baker


Data Science


Lab 4 (Zylabs 6.11)


`main.py`

```python
import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns

# Load the data
health = pd.read_csv("diabetes.csv")

# Change data type of SEQN
health["SEQN"] = health["SEQN"].astype("string")

# Find the dimensions of health
dimensions = health.shape
print("Dimensions:", dimensions)

# Find the name, number of non-null values, and type of each feature
description = health.info()
print(description)

# Set the figure dimensions to 14 by 10
sns.set(rc={'figure.figsize': (14, 10)})

# Create a figure containing a scatterplot for every pair of numeric features, save as scatterplots.png
pairPlot = sns.pairplot(health, kind="scatter")
pairPlot.savefig("scatterplots.png")
```
