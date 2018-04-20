# musclr-neo4j

## How to run this server?

### Install Neo4j
1. Install the Neo4j Desktop and Neo4j Enterprise Edition for Developer:  [Download](https://neo4j.com/download/)
2. Check the tutorial: [Tutorial](https://neo4j.com/developer/guide-neo4j-browser)
3. Create some users with at least a username and link them (FRIEND or COACH), for example:

  CREATE (Keanu:User {username:'Keanu Reeves', role:'CoachR', level:'Gold'})
  CREATE (Carrie:User {username:'Carrie-Anne Moss', role:'MusclR', level:'Silver'})
  CREATE (Laurence:User {username:'Laurence Fishburne', role:'MusclR', level:'Bronze'})
  CREATE (Hugo:User {username:'Hugo Weaving', role:'MusclR', level:'Silver'})
  CREATE (LillyW:User {username:'Lilly Wachowski', role:'MusclR', level:'Gold'})
  CREATE (LanaW:User {username:'Lana Wachowski', role:'MusclR', level:'Silver'})
  CREATE (JoelS:User {username:'Joel Silver', role:'MusclR', level:'Bronze'})
  CREATE
    (Keanu)-[:COACH]->(Carrie),
    (Keanu)-[:FRIEND]->(Laurence),
    (Keanu)-[:FRIEND]->(Hugo),
    (Keanu)-[:FRIEND]->(LillyW),
    (Keanu)-[:FRIEND]->(LanaW),
    (Keanu)-[:FRIEND]->(JoelS);
  
### Spring Boot
1. In musclr-neo4j\src\main\resources\application.properties, correct (if needed) the username and the password (it's the one used in the tutorial)
2. Run the spring boot application


### MusclR
1. Run MusclR using ng serve
2. go to http://localhost:4200/graph
