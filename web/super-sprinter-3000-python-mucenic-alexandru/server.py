from flask import Flask, render_template, request, redirect, url_for
import data_handler

app = Flask(__name__)


@app.route('/')
@app.route('/list', methods=['POST', 'GET'])
def route_list():
    user_stories = data_handler.get_all_user_story()
    header = data_handler.DATA_HEADER
    return render_template('list.html', user_stories=user_stories, header=header)


@app.route('/story', methods=['GET', 'POST'])
def new_story():
    story = data_handler.get_all_user_story()  # [{dict},{dict},{dict},{dict},{dict}]
    if not story:
        counter = 0
    else:
        counter = int(story[-1]['id']) + 1  # last list from story, we get the value of 'id key'
    if request.method == "POST":
        new_id = str(counter)
        new_title = request.form['enter_story']
        new_user_story = request.form['user_story']
        new_acceptance = request.form['acceptance']
        new_business = str(request.form['business'])
        new_estimation = str(request.form['estimation'])
        new_status = request.form['status']
        dictionary = {'id': new_id,
                      'title': new_title,
                      'user_story': new_user_story,
                      'acceptance_criteria': new_acceptance,
                      'business_value': new_business,
                      'estimation': new_estimation,
                      'status': new_status
                      }
        story.append(dictionary)  # story is becoming a list of dictionaries
        data_handler.write_to_file(story)
        return redirect(url_for('route_list'))
    return render_template('story.html', story=story)


@app.route('/update_story/<post_id>/', methods=['POST', 'GET'])
def update_story(post_id):
    story = data_handler.get_all_user_story()  # [{dict},{dict},{dict},{dict},{dict}]
    if request.method == 'GET':
        for post in story:
            if post_id == post['id']:  # we iterate through the list until we find our dictionary with similar ID
                same_id = post['id']
                update_title = post['title']
                update_user_story = post['user_story']
                update_acceptance = post['acceptance_criteria']
                update_business = post['business_value']
                update_estimation = post['estimation']
                update_status = post['status']
                return render_template('update_story.html',
                                       # with all this variables we populate the input(value={{}}) and texarea(required>{{}}
                                       id=same_id,
                                       title=update_title,
                                       user_story=update_user_story,
                                       acceptance=update_acceptance,
                                       business=update_business,
                                       estimation=update_estimation,
                                       status=update_status)
    elif request.method == 'POST':
        for post in story:
            if post['id'] == post_id:  # we iterate through the list until we find our dictionary with similar ID
                post['id'] = post_id
                post['title'] = request.form['enter_story']  # we start replacing the dictionary keys
                post['user_story'] = request.form['user_story']
                post['acceptance_criteria'] = request.form['acceptance']
                post['business_value'] = request.form['business']
                post['estimation'] = request.form['estimation']
                post['status'] = request.form['status']
        data_handler.write_to_file(story)
        return redirect(url_for('route_list'))


if __name__ == '__main__':
    app.run(
        host='0.0.0.0',
        port=8000,
        debug=True,
    )
