# musclr-neo4j

## How to run this server?

### Install Neo4j
1. Install the Neo4j Desktop and Neo4j Enterprise Edition for Developer:  [Download](https://neo4j.com/download/)
2. Check the tutorial: [Tutorial](https://neo4j.com/developer/guide-neo4j-browser)
3. Create some users with at least a username and link them, for example:

  CREATE (Keanu:User {username:'Keanu Reeves', born:1964})
  CREATE (Carrie:User {username:'Carrie-Anne Moss', born:1967})
  CREATE
    (Keanu)-[:FRIEND {roles:['Coach']}]->(Carrie)
  ;
  
### Spring Boot
1. In musclr-neo4j\src\main\resources\application.properties, correct (if needed) the username and the password (it's the one used in the tutorial)
2. Run the spring boot application
3. In postman, make a get request : http://localhost:8080/users, you will get a json with the following format
```json
{
    "links": [
        {
            "source": 544,
            "target": 545
        },
        {
            "source": 562,
            "target": 563
        }
    ],
    "nodes": [
        {
            "id": 563,
            "label": "Carrie-Anne Moss"
        },
        {
            "id": 562,
            "label": "Keanu Reeves"
        }
    ]
}
```
