Alexis Baker


Data Science


Lab 5 (Zylab.7.100


`main.py`

```python
import pandas as pd 
import numpy as np 
from sklearn.linear_model import LinearRegression

# Load the insurance dataset
Insurance = pd.read_csv('insurance.csv')

# Set charges as the output feature in y
y = Insurance['charges']

# Set age, sex, bmi, and smoker as input features in X
X = Insurance[['age', 'sex', 'bmi', 'smoker']]

# Initialize and fit a multiple linear regression model using y and X
MLRModel = LinearRegression().fit(X, y)

# Print the intercept
intercept = MLRModel.intercept_
print("The intercept of the multiple regression model is ", intercept)

# Compute the proportion of variation explained by the multiple linear regression model
score = MLRModel.score(X, y)
print("The proportion of variation explained by the model is ", "[", score, "]")

# Predict charges for the first 10 instances in the dataframe
predictions = MLRModel.predict(X[:10])
print("The predicted charges for the first 10 instances are ", predictions)
```
