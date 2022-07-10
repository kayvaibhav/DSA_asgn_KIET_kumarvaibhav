class Solution {
    // https://leetcode.com/submissions/detail/743171545/
    // 567. Permutation in String
    public boolean checkInclusion(String s1, String s2) {

        // Approach 1: Expand window
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int start = 0, end = 0;

        int[] str1Freq = new int[26];

        // find char freq of string 1
        for (char c : str1) {
            str1Freq[c - 'a']++;
        }

        while (end < str2.length) {
            // System.out.println("currChar = " + str2[end]);
            char currChar = str2[end++];
            --str1Freq[currChar - 'a'];
            while (str1Freq[currChar - 'a'] < 0 && start < end) {
                // System.out.println("start char eliminated: " + str2[start]);
                ++str1Freq[str2[start++] - 'a'];
            }
            // System.out.println("start: " + start + " end: " + end);
            if (end - start == str1.length) {
                return true;
            }
        }
        return false;
    }
}

// class Solution {
// public boolean checkInclusion(String p, String s)
// {
// HashMap<Character, Integer> map = new HashMap<>();
// HashMap<Character, Integer> smap = new HashMap<>();
// ArrayList<Integer> arr =new ArrayList<Integer>();

// if(p.length()>s.length())
// {
// return false;
// }

// for(Character ch: p.toCharArray())
// {
// map.put(ch, map.getOrDefault(ch, 0) +1);
// }

// for(int i = 0;i<p.length();i++)
// {
// char c = s.charAt(i);
// smap.put(c, smap.getOrDefault(c,0)+1 );
// }

// System.out.println(map);
// System.out.println(smap);

// if(map.equals(smap) == true)
// {
// return true;
// }

// int l = p.length();

// while(l< s.length())
// {
// char ch = s.charAt(l);
// smap.put(ch, smap.getOrDefault(ch, 0) + 1);

// char cha = s.charAt(l-p.length());
// if(smap.get(cha) == 1)
// {
// smap.remove(cha);
// }
// else
// {
// smap.put(cha, smap.get(cha) - 1);
// }
// l++;
// if(map.equals(smap) == true)
// {
// return true;
// }
// }
// return false;

// }
// }