dictionary = {'edit_count': 1}

dictionary['edit_count'] = dictionary.get('edit_count', 0) + 1

print(dictionary)