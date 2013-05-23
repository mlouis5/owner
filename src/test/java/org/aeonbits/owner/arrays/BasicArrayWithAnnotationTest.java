/*
 * Copyright (c) 2013, Luigi R. Viggiano
 * All rights reserved.
 *
 * This software is distributable under the BSD license.
 * See the terms of the BSD license in the documentation provided with this software.
 */

package org.aeonbits.owner.arrays;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Luigi R. Viggiano
 */
public class BasicArrayWithAnnotationTest {
    private BasicArrayWithAnnotationConfig cfgBasicArrayWithAnnotationConfig;

    @Before
    public void before() {
        cfgBasicArrayWithAnnotationConfig = ConfigFactory.create(BasicArrayWithAnnotationConfig.class);
    }

    public static interface BasicArrayWithAnnotationConfig extends Config {
        @Separator(";")
        @DefaultValue("0; 1; 1; 2; 3; 5; 8; 13; 21; 34; 55")
        public int[] fibonacci();

        @TokenizerClass(CustomDashTokenizer.class)
        @DefaultValue("foo-bar-baz")
        public String[] withSeparatorClass();
    }

    @Test
    public void testSeparatorAnnotation() throws Exception {
        assertThat(cfgBasicArrayWithAnnotationConfig.fibonacci(), is(new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55}));
    }

    @Test
    public void testTokenizerClass() throws Exception {
        assertThat(cfgBasicArrayWithAnnotationConfig.withSeparatorClass(), is(new String[]{"foo", "bar", "baz"}));
    }
}
