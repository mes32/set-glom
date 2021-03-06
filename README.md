# Set Glom

![Language](https://img.shields.io/github/languages/top/mes32/set-glom.svg?style=flat-square) ![RepoSize](https://img.shields.io/github/repo-size/mes32/set-glom.svg?style=flat-square)

Combine sets of items on the commandline. I built this project to learn a bit about Clojure and work with mathematical sets.

## Requirements
- Clojure
- Leiningen

## Setup and Run
```bash
# 1. Clone this repo 
git clone https://github.com/mes32/set-glom

# 2. Change directory into cloned repo
cd set-glom

# 3. Run using Leiningen
lein run
```

## Testing
```bash
# Run unit tests in /test/set_glom/core_test.clj
lein test
```

## Example Usage
At the command prompt `> ` the user can enter sets. Then the program prints the current list of sets followed by another command prompt. Typing `quit` at the command prompt will end the program.

Sets are entered as space delimited strings of elements. If set is entered that shares items with any existing sets those sets are merged/glommed together.

```clojure
> 1 2 3
  {3, 1, 2}
> 4 5 5
  {4, 5}
  {3, 1, 2}
> aaa bbb
  {aaa, bbb}
  {4, 5}
  {3, 1, 2}
> bbb 5 7
  {4, 7, 5, aaa, bbb}
  {3, 1, 2}
> quit
```

Above the user first enters `1 2 3`, a set containing the elements is echoed back `{3, 1, 2}`. Note that mathematical sets do not have a concept of element order and Clojure's hash-set data structure returns elements in arbitrary order. Then the user enters `4 5 5`. Since elements in a set are by definition unique this echos the set `{4, 5}`. Then the user enters `aaa bbb`. Since these three entered sets are disjoint (no elements in common), three sets are echoed back to the user.

Next the user enters `bbb 5 7`. This new set bridges the sets `{aaa, bbb}` and `{4, 5}` also introducing the new element `7`. This results in a new set composed of all all five of those elements `{4, 7, 5, aaa, bbb}`. The previously entered set `{3, 1, 2}` remains distinct.

Finally the user enters `quit` and the command line program exits.

## References
- [https://clojuredocs.org/](https://clojuredocs.org/)
- [https://www.braveclojure.com/](https://www.braveclojure.com/)
- [https://en.wikipedia.org/wiki/Set_(mathematics)](https://en.wikipedia.org/wiki/Set_(mathematics))

## Author
Mike Stockman
