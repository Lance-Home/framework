/**
 *    Copyright (c) 2014-2019 CK.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.github.fartherp.framework.core.web.util;

import com.github.fartherp.framework.core.web.ThreadLocalInfo;
import com.github.fartherp.framework.core.web.filter.auth.AuthWrapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.SortedSet;

/**
 * Created by IntelliJ IDEA.
 * @author CK
 * @date 2015/12/15
 */
public class SessionHelper {
    /**
     * 获取当前用户
     *
     * @return 当前用户
     */
    public static Object getUser() {
        return ThreadLocalInfo.currentHttpServletSession().getAttribute(AuthWrapper.SESSION_USER_MESSAGE);
    }

    /**
     * 获取角色、权限集合
     *
     * @return 角色、权限集合
     */
    public static AuthWrapper getAuthWrap() {
        return (AuthWrapper) ThreadLocalInfo.currentHttpServletSession()
			.getAttribute(AuthWrapper.SESSION_AUTH_WRAPPER_MESSAGE);
    }

    /**
     * 获取当前用户是否有访问这个url的权限
     * @param path url
     * @return url的权限
     */
    public static boolean hasOpAuth(String path) {
        // 从缓存中获取当前用户所能操作的所有的url
        SortedSet<String> urls = SessionHelper.getAuthWrap().getAuthUrlSet();
        return CollectionUtils.isNotEmpty(urls) && StringUtils.isNotBlank(UrlUtils.urlMatch(urls, path));
    }

    public static void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
