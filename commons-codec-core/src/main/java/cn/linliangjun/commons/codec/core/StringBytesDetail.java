/*
 * Copyright 2022-2022 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.linliangjun.commons.codec.core;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 字符串——字节数组清单
 *
 * @author linliangjun
 */
public class StringBytesDetail extends AbstractBytesDetail {

    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private Charset charset = DEFAULT_CHARSET;

    public StringBytesDetail(int length) {
        setLength(length);
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }
}
