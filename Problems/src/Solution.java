import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {

    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int result = 0;
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        for (Character c : s.toCharArray()) {
            
            result += hashMap.get(c);
        }   
        return result;     
    }

    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                int abs = Math.abs(nums[i] - nums[j]);
                if(abs == k && i<j) {
                    count++;
                }
            }
        }
        return count;
    }

    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(Character c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : t.toCharArray()) {
            if(hashMap.containsKey(c) && hashMap.get(c) == 0 || !hashMap.containsKey(c)) {
                return c;
            }
            else {
                hashMap.put(c, hashMap.get(c) - 1);
            }
        }
        return 'n';
    }

    static List<Integer> range(int start, int end, int step) {
        List<Integer> list = new ArrayList<Integer>();
        while(start < end) {
            list.add(start);
            start+=step;
        }
        return list;
    }

    static HashMap<Character, Integer> letter_frequency(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for(Character c : str.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        return hashMap;
    }

    static double get_range(List<Double> values) {
        Collections.sort(values);
        return values.get(values.size()-1) - values.get(0); // this is assuming there are at least two different numbers in list.
    }

    static double get_price(String item) {
        switch(item) {
            case "Big Mac": return 3.39; 
            case "Hamburger": return 0.89; 
            case "Filet-O-Fish": return 3.29; 
            case "Crispy Chicken Salad": return 2.99; 
            case "Medium Fries": return 1.19;  
        }
        return 0.0;  
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for(Character c : allowed.toCharArray()) {
            hashSet.add(c);
        }
        for(String string : words) {
            for(int i=0; i<string.length(); i++) {
                if(!hashSet.contains(string.charAt(i))) {
                    break;
                }
                if(i == string.length()-1) {
                    count++;
                }
            }
        }
        return count;
    }

    static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        HashSet<Character> hashSet = new HashSet<Character>();
        int count=0;
        String substring = s.substring(1);
        while(substring.length() > count) {
            for(Character c : substring.toCharArray()) {
                if(!hashSet.add(c)) {
                    count++;
                }
            }
            substring = substring.substring(1, substring.length()-count);
        }
        return substring.length();
    }

    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for(Character c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        int j = hashMap.get(s.charAt(0));
        for(Character c : s.toCharArray()) {
            if(hashMap.get(c) != j) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfPangram(String sentence) {
        HashSet<Character> hashSet = new HashSet<Character>();
        for(Character c : sentence.toCharArray()) {
            hashSet.add(c);
        }
        return hashSet.size() == 26;
    }

    public int repeatedNTimess(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i : nums) {
            if(hashSet.add(i) == false) {
                return i;
            }
        }
        return -1;
    }

    public int sumOfUnique(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        for(int i : nums) {
            if (hashMap.get(i) == 1) {
                result+=i;
            }
        }
        return result;
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);     // build hashmap
        }
        
        return hashMap.size() == new HashSet<>(hashMap.values()).size();
    }

    static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] output_arr = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if(nums[j] < nums[i] && j!=i) {
                    output_arr[i]++;
                }
            }
        }
        return output_arr;
    }

    // hashmaps are crazy
    static int numJewelsInStones(String jewels, String stones) {
        int count=0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i=0; i<stones.length(); i++) {
            hashMap.put(stones.charAt(i), hashMap.getOrDefault(stones.charAt(i), 0) + 1);
        }
        for(int i=0; i<jewels.length(); i++) {
            char c = jewels.charAt(i);
            if(hashMap.containsKey(c)) {
                count+=hashMap.get(c);
            }
        }
        return count;
    }

    // traverse right tree first so left nodes end up on top of stack hence start of list
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        TreeNode current = root;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(current);

        if(current == null) {
            return arrayList;
        }

        while(!stack.isEmpty()) {
            current = stack.pop();
            arrayList.add(current.val);

            if(current.right != null) {
                stack.push(current.right);
            }

            if(current.left != null) {
                stack.push(current.left);
            }
        }
        return arrayList;
    }

    // need to find different solution - this works though
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        TreeNode current = root;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(current);

        if(current == null) {
            return arrayList;
        }

        while(!stack.isEmpty()) {
            current = stack.pop();
            arrayList.add(current.val);
            
            if(current.left != null) {
                stack.push(current.left);
            }
            
            if(current.right != null) {
                stack.push(current.right);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    static int numIdenticalPairs(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if(nums[i] == nums[j] && i<j) {
                    count++;
                }
            }
        }
        return count;
    }

    // for this problem, just push each character onto the stack, and if its been seen before then pop it. whatever is left on the stack is the word with all duplicates removed
    // "abbaca" returns "ca"
    static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        for(int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == currentChar) {
                stack.pop();
            }
            else {
                stack.push(currentChar);
            }
        }
        for (Character c  : stack) {
            result+=c;
        }
        return result;
    }

        static int firstUniqChar(String s) {
            HashMap<Character, Integer> count = new HashMap<Character, Integer>(); // abaabc
            int n = s.length();
            // build hash map : character and how often it appears
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
            
            // find the index
            for (int i = 0; i < n; i++) {
                if (count.get(s.charAt(i)) == 1) 
                    return i;
            }
            return -1;
        }

    /**     Tree 1          Tree 2       Output (Sum)
     *        1               2               3
     *      3   2           1   3           4   5
     *    5                   4   7       3   4   7
     */ 

    static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            TreeNode mergedTree = new TreeNode();
            if(root1 == null) {
                return root2;   // if root1 is 0, the sum will be root2 + 0 which is root 2
            }
            if(root2 == null) {
                return root1;   // same here, if root 2 is 0, the sum of both nodes is root1 + 0 which is root1
            }
            mergedTree.val = root1.val + root2.val; // if neither nodes are null, we sum them together and set this to the value in our new tree
            mergedTree.left = mergeTrees(root1.left, root2.left);   // build all left nodes
            mergedTree.right = mergeTrees(root1.right, root2.right); // build all right
            return mergedTree;
        }

    static int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int result = 0;
        while(current != null || !stack.isEmpty()) {
            while(current!=null) {
                if(current.val >= low && current.val <= high) {
                    result+=current.val;
                } 
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return result;
    }

    static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(); // k = number, value = index in array
        for(int i=0; i<nums.length; i++) {
            if(hashMap.containsKey(nums[i])) { // if the map already contains the current number it must be a duplicate
                if(i - hashMap.get(nums[i]) <= k) { // next check: is i - j <= k where j is the index number in the array
                    return true;
                }
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }

    // best traversal
    static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode current = root;
        while(current != null || !nodeStack.isEmpty()) {
            while(current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    public String multiply(String num1, String num2) {
        String result = "";
        int count = 0;
        while(count+1 <= Math.min(num1.length(), num2.length())) {
            result += String.valueOf(Integer.parseInt(num1.substring(count, count+1)) * Integer.parseInt(num2.substring(count, count+1)));
        }
        result+=num1.substring(count+1) + num2.substring(count+1);
        return result;
    }

    // " ([)] " returns false
    // " ([]) " returns true
    // " ()[] " returns true
    public static boolean isValid(String s) {
        int count=0;
        Stack<String> parentheses = new Stack<>();
        for (Character c : s.toCharArray()) {
            if(!parentheses.isEmpty() && c == ')') {
                if(parentheses.peek() == "(") {
                    parentheses.pop();
                }
                else {
                    count++;
                }
            }
            else {
                parentheses.push("(");
            }
        }
        return true;
    }

    static void createTable() {
        String[] names = new String[]{"Almonds", "Avocados", "Boiled Eggs", "Grilled Chicken", "Cheese"};
        double[] protein = new double[] {21.35, 2.1, 13.89, 29.61, 22.8};
        System.out.println("           Food  Protein");
        System.out.println("------------------------");
        for(int i=0; i<names.length; i++) {
            System.out.printf("%15s  %7.2f \n", names[i], protein[i]);
        }
    }

    static ArrayList<String> chunks(String str, int size) {
        ArrayList<String> chunks = new ArrayList<>();
        int count = 0;
        while((count+size) <= str.length()) {
            chunks.add(str.substring(count, count+size));
            count+=size;
        }
        chunks.add(str.substring(count));
        return chunks;
    }

    static void weirdAlgorithm(int n) {
        System.out.println("Starting number is: " + n);
        while(n != 1) {
            if(n%2 == 0) {
                n/=2;
            }
            else {
                n = (n*3) + 1;
            }
            System.out.println(n);
        }
    }

    static boolean containsUnique(String str, String pattern) {
        if(str.contains(pattern)) { 
            if(str.lastIndexOf(pattern) == str.indexOf(pattern)) {
                return true;
            }
        }
        return false;
    }

    static String firstHalfLowerCase(String s) {
        String newString = s.substring(0, s.length() / 2).toLowerCase() + s.substring(s.length() / 2);
        return newString;
    }

    static int countLessThan(String s, String[] arr) {
        int count = 0;
        for (String string : arr) {
            if(s.compareTo(string) != 0) {
                count++;
            }
        }
        return count;
    }

    static boolean validate(String str) {
        return str.matches("^[A-Za-z0-9+_.-]+@(.+)$"); //this was a painful process
    }

    public static int compareVersion(String version1, String version2) {
        int v1 = Math.round(Integer.parseInt(version1));
        int v2 = Math.round(Integer.parseInt(version2));
        if(v1 < v2) {
            return -1;
        }
        else if(v1 > v2) {
            return 1;
        }
        return 0;
    }
    
    static String longestCommonPrefix(String[] strs) {
        // e.g. strs = ["flower","flow","flight"] returns "fl"
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }

    

}