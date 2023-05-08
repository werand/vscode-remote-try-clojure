#-----------------------------------------------------------------------------------------
# Copyright (c) Microsoft Corporation. All rights reserved.
# Licensed under the MIT License. See LICENSE in the project root for license information.
#-----------------------------------------------------------------------------------------

FROM --platform=linux/amd64 clojure:tools-deps

# Configure apt
ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update
RUN apt-get install -y --no-install-recommends apt-utils

# Install git, process tools, lsb-release (common in install instructions for CLIs)
RUN apt-get -y install git procps lsb-release wget unzip

# Clean up
RUN apt-get autoremove -y \
    && apt-get clean -y \
    && rm -rf /var/lib/apt/lists/*
ENV DEBIAN_FRONTEND=dialog

# Allow for a consistant java home location for settings - image is changing over time
RUN if [ ! -d "/docker-java-home" ]; then ln -s "${JAVA_HOME}" /docker-java-home; fi

# install joker
ENV JOKER_VERSION=1.1.0
RUN wget https://github.com/candid82/joker/releases/download/v${JOKER_VERSION}/joker-linux-amd64.zip \
    && unzip joker-linux-amd64.zip \
    && rm joker-linux-amd64.zip \
    && chmod a+x joker && mv joker /usr/bin

# Set the default shell to bash rather than sh
ENV SHELL /bin/bash
