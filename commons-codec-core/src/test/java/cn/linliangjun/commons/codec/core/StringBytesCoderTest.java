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

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.Stream;

class StringBytesCoderTest {

    private final StringBytesCoder coder = new StringBytesCoder();

    @ParameterizedTest
    @MethodSource("codeArgs")
    void code(String source, StringBytesDetail detail) {
        byte[] target = coder.code(source, detail);
        System.out.println("target = " + Arrays.toString(target));
    }

    private static Stream<Arguments> codeArgs() {
        return Stream.of(
                Arguments.of("你好，世界", new StringBytesDetail(10) {{
                    setCharset(Charset.forName("GBK"));
                    setZeroFill(false);
                    setOrder(BytesOrder.LITTLE_ENDIAN);
                }}),
                Arguments.of("Hello, world!", new StringBytesDetail(15))
        );
    }
}
