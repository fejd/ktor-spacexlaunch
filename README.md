# ktor-spacexlaunch
A Ktor sample implementation that queries an open API to get SpaceX launch info and communicates back to Dialogflow.

The Ktor app acts as a webhook endpoint for a Dialogflow agent, accepts a POST request and queries a 3rd party open API (https://github.com/r-spacex/SpaceX-API) to get details on the latest SpaceX launch. It then composes a response using the Actions on Google library (https://github.com/actions-on-google/actions-on-google-java) and communicates back to the agent. This sample is setup to be hosted on Heroku.

For more details, see the blog post at https://medium.com/@fejd/google-assistant-meets-ktor-d9e0c7904e04.
