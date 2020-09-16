FROM node:10-alpine AS build
RUN mkdir -p /home/front
WORKDIR /home/front
COPY package.json . 
RUN npm install
RUN npm install -g @angular/cli@6.0.8
COPY . .
EXPOSE 4200
ENTRYPOINT ["ng", "serve", "--host","0.0.0.0"]