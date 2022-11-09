class Solution {
public:
    long long minimumHealth(vector<int>& damage, int armor) {
        long yes = 1, no = 1;
        for (int i = damage.size() - 1; i >= 0; --i) {
            long newYes = min(no + max(0, damage[i] - armor), yes + damage[i]);
            long newNo = no + damage[i];
            yes = newYes, no = newNo;
        }
        return min(yes, no);
    }
};