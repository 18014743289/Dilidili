package com.he.dilidili.common.cache;

import com.alibaba.fastjson2.JSON;
import com.he.dilidili.model.entity.PersonalInformation;
import com.he.dilidili.model.vo.PersonalInformationVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

import static com.he.dilidili.common.cache.RedisCache.HOUR_ONE_EXPIRE;
import static com.he.dilidili.common.cache.RedisCache.HOUR_SIX_EXPIRE;

@Component
@AllArgsConstructor
public class TokenStoreCache {
    private final RedisCache redisCache;

    public void saveUser(String accessToken, PersonalInformation user) {
        String accessTokenKey = RedisKeys.getAccessTokenKey(accessToken);
        String userIdKey = RedisKeys.getUserIdKey(user.getId());
        if (redisCache.get(userIdKey) != null) {
            redisCache.delete(String.valueOf(redisCache.get(userIdKey)));
        }
        System.out.println("[TokenStoreCache] accessToken = " + accessToken);
        redisCache.set(userIdKey, accessToken, HOUR_ONE_EXPIRE);
        redisCache.set(accessTokenKey, user, HOUR_ONE_EXPIRE);
    }

    public PersonalInformationVO getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return JSON.to(PersonalInformationVO.class, redisCache.get(key));
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }

    public void deleteUserById(Integer id) {
        String userId = RedisKeys.getUserIdKey(id);
        String key = String.valueOf(redisCache.get(userId));
        redisCache.delete(key);
    }

    public void deleteUserByIds(List<Integer> ids) {
        List<String> keys = new ArrayList<>();
        for (Integer id : ids) {
            String userId = RedisKeys.getUserIdKey(id);
            String key = String.valueOf(redisCache.get(userId));
            keys.add(key);
        }
        redisCache.delete(keys);
    }
}
