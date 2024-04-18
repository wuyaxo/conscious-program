package org.elac;

import org.elac.utils.RandomUtil;
import org.junit.Test;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-13 22:49
 */
public class TestRandom {

    @Test
    public void testR1(){
        int random = RandomUtil.genRandom(6);
        System.out.println(random);
    }

}