def sum_of_minimums(numbers):
    min_list = []
    for i in range(len(numbers)):
        x = min(numbers[i])
        min_list.append(x)
    return sum(i for i in min_list)