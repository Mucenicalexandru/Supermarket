from flask import Flask, render_template, redirect, request

app = Flask(__name__)
saved_data = {}
@app.route('/login')
def main_page():
    return render_template('login.html')

@app.route('/list')
def note_list():
    text = None
    if 'note' in saved_data:
        text = saved_data['note']
    edits = saved_data.get('edit_count', 0)
    return render_template('list.html', note=text, edit_count=edits)


@app.route('/note', methods=['POST', 'GET'])
def note_page():
    if request.method == 'POST':
        saved_data['note'] = request.form['note']
        saved_data['edit_count'] = saved_data.get('edit_count', 0) + 1
        file = open('post.csv', 'a+')
        file.write(saved_data['note'] + "\n")
        file.close()
        return redirect('/list')
    return render_template('note.html')




if __name__ == '__main__':
    app.run(debug=True, port=5000)