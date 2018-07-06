## Docker container for running automated tests with Selenide and Chrome

### Example usage

Pull docker image
```
docker pull ikudinov/docker-selenide-gitlab-ci
```
Download new chrome && run tests from example folder
```
./download-chrome.sh && ./run-tests.sh
```

**Note**: 
* test run command is `mvn test -Dtest=*`. If you are using different project management tool than Maven, just change this line in `run-tests.sh`.
* you can put your test sources in folder `example/test`

**Requirements**: for run example you need wget, unzip, docker
