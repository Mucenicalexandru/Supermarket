#  String format
'''a = "Alex"
b = "Ada"
print("My name is %s" %a)
print("My name is {}".format(b))'''


def zero_fuel(distance_to_pump, mpg, fuel_left):
    a = mpg * fuel_left
    if distance_to_pump < a:
        return True
    else:
        return False


def basic_op(operator, value1, value2):
    if operator == "+":
        return value1+value2
    elif operator == "-":
        return value1-value2
    elif operator == "*":
        return value1*value2
    elif operator == "/":
        return value1/value2
    else:
        print("Invalid input")


def count_positives_sum_negatives(arr):
    positive = 0
    if len(arr) < 1:
        return arr
    else:
        for i in arr:
            if i > 0:
                positive += 1
        a = sum(i for i in arr if i < 0)
        return [positive, a]


def array_diff(a, b):
    c = [i for i in a if i not in b]
    return c


def summation(num):
    #  return (1+num) * num / 2
    b = []
    for i in range(num+1):
        b.append(i)
    return sum(b)


def row_sum_odd_numbers(n):
    return n**3


def count_smileys(arr):
    a = [':)', ':D', ':-)', ':-D', ':~)', ':~D', ';)', ';D', ';-)', ';-D', ';~)', ';~D']
    b = []
    for i in a:
        if i in arr:
            b.append(i)
    return len(b)


def past(h, m, s):
    if 0 < s <= 59:
        s = s * 1000
    else:
        s = 0
    if 0 < m <= 59:
        m = m * 60000
    else:
        m = 0
    if 0 < h <= 23:
        h = h * 60 * 60 * 1000
    else:
        h = 0
    return s+m+h


def getCount(inputStr):
    num_vowels = 0
    for i in inputStr:
        if i in "aeiou":
            num_vowels = num_vowels+1
    return num_vowels


def hero(bullets, dragons):
    a = bullets/dragons
    if a >= 2:
        return True
    else:
        return False


def triple_trouble(one, two, three):
    list_l = []
    for i in range(len(one)):
        a = one[i] + two[i] + three[i]
        list_l.append(a)
    return "".join(list_l)


def solution(number):
    a = (number-1) // 3
    b = (number-1) // 5
    list1 = []
    list2 = []
    if number in range(0, 6):
        return 0
    else:
        for i in range(1, a+1):
            x = i*3
            list1.append(x)
            z = set(list1)

        for j in range(1, b+1):
            y = j*5
            list2.append(y)
            w = set(list2)
        res = z | w
        return sum(res)