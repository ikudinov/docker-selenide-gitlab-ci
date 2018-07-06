#! /bin/bash

# Get chrome version from latest puppeteer's tag
TAG=$(wget -qO - https://api.github.com/repos/GoogleChrome/puppeteer/releases/latest | grep tag_name | grep -o "v[0-9.]\+")
NEW_REVISION=$(wget -qO - https://raw.githubusercontent.com/GoogleChrome/puppeteer/$TAG/package.json | grep chromium_revision | grep -o "[0-9]\+")
CURR_REVISION=$(cat ./chrome-linux/version)
DOWNLOAD_URL="https://storage.googleapis.com/chromium-browser-snapshots/Linux_x64/$NEW_REVISION/chrome-linux.zip"

# Download chrome if newer
if [ "$NEW_REVISION" != "$CURR_REVISION" ]; then  
  rm -rf chrome-linux
  rm -rf chrome-linux.zip
  rm -rf chrome-linux.zip.*

  wget $DOWNLOAD_URL \
  && unzip chrome-linux.zip \
  && rm -rf chrome-linux.zip \
  && echo "$NEW_REVISION" > ./chrome-linux/version
else
  echo "Already newest chrome version $CURR_REVISION"
fi
