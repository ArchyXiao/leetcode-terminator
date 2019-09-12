import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * Example 1:
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * Example 2:
 *
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 *
 * @Auther: lenovo
 * @Date: 2019/7/1 14:08
 */
public class TwoSumIII {
    private Map<Integer, Integer> map;
    private List<Integer> nums = new ArrayList<>();
    /**
     *
     * HashMap法：时间复杂度O(N)，空间复杂度O(N)；
     * add：在将数字添加进nums数组的同时，将数字作为key存入map，map的value存此数字在数组的位置；
     * find：在搜索是否有加和时，遍历整个数组nums，判断value - nums[i]是否在map中：
     * 若在，还需要判断map[value - nums[i]] == i，这个是为了排除是否是数组中同一个元素的加和（题意是必须两个不同元素的加和）；
     * 因为如果add了两个相同的数字，那么map[value - nums[i]]一定大于i，因为在add操作中每次会刷新此数字的最新index。
     * 若不在，就继续遍历，直至遍历完nums。
     *
     */
    /** Initialize your data structure here. */
    public TwoSumIII() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
        map.put(number, nums.size() - 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < nums.size(); i++) {
            int complement = value - nums.get(i);
            if(map.containsKey(complement) && map.get(complement) > i) {
                return true;
            }
        }
        return false;
    }
}