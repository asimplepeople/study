import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/design-authentication-manager/
 *
 * @author xiezhaohui
 * @date 2023/2/9
 */
public class LeeCode_1797 {
    public static void main(String[] args) {

    }
    class AuthenticationManager {

        private final Integer timeTolive;
        Map<String, Integer> map = new HashMap();

        public AuthenticationManager(int timeToLive) {
            this.timeTolive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime);
        }

        public void renew(String tokenId, int currentTime) {
            if(map.containsKey(tokenId) &&  currentTime >= map.get(tokenId) && currentTime - map.get(tokenId) <  timeTolive){
                map.put(tokenId, currentTime);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            return (int)map.values().stream().filter(i -> currentTime >= i && currentTime - i < timeTolive).count();
        }
    }
}
