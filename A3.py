def selection_sort(arr):
    for i in range(0,len(arr)):
        minIndex=i
        for j in range(i+1,len(arr)):
            if(arr[minIndex] > arr[j]):
                minIndex = j
        arr[i], arr[minIndex] = arr[minIndex], arr[i]
    
    print("Sorted array: ",arr)



arr = []

l = int(input("Enter the length of the array:\n"))
print("Enter the elements of the array to be sorted\n")

for i in range(l):
    ele = int(input("Element {}\n".format(i+1)))
    arr.append(ele)

selection_sort(arr)

