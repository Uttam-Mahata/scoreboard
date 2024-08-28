FROM ubuntu:latest
LABEL authors="uttam"

ENTRYPOINT ["top", "-b"]