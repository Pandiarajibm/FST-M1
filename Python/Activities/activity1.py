name = input("Enter your Name: " )
age=int(input("Enter your age: "))
year = ( 2025- age) + 100

print("you will be 100 in ", + year)
output = "In {}, you will be 100 years old.".format(year)
print(output)

year = str( ( 2025 - age ) + 100 )
print( name + " will be 100 years old in the year " + year )
