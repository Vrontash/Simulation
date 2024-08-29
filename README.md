# Simulation
The project was created using the technical specifications located [here](https://zhukovsd.github.io/java-backend-learning-course/projects/simulation/).
Simulation consists of different entities and they have certain goals:
1. Static objects:
     - grass: food for herbivores
     - rock: obstacle in moving towards the creature's target
     - tree: obstacle in moving towards the creature's target
2. Creatures:
    - predator: either moves closer to the nearest herbivore or tries to kill him 
    - herbivore: either moves closer to the grass or eats the nearest grass

Simulation ends when all creatures can't perfom any action.
## Features
 - [Breadth-First Search](https://en.wikipedia.org/wiki/Breadth-first_search) algorithm used to find path from creature to their food
 - CLI displaying entities as emojis corresponding to their meaning
