Alexis Baker


Data Structures


Homework 4


12/14/2025


**You don't need to write complete programs for this homework. Draw pictures for what each function does.**


**1. Write a description of an O-O design for Dijkstra's algorithm: what classes would you define? It should include the Node (vertex) class.**


`node`: represents a vertex. Stores a unique identifier and adjacency info.

`edge`: represents the connection between two `node` values.

`graph`: represents the overarching structure.

`dijkstra`: represents the algorithm itself.


I uh, don't know how to implement a picture in Markdown that isn't one I scanned in, but this would work something like this:


`graph`

_oversees_

`node`

_multiple `node`s are connected by_

`edge`s

_and then overseeing the whole operation is_

`dijkstra`



**2. Write a description of the `node` class.**


I did above. If you want more details, it should also hold fields for the value ID, a list of edges, the tentative shortest distance, previous nodes, and a Boolean for whether a node has been previously visted.


**3. The collection of nodes that are finalized could be a set, or a list. Explain your choice.**


Easily a set. Sets are faster to assemble than lists, especially in use with an algorithmic procedure like this one, with O(1) complexity rather than O(n) as in a list.
