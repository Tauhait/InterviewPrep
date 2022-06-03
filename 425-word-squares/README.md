<h2><a href="https://leetcode.com/problems/word-squares/">425. Word Squares</a></h2><h3>Hard</h3><hr><div><p>Given an array of <strong>unique</strong> strings <code>words</code>, return <em>all the </em><strong><a href="https://en.wikipedia.org/wiki/Word_square" target="_blank">word squares</a></strong><em> you can build from </em><code>words</code>. The same word from <code>words</code> can be used <strong>multiple times</strong>. You can return the answer in <strong>any order</strong>.</p>

<p>A sequence of strings forms a valid <strong>word square</strong> if the <code>k<sup>th</sup></code> row and column read the same string, where <code>0 &lt;= k &lt; max(numRows, numColumns)</code>.</p>

<ul>
	<li>For example, the word sequence <code>["ball","area","lead","lady"]</code> forms a word square because each word reads the same both horizontally and vertically.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> words = ["area","lead","wall","lady","ball"]
<strong>Output:</strong> [["ball","area","lead","lady"],["wall","area","lead","lady"]]
<strong>Explanation:</strong>
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> words = ["abat","baba","atan","atal"]
<strong>Output:</strong> [["baba","abat","baba","atal"],["baba","abat","baba","atan"]]
<strong>Explanation:</strong>
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 4</code></li>
	<li>All <code>words[i]</code> have the same length.</li>
	<li><code>words[i]</code> consists of only lowercase English letters.</li>
	<li>All <code>words[i]</code> are <strong>unique</strong>.</li>
</ul>
</div>