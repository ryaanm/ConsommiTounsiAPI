#stage 1
FROM node:latest as node
WORKDIR /app
COPY . .
CMD ["npm", "start"]
CMD npm run build --prod
CMD ["npm", "run", "build", "--prod"]
#stage 22
FROM nginx:alpine
COPY --from=node /app/dist/ /usr/share/nginx/html