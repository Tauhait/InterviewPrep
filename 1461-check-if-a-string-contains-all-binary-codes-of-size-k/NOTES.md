Rolling Hash:
new_hash = ((old_hash << 1) & all_one) | last_digit_of_new_hash
​
// calculate hash for s.substr(i-k+1,i+1)
hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');