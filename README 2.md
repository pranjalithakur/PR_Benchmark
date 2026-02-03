# Reviewdemo - Blab-a-Gag

This project is intentionally vulnerable! It contains known vulnerabilities and security errors in its code and is meant as an example project for software security scanning tools such as Review demo.



See the `/docs` folder. [Pipeline Scan](https://docs.verademo.com/r/Pipeline_Scan) results of this application are in `/docs/scan_results/results.json`. 

## Technologies Used

* Spring boot
* MariaDB

## Development

To build the container run this:
```
docker pull mariadb:10.6.2
docker build --no-cache -t verademo .
```

To run the container for local development run this:

```
docker run --rm -it -p 127.0.0.1:8080:8080 --entrypoint bash -v "$(pwd)/app:/app" verademo
```

You will then need to manually run the two commands within `/entrypoint.sh`. The first starts the DB in the background whereas the second compiles and runs the application. Typically a container shouldn't have multiple services but this was done for convenience.
