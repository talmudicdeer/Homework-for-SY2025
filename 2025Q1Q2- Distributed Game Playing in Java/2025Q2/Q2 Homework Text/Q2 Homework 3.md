Alexis Baker

Distributed Game Playing in Java

### Part 1

**Intro to Java and Git**
- Java data types
  - Primitive data types
    - Boolean type
      - Uh, well, booleans. true-false statements.
    - Numeric type
      - Everything else.
      - Character value
      - `char` 
      - Integral value
        - Integer
          - `byte`, `short`, `int`, `long`
        - Floating-point
        - `float`, `double`
  - Non-primitive data types
    - `string`, `array`, etc
- Git
  - Version control system, way for a team to make changes to the same thing and know what and when things were changed
  - working directory: code in local storage
  - staging area: code ready to be committed
  - local repository: code's committed locally
  - remote repository: code's been pushed to GitHub (committed globally)
  - Commands
    - `init`: starts local repository
    - `clone`: copies remote repository locally
    - `status`: displays current status of unstaged and staged changes
    - `add`: adds local changes to the staged area
    - `commit`: moves changes in the staging area to the local repository
    - `push`: makes local commits global
    - `pull`: pulls remote commits to the local repository

**Intro to Botmaking**
- `RobotPlayer`: the Big Kahuna. Your player.
  - Important: wrap the code in a `while(true)` loop and a try-catch block, both of these are mandatory for the code to run properly.
  - Also critical: Clock.yield(), which keeps your bot from consuming its max of bytecode
- Bytecode limits
  - It's important to keep track of how many bytes functions take up and to plan strategy accordingly. Optimize as much as possible in terms of functionality and cost.