## Docker container for running automated tests with Selenide and Chrome

### Example usage

Pull docker image
```
docker pull ikudinov/selenide-gitlab-ci
```
Put your test sources in folder 
```
example/test
```
Download new chrome && run tests from example folder
```
./download-chrome.sh && ./run-tests.sh
```

**Note**: test run command is `mvn test -Dtest=*`. If you are using different project management tool than Maven, just change this line in `run-tests.sh`.

**Requirements**: for run example you need wget, unzip, docker
