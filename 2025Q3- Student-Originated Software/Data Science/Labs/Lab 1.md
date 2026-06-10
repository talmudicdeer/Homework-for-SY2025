Alexis Baker


Data Science


Lab 1 (Zylab 2.14)


**Score:** 4/10

`main.py`

```python
import pandas as pd
import matplotlib.pyplot as plt


def PlotFiresPerMonth(fires):
    print("plotting lineplot")
    fig, ax = plt.subplots()
    ax.set(
        xlabel='Month', 
        ylabel='Fire', 
        title= 'Fires per month' 
    )
    lineTable = fires.groupby("Month")["Fire"].sum().reset_index()
    fireCounts = lineTable["Fire"]
    months = lineTable["Month"]

    ax.plot(months, fireCounts, color='black')

    fig.savefig("fire_line.png")
    plt.clf()

def PlotTempbyHumidity(fires):
    print("plotting scatterplot")
    fig, ax = plt.subplots()

    firePoints = fires.loc[fires["Fire"] == 1]
    noFirePoints = fires.loc[fires["Fire"] == 0]

    ax.scatter(firePoints["Temp"], firePoints["Humidity"], color = "Red", label="Fire")
    ax.scatter(noFirePoints["Temp"], noFirePoints["Humidity"], color = "Blue", label="No fire")

    ax.set(
        xlabel="Temperature (C)", 
        ylabel="Humidity", 
        title="Fire events by temperature and humidity",
        )
    ax.legend()

    fig.savefig("fire_scatter.png")
    plt.clf()

# # Load the dataset
fires = pd.read_csv('forest_fires.csv')

 #Compute and print the number of fires per month
fires_per_month = fires.groupby("Month")["Fire"].sum().reset_index()
print(fires_per_month)

# # Create a line plot of the number of fires per month
months = fires_per_month['Month']
fires = fires_per_month['Fire']
plt.plot(months, fires, color='k')

# # Style the plot as specified and save as fire_line.png
plt.title("Fires per Month")
plt.xlabel("Month")
plt.ylabel("Fire")
plt.savefig("fire_line.png")
plt.show()

# # Clear the current figure
plt.clf()

fires = pd.read_csv('forest_fires.csv')

# # Create fire_days and no_fire_days dataframes
fire_days = fires[fires["Fire"]==1]
no_fire_days = fires[fires["Fire"]==0]

# # Create a scatter plot of temperature and humidity for fire and no fire days
fire_temps = fire_days['Temp']
no_fire_temps = no_fire_days['Temp']
fire_humidity = fire_days['Humidity']
no_fire_humidity = no_fire_days['Humidity']

# # Style the plot as specified and save as fire_scatter.png
plt.title("Fire events by temperature and humidity")
plt.xlabel("Temperature (C)")
plt.ylabel("Humidity")
plt.legend(loc='upper right')
plt.scatter(fire_temps, fire_humidity)
plt.scatter(no_fire_temps, no_fire_humidity)
plt.savefig("fire_scatter.png")
plt.show()

fires = pd.read_csv('forest_fires.csv')
PlotFiresPerMonth(fires)
PlotTempbyHumidity(fires)

```
