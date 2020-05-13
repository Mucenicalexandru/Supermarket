# Flask Note

## Story

Do you know the feeling when something great comes to your mind, but there is no paper and pencil nearby so you can not take a note quickly? How marvelous would it be to have a web page where you could quickly take a note!

## What are you going to learn?

By the time you are finished with it you will have a working example project that you can use as a reference for future projects. We will touch these topics:

 - creating a new Flask project
   - virtual environment
   - requirements.txt
 - working with HTTP requests
   - flask routes
   - respond differently based on the HTTP request's method value
   - redirection
 - HTML and template engine
   - HTML tags, attributes
   - working with a `<form>`
   - jinja2 commands in an HTML file

This project also has a step-by-step guide as this is your first web project. Try to solve it without the guide, only using the other background materials. After that check out the guide as it has detailed descriptions about the steps.

## Tasks


1. After you clone the repository of the project it only has a README.md file in it. After you set it up you should have:

    - `venv` folder containing a virtual environtment with at least python 3.6
    - `requirements.txt` with Flask as one of the requirements
    - `templates` folder for your html template files
    - There is a `server.py` where you can handle incoming HTTP requests

2. You have created functions and decorated them so they can accept requests on two routes in `server.py`

    - You have a `/` route that will respond with the main page
    - You have a `/note` route where a note add/edit page will be created
    - The `/note` route can handles GET and POST requests

3. You have a main page with these features.

    - If you haven't saved a note yet, there is a text indicating it in the first `<p>` tag on the page
    - After you saved a note you can read it in the first `<p>` element
    - You have an edit counter in a `<small>` tag that updates every time you edit a note, it starts from 0
    - There is a link to the `/note` page

4. You have a note page with these features

    - When you send a request with GET method to the `/note`, you get a page with a form on it
    - The form has a `<textarea>` with a `<label>` for it and there is a submit `<button>`
    - On submit the browser sends an HTTP request to the `\note` URL with POST method
    - After we submit the form, we are redirected to the main page and we can read the saved note there


## General requirements


None

## Hints


## Starting repository

Click here to clone your own Git repository:
https://classroom.github.com/a/ojaXRJTI


## Background materials

- :exclamation: [Introduction to HTML](https://learn.code.cool/codecool-graph/#/../tutorials/introduction-to-html)
- :exclamation: [Pip and VirtualEnv](https://learn.code.cool/codecool-graph/#/../pages/python/pip-and-virtualenv)
- :exclamation: [A web-framework for Python: Flask](https://learn.code.cool/codecool-graph/#/../pages/python/python-flask)
- :open_book: [Flask documentation](http://flask.palletsprojects.com/) (the Quickstart gives a good overview)
- :open_book: [Jinja2 documentation](https://jinja.palletsprojects.com/en/2.10.x/templates/)
- :open_book: [htmlreference.io](https://htmlreference.io/)
- :open_book: [HTML tutorials and references on MDN](https://developer.mozilla.org/en-US/docs/Web/HTML)
- :open_book: [The official page of the HTML standard](https://html.spec.whatwg.org/multipage/)
- :lollipop: [FlaskNote step-by-step project guide](https://learn.code.cool/codecool-graph/#/../assignments/web-python/flask-note)


## Acceptance review

You will need this only at review time, **after** completing the project.
[Use this form](https://forms.gle/rWVjn6ijPtFaKCic9) to record the review you provide for your peer.