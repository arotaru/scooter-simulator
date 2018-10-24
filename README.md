This project can be built by cloning the scooter-simulator repo.

Each of the services must be build with maven.

At this time there are 6 integrated in docker-compose: 
charger-network-config
charger-network-discovery
charger-network-gateway
charger-network-manager
charger-account-manager
chager-client-simulator

Next, you'll need to install Docker on your machine.

Before running the docker-compose file, 2 Docker Volumes must be created as it is referenced in the compose file. Simply run:
>docker volume create --name=spring-cloud-config-repo
>docker volume create --name=charger-accounts

Next, you'll need to install mongodb. Instructions on how to do that can be found here:
https://www.mongodb.com/download-center/enterprise

Next, the docker-compose.yml file is run:
>docker-compose up --build
To stop, run:
>docker-compose down

- The repo at https://github.com/arotaru/config is used by the Network-Config-Server for configuration of managed services
