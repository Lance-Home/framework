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
package com.github.fartherp.framework.common.util;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class BigDecimalUtilTest {

    @Test
    public void testAdd() {
        assertEquals(BigDecimalUtil.add(123, 234), 357.0);
    }

    @Test
    public void testAdd1() {
        BigDecimal v1 = new BigDecimal(123);
        BigDecimal v2 = new BigDecimal(234);
        assertEquals(BigDecimalUtil.add(v1, v2), new BigDecimal("357.00"));
    }

    @Test
    public void testSub() {
        assertEquals(BigDecimalUtil.sub(123, 234), -111.0);
    }

    @Test
    public void testSub1() {
        BigDecimal v1 = new BigDecimal(123);
        BigDecimal v2 = new BigDecimal(234);
        assertEquals(BigDecimalUtil.sub(v1, v2), new BigDecimal("-111.00"));
    }

    @Test
    public void testMul() {
        assertEquals(BigDecimalUtil.mul(10, 23), 230.0);
    }

    @Test
    public void testMul1() {
        BigDecimal v1 = new BigDecimal(10);
        BigDecimal v2 = new BigDecimal(23);
        assertEquals(BigDecimalUtil.mul(v1, v2), new BigDecimal("230.00"));
    }

    @Test
    public void testDiv() {
        assertEquals(BigDecimalUtil.div(23, 10), 2.3);
    }

    @Test
    public void testDiv1() {
        BigDecimal v1 = new BigDecimal(23);
        BigDecimal v2 = new BigDecimal(10);
        assertEquals(BigDecimalUtil.div(v1, v2), new BigDecimal("2.30"));
    }

	@Test
	public void testDiv2() {
		BigDecimal v1 = new BigDecimal(23);
		BigDecimal v2 = new BigDecimal(0);
		assertEquals(BigDecimalUtil.div(v1, v2), BigDecimal.ZERO);
	}
}
