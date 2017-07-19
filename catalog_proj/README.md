# Overview
Item Catalog application made with Flask

# Components
- Routing and Templating made with Flask
- Uses SQLAlchemy to communicate with the back-end db
- RESTful API endpoints that return json files
- Uses Google Login to authenticate users
  - authenticated users can create and edit items
- Front-end forms and webpages built with boostrap

# To run the application:
- Install the dependency libraries (Flask, sqlalchemy, requests and oauth2client) by running `pip install -r requirements.txt`
- Seeding the database: `python database_seed.py` (Sample items and categories can be added there)
- Run `python project.py`

# License
Project is released under the [MIT License](http://opensource.org/licenses/MIT).
