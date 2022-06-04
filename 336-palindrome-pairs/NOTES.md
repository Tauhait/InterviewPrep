***
​
Discussion: Online Algorithms
This section is beyond what is needed for an interview, and is included only for interest.
​
When developing algorithms for the real world, an often desirable property is that the algorithm works online. This does not mean on the internet, instead it means that the algorithm can still work if the input data is provided bit-by-bit. In this case, it'd be that we want to feed the algorithm the words one at a time, and each time, we want to update the list of all pairs without doing too much extra work.
​
So, let's think through how this would work for approach 2. We'd simply be maintaining a hash table of words to indexes. Each time a new word arrives, we'd need to add it to the hash table and also check which existing words it'd form a palindrome pair with. It's a little bit different to before, because we need to find all pairs with previous words that
​
For case 1, this is straightforward. We simply check if its reverse is already in the hash table. If it is, then we have 2 new pairs (the new word can be either first or second).
​
But it breaks for case 2 and case 3. It's straightforward to find pairs where our new word is the longer word of the pair (i.e. second in case 2 and first in case 3), however not where the new word is shorter. The problem is that the additional letters of the longer word could be anything, and therefore we have no way of knowing what to look up in the index. Approach 2 worked as an offline algorithm because pairs were always identified by starting with their longer word, and then looking up their shorter word. Going the other way is intractable.
​
Approach 3, however, works differently. If we build up a Trie as we go, we can always identify words from the Trie that will form the second half of the pair. It doesn't matter whether it is the current word, or the word from the Trie, that is longer. This solves half the problem—each time we get a new word, we can efficiently find all "second" words for it.
​
We aren't done yet though—the algorithm wouldn't find pairs where our current word was second. We still need to find a way of identifying all "first" words for the current word. It turns out that if we hadn't reversed words when putting them into the Trie, but instead had reversed the word we are looking up, that we'd be looking up "first" words in the Trie.
​
Therefore, we can make an online algorithm by maintaining 2 Tries—one with the words forward, and one with the words in reverse. The reverse Trie tells us where the new word will be the first word of a pair, and the forward Trie tells us where the new word will be the second of a pair.
​
​
​