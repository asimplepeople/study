import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 🤪zhaohui🤪
 * @date 2023/2/7
 */
public class LeeCode_1604 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] keyName = {"a","a","a","a","a","b","b","b","b","b","b"};
        String[] keyTime = {"23:20","11:09","23:30","23:02","15:28","22:57","23:40","03:43","21:55","20:38","00:19"};
        List<String> strings = solution.alertNames(keyName, keyTime);
        System.out.println(strings);
    }

    static class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < keyName.length; i++) {
                String name = keyName[i];
                if (map.containsKey(name)) {
                    map.get(name).add(keyTime[i]);
                }else{
                    List<String> times = new ArrayList<>();
                    times.add(keyTime[i]);
                    map.put(name, times);
                }
            }
            return map.keySet().stream().filter(i -> validMoreThanThreeTimesInAnHour(map.get(i).toArray(new String[0]))).sorted().collect(Collectors.toList());
        }

        public boolean validMoreThanThreeTimesInAnHour(String[] keyTime){
            if(null == keyTime || keyTime.length <= 2){
                return false;
            }
            List<LocalTime> collect = Arrays.stream(keyTime).map(LocalTime::parse).sorted().collect(Collectors.toList());
            for (int i = 2; i < collect.size(); i++) {
                if(Duration.between(collect.get(i - 2), collect.get(i)).toMillis() <= 60 * 1000 * 60) return true;
            }
            return false;
        }
    }

   static class Solution1 {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            Map<String, List<Integer>> timeMap = new HashMap<String, List<Integer>>();
            int n = keyName.length;
            for (int i = 0; i < n; i++) {
                String name = keyName[i];
                String time = keyTime[i];
                timeMap.putIfAbsent(name, new ArrayList<Integer>());
                int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
                int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
                timeMap.get(name).add(hour * 60 + minute);
            }
            List<String> res = new ArrayList<String>();
            Set<String> keySet = timeMap.keySet();
            for (String name : keySet) {
                List<Integer> list = timeMap.get(name);
                Collections.sort(list);
                int size = list.size();
                for (int i = 2; i < size; i++) {
                    int time1 = list.get(i - 2), time2 = list.get(i);
                    int difference = time2 - time1;
                    if (difference <= 60) {
                        res.add(name);
                        break;
                    }
                }
            }
            Collections.sort(res);
            return res;
        }
    }

}
