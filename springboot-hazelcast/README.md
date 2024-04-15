## Springboot-hazelcast
Spring Boot and Hazelcast (Distributed Cache)

### Cache topologies
- Embedded-cache
- Client-server


### client-server
Run the Hazelcast nodes and Hazelcast management center

`docker-compose -f docker-compose-hazelcast.yml up -d`

`docker-compose -f docker-compose-hazelcast.yml down`

<p>
	<h4>Hazelcast mgmt center login</h4>	
	<img src="./client-server/screenshots/hazelcast-mc.png" alt="hazelcast-mc" style="max-width: 50%; height: auto;">
</p> 

<p>
	<h4>Hazelcast mgmt center dev cluster</h4>	
	<img src="./client-server/screenshots/hazelcast-mc-dev-cluster.png" alt="hazelcast-mc-dev-cluster" style="max-width: 50%; height: auto;">
</p>

<p>
	<h4>Cache Map created by client app in the Hazelcast node</h4>	
	<img src="./client-server/screenshots/hazelcast-mc-dev-cluster-maps.png" alt="hazelcast-mc-dev-cluster-maps" style="max-width: 50%; height: auto;">
</p>
