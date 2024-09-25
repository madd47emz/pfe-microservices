# Fog Computing Setup:

In this research, we built a bare-metal fog environment using k3s (a lightweight Kuber-netes distribution) on multiple Raspberry Pi4 devices connected via Wi-Fi. A Single-server Setup with an Embedded DB. K3s cluster consists of:

1. **Control Plane Node(laptop)**: Manages the overall cluster and handles scheduling and scaling of pods. It also where the loadbalancer is deployed.

2. **Multiple Worker Nodes**: These nodes are responsible for running the microservice instances. Each worker node runs a set of microservices in pods.

# Microservices:

1. The system consists of three microservices built using **Spring Boot**, each exposing a common API endpoint at /api/test.

2. These microservices are containerized and built using the **linux/arm64/v8 architecture supported by raspberry pi4**, and the images are stored in the Docker Hub public repository **madd47emz/pfe-microservices** in order to make it available to other **fog nodes**.

3. Each microservice will be deployed as **NodePort kubernetes service** with:
   
  **externalTrafficPolicy: Local** ##to prevent fowarding request to other pods in another nodes. Such service configuration(.yaml) overrides the loadbalancing bihaviour to none.

To make the simulation more effective, Each microservice performs different workloads depending on its specific tag, as described below:

## First Microservice
• Tag: madd47emz/pfe-microservices:ms1
• Workload: This microservice performs a light load when the API endpoint is requested. It allocates 50MB of RAM and executes a bubble sort on 1,000 elements.

## Second Microservice
• Tag: madd47emz/pfe-microservices:ms2
• Workload: This microservice performs a medium load, allocating 200MB of RAM when processing requests at the API endpoint.

## Third Microservice
• Tag: madd47emz/pfe-microservices:ms3
• Workload: This microservice performs a heavy load by allocating 500MB of RAM and calculating 1,000,000 prime numbers when the API endpoint /api/test is triggered.

