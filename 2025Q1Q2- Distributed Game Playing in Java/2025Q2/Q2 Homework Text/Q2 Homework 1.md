Alexis Baker

Distributed Game Playing in Java


### Part 1

- Battlecode is MIT's largest programming competition.
- It's specifically held in January as part of MIT's Independent Activities Period, and can be taken for credit.
- Credit is awarded based on either a) beating the devs' reference player (`refplayer`), or writing a two-page report summarizing your strategy.
- Different phases of the competition (two sprints plus the final tournament) will be held throughout January.
- The training material consists of the reference player, as well as the Battlecode guide and API on the website. Your match replays are also available for download.
- This is the first year of Battlecode being available for crossplay in both Java and Python; however, the Python release was delayed, and so they're asking people to work with the Java version if able, but if you're only comfortable working in Python it's available for testing.
- The game for 2026 is Uneasy Alliances.
- The objective is to collect cheese, protect your king, and kill cats.
- Cats will attack *everyone*.
- You can choose to cooperate with the other rat assemblage, or to take them on too; or, even, both, in what is called 'backstab mode'.
- The win conditions are:
  - Defeat the cats
  - All other Rat Kings dead
  - Round 2000 reached, in which case damage dealt to the cats and the amount of cheese collected will act as tiebreakers.
- There are only two major map elements this year: cheese, found in cheese mines, and dirt, which are constructable and removable barriers that cannot be traversed once erected. Cheese keeps rat kings alive.
- Baby rats are the footsoldiers of the game. They can harvest cheese, attack cats, and build barriers.
- Rat Kings require cheese to stay alive, as mentioned, but also cheese makes rat kings able to spawn more baby rats. Multiple baby rats can also form a rat king.
- Cats are NPCs, can jump over barriers and deal damage to baby rats and rat kings.
- There are also traps that can be set for both cats and rats.