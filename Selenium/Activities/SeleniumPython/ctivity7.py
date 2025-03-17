num_list = [15,3,6,7,2,8]
numbers = list(input("Enter a sequence of comma separated numbers ").split (", "))
sum=0

for number in numbers:
    sum += int(number)

print(sum)

