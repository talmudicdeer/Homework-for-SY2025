Alexis Baker


Data Science 


Lab 3 (Zylab 5.11)


`main.py`

```python
# Hide warnings about future package updates
import warnings
warnings.simplefilter("ignore")

import pandas as pd
import numpy as np

# Load the doctor visits dataset
DoctorVisits = pd.read_csv("DoctorVisits.csv")

# Create a frequency table with how many people have visited a doctor or not in the past two weeks
tableVisits = DoctorVisits["visits"].value_counts().rename(None)
#.rename(None) gets rid of the annoying "Name: count" issue

# Create a frequency table with the average number of visits to a doctor based on whether a person has private health insurance (private) in the past two weeks
tableVisitsPrivate = DoctorVisits.groupby("private").agg(num_visits=("num_visits","mean"))

# Create a contingency table with how many people have visited a doctor or not on the rows and private health insurance status on the columns
tableCountsVisitsPrivate = pd.crosstab(index=DoctorVisits["visits"], columns=DoctorVisits["private"])

# Create a contingency table with the average number of visits to a doctor, grouped by private health insurance status on the rows 
# and whether chronic conditions limit activity (lchronic) on the columns
tablePrivatebyLChronic = DoctorVisits.pivot_table(values="num_visits",index="private",columns="lchronic",aggfunc="mean")


# Print the tables
print("Counts of doctor visits:\n", tableVisits)
print("Average number of visits by insurance:\n", tableVisitsPrivate)
print("Counts of visits by insurance:\n", tableCountsVisitsPrivate)
print("Average visits by insurance and chronic condition:\n", tablePrivatebyLChronic)
```
