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

Before running the docker-compose file, a Docker Volume must be created as it is referenced in the compose file. Simply run:
>docker volume create --name=spring-cloud-config-repo

Next, the docker-compose.yml file is run:
>docker-compose up --build
To stop, run:
>docker-compose down

- The repo at https://github.com/arotaru/config is used by the Config Server for configuration of managed services
