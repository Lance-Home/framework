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
package com.github.fartherp.framework.core.web.interceptor;

import com.github.fartherp.framework.core.util.SpringProxyUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2018/4/4
 */
@Component("fartherpMockInterceptor")
public class MockInterceptor implements MethodInterceptor, Serializable, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object o = SpringProxyUtils.getRealTarget(invocation.getThis());
        Class<?> targetClass = o.getClass();
        Class<?>[] interfaces = targetClass.getInterfaces();
        Map<String, ?> map = applicationContext.getBeansOfType(interfaces[0]);
        for (Map.Entry<String, ?> m : map.entrySet()) {
            try {
                // 拦截把自己除去
                if (SpringProxyUtils.getRealTarget(m.getValue()) == o) {
                    continue;
                }
                return ReflectionUtils.invokeMethod(invocation.getMethod(), m.getValue(), invocation.getArguments());
            } catch (Throwable e) {
                // do nothing
            }
        }
        return invocation.proceed();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
