import csv
import os

DATA_FILE_PATH = os.getenv('DATA_FILE_PATH') if 'DATA_FILE_PATH' in os.environ else 'data.csv'
DATA_HEADER = ['id', 'title', 'user_story', 'acceptance_criteria', 'business_value', 'estimation', 'status']
STATUSES = ['planning', 'todo', 'in progress', 'review', 'done']


def get_all_user_story(filename='data.csv'):
    result = []
    with open(filename, newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            result.append(row)
    return result


def write_to_file(list_of_dict):
    with open('data.csv', 'w', newline='') as csvfile:
        fieldnames = DATA_HEADER
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()
        for row in list_of_dict: # we iterate through the list of dictionaries
            writer.writerow({'id': row['id'],
                             'title': row['title'],
                             'user_story': row['user_story'],
                             'acceptance_criteria': row['acceptance_criteria'],
                             'business_value': row['business_value'],
                             'estimation': row['estimation'],
                             'status': row['status']
                             })



