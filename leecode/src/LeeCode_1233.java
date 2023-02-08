import java.util.*;

/**
 * @author 🤪zhaohui🤪
 * @date 2023/2/8
 */
public class LeeCode_1233 {

    public static void main(String[] args) {
        String[] arr = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(removeSubfolders1(arr));
    }

    public static List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        for (String s : folderSet) {
            boolean subFolder = false;
            String str = s.substring(0, s.lastIndexOf("/"));
            while (str.length() > 0) {
                if (folderSet.contains(str)) {
                    subFolder = true;
                }
                str = str.substring(0, str.lastIndexOf("/"));
            }
            if (!subFolder) result.add(s);
        }
        return result;
    }

    public static List<String> removeSubfolders1(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; ++i) {
            List<String> path = split(folder[i]);
            Trie cur = root;
            for (String name : path) {
                cur.children.putIfAbsent(name, new Trie());
                cur = cur.children.get(name);
            }
            cur.ref = i; 
        }

        List<String> ans = new ArrayList<String>();
        dfs(folder, ans, root);
        return ans;
    }

    public static List<String> split(String s) {
        List<String> ret = new ArrayList<String>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '/') {
                ret.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(ch);
            }
        }
        ret.add(cur.toString());
        return ret;
    }

    public static void dfs(String[] folder, List<String> ans, Trie cur) {
        if (cur.ref != -1) {
            ans.add(folder[cur.ref]);
            return;
        }
        for (Trie child : cur.children.values()) {
            dfs(folder, ans, child);
        }
    }

    static class Trie {
        /**
         * -1 代表是父类
         */
        int ref;
        Map<String, Trie> children;

        public Trie() {
            ref = -1;
            children = new HashMap<String, Trie>();
        }
    }

}
