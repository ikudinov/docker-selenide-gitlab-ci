FROM maven:3.5-jdk-8-slim

# Chrome runtime requirements
RUN apt-get update \
    && apt-get install -yq libgconf-2-4 gnupg \
    && apt-get install -y wget --no-install-recommends \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google.list' \
    && apt-get update \
    && apt-get install $(apt-cache depends google-chrome-stable | grep Depends | sed "s/.*ends:\ //" | tr '\n' ' ') -y --no-install-recommends

RUN apt-get install -yq git unzip iproute2

# Aptitude cleanup
RUN rm -rf /var/lib/apt/lists/* \
    && apt-get purge --auto-remove -y curl \
    && rm -rf /src/*.deb

ENTRYPOINT []
CMD echo "This image is part of Gitlab CI automated UI testing environment"
