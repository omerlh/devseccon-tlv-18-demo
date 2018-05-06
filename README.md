# DevSecCon18 Demo
A small demo for my talk at DevSecCon TLV 2018. 
The talk was about security testing for containerized applications.
In this demo I'm using a [LolCode](http://lolcode.org/) to demo dynamic security testing using [OWASP Zaproxy](https://github.com/zaproxy/zaproxy).
The code of the app is based on this [repo](https://github.com/justinmeza/httpd.lol), all I added was dockerizing it.
The demo is built using this [guide](https://github.com/Soluto/owasp-zap-glue-ci-images), check it out to have a better understanding of what's going on.

## Running the demo
* Run the app:
  * `cd api` && `docker build -t httpd .`
  * `docker run -it -p 13337:13337 httpd`
  * Open `http://localhost:13337` on you browser
* Run the blaxbox/e2e tests: `./scripts/run_tests.sh`
* Run the dynamic analysis: ` ./scripts/run_security_tests.sh`

You'll see output of failures in TeamCity format. 
Edit the file under `glue/api.txt` to ignore findings, and re-run the tests.
Now the tests are passing.