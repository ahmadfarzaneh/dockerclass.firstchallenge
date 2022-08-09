# dockerclass.firstchallenge
dockerclass - firstchallenge

### Reference Documentation
please consider the following tips:

* For unit Test, Classical Style has been used
* AspectJ has been used for cross-cutting concern like logging 

### Guides
The following guides illustrate how to use build docker image and run it as a container:
#### Build Image
* Compile project
* Replace the name of jarfile in the Dockerfile file if it changed
* Run the docker build image command from the project's root directory: docker build -t {tag_name} .
* Run a container: run -d -p 8080:8080 --name {container_name} {tage_name}
