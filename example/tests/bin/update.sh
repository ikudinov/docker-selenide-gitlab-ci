#/bin/sh

if [ ! -d "web_client" ]; then
  git clone "https://oauth2:$1@gitlab.ccsteam.ru/ccs/web_client.git" web_client
  cd web_client
else
  cd web_client
  git checkout master
  git pull
fi

npm install