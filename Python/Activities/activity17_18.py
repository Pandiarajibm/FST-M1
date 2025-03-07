# Import pandas
import pandas 

# Create a Dictionary that will hold our data
# Create a dataset
data = {
  "Usernames": ["admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"]
}

# Create a DataFrame using that data
# Convert dataset to a datafram
dataframe = pandas.DataFrame(data)

# Print the DataFrame
# Write the datafra,e to CSV file
print(dataframe)

"""
 Write the DataFrame to a CSV file
 To avoid writing the index numbers to the file as well
 the index property is set to false
"""
dataframe.to_csv("sample.csv", index=False)


# Read data from the CSV file
input_data=pandas.read_csv("sample.csv")

# Print the values only in the username colomn
username_col=input_data("Usernames")
print(username_col) # -> ["admin","Charles","Deku"]
# Print username and password of the second row
print(input_data["usernames"][1]) # -> "Charles"
print(input_data["passwords"][1]) # -> "Charl13"
# Sort the Usernames column data in ascending order and print data
print(input_data.sort_values("usernames"))
# Sort the Passwords column in descending order and print data
print(input_data.sort_values("passwords",ascending=False))
