# Use the official Node.js 18 as a parent image
FROM node:18-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json to the working directory
COPY web/package*.json ./

# Install dependencies
RUN npm ci

# Copy the rest of your application's code
COPY ./dist/web

# Build your application
RUN npm run build

# If your app is a server
# Expose the port your app runs on
EXPOSE 3000

# Command to run your app
CMD ["npm", "start"]

# If your app is static, you might want to serve it with a static server
# Uncomment the lines below and adjust as necessary

# Install a static server
# RUN npm install -g serve

# Serve your static build directory on port 5000
# CMD ["serve", "-s", "build", "-l", "5000"]
# EXPOSE 5000
